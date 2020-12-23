package model;

import repositorio.*;

import java.util.ArrayList;

public class Sistema {

    private RepositorioGerente gerentes;
    private RepositorioVendedor vendedores;
    private RepositorioItem itens;
    private RepositorioVenda vendas;
    private int id;

    public Sistema() {

        this.gerentes = new RepositorioGerente();
        this.vendedores = new RepositorioVendedor();
        this.itens = new RepositorioItem();
        this.vendas = new RepositorioVenda();
        this.id = 1;

    }

    public void criarGerente(String nome, String senha) {

        Gerente gerente = new Gerente(nome, senha);
        gerentes.inserirGerente(gerente);

    }

    public boolean excluirGerente(String nome, String senha) {

        boolean status = gerentes.excluirGerente(nome, senha);

        return status;

    }

    public boolean verificaGerente(String nome, String senha){

        boolean status = gerentes.verificaGerente(nome, senha);

        return status;

    }

    public void criarVendedor(String nome) {

        Vendedor vendedor = new Vendedor(nome);
        vendedores.adicionarVendedor(vendedor);

    }

    public boolean excluirVendedor(String nome) {

        boolean status = vendedores.excluirVendedor(nome);

        return status;

    }

    public boolean verificaVendedor(String nome){

        if (vendedores.verificaVendedor(nome) == true){
            return true;
        }

        return false;

    }

    public void criarItem(String descricao, double preco, double estoque, String medida) {

        Item item = new Item(id, descricao, preco, estoque, medida);
        itens.inserirItem(item);
        id++;

    }

    public ArrayList<Item> recuperarTodosOsItens() {
        return itens.recuperarTodosOsItens();
    }

    public Item buscarItem(String nome) {
        Item item = itens.recuperarItem(nome);
        return item;
    }

    public void modificarItem(int id2, String descricao, double preco, double estoque, String medida) {
        itens.atualiazarItem(id2, descricao, preco, estoque, medida);
    }

    public boolean excluirItem(String nome) {

        boolean status = itens.excluirItem(nome);

        return status;

    }

    public void decrementarItem(String nome, double quant){

        itens.decrementarItem(nome, quant);

    }

    public double getTotalGrupos(ArrayList<Grupo> grupos){

        double total = 0;
        for (Grupo grupo : grupos){
            total += grupo.getTotal();
        }

        return total;

    }

    public void criarVenda(Vendedor vendedor, ArrayList<Grupo> grupos, double aVista, double credito, double debito) {

        Venda venda = new Venda(vendedor, grupos, aVista, credito, debito);
        vendas.adicionarVenda(venda);

    }

    public ArrayList<Venda> getVendas(){
        return vendas.recuperarTodasAsVendas();
    }

}