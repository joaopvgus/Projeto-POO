package repositorio;

import java.util.ArrayList;

import model.Gerente;

public class RepositorioGerente implements IRepositorioGerente {

    private ArrayList<Gerente> gerentes = new ArrayList<Gerente>();

    @Override
    public void inserirGerente(Gerente gerente) {
        
        gerentes.add(gerente);

    }

    @Override
    public ArrayList<Gerente> recuperarTodosOsGerentes() {
        return gerentes;
    }

}