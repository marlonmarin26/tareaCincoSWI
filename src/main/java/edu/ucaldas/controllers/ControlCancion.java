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

    /**
     * Crea canciones por defecto para luego añadirlas al album.
     */
    public void crearCanciones() {
        Cancion cancion1 = new Cancion("Bohemian Rhapsody", "5:55");
        Cancion cancion2 = new Cancion("Imagine", "3:03");
        Cancion cancion3 = new Cancion("Hotel California", "6:30");
        Cancion cancion4 = new Cancion("Like a Rolling Stone", "6:13");
        Cancion cancion5 = new Cancion("Billie Jean", "4:54");
        Cancion cancion6 = new Cancion("Hey Jude", "7:11");
        Cancion cancion7 = new Cancion("Let It Be", "3:50");
        Cancion cancion8 = new Cancion("Stairway to Heaven", "8:02");
        Cancion cancion9 = new Cancion("Yesterday", "2:05");
        Cancion cancion10 = new Cancion("Purple Haze", "2:51");
        Cancion cancion11 = new Cancion("Sweet Child o' Mine", "5:55");
        Cancion cancion12 = new Cancion("Imagine", "3:03");

        listaCanciones.add(cancion1);
        listaCanciones.add(cancion2);
        listaCanciones.add(cancion3);
        listaCanciones.add(cancion4);
        listaCanciones.add(cancion5);
        listaCanciones.add(cancion6);
        listaCanciones.add(cancion7);
        listaCanciones.add(cancion8);
        listaCanciones.add(cancion9);
        listaCanciones.add(cancion10);
        listaCanciones.add(cancion11);
        listaCanciones.add(cancion12);

        System.out.println("Canciones creadas exitosamente.");
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

    // No se está usando en el programa
    /**
     * Muestra la lista de canciones registradas.
     */
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
