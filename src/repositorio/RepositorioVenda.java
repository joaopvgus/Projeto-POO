package repositorio;

import java.util.ArrayList;

import model.Venda;

public class RepositorioVenda implements IRepositorioVenda {

    private ArrayList<Venda> vendas = new ArrayList<Venda>();

    @Override
    public void adicionarVenda(Venda venda) {
        
        vendas.add(venda);

    }

    @Override
    public ArrayList<Venda> recuperarTodasAsVendas() {
        
        return vendas;

    }
    
}
