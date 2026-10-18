package com.whisky.teoria01;

public class MostrarEntorno {
    public static void main(String[] args) {

        String modulo = System.getenv("MODULO");
        String curso = System.getenv("CURSO");
        System.out.println("Directorio: " +
                System.getProperty("user.dir"));
        System.out.println("Módulo: " +
                valorODesconocido(modulo));
        System.out.println("Curso: " + valorODesconocido(curso));

    }
    private static String valorODesconocido(String valor) {
        return valor == null
                ? "No definido"
                : valor;
    }
}
