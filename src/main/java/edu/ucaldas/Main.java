package edu.ucaldas;

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ucaldas.controllers.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static ControlBanda controlBanda = new ControlBanda();
    static ControlConcierto controlConcierto = new ControlConcierto();
    static ControlMiembro controlMiembro = new ControlMiembro();
    static ControlAlbum controlAlbum = new ControlAlbum();
    static ControlCancion controlCancion = new ControlCancion();

    public static void main(String[] args) {
        try {
            do {
                int opcion = leerOpcion();

                switch (opcion) {
                    case 1:
                        controlBanda.registrarBanda();
                        break;
                    case 2:
                        controlBanda.mostrarBanda();
                        break;
                    case 3:
                        // Aun no funciona seleccionarFotos
                        controlBanda.actualizarBanda();
                        break;
                    case 4:
                        controlMiembro.crearMiembros();
                        break;
                    case 5:
                        // Falta validar corretamente que exista la banda
                        controlBanda.agregarMiembroBanda();
                        break;
                    case 6:
                        controlBanda.eliminarMiembroBanda();
                        break;
                    case 7:
                        controlAlbum.crearAlbum();
                        break;
                    case 8:
                        controlCancion.crearCanciones();
                        break;
                    case 9:
                        controlAlbum.seleccionarCancionesParaAlbum(ControlAlbum.getListaAlbumes(),
                                ControlCancion.getListaCanciones());
                        break;
                    case 10:
                        controlAlbum.consultarAlbum();
                        break;
                    case 11:
                        controlConcierto.programarConcierto();
                        break;
                    case 12:
                        controlConcierto.agregarCancionesConcierto();
                        break;
                    case 13:
                        controlConcierto.registrarBoletosVendidos();
                        break;
                    case 14:
                        controlConcierto.consultarConciertos();
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

    private static int leerOpcion() {
        int opcion = 0;

        try {
            System.out.print("\n----------------------------- \n"
                    + "        ROCK&CODE MENU                 \n"
                    + "-----------------------------          \n"
                    + " 1 - Crear banda ROCK&CODE             \n"
                    + " 2 - Mostrar información de la banda   \n"
                    + " 3 - Actualizar banda                  \n"
                    + " 4 - Crear miembros                    \n"
                    + " 5 - Agregar miembros a la banda       \n"
                    + " 6 - Eliminar miembros de la banda     \n"
                    + " 7 - Lanzar álbum                      \n"
                    + " 8 - Crear canciones                   \n"
                    + " 9 - Agregar canciones a álbum         \n"
                    + " 10 - Consultar álbum                  \n"
                    + " 11 - Programar un concierto           \n"
                    + " 12 - Agregar canciones a concierto    \n"
                    + " 13 - Registrar boletos vendidos       \n"
                    + " 14 - Mostrar todos los conciertos     \n"
                    + "                                       \n"
                    + "\nElija una opción (99 para salir) > ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        } catch (NoSuchElementException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine(); // Consumir la entrada no válida
        }

        return opcion;
    }

}
