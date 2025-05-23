package services;

import java.util.Scanner;

//Clase de verificacion para la entrada segura y cntrolada de datos
public class Verificacion {

    private static final Scanner scanner = new Scanner(System.in);


    //Entrada de datos enteros
    public static int entero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                return val;
            } else {
                System.out.println("\nError\uD83D\uDE20!!! \nDebe ingresar un numero entero.");
                scanner.next();
            }
        }
    }

    //Entrada de datos entros entre un rango
    public static int enteroEntre(String mensaje, int min, int max) {
        while (true) {
            int num = entero(mensaje);
            if (num >= min && num <= max) {
                return num;
            } else {
                System.out.println("\nError\uD83D\uDE20!!! \nEl numero debe estar entre " + min + " y " + max + ".");
            }
        }
    }

    //Entrada de datos enteros desde un numero
    public static int enteroMayorQue(String mensaje, int min) {
        while (true) {
            int num = entero(mensaje);
            if (num > min) {
                return num;
            } else {
                System.out.println("\nError\uD83D\uDE20!!! \nEl numero debe ser mayor que " + min + ".");
            }
        }
    }

    //Entrada de datos double desde un numero
    public static double doubleMayorQue(String mensaje, int min) {
        while (true) {
            double num = doble(mensaje);
            if (num > min) {
                return num;
            } else {
                System.out.println("\nError\uD83D\uDE20!!! \nEl numero debe ser mayor que " + min + ".");
            }
        }
    }

    //Entrada de datos dobles
    public static double doble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                return val;
            } else {
                System.out.println("\nError\uD83D\uDE20!!! \nDebe ingresar un numero decimal.");
                scanner.next();
            }
        }
    }

    //Entrada de datos float
    public static float flotante(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextFloat()) {
                float val = scanner.nextFloat();
                return val;
            } else {
                System.out.println("\nError\uD83D\uDE20!!! \nDebe ingresar un numero decimal (float).");
                scanner.next();
            }
        }
    }

    //Entrada de datos tipo cadena
    public static String cadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }


    //Entrada para booleano
    public static boolean booleano(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (si/no): ");
            String entrada = scanner.next().toLowerCase();

            if (entrada.equals("s") || entrada.equals("si")) {
                return true;
            } else if (entrada.equals("n") || entrada.equals("no")) {
                return false;
            } else {
                System.out.println("\nError\uD83D\uDE20!!! \nResponda con 'Si' o 'No'.");
            }
        }
    }

}
