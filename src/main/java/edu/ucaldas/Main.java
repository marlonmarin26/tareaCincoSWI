package edu.ucaldas;

import java.util.Scanner;

import edu.ucaldas.controllers.ControlAlbum;
import edu.ucaldas.controllers.ControlBanda;
import edu.ucaldas.controllers.ControlCancion;
import edu.ucaldas.controllers.ControlMiembro;
import edu.ucaldas.model.Miembro;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Miembro miembro = new Miembro();

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
                        ControlAlbum.mostrarAlbunes();
                        break;
                    case 5:
                        consultarAlbumPorNombre();
                        break;
                    case 6:
                        ControlMiembro.agregarMiembros();
                        break;
                    case 7:
                        ControlMiembro.mostrarMiembros();
                        break;
                    case 8:
                        ControlBanda.agregarMiembroABanda();
                        break;
                    case 9:
                        ControlBanda.mostrarBanda();
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
                + " 6 - Agregar miembro                 \n"
                + " 7 - Mostrar miembro                 \n"
                + " 8 - agregar miembro a banda         \n"
                + " 9 - Mostrar banda                   \n"
                + "                                     \n"
                + "\nElija una opción (99 para salir) > ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

}
