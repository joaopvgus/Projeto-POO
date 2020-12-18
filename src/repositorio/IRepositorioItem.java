package repositorio;

import java.util.ArrayList;

import model.Item;

public interface IRepositorioItem {

    void inserirItem(Item item);

    ArrayList<Item> recuperarTodosOsItens();
    
}
