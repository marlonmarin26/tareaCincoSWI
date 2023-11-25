package edu.ucaldas.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.Album;
import edu.ucaldas.model.Cancion;
import edu.ucaldas.model.Concierto;
import edu.ucaldas.model.ConciertoException;

public class ControlConcierto {

    private List<Concierto> conciertos;

    public ControlConcierto() {
        this.conciertos = new ArrayList<>();
    }

    public void agregarConcierto(String nombre, LocalDate fecha, String lugar, LocalTime hora,
            int capacidad, int boletasVendidas) {

        Concierto nuevoConcierto = new Concierto(nombre, fecha, lugar, hora, capacidad, boletasVendidas, null);

        conciertos.add(nuevoConcierto);
    }

    public void agregarCancionesConcierto(){
        Scanner scanner = new Scanner(System.in);
        boolean continuarIngresando = true;
        System.out.println("Ingrese el nombre del concierto: ");
        String nombreConcierto = scanner.nextLine();
        Concierto concierto = buscarConciertoPorNombre(nombreConcierto);
        if (concierto != null) {
            while (continuarIngresando) {
                System.out.println("Ingrese el nombre del álbum: ");
                String nombreAlbum = scanner.nextLine();
                List<Album> album = ControlAlbum.getListaAlbumes();
                System.out.println("Ingrese el nombre de la canción: ");
                String nombreCancion = scanner.nextLine();
                for (Album album2 : album) {
                    if (album2.getNombre().equals(nombreAlbum)) {
                        List<Cancion> canciones = album2.getCancionesAlbum();
                        for (Cancion cancion : canciones) {
                            if (cancion.getNombre().equals(nombreCancion)) {
                                concierto.getCancionesConcierto().add(cancion);
                                System.out.println("Canción agregada exitosamente");
                            }else{
                                System.out.println("No se encontró la canción");
                            }
                        }
                    }else{
                        System.out.println("No se encontró el álbum");
                    }
                }
                System.out.println("¿Desea ingresar otra canción? (Si/No)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("No")) {
                    continuarIngresando = false;
                }
            }
        }
    }

    public Concierto buscarConciertoPorNombre(String nombre) throws ConciertoException{
        for (Concierto concierto : conciertos) {
            if (concierto.getNombre().equals(nombre)) {
                return concierto;
            }
        }
        throw new ConciertoException("El concierto " + nombre + " no ha sido realizado");
    }

    public void registrarBoletos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del concierto: ");
        String nombreConcierto = scanner.nextLine();
        Concierto concierto = buscarConciertoPorNombre(nombreConcierto);
        if (concierto != null) {
            System.out.println("Ingrese el número de boletas vendidas: ");
            int numeroBoletos = scanner.nextInt();
            scanner.nextLine();
            concierto.setBoletasVendidas(numeroBoletos);
        } else {
            System.out.println("No se encontró el concierto");
        }
    }

    public void conciertosRealizados(){
        for (Concierto concierto : conciertos) {
            System.out.println("Nombre: " + concierto.getNombre() + ", Fecha" + concierto.getFecha() + ", Lugar" + concierto.getLugar() + ", Boletas Vendidas: " + concierto.getBoletasVendidas());
        }
    }



}
