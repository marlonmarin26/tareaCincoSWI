package edu.ucaldas.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.*;

/**
 * Controlador para realizar operaciones con conciertos, como programar
 * conciertos, agregar canciones a un concierto, registrar boletos vendidos,
 * consultar información de un concierto, etc.
 * 
 * @author MJP
 * @version 1.0
 */
public class ControlConcierto {

    private static Scanner scanner = new Scanner(System.in);
    private List<Concierto> conciertos;

    /**
     * Constructor por defecto.
     */
    public ControlConcierto() {
        this.conciertos = new ArrayList<>();
    }

    /**
     * @return the conciertos
     */
    public List<Concierto> getConciertos() {
        return conciertos;
    }

    /**
     * Permite al usuario ingresar la información de un nuevo concierto y lo agrega
     * a la lista de conciertos.
     */
    public void programarConcierto() {
        try {
            System.out.print("Ingrese el nombre del concierto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la fecha del concierto (formato YYYY-MM-DD): ");
            LocalDate fecha = LocalDate.parse(scanner.nextLine());

            System.out.print("Ingrese el lugar del concierto: ");
            String lugar = scanner.nextLine();

            System.out.print("Ingrese la hora del concierto (formato HH:mm): ");
            LocalTime hora = LocalTime.parse(scanner.nextLine());

            int capacidad;
            do {
                System.out.print("Ingrese la capacidad del concierto: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); // Consumir la entrada no válida
                }
                capacidad = scanner.nextInt();
                if (capacidad <= 0) {
                    System.out.println("La capacidad debe ser un número positivo.");
                }
            } while (capacidad <= 0);

            // Consumir la nueva línea después de leer el entero
            scanner.nextLine();

            // Crear un nuevo concierto con la información proporcionada
            Concierto nuevoConcierto = new Concierto(nombre, fecha, lugar, hora, capacidad, 0, new ArrayList<>());

            // Agregar el nuevo concierto a la lista de conciertos
            conciertos.add(nuevoConcierto);

            System.out.println("Concierto programado exitosamente.");
        } catch (DateTimeParseException e) {
            System.out.println("Error al analizar la fecha u hora. Asegúrese de ingresar el formato correcto.");
        } finally {

        }
    }

