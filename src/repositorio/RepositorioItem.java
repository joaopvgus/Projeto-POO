package repositorio;

import java.util.ArrayList;

import model.Item;

public class RepositorioItem implements IRepositorioItem{

    private ArrayList<Item> itens = new ArrayList<Item>();

    @Override
    public void inserirItem(Item item) {
        
        itens.add(item);

    }

    @Override
    public ArrayList<Item> recuperarTodosOsItens() {
        
        return itens;
    }

}
