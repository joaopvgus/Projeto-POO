package model;

import java.util.ArrayList;

public class Venda {

    private Vendedor vendedor;
    private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
    private double aVista;
    private double credito;
    private double debito;

    public Venda(Vendedor vendedor, ArrayList<Grupo> grupos, double aVista, double credito, double debito) {
        this.vendedor = vendedor;
        this.grupos = grupos;
        this.aVista = aVista;
        this.credito = credito;
        this.debito = debito;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public double getaVista() {
        return aVista;
    }

    public void setaVista(double aVista) {
        this.aVista = aVista;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getTotal() {

        double total = 0;

        for (Grupo grupo : grupos) {

            total += grupo.getTotal();

        }

        return total;
    }

    public ArrayList<String> getGruposArrayListStrings() {

        ArrayList<String> gruposString = new ArrayList<String>();

        for (Grupo grupo : grupos) {

            String texto = "";

            texto += grupo.getQuantidade() + " | " + grupo.getItem().getDescricao() + " | "
                    + Double.toString(grupo.getItem().getPreco()) + " | " + Double.toString(grupo.getTotal());

            gruposString.add(texto);

        }

        return gruposString;

    }

}
