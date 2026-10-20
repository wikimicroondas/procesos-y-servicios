package com.whisky.tema01;

public class Oraculo {

    static void main(String[] args) {
        argsValidator(args);
    }

    public static void argsValidator(String[] args) {
        if (args.length == 0) {
            IO.println("Incorrect call.\n\n'java oraculo <name> <question>' was expected.");
        }
    }
}
