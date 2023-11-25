package edu.ucaldas.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.ucaldas.model.Banda;
import edu.ucaldas.model.Foto;
import edu.ucaldas.model.Miembro;
import edu.ucaldas.model.MiembroExcepcion;
import edu.ucaldas.model.Rol;

public class ControlBanda {
    private static Banda banda;

    public static void agregarMiembro(Miembro miembro) {
        try {
            banda.adicionarMiembro(miembro);
        } catch (MiembroExcepcion e) {
            // Manejar la excepción
        }
    }

    public static void eliminarMiembro(Miembro miembro) {
        try {
            banda.eliminarMiembro(miembro);
        } catch (MiembroExcepcion e) {
            // Manejar la excepción
        }
    }

    public static void actualizarBanda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el genero de la banda: ");
        String genero = scanner.nextLine();
        System.out.println("Ingrese la fecha de creación de la banda: ");
        LocalDate fechaCreacion = LocalDate.now();
        System.out.println("Ingrese las fotos de la banda: ");
        List<Foto> fotos = seleccionarFotos();
        System.out.println("Ingrese los miembros de la banda: ");
        List<Miembro> miembros = ingresarMiembros();
        scanner.close();
        crearActualizarBanda(genero, fechaCreacion, fotos, miembros);
    }

    public static void crearActualizarBanda(String genero, LocalDate fechaCreacion, List<Foto> fotos,
            List<Miembro> miembros) {
        if (banda == null) {
            banda = new Banda(genero, fechaCreacion, fotos, miembros);
        } else {
            banda.setGenero(genero);
            banda.setFechaCreacion(fechaCreacion);
            banda.setFotos(fotos);
            banda.setMiembros(miembros);
        }
    }

    public static void datosCrearBanda() {
        Scanner scanner = new Scanner(System.in);

        // Crear o actualizar banda
        System.out.print("Ingrese el genero de la banda: ");
        String genero = scanner.nextLine();
        LocalDate fechaCreacion = LocalDate.now();
        List<Foto> fotos = seleccionarFotos();
        List<Miembro> miembros = ingresarMiembros();

        scanner.close();
        crearActualizarBanda(genero, fechaCreacion, fotos, miembros);
    }

    public static List<Foto> seleccionarFotos() {
        List<Foto> fotos = new ArrayList<>();
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for (File file : selectedFiles) {
                Foto foto = new Foto(file.toURI().toString());
                fotos.add(foto);
            }
        } else {
            System.out.println("Operación cancelada por el usuario.");
        }
        return fotos;
    }

    public static List<Miembro> ingresarMiembros() {
        List<Miembro> miembros = new ArrayList<>();
        boolean continuarIngresando = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Ingrese el nombre del miembro: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el rol del miembro: ");
            String rolMiembro = scanner.nextLine().toUpperCase();
            Rol rol = Rol.valueOf(rolMiembro);

            System.out.print("Ingrese el instrumento que utiliza el miembro: ");
            String instrumentos = scanner.nextLine();

            Miembro miembro = new Miembro(nombre, rol, instrumentos);
            miembros.add(miembro);

            System.out.print("¿Quieres ingresar otro miembro? (Si/No): ");
            String respuesta = scanner.nextLine().toLowerCase();

            if (!respuesta.equals("si")) {
                continuarIngresando = false;
            }
        } while (continuarIngresando);

        scanner.close();
        return miembros;
    }
}