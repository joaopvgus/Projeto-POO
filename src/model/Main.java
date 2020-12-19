package model;

import java.util.Scanner;

import exceptions.CampoVazioException;

public class Main {

    public static void main(String[] args) throws CampoVazioException {

        Scanner input = new Scanner(System.in);

        Sistema sistema = new Sistema();
        
        sistema.criarVendedor("joao");

        System.out.print("Nome: ");
        
        String descricao = input.next();
        System.out.println();

        System.out.print("preco: ");
        double preco = input.nextDouble();
        System.out.println();

        System.out.print("Estoque: ");
        double estoque = input.nextDouble();
        System.out.println();

        sistema.criarItem(descricao, preco, estoque, "UN");

    }

}
