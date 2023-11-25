package edu.ucaldas;

import java.util.List;
import java.util.Scanner;

import edu.ucaldas.controllers.ControlAlbum;
import edu.ucaldas.controllers.ControlBanda;
import edu.ucaldas.controllers.ControlCancion;
import edu.ucaldas.controllers.ControlMiembro;
import edu.ucaldas.model.Album;
import edu.ucaldas.model.Banda;
import edu.ucaldas.model.Miembro;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Miembro miembro = new Miembro();

    public static void main(String[] args) {
        ControlBanda controlBanda = new ControlBanda();
        controlBanda.seleccionarFotos();
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
                        seleccionarCancionesParaAlbum();
                        break;
                    case 7:
                        ControlBanda.datosCrearBanda();
                        break;
                    case 8:
                        ControlBanda.actualizarBanda();
                        break;
                    case 9: 
                        ControlMiembro.agregarMiembros();
                        break;
                    case 10: 
                        ControlMiembro.agregarFotos();
                        break;
                    case 11:
                        buscarFoto();
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
    public static void buscarFoto(){
        ControlBanda controlBanda = new ControlBanda();
        controlBanda.seleccionarFotos();
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
                + " 7 - crear banda                     \n"
                + " 8 - actualizar banda                \n"
                + " 9 - agregar miembros                \n"
                + " 10 - agregar fotos                  \n"
                + "                                     \n"
                + "\nElija una opción (99 para salir) > ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}
