package repositorio;

import java.util.ArrayList;

import model.Vendedor;

public class RepositorioVendedor implements IRepositorioVendedor {

    private ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

    @Override
    public void adicionarVendedor(Vendedor vendedor) {

        vendedores.add(vendedor);

    }

    @Override
    public ArrayList<Vendedor> recuperarTodosOsVendedores() {
        
        return vendedores;

    }
    
}