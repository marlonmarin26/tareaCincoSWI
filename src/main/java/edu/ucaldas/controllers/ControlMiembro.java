package edu.ucaldas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.Cancion;
import edu.ucaldas.model.Foto;
import edu.ucaldas.model.Miembro;
import edu.ucaldas.model.Rol;


public class ControlMiembro {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Miembro> listaMiembros = new ArrayList<>();
    private static List<Foto> listaFotos = new ArrayList<>();

    public static List<Miembro> getListaMiembros() {
        return listaMiembros;
    }

    public static void agregarMiembros() {
        Miembro miembro = new Miembro("Juan", Rol.BAJISTA, "Bajo");
        Miembro miembro1 = new Miembro("Pedro", Rol.GUITARRISTA, "Guitarra");
        Miembro miembro2 = new Miembro("Maria", Rol.VOCALISTA, "Voz");

        listaMiembros.add(miembro);
        listaMiembros.add(miembro1);
        listaMiembros.add(miembro2);
    }
    public static void mostrarMiembros() {
        if (!listaMiembros.isEmpty()) {
            System.out.println("Miembros:");
            for (Miembro miembro : listaMiembros) {
                System.out.println(miembro);
            }
        } else {
            System.out.println("No hay canciones para mostrar.");
        }
    }
    public static void agregarFotos() {
        Foto foto = new Foto("foto1");
        Foto foto1 = new Foto("foto2");
        Foto foto2 = new Foto("foto2");

        listaFotos.add(foto);
        listaFotos.add(foto1);
        listaFotos.add(foto2);
    }

}