    /**
     * Permite al usuario seleccionar un concierto de la lista de conciertos
     * disponibles, seleccionar canciones de la lista de canciones disponibles y
     * agregarlas al concierto seleccionado.
     */
    public void agregarCancionesConcierto() {
        try {

            // Mostrar la lista de conciertos disponibles
            mostrarListaConciertos();

            // Solicitar al usuario que seleccione un concierto
            System.out.print("Seleccione el número del concierto al que desea agregar canciones (o 0 para salir): ");
            int indiceConciertoSeleccionado = scanner.nextInt();

            if (indiceConciertoSeleccionado >= 1 && indiceConciertoSeleccionado <= conciertos.size()) {
                Concierto conciertoSeleccionado = conciertos.get(indiceConciertoSeleccionado - 1);

                // Mostrar la lista de canciones disponibles en álbumes
                List<Cancion> cancionesDisponibles = obtenerCancionesEnAlbumes();
                System.out.println("Lista de canciones disponibles:");
                mostrarListaCanciones(cancionesDisponibles);

                // Solicitar al usuario que seleccione canciones hasta que decida parar
                int indiceCancionSeleccionada;
                do {
                    System.out.print(
                            "Seleccione el número de la canción que desea agregar al concierto (o 0 para terminar): ");
                    indiceCancionSeleccionada = scanner.nextInt();

                    if (indiceCancionSeleccionada >= 1 && indiceCancionSeleccionada <= cancionesDisponibles.size()) {
                        Cancion cancionSeleccionada = cancionesDisponibles.get(indiceCancionSeleccionada - 1);

                        // Agregar la canción directamente al concierto
                        conciertoSeleccionado.getCancionesConcierto().add(cancionSeleccionada);
                        System.out.println("Canción agregada al concierto exitosamente.");
                    } else if (indiceCancionSeleccionada != 0) {
                        System.out.println("Número de canción no válido.");
                    }
                } while (indiceCancionSeleccionada != 0);

                System.out.println("Operación de agregar canciones al concierto completada.");
            } else {
                System.out.println("Número de concierto no válido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine(); // Consumir la entrada no válida
        }
    }

    /**
     * Muestra la lista de conciertos disponibles.
     */
    private void mostrarListaConciertos() {
        System.out.println("Lista de conciertos disponibles:");
        for (int i = 0; i < conciertos.size(); i++) {
            System.out.println((i + 1) + ". " + conciertos.get(i).getNombre());
        }
    }

    /**
     * Muestra la lista de canciones disponibles.
     */
    private void mostrarListaCanciones(List<Cancion> canciones) {
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println((i + 1) + ". " + canciones.get(i).getNombre());
        }
    }

    /**
     * Obtiene la lista de canciones que están en álbumes.
     * 
     * @return Lista de canciones que están en álbumes.
     */
    private List<Cancion> obtenerCancionesEnAlbumes() {
        List<Cancion> cancionesEnAlbumes = new ArrayList<>();

        // Iterar sobre los álbumes
        for (Album album : ControlAlbum.listaAlbumes) {
            // Obtener las canciones del álbum y agregarlas a la lista
            List<Cancion> cancionesAlbum = album.getCancionesAlbum();
            if (cancionesAlbum != null) {
                cancionesEnAlbumes.addAll(cancionesAlbum);
            }
        }

        return cancionesEnAlbumes;
    }

    /**
     * Permite al usuario seleccionar un concierto de la lista de conciertos
     * disponibles y registrar el número de boletos vendidos para ese concierto.
     */
    public void registrarBoletosVendidos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del concierto: ");
        String nombreConcierto = scanner.nextLine();

        try {
            Concierto concierto = buscarConciertoPorNombre(nombreConcierto);

            if (concierto != null) {
                System.out.print("Ingrese el número de boletas vendidas: ");
                int numeroBoletos = scanner.nextInt();

                // Consumir la nueva línea después de leer el entero
                scanner.nextLine();

                concierto.setBoletasVendidas(numeroBoletos);
                System.out.println("Boletos registrados exitosamente.");
            }
        } catch (ConciertoException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine(); // Consumir la entrada no válida
        }
    }

    /**
     * Busca un concierto por su nombre en la lista de conciertos.
     */
    public Concierto buscarConciertoPorNombre(String nombre) {
        for (Concierto concierto : conciertos) {
            if (concierto.getNombre().equals(nombre)) {
                return concierto;
            }
        }
        return null;
    }

    /**
     * Muestra la información de todos los conciertos registrados.
     */
    public void consultarConciertos() {
        for (Concierto concierto : conciertos) {
            System.out.println("Información del concierto:");
            System.out.println("Nombre: " + concierto.getNombre());
            System.out.println("Fecha: " + concierto.getFecha());
            System.out.println("Lugar: " + concierto.getLugar());
            System.out.println("Hora: " + concierto.getHora());
            System.out.println("Capacidad: " + concierto.getCapacidad());
            System.out.println("Boletos Vendidos: " + concierto.getBoletasVendidas());

            List<Cancion> cancionesConcierto = concierto.getCancionesConcierto();
            if (cancionesConcierto != null && !cancionesConcierto.isEmpty()) {
                System.out.println("Canciones:");
                for (Cancion cancion : cancionesConcierto) {
                    System.out.println("- " + cancion.getNombre() + " (" + cancion.getDuracion() + ")");
                }
            } else {
                System.out.println("El concierto no tiene canciones.");
            }

            System.out.println("------------------------------");
        }
    }

}
