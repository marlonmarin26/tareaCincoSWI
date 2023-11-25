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
        Album album = crearAlbumBasico();

        List<Cancion> listaCanciones = ControlCancion.getListaCanciones();
        seleccionarCancionesParaAlbum(album, listaCanciones);

        listaAlbumes.add(album);

        System.out.println("Álbum agregado exitosamente.");
    }

    public static void mostrarAlbunes() {
        if (!listaAlbumes.isEmpty()) {
            System.out.println("Álbunes y sus canciones:");
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

    public static Album crearAlbumBasico() {
        System.out.println("Ingrese el nombre del álbum: ");
        String nombreAlbum = scanner.nextLine();

        System.out.println("Ingrese la fecha de lanzamiento del álbum (formato YYYY-MM-DD): ");
        String fechaString = scanner.nextLine();
        LocalDate fechaLanzamiento = LocalDate.parse(fechaString);

        return new Album(nombreAlbum, fechaLanzamiento, new ArrayList<>());
    }

    public static void seleccionarCancionesParaAlbum(Album album, List<Cancion> listaCanciones) {
        // Mostrar la lista de canciones disponibles
        System.out.println("Lista de canciones disponibles:");
        for (int i = 0; i < listaCanciones.size(); i++) {
            System.out.println((i + 1) + ". " + listaCanciones.get(i).getNombre());
        }

        // Solicitar al usuario que seleccione canciones hasta que decida parar
        int indiceCancionSeleccionada;
        do {
            System.out.print("Seleccione el número de la canción que desea agregar al álbum (o 0 para terminar): ");
            indiceCancionSeleccionada = scanner.nextInt();

            if (indiceCancionSeleccionada >= 1 && indiceCancionSeleccionada <= listaCanciones.size()) {
                Cancion cancionSeleccionada = listaCanciones.get(indiceCancionSeleccionada - 1);
                album.getCancionesAlbum().add(cancionSeleccionada);
                System.out.println("Canción agregada al álbum exitosamente.");
            } else if (indiceCancionSeleccionada != 0) {
                System.out.println("Número de canción no válido.");
            }
        } while (indiceCancionSeleccionada != 0);
    }

    public static Album obtenerAlbumPorNombre(String nombre) {
        for (Album album : listaAlbumes) {
            if (album.getNombre().equalsIgnoreCase(nombre)) {
                return album;
            }
        }
        return null; // Si no se encuentra un álbum con el nombre proporcionado
    }

    public static List<Album> getListaAlbumes() {
        return listaAlbumes;
    }
    
}
