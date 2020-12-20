package model;

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
        System.out.println("3 - GERENCIAR VENDEDORES");
        System.out.println("4 - GERENCIAR GERENTES");
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

            } catch (Exception e) {
                System.out.println(mensagem);
            }

        } while (numero <= 0);

        return numero;

    }

    //////////////////////// METODOS DIRETAMENTE RELACIONADOS AO MENU PRINCIPAL
    //////////////////////// ////////////////////////

    public static void efetuarVenda() {

        printLinha("EFETUAR VENDA");

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

                // criarItem();

            } else if (opcao.equals("2")) {

                // modificarItem();

            } else if (opcao.equals("3")) {

                // listarItens();

            } else if (opcao.equals("4")) {

                // excluirItem();

            } else if (!opcao.equals("0")) {

                System.out.println("");
                System.out.println("ESCOLHA UMA OPCAO VALIDA");

            }

        } while (!opcao.equals("0"));

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

    ////////////////////////////////////////// GERENCIAR ITENS
    ////////////////////////////////////////// //////////////////////////////////////////

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

        do {

            Scanner input = new Scanner(System.in);
            printMenu();
            opcao = input.nextLine();

            if (opcao.equals("1")) {

            } else if (opcao.equals("2")) {

                gerenciarItens();

            } else if (opcao.equals("3")) {

                gerenciarVendedores();

            } else if (opcao.equals("4")) {

                gerenciarGerentes();

            } else if (!opcao.equals("0")) {

                System.out.println("");
                System.out.println("ESCOLHA UMA OPCAO VALIDA");

            }

        } while (!opcao.equals("0"));

    }

}
