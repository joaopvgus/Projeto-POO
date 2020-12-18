package model;

public class Gerente extends Pessoa {

    private String senha;

    public Gerente(String nome, String senha) {
        super(nome);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    } 

}
