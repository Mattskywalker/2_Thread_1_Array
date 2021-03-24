package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayListPincipal principal = new ArrayListPincipal();
        principal.adicionar();

        ThreadString threadString = new ThreadString(principal.getA());
        ThreadInt threadInt = new ThreadInt(principal.getA());

        threadInt.start();
        threadString.start();

    }
}
