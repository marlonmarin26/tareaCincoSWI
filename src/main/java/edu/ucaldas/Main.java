package edu.ucaldas;

import java.util.Scanner;

import edu.ucaldas.controllers.ControlAlbum;
import edu.ucaldas.controllers.ControlCancion;
import edu.ucaldas.model.Album;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            do {
                int opcion = leerOpcion();

                switch (opcion) {
                    case 1:
                        ControlCancion.agregarCanciones();
                        break;
                    case 2:
                        ControlCancion.mostrarCanciones();
                        break;
                    case 3:
                        ControlAlbum.crearAlbum();
                        break;
                    case 4:
                        ControlAlbum.mostrarAlbumes();
                        break;
                    case 5:
                        consultarAlbumPorNombre();
                        break;
                    case 6:
                        seleccionarCancionesParaAlbum();
                        break;
                    case 99:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void seleccionarCancionesParaAlbum() {
        System.out.print("Ingrese el nombre del álbum al que desea agregar canciones: ");
        String nombreAlbum = scanner.nextLine();

        // Obtener el álbum por nombre
        Album album = ControlAlbum.obtenerAlbumPorNombre(nombreAlbum);

        if (album != null) {
            // Pasa la lista de canciones al método seleccionarCancionesParaAlbum
            ControlAlbum.seleccionarCancionesParaAlbum(album, ControlCancion.getListaCanciones());
        } else {
            System.out.println("No se encontró un álbum con el nombre proporcionado: " + nombreAlbum);
        }
    }

    private static void consultarAlbumPorNombre() {
        System.out.print("Ingrese el nombre del álbum a consultar: ");
        String nombreAlbum = scanner.nextLine();
        ControlAlbum.consultarAlbumPorNombre(nombreAlbum);
    }

    private static int leerOpcion() {
        System.out.print("\n-----------------------------\n"
                + "        ROCK&CODE MENU               \n"
                + "-----------------------------        \n"
                + " 1 - Agregar canción                 \n"
                + " 2 - Mostrar canciones               \n"
                + " 3 - Crear álbum                     \n"
                + " 4 - Mostrar álbumes                 \n"
                + " 5 - Consultar álbum                 \n"
                + " 6 - Seleccionar canciones para álbum\n"
                + "                                     \n"
                + "\nElija una opción (99 para salir) > ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}
