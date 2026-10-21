package com.whisky.tema01;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Oraculo {
    static String alias;

    static void main(String[] args) {
        argsValidator(args);

        alias = args[0];
        IO.println(alias + "\n:-._.-._.-._.-._.-:");

        int oracle = Arrays.stream(args)
                .skip(1)
                .flatMapToInt(String::chars)
                .reduce(0, (a, b) -> a += b) % 10;

        callOracle(oracle);
    }


    public static void argsValidator(String[] args) {
        if (args == null || args.length < 2) {
            IO.println("Incorrect call.\n\n'java Oraculo <name> <question>' was expected.");
            System.exit(1);
        }
    }

    public static void callOracle(int n) {
        String[] possibilities = {
                "Los reyes magos son los padres",
                alias,
                "El scroll infinito fue un error",
                "Las súperbacterias serán completamente inmunes a la penicilina en 2050",
                "Se han acabado los tokens por hoy, se reestablecerán a las " + timeThere(),
                "No",
                "Muy buena pregunta",
                "creat()",
                "Si mueres con dinero en el banco, has hecho mal las cuentas",
                "\n\n\n\n\t\t<div align=\"center\"></div>\n\n\n\n"
        };

        IO.println(possibilities[n]);
    }

    public static String timeThere() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm z")
                .withZone(ZoneId.systemDefault());
        return f.format(Instant.now().plusSeconds(21_600));
    }

}
