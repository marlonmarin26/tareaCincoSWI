package edu.ucaldas.controllers;

import java.util.List;

import edu.ucaldas.model.Banda;
import edu.ucaldas.model.Miembro;
import edu.ucaldas.model.MiembroExcepcion;

public class ControlBanda {
    private Banda banda;
    
    public ControlBanda(Banda banda) {
        this.banda = banda;
    }
    public ControlBanda (){
        this.banda = new Banda("", null, null, null);
    }
    /*
     * método para agregar miembros a la banda
     */
    public void agregarMiembro(Miembro miembrp) {
        try {
            Miembro miembro = new Miembro();
            Miembro miembroAgregar = miembro.buscarMiembro(miembro);
            Banda banda = new Banda();
            banda.adicionarMiembro(miembroAgregar);
            
        } catch (MiembroExcepcion e) {

        }

    }

    public void eliminarMiembro(Miembro miembro) {
        try {
            Miembro miembroEliminar = new Miembro();
            Miembro miembroEliminado = miembroEliminar.buscarMiembro(miembro);
            Banda banda = new Banda();
            miembroEliminado.eliminarMiembro(miembroEliminado);
            banda.eliminarMiembro(miembroEliminado);
        } catch (MiembroExcepcion e) {

        }
    }

}
