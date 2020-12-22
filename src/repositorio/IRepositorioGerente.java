package repositorio;

import java.util.ArrayList;

import model.Gerente;

public interface IRepositorioGerente {

    void inserirGerente(Gerente gerente);

    ArrayList<Gerente> recuperarTodosOsGerentes();
    
    boolean excluirGerente(String nome, String senha);

    boolean verificaGerente(String nome, String senha);
    
}
