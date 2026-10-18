package com.whisky.tema01;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FichaAgente {

    void main(String[] args) {
        showProcessInfo(args);
    }

    public static void showProcessInfo(String[] args) {
        String title = "Esto es una instancia de " + FichaAgente.class.getSimpleName();
        System.out.println(title);
        if (args.length != 0) {
            System.out.println("Alias: " + args[0]);
        }

        for (int i = 0; i < title.length(); i++) {
            System.out.print('-');
        }
        System.out.println();


        ProcessHandle process = ProcessHandle.current();
        ProcessHandle.Info processInfo = process.info();

        // PID
        System.out.println("PID:\t\t\t\t\t" + process.pid());

        // PID padre
        process.parent().ifPresentOrElse(
                FichaAgente::printParentInfo,
                FichaAgente::printParentError
        );

        // Usuario
        String user = processInfo.user()
                .orElse("No disponible");
        System.out.println("Usuario:\t\t\t\t" + user);

        // Instante de inicio
        String start = processInfo.startInstant()
                .map(Object::toString)
                .orElse("No disponible");
        System.out.println("Instante de inicio:\t\t" + start);

    }

    public static void printParentInfo(ProcessHandle process) {
        System.out.println("PID padre:\t\t\t\t" + process.pid());
    }
    public static void printParentError() {
        System.out.println("PID padre:\t\t\t\tProceso padre no disponible");
    }


    // con Optional<T> y ProcessHandle es mejor
    public static void printInstant() {
        System.out.printf("Fecha de inicio:\t\t\t%s\n", Instant.now().toString());
    }

    // SYSTEMD_EXEC_PID = PID
    // MANAGERPID = Parent PID
    // USER
}
