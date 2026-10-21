package com.whisky.tema01;

import java.io.IOException;
import java.util.Map;

public class ControlMision {

    static void main(String[] args) throws IOException {
        String classpath = System.getProperty("java.class.path");
        String packageName = ControlMision.class.getPackageName() + ".Starship";

        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "java",
                    "-cp",
                    classpath,
                    packageName
            );

            Map<String, String> entorno = builder.environment();
            entorno.put("PLANETA", "A-067");

            builder.inheritIO();
            builder.start();

        }
        catch (IOException ioe) {
            throw new IOException("Se ha producido un error de entrada/salida:\n" +
                    ioe.getMessage());
        }
    }
}
