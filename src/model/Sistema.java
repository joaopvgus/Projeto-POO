package model;

import repositorio.*;

import java.util.ArrayList;

import exceptions.*;

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

    public void criarGerente(String nome, String senha) throws CampoVazioException {

        if (nome.equals("") || senha.equals("")) {

            throw new CampoVazioException("Todos os campos devem ser preenchidos");

        } else {

            Gerente gerente = new Gerente(nome, senha);
            gerentes.inserirGerente(gerente);

        }

    }

    public void criarVendedor(String nome) throws CampoVazioException {

        if (nome.equals("")) {

            throw new CampoVazioException("Insira um nome");

        } else {

            Vendedor vendedor = new Vendedor(nome);
            vendedores.adicionarVendedor(vendedor);

        }

    }

    public void criarItem(String descricao, double preco, double estoque, String medida) {

        Item item = new Item(id, descricao, preco, estoque, medida);
        itens.inserirItem(item);
        id++;

    }

    public void criarVenda(Vendedor vendedor, ArrayList<Grupo> grupos, double aVista, double credito, double debito) {

        Venda venda = new Venda(vendedor, grupos, aVista, credito, debito);
        vendas.adicionarVenda(venda);

    }

}