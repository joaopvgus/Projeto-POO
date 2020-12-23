package repositorio;

import java.util.ArrayList;

import model.Item;

public interface IRepositorioItem {

    void inserirItem(Item item);

    ArrayList<Item> recuperarTodosOsItens();

    Item recuperarItem(String nome);

    void atualiazarItem(int id, String descricao, double preco, double estoque, String medida);

    boolean excluirItem(String nome);

    void decrementarItem(String nome, double quant);
}
