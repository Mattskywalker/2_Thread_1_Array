package main;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPincipal {

    private char[] a;
    ArrayList<Character> cara = new ArrayList<Character>();



    public void adicionar(){

        String string;

        System.out.println("Digite a cadeia: ");
        Scanner scan = new Scanner(System.in);

        string = scan.nextLine();
        int size = string.length();
        a = new char[size++];
        //System.out.println("valor: " + size);

        a = string.toCharArray();

    }

    public void listar(){

        for(char a : this.a){

            System.out.println("Valor: " + a);
        }

    }


    public char[] getA() {
        return a;
    }

    public void setA(char[] a) {
        this.a = a;
    }
}
