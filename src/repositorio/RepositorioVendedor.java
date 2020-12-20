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
    public boolean excluirVendedor(String nome) {
        
        for (Vendedor vendedor : vendedores) {
            
            if (vendedor.getNome().equals(nome)){

                vendedores.remove(vendedor);
                return true;

            }

        }

        return false;
    }

    @Override
    public boolean verificaVendedor(String nome){

        for (Vendedor vendedor : vendedores){
            if (vendedor.getNome().equals(nome)){
                return true;
            }
        }

        return false;

    }

    @Override
    public ArrayList<Vendedor> recuperarTodosOsVendedores() {
        
        return vendedores;

    }
    
}