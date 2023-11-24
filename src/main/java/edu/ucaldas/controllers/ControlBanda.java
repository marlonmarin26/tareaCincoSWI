package edu.ucaldas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.Album;
import edu.ucaldas.model.Banda;

import edu.ucaldas.model.Foto;
import edu.ucaldas.model.Miembro;
import edu.ucaldas.model.MiembroExcepcion;

public class ControlBanda {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Banda> listaBanda = new ArrayList<>();

    /*
     * método para agregar miembros a la banda
     */
    public static void agregarMiembroABanda() {
        List<Miembro> listaMiembros = ControlMiembro.getListaMiembros();
        try {
            System.out.println("Ingrese el nombre del miembro a ingresar: ");
            String nombre = scanner.nextLine();
            System.out.println("**********");

            Miembro miembro = new Miembro();
            Miembro miembroAgregar = miembro.buscarMiembro(nombre);
            System.out.println("**********");
            if (listaMiembros.isEmpty()) {
                System.out.println("No hay miembros.");
                return;
            }
            Banda banda = new Banda("Rock", LocalDate.now(),null, new ArrayList<>(listaMiembros));
            listaBanda.add(banda);
            banda.adicionarMiembro(miembroAgregar);

        System.out.println("banda agregada exitosamente.");

        } catch (MiembroExcepcion e) {

        }

    }

    public void eliminarMiembro(String nombre) {
        try {
            Miembro miembroEliminar = new Miembro();
            Miembro miembroEliminado = miembroEliminar.buscarMiembro(nombre);
            Banda banda = new Banda();
            miembroEliminado.eliminarMiembro(miembroEliminado);
            banda.eliminarMiembro(miembroEliminado);
        } catch (MiembroExcepcion e) {

        }
    }

    public static void mostrarBanda() {
        if (!listaBanda.isEmpty()) {
            System.out.println("Banda:");
            for (Banda banda : listaBanda) {
                System.out.println(banda.getGenero() + " - Fecha de creacion: " + banda.getFechaCreacion());
                System.out.println("Fotos:");
                for (Foto foto : banda.getFotos()) {
                    System.out.println("  - " + foto.getUrl());
                }
                System.out.println("Miembros:");
                for (Miembro miembro : banda.getMiembros()) {
                    System.out.println("- Nombre: " + miembro.getNombre() + " - Rol: " + miembro.getRol() +
                            " - Instrumentos: " + miembro.getInstrumentos());
                }

            }
        } else {
            System.out.println("No hay álbumes para mostrar.");
        }
    }

}
