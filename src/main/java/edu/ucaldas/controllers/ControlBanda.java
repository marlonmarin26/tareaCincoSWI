package edu.ucaldas.controllers;

import edu.ucaldas.model.Miembro;
import edu.ucaldas.model.MiembroExcepcion;

public class ControlBanda {
    public void agregarMiembro(String nombre) {
        try {
            Miembro miembro = new Miembro();
            miembro.buscarMiembro(nombre);

        } catch (MiembroExcepcion e) {

        }

    }

    public void eliminarMiembro(String nombre) {

    }

}
