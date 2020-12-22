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

    @Override
    public boolean excluirGerente(String nome, String senha) {

        for (Gerente gerente : gerentes) {

            if (gerente.getNome().equals(nome) && gerente.getSenha().equals(senha)) {

                gerentes.remove(gerente);
                return true;

            }

        }

        return false;
    }

    @Override
    public boolean verificaGerente(String nome, String senha) {

        for (Gerente gerente : gerentes){

            if (gerente.getNome().equals(nome) && gerente.getSenha().equals(senha)){

                    return true;

            }

        }

        return false;

    }
}