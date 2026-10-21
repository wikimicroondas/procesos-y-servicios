package com.whisky.tema01;

public class Mascota {
    static String name;
    static int steps;

    static void main(String[] args) {
        argsValidator(args);
    }

    public static void argsValidator(String[] args) {
        if (args == null || args.length == 0) {
            IO.println();
            System.exit(1);
        }
    }
}
