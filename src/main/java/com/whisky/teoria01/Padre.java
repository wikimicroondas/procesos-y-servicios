package com.whisky.teoria01;

import java.io.IOException;
import java.util.Map;

public class Padre {

    static void main(String[] args) {
        System.out.println();

        int codigoSalida = -1;
        String nombrePaquete = Padre.class.getPackageName();
        try {
            String classpath = System.getProperty("java.class.path");
            ProcessBuilder constructor = new ProcessBuilder(
                    "java",
                    "-cp", classpath,
                    nombrePaquete + ".MostrarEntorno"
            );

            // Cambios  -- v
            Map<String, String> entorno = constructor.environment();
            entorno.put("MODULO", "Programación de procesos y servicios");
            entorno.put("CURSO", "DAM");
            entorno.remove("VARIABLE_NO_DESEADA");

            constructor.inheritIO();
            Process proceso = constructor.start();
            codigoSalida = proceso.waitFor();

        }
        catch (IOException ioe) {
            System.err.println("Error al abrir el proceso. " + ioe.getMessage());
        }
        catch (InterruptedException ignored) { }
        finally {
            System.out.println("Fin de MostrarEntorno.");
            codigoSalida = 0;
        }
        System.out.println("\nFin del programa con código de salida: " + codigoSalida + "\n");
    }

}
