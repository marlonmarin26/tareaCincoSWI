package edu.ucaldas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.Album;
import edu.ucaldas.model.Cancion;

public class ControlAlbum {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Album> listaAlbumes = new ArrayList<>();

    public static void crearAlbum() {
        List<Cancion> listaCanciones = ControlCancion.getListaCanciones();

        if (listaCanciones.isEmpty()) {
            System.out.println("No hay canciones para crear un álbum. Agregue canciones primero.");
            return;
        }

        System.out.println("Ingrese el nombre del álbum: ");
        String nombreAlbum = scanner.nextLine();

        Album album = new Album(nombreAlbum, LocalDate.now(), new ArrayList<>(listaCanciones));
        listaAlbumes.add(album);

        System.out.println("Álbum agregado exitosamente.");
    }

    public static void mostrarAlbumes() {
        if (!listaAlbumes.isEmpty()) {
            System.out.println("Álbumes y sus canciones:");
            for (Album album : listaAlbumes) {
                System.out.println(album.getNombre() + " - Fecha de lanzamiento: " + album.getFechaLanzamiento());
                for (Cancion cancion : album.getCancionesAlbum()) {
                    System.out.println("  - " + cancion.getNombre() + " (" + cancion.getDuracion() + ")");
                }
            }
        } else {
            System.out.println("No hay álbumes para mostrar.");
        }
    }

    public static void consultarAlbumPorNombre(String nombre) {
        for (Album album : listaAlbumes) {
            if (album.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Álbum encontrado:");
                System.out.println(album.getNombre() + " - Fecha de lanzamiento: " + album.getFechaLanzamiento());
                System.out.println("Canciones:");
                for (Cancion cancion : album.getCancionesAlbum()) {
                    System.out.println("  - " + cancion.getNombre() + " (" + cancion.getDuracion() + ")");
                }
                return; 
            }
        }
        System.out.println("No se encontró un álbum con el nombre proporcionado: " + nombre);
    }
}
