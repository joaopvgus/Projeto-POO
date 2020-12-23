package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Sistema sistema = new Sistema();

    //////////////////////////////// METODOS BASICOS DE ENTRADA E SAIDA
    //////////////////////////////// ////////////////////////////////

    public static void printLinha(String titulo) {
        System.out.println("");
        System.out.println("--------------- " + titulo + " ---------------");
        System.out.println("");
    }

    public static void printMenu() {

        printLinha("MENU");
        System.out.println("1 - EFETUAR VENDA");
        System.out.println("2 - GERENCIAR ITENS");
        System.out.println("3 - EXIBIR VENDAS");
        System.out.println("4 - GERENCIAR VENDEDORES");
        System.out.println("5 - GERENCIAR GERENTES");
        System.out.println("0 - ENCERRAR PROGRAMA");
        System.out.println("");
        System.out.print("DIGITE O NUMERO REFERENTE A SUA OPCAO: ");

    }

    public static String inputString(String mensagem) {

        Scanner input = new Scanner(System.in);
        String texto = "";

        do {

            texto = input.nextLine();

            if (texto.equals("")) {
                System.out.println(mensagem);
            }

        } while (texto.equals(""));

        return texto;

    }

    public static double inputDouble(String mensagem) {

        Scanner input = new Scanner(System.in);
        double numero = 0;

        do {
            try {
                numero = input.nextDouble();

                if (numero <= 0) {
                    System.out.println(mensagem);
                }

            } catch (InputMismatchException e) {
                System.out.println(mensagem);
                input.nextLine();
            }

        } while (numero <= 0);

        return numero;

    }

    public static boolean login() {

        System.out.print("DIGITE O NOME DE USUARIO: ");
        String nome = inputString("DIGITE UM NOME VALIDO");
        System.out.print("DIGITE SUA SENHA: ");
        String senha = inputString("DIGITE UMA SENHA VALIDA");

        if (sistema.verificaGerente(nome, senha) == true) {

            return true;

        }

        System.out.println("CREDENCIAIS INVALIDAS");
        return false;

    }

    //////////////////////// METODOS DIRETAMENTE RELACIONADOS AO MENU PRINCIPAL
    //////////////////////// ////////////////////////

    public static void efetuarVenda() {

        printLinha("EFETUAR VENDA");
        Vendedor vendedor = setVendedor();

        if (vendedor != null) {
            ArrayList<Grupo> grupos = setGrupos(new ArrayList<Grupo>());
            double totalGrupos = sistema.getTotalGrupos(grupos);
            double credito = 0;
            double debito = 0;

            double aVista = setAVista(totalGrupos);

            if (aVista < totalGrupos) {
                totalGrupos -= aVista;
                credito = setCredito(totalGrupos);
                totalGrupos -= credito;
                if (totalGrupos != 0) {
                    debito = totalGrupos;
                    System.out.println("VALOR DE " + totalGrupos + " ATRIBUIDO AO DEBITO");
                }
            }

            for (Grupo grupo : grupos) {
                sistema.decrementarItem(grupo.getItem().getDescricao(), grupo.getQuantidade());
            }

            sistema.criarVenda(vendedor, grupos, aVista, credito, debito);

            printLinha("VENDA EFETUADA COM SUCESSO");
        }

    }

    public static void gerenciarItens() {

        String opcao = "";

        do {

            Scanner input = new Scanner(System.in);

            printLinha("GERENCIAR ITENS");
            System.out.println("1 - CRIAR ITEM");
            System.out.println("2 - MODIFICAR ITEM");
            System.out.println("3 - LISTAR ITENS");
            System.out.println("4 - EXCLUIR ITEM");
            System.out.println("0 - VOLTAR");
            System.out.println("");
            System.out.print("DIGITE O NUMERO REFERENTE A SUA OPCAO: ");
            opcao = input.nextLine();

            if (opcao.equals("1")) {

                criarItem();

            } else if (opcao.equals("2")) {
                modificarItem();

            } else if (opcao.equals("3")) {

                listarItens();

            } else if (opcao.equals("4")) {

                excluirItem();

            } else if (!opcao.equals("0")) {

                System.out.println("");
                System.out.println("ESCOLHA UMA OPCAO VALIDA");

            }

        } while (!opcao.equals("0"));

    }

    public static void exibirVendas() {

        printLinha("VENDAS");

        if (sistema.getVendas().isEmpty()) {
            printLinha("NENHUMA VENDA FOI REALIZADA");
        }

        for (Venda venda : sistema.getVendas()) {
            System.out.println(venda.getVendedor().getNome());
            for (String grupo : venda.getGruposArrayListStrings()) {
                System.out.println(grupo);
            }

            System.out.println("");
            System.out.println("A VISTA: R$ " + venda.getaVista());
            System.out.println("CREDITO: R$ " + venda.getCredito());
            System.out.println("DEBITO: R$ " + venda.getDebito());

        }

    }

    public static void gerenciarVendedores() {

        String opcao = "";

        do {

            Scanner input = new Scanner(System.in);

            printLinha("GERENCIAR VENDEDORES");
            System.out.println("1 - CRIAR VENDEDOR");
            System.out.println("2 - EXCLUIR VENDEDOR");
            System.out.println("0 - VOLTAR");
            System.out.println("");
            System.out.print("DIGITE O NUMERO REFERENTE A SUA OPCAO: ");
            opcao = input.nextLine();

            if (opcao.equals("1")) {

                criarVendedor();

            } else if (opcao.equals("2")) {

                excluirVendedor();

            } else if (!opcao.equals("0")) {

                System.out.println("");
                System.out.println("ESCOLHA UMA OPCAO VALIDA");

            }

        } while (!opcao.equals("0"));

    }

    public static void gerenciarGerentes() {

        String opcao = "";

        do {

            Scanner input = new Scanner(System.in);

            printLinha("GERENCIAR GERENTES");
            System.out.println("1 - CRIAR GERENTE");
            System.out.println("2 - EXCLUIR GERENTE");
            System.out.println("0 - VOLTAR");
            System.out.println("");
            System.out.print("DIGITE O NUMERO REFERENTE A SUA OPCAO: ");
            opcao = input.nextLine();

            if (opcao.equals("1")) {

                criarGerente();

            } else if (opcao.equals("2")) {

                excluirGerente();

            } else if (!opcao.equals("0")) {

                System.out.println("");
                System.out.println("ESCOLHA UMA OPCAO VALIDA");

            }

        } while (!opcao.equals("0"));

    }

    /////////////////////////////////////////// EFETUAR VENDA
    /////////////////////////////////////////// ///////////////////////////////////////////

    public static Vendedor setVendedor() {

        System.out.print("DIGITE O NOME DO VENDEDOR: ");
        String nome = inputString("DIGITE UM NOME VALIDO");

        if (sistema.verificaVendedor(nome) == true) {
            System.out.println("VENDEDOR VINCULADO");
            return new Vendedor(nome);
        } else {
            System.out.println("VENDEDOR NAO CADASTRADO");
            return null;
        }

    }

    public static ArrayList<Grupo> setGrupos(ArrayList<Grupo> grupos) {

        System.out.print("DIGITE O NOME DO ITEM: ");
        String nome = inputString("DIGITE UM NOME VALIDO");

        if (sistema.buscarItem(nome) != null) {

            System.out.print("DIGITE A QUANTIDADE: ");
            double quantidade = inputDouble("DIGITE UMA QUANTIDADE VALIDA");

            if (sistema.buscarItem(nome).getEstoque() >= quantidade) {

                Grupo grupo = new Grupo(sistema.buscarItem(nome), quantidade);
                grupos.add(grupo);
                System.out.print("DESEJA INSERIR OUTRO ITEM? (S/N): ");
                String opcao = inputString("DIGITE \"S\" OU \"N\"");

                if (opcao.equals("S") || opcao.equals("s")) {
                    return setGrupos(grupos);
                } else {
                    return grupos;
                }
            } else {

                System.out.println("A QUANTIDADE INSERIDA E SUPERIOR AO ESTOQUE");
                return setGrupos(grupos);

            }
        } else {
            System.out.println("ITEM NAO CADASTRADO");
            return setGrupos(grupos);
        }

    }

    public static double setAVista(double restante) {

        System.out.println("");
        System.out.print("VALOR RESTANTE: R$");
        System.out.println(restante);
        System.out.print("DIGITE O VALOR PAGO A VISTA: ");
        double valor = inputDouble("DIGITE UM VALOR VALIDO");

        if (valor > restante) {
            System.out.print("TROCO: R$");
            System.out.println(valor - restante);
            return valor;
        } else {
            return valor;
        }

    }

    public static double setCredito(double restante) {

        System.out.println("");
        System.out.print("VALOR RESTANTE: R$");
        System.out.println(restante);
        System.out.print("DIGITE O VALOR PAGO NO CREDITO: ");
        double valor = inputDouble("DIGITE UM VALOR VALIDO");

        if (valor > restante) {
            System.out.println("VALOR SUPERIOR AO RESTANTE");
            return setCredito(restante);
        } else {
            return valor;
        }

    }

    ////////////////////////////////////////// GERENCIAR ITENS
    ////////////////////////////////////////// //////////////////////////////////////////

    private static void criarItem() {
        printLinha("CRIAR ITEM");

        System.out.print("DIGITE A DESCRIÇÃO DO ITEM: ");
        String descricao = inputString("DIGITE UMA DESCRIÇÃO VALIDA");

        System.out.print("DIGITE O PREÇO DO ITEM: ");
        double preco = inputDouble("DIGITE UM PREÇO VALIDO");

        System.out.print("DIGITE O ESTOQUE DO ITEM: ");
        double estoque = inputDouble("DIGITE UM VALOR VALIDO");

        System.out.print("DIGITE A MEDIDA DO ITEM: ");
        String medida = inputString("DIGITE UMA MEDIDA VALIDA");

        sistema.criarItem(descricao, preco, estoque, medida);

        printLinha("ITEM CADASTRADO COM SUCESSO");
    }

    public static Item buscarItem() {

        System.out.print("DIGITE O NOME DO ITEM QUE DESEJA MODIFICAR: ");
        String nome = inputString("DIGITE UM NOME VALIDO");

        Item item = sistema.buscarItem(nome);

        return item;
    }

    public static void modificarItem() {
        printLinha("MODIFICAR ITEM");

        Item item = buscarItem();
        if (item == null) {
            System.out.print("ITEM NÃO ENCONTRADO");
        } else {

            System.out.print("DIGITE A DESCRIÇÃO DO ITEM: (" + item.getDescricao() + "): ");
            String descricao = inputString("DIGITE UMA DESCRIÇÃO VALIDA");

            System.out.print("DIGITE O PREÇO DO ITEM: (" + item.getPreco() + "): ");
            double preco = inputDouble("DIGITE UM PREÇO VALIDO");

            System.out.print("DIGITE O ESTOQUE DO ITEM: (" + item.getEstoque() + "): ");
            double estoque = inputDouble("DIGITE UM VALOR VALIDO");

            System.out.print("DIGITE A MEDIDA DO ITEM: (" + item.getMedida() + "): ");
            String medida = inputString("DIGITE UMA MEDIDA VALIDA");

            sistema.modificarItem(item.getID(), descricao, preco, estoque, medida);

            printLinha("ITEM CADASTRADO COM SUCESSO");
        }
    }

    private static void listarItens() {
        printLinha("LISTAR ITENS");

        if (sistema.recuperarTodosOsItens().isEmpty()) {
            printLinha("NENHUM ITEM FOI CADASTRADO");
        }

        ArrayList<Item> itens = sistema.recuperarTodosOsItens();

        for (Item item : itens) {
            System.out.println("ID: " + item.getID());
            System.out.println("DESCRIÇÃO DO ITEM: " + item.getDescricao());

            System.out.println("PREÇO DO ITEM:: " + item.getPreco());

            System.out.println("ESTOQUE DO ITEM:: " + item.getEstoque());

            System.out.println("MEDIDA DO ITEM:: " + item.getMedida());
            System.out.println("");
        }
    }

    public static void excluirItem() {

        printLinha("EXCLUIR ITEM");
        System.out.print("DIGITE A DESCRIÇÃO DO ITEM: ");
        String nome = inputString("DIGITE UMA DESCRIÇÃO VALIDA");

        if (sistema.excluirItem(nome) == true) {
            printLinha("ITEM EXCLUIDO");
        } else {
            printLinha("ITEM NAO CADASTRADO");
        }

    }

    /////////////////////////////////////// GERENCIAR VENDEDORES
    /////////////////////////////////////// ///////////////////////////////////////

    public static void criarVendedor() {

        printLinha("CRIAR VENDEDOR");
        System.out.print("DIGITE O NOME DO VENDEDOR: ");
        String nome = inputString("DIGITE UM NOME VALIDO");

        sistema.criarVendedor(nome);

        printLinha("VENDEDOR CADASTRADO COM SUCESSO");

    }

    public static void excluirVendedor() {

        printLinha("EXCLUIR VENDEDOR");
        System.out.print("DIGITE O NOME DO VENDEDOR: ");
        String nome = inputString("DIGITE UM NOME VALIDO");

        if (sistema.excluirVendedor(nome) == true) {
            printLinha("VENDEDOR EXCLUIDO");
        } else {
            printLinha("VENDEDOR NAO CADASTRADO");
        }

    }

    //////////////////////////////////////// GERENCIAR GERENTES
    //////////////////////////////////////// ////////////////////////////////////////

    public static void criarGerente() {

        printLinha("CRIAR GERENTE");
        System.out.print("DIGITE O NOME DO GERENTE: ");
        String nome = inputString("DIGITE UM NOME VALIDO");

        System.out.print("DIGITE A SENHA DO GERENTE: ");
        String senha = inputString("DIGITE UMA SENHA VALIDA");

        sistema.criarGerente(nome, senha);

        printLinha("GERENTE CADASTRADO COM SUCESSO");

    }

    public static void excluirGerente() {

        printLinha("EXCLUIR GERENTE");
        System.out.print("DIGITE O NOME DO GERENTE: ");
        String nome = inputString("DIGITE UM NOME VALIDO");

        System.out.print("DIGITE A SENHA DO GERENTE: ");
        String senha = inputString("DIGITE UMA SENHA VALIDA");

        if (sistema.excluirGerente(nome, senha) == true) {
            printLinha("GERENTE EXCLUIDO");
        } else {
            printLinha("GERENTE NAO CADASTRADO");
        }

    }

    /////////////////////////////////////////////// MAIN
    /////////////////////////////////////////////// ///////////////////////////////////////////////

    public static void main(String[] args) {

        sistema.criarGerente("admin", "admin");

        String opcao = "";

        boolean auth = login();

        while (auth == false) {
            auth = login();
        }

        do {

            Scanner input = new Scanner(System.in);
            printMenu();
            opcao = input.nextLine();

            if (opcao.equals("1")) {

                efetuarVenda();

            } else if (opcao.equals("2")) {

                gerenciarItens();

            } else if (opcao.equals("3")) {

                exibirVendas();

            } else if (opcao.equals("4")) {

                gerenciarVendedores();

            } else if (opcao.equals("5")) {

                gerenciarGerentes();

            } else if (!opcao.equals("0")) {

                System.out.println("");
                System.out.println("ESCOLHA UMA OPCAO VALIDA");

            }

        } while (!opcao.equals("0"));

    }

}
