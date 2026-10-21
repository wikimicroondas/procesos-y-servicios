package com.whisky.tema01;

import java.io.IOException;

public class Hipodromo {

    static void main(String[] args) throws IOException, InterruptedException {

        String classpath = System.getProperty("java.class.path");
        String packageName = Mascota.class.getPackageName() + ".Mascota";

        String[] gallinaArgs = {"Gallina", "2"};
        String[] perroArgs = {"Perro", "4"};
        String[] caballoArgs = {"Caballo", "7"};

        String resultado = "";
        try {
            ProcessBuilder gallina = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath,
                    packageName,
                    gallinaArgs[0],
                    gallinaArgs[1]
            );
            ProcessBuilder perro = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath,
                    packageName,
                    perroArgs[0],
                    perroArgs[1]
            );
            ProcessBuilder caballo = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath,
                    packageName,
                    caballoArgs[0],
                    caballoArgs[1]
            );

            gallina.inheritIO();

            Process p1 = gallina.start();
            Process p2 = perro.start();
            Process p3 = caballo.start();

            while (true) {
                if (!p1.isAlive()) {
                    resultado = "La gallina ha ganado.";
                    p2.destroy();
                    p3.destroy();
                    break;
                }
                if (!p2.isAlive()) {
                    resultado = "El perro ha ganado.";
                    p1.destroy();
                    p3.destroy();
                    break;
                }
                if (!p3.isAlive()) {
                    resultado = "El caballo ha ganado.";
                    p1.destroy();
                    p2.destroy();
                    break;
                }

                Thread.sleep(50);
            }
        }
        catch (IOException ioe) {
            throw new IOException("Se ha producido un error de entrada/salida:\n" +
                    ioe.getMessage());
        }
        catch (InterruptedException ie) {
            throw new InterruptedException("Se ha interrumpido el hilo principal");
        }
        finally {
            IO.print("\n" + resultado);
            System.exit(0);
        }

    }
}
