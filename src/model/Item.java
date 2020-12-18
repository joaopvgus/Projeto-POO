package model;

public class Item {

    private int ID;
    private String descricao;
    private double preco;
    private double estoque;
    private String medida;

    public Item(int ID, String descricao, double preco, double estoque, String medida) {
        this.setID(ID);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setEstoque(estoque);
        this.setMedida(medida);
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

}
