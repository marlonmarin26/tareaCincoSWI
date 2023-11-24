package edu.ucaldas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.Cancion;

public class ControlCancion {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Cancion> listaCanciones = new ArrayList<>();

    public static List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public static void agregarCanciones() {
        Cancion cancion = new Cancion("Hola", "3 Minutos");
        Cancion cancion1 = new Cancion("Dia", "3 Minutos");
        Cancion cancion2 = new Cancion("Mañana", "3 Minutos");

        listaCanciones.add(cancion);
        listaCanciones.add(cancion1);
        listaCanciones.add(cancion2);
        System.out.println("Canciones agregadas exitosamente.");
    }

    // Opción para agregar canciones, no se usa en el programa
    public static void agregarCancion() {
        do {
            System.out.print("Ingrese el nombre de la canción: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la duración de la canción: ");
            String duracion = scanner.nextLine();

            Cancion cancion = new Cancion(nombre, duracion);
            listaCanciones.add(cancion);

            System.out.print("¿Desea agregar otra canción? (S/N): ");
            String respuesta = scanner.nextLine();

            if (!respuesta.equalsIgnoreCase("S")) {
                break;
            }
        } while (true);

        System.out.println("Canciones agregadas exitosamente.");
    }

    public static void mostrarCanciones() {
        if (!listaCanciones.isEmpty()) {
            System.out.println("Canciones:");
            for (Cancion cancion : listaCanciones) {
                System.out.println(cancion);
            }
        } else {
            System.out.println("No hay canciones para mostrar.");
        }
    }
}
