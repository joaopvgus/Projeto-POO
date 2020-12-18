package repositorio;

import java.util.ArrayList;

import model.Vendedor;

public interface IRepositorioVendedor {
    
    void adicionarVendedor(Vendedor vendedor);

    ArrayList<Vendedor> recuperarTodosOsVendedores();

}
