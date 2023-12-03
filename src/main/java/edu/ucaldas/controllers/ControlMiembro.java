package edu.ucaldas.controllers;

import java.util.ArrayList;
import java.util.List;
import edu.ucaldas.model.Miembro;
import edu.ucaldas.model.Rol;

/**
 * Controlador para la creación y consulta de miembros.
 * 
 * @author MJP
 * @version 1.0
 */
public class ControlMiembro {
    private static List<Miembro> listaMiembros = new ArrayList<>();

    public static List<Miembro> getListaMiembros() {
        return listaMiembros;
    }

    /**
     * Metodo que permite crear un miembro
     */
    public void crearMiembros() {
        Miembro miembro1 = new Miembro("Juan", Rol.BAJISTA, "Bajo");
        Miembro miembro2 = new Miembro("Pedro", Rol.GUITARRISTA, "Guitarra");
        Miembro miembro3 = new Miembro("Maria", Rol.VOCALISTA, "Voz");
        Miembro miembro4 = new Miembro("Carlos", Rol.BATERISTA, "Batería");
        Miembro miembro5 = new Miembro("Ana", Rol.TECLADISTA, "Teclado");
        Miembro miembro6 = new Miembro("Luis", Rol.VOCALISTA, "Voz");
        Miembro miembro7 = new Miembro("Laura", Rol.GUITARRISTA, "Guitarra");
        Miembro miembro8 = new Miembro("Javier", Rol.BAJISTA, "Bajo");
        Miembro miembro9 = new Miembro("Sofia", Rol.BATERISTA, "Batería");
        Miembro miembro10 = new Miembro("Eduardo", Rol.TECLADISTA, "Teclado");
        Miembro miembro11 = new Miembro("Carmen", Rol.VOCALISTA, "Voz");
        Miembro miembro12 = new Miembro("Roberto", Rol.GUITARRISTA, "Guitarra, Voz");

        listaMiembros.add(miembro1);
        listaMiembros.add(miembro2);
        listaMiembros.add(miembro3);
        listaMiembros.add(miembro4);
        listaMiembros.add(miembro5);
        listaMiembros.add(miembro6);
        listaMiembros.add(miembro7);
        listaMiembros.add(miembro8);
        listaMiembros.add(miembro9);
        listaMiembros.add(miembro10);
        listaMiembros.add(miembro11);
        listaMiembros.add(miembro12);

        System.out.println("Miembros creados exitosamente.");
    }

}
