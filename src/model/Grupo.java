package model;

public class Grupo {

    private Item item;
    private double quantidade;
    private double total;

    public Grupo(Item item, double quantidade) {
        this.item = item;
        this.quantidade = quantidade;
        this.total = item.getPreco() * quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

}
