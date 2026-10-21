package com.whisky.tema01;

import java.util.Optional;

public class Starship {

    static void main(String[] args) {
        String planeta = System.getenv("PLANETA");

        IO.println("El planeta " + valorODesconocido(planeta) + " es visible desde la Tierra");
    }

    private static String valorODesconocido(String valor) {
        return valor == null
                ? "<no identificado>"
                : valor;
    }
}
