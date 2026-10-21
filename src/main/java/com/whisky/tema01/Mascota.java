package com.whisky.tema01;

public class Mascota {
    static String name;
    static int stepRate;
    static int stepCount = 0;
    final static int FINISH = 50;

    static void main(String[] args) throws InterruptedException {
        argsValidator(args);

        name = args[0];
        stepRate = Integer.parseInt(args[1]);

        ProcessHandle process = ProcessHandle.current();

        try {
            while (stepCount < FINISH) {
                Thread.sleep(500);
                printBar(process);
            }
        } catch (InterruptedException ie) {
            throw new InterruptedException("Ha habido un problema al intentar pausar el programa");
        }


        System.exit(0);
    }

    public static void argsValidator(String[] args) {
        if (args == null || args.length < 2) {
            IO.println("Incorrect call.\n\n'java Mascota <name> <stepRate>' was expected.");
            System.exit(1);
        }

        try {
            Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            IO.println("Incorrect call.\n\n<stepRate> must be an integer.");
            System.exit(2);
        }
    }

    public static void printBar(ProcessHandle process) {

        StringBuilder output = new StringBuilder();

        if (stepCount + stepRate >= FINISH) {
            for (int i = 0; i < FINISH; i++) {
                output.append('=');
            }
            IO.print("\r[" + name + ", PID: " + process.pid() + "]: " + output);
            System.exit(0);
        }

        for (int i = 0; i < stepCount - 1; i++) {
            output.append('=');
        }
        output.append('>');

        IO.print("\r[" + name + ", PID: " + process.pid() + "]: " + output);

        stepCount += stepRate;
    }

}
