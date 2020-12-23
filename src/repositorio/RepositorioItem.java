package repositorio;

import java.util.ArrayList;

import model.Item;

public class RepositorioItem implements IRepositorioItem {

    private ArrayList<Item> itens = new ArrayList<Item>();

    @Override
    public void inserirItem(Item item) {

        itens.add(item);

    }

    @Override
    public ArrayList<Item> recuperarTodosOsItens() {

        return itens;
    }

    @Override
    public Item recuperarItem(String nome) {
        for (Item item : itens) {
            if (item.getDescricao().equals(nome)) {
                return item;
            }

        }
        return null;
    }

    @Override
    public void atualiazarItem(int id, String descricao, double preco, double estoque, String medida) {
        for (Item item : itens) {
            if (item.getID() == id) {
                item.setDescricao(descricao);
                item.setPreco(preco);
                item.setEstoque(estoque);
                item.setMedida(medida);
            }
        }
    }

    @Override
    public boolean excluirItem(String nome) {

        for (Item item : itens) {

            if (item.getDescricao().equals(nome)) {

                itens.remove(item);
                return true;

            }

        }

        return false;
    }

    @Override
    public void decrementarItem(String nome, double quant) {
        for (Item item : itens) {
            if (item.getDescricao().equals(nome)) {

                item.setEstoque(item.getEstoque() - quant);
            }
        }
    }
    
}
