package main.java.utils;

public class Reporte {

    public static void registrarPaso(String mensaje, boolean exitoso) {
        String estado = exitoso ? "[OK]" : "[ERROR]";
        System.out.println(estado + " " + mensaje);
    }
}