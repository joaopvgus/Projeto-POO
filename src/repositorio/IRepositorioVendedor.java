package repositorio;

import java.util.ArrayList;

import model.Vendedor;

public interface IRepositorioVendedor {
    
    void adicionarVendedor(Vendedor vendedor);

    boolean excluirVendedor(String nome);

    boolean verificaVendedor(String nome);

    ArrayList<Vendedor> recuperarTodosOsVendedores();

}
