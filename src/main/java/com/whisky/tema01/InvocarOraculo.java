package com.whisky.tema01;

import java.io.IOException;

public class InvocarOraculo {

    static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");
        String packageName = InvocarOraculo.class.getPackageName() + ".Oraculo";
        String name = "Amazon Q";
        String question = "¿Cuál va a ser el número de la lotería?";

        int exitCode = -1;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath,
                    packageName,
                    name,
                    question
            );

            builder.inheritIO();
            Process process = builder.start();
            exitCode = process.waitFor();
        }
        catch (IOException ioe) {
            throw new IOException("Se ha producido un error de entrada/salida:\n" +
                    ioe.getMessage());
        }
        catch (InterruptedException ie) {
            throw new InterruptedException("Se ha interrumpido el hilo principal");
        }
        finally {
            IO.println("\nFin del programa.\nExit code: " + exitCode);
        }


    }
}
