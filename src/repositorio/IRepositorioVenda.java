package repositorio;

import java.util.ArrayList;

import model.Venda;

public interface IRepositorioVenda {

    void adicionarVenda(Venda venda);

    ArrayList<Venda> recuperarTodasAsVendas();
    
}
