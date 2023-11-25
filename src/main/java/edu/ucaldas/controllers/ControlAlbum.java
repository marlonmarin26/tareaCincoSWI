package edu.ucaldas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.Album;
import edu.ucaldas.model.Cancion;

public class ControlAlbum {

    private static Scanner scanner = new Scanner(System.in);
    public static List<Album> listaAlbumes = new ArrayList<>();

    /**
     * Crea un nuevo álbum y lo agrega a la lista de álbumes.
     */
    public void crearAlbum() {
        boolean deseaAgregarMasAlbumes = true;

        do {
            System.out.println("Ingrese el nombre del álbum: ");
            String nombreAlbum = scanner.nextLine();

            System.out.println("Ingrese la fecha de lanzamiento del álbum (formato YYYY-MM-DD): ");
            String fechaString = scanner.nextLine();
            LocalDate fechaLanzamiento = LocalDate.parse(fechaString);

            Album album = new Album(nombreAlbum, fechaLanzamiento);
            album.setCancionesAlbum(new ArrayList<>());
            listaAlbumes.add(album);

            System.out.println("Álbum agregado exitosamente.");

            // Preguntar si desea agregar más álbumes
            System.out.print("¿Desea agregar más álbumes? (Sí/No): ");
            String respuesta = scanner.next().toLowerCase();
            deseaAgregarMasAlbumes = respuesta.equals("si") || respuesta.equals("sí");

            // Consumir el salto de línea pendiente
            scanner.nextLine();

        } while (deseaAgregarMasAlbumes);

        System.out.println("Operación de agregar álbumes completada.");
    }

    /**
     * Permite al usuario seleccionar un álbum de la lista de álbumes
     * disponibles, seleccionar canciones de la lista de canciones disponibles y
     * agregarlas al álbum seleccionado.
     * 
     * @param listaAlbumes
     * @param listaCanciones
     */
    public void seleccionarCancionesParaAlbum(List<Album> listaAlbumes, List<Cancion> listaCanciones) {
        // Mostrar la lista de álbumes disponibles
        System.out.println("Lista de álbumes disponibles:");
        for (int i = 0; i < listaAlbumes.size(); i++) {
            System.out.println((i + 1) + ". " + listaAlbumes.get(i).getNombre());
        }

        // Solicitar al usuario que seleccione un álbum
        int indiceAlbumSeleccionado;
        Album albumSeleccionado = null;
        do {
            System.out.print("Seleccione el número del álbum al que desea agregar canciones (o 0 para cancelar): ");
            indiceAlbumSeleccionado = scanner.nextInt();

            if (indiceAlbumSeleccionado >= 1 && indiceAlbumSeleccionado <= listaAlbumes.size()) {
                albumSeleccionado = listaAlbumes.get(indiceAlbumSeleccionado - 1);
            } else if (indiceAlbumSeleccionado != 0) {
                System.out.println("Número de álbum no válido.");
            }
        } while (albumSeleccionado == null && indiceAlbumSeleccionado != 0);

        if (albumSeleccionado != null) {
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

                    // Verificar si la canción ya está en el álbum
                    if (!albumSeleccionado.getCancionesAlbum().contains(cancionSeleccionada)) {
                        albumSeleccionado.getCancionesAlbum().add(cancionSeleccionada);
                        System.out.println("Canción agregada al álbum exitosamente.");
                    } else {
                        System.out.println("La canción ya está en el álbum.");
                    }
                } else if (indiceCancionSeleccionada != 0) {
                    System.out.println("Número de canción no válido.");
                }
            } while (indiceCancionSeleccionada != 0);

            System.out.println("Operación de agregar canciones al álbum completada.");
        } else {
            System.out.println("Operación cancelada. No se ha seleccionado ningún álbum.");
        }
    }

    /**
     * Consulta y muestra la información de un álbum dado su nombre.
     * Solicita al usuario ingresar el nombre del álbum a consultar y luego muestra
     * detalles como el nombre, fecha de lanzamiento y la lista de canciones del
     * álbum.
     * Si el álbum no se encuentra, se muestra un mensaje indicando la ausencia.
     */
    public void consultarAlbum() {
        // Solicitar al usuario ingresar el nombre del álbum a consultar
        System.out.print("Ingrese el nombre del álbum a consultar: ");
        String nombreAlbum = scanner.nextLine();

        // Bandera para indicar si se encontró el álbum
        boolean albumEncontrado = false;

        // Iterar sobre la lista de álbumes para buscar el álbum por nombre
        for (Album album : listaAlbumes) {
            // Comparar el nombre del álbum ignorando mayúsculas y minúsculas
            if (album.getNombre().equalsIgnoreCase(nombreAlbum)) {
                albumEncontrado = true;

                // Mostrar información del álbum encontrado
                System.out.println("Información del álbum:");
                System.out.println("Nombre: " + album.getNombre());
                System.out.println("Fecha de lanzamiento: " + album.getFechaLanzamiento());

                // Obtener la lista de canciones del álbum
                List<Cancion> canciones = album.getCancionesAlbum();

                // Verificar si el álbum tiene canciones y mostrarlas
                if (canciones != null && !canciones.isEmpty()) {
                    System.out.println("Canciones:");
                    for (Cancion cancion : canciones) {
                        System.out.println("- " + cancion.getNombre() + " (" + cancion.getDuracion() + ")");
                    }
                } else {
                    System.out.println("El álbum no tiene canciones.");
                }

                // No es necesario seguir buscando, salir del bucle
                break;
            }
        }

        // Mostrar mensaje si el álbum no se encontró
        if (!albumEncontrado) {
            System.out.println("No se encontró un álbum con el nombre proporcionado: " + nombreAlbum);
        }
    }

    /**
     * Muestra la lista de álbumes disponibles.
     */
    public static List<Album> getListaAlbumes() {
        return listaAlbumes;
    }

}
