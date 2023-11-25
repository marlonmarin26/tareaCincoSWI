package edu.ucaldas.model;

import java.util.Objects;

/**
 * Clase Miembro, representa a un miembro de la banda.
 */
public class Miembro {

    private String nombre;
    private Rol rol;
    private String instrumentos;

    public Miembro(String nombre, Rol rol, String instrumentos) {
        this.nombre = nombre;
        this.rol = rol;
        this.instrumentos = instrumentos;
    }

    public Miembro() {
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
    }

    /*
     * Método que verifica que un miembro exista, si existe lo retorna
     */
    public Miembro buscarMiembro(String nombre) {
        if (this.nombre != null && this.nombre.equals(nombre)) {
            return this;
        } else {
            throw new MiembroExcepcion("El miembro no existe");
        }
    }

    public void eliminarMiembro(Miembro miembro) {
        if (this.nombre != null && miembro != null && this.nombre.equals(miembro.getNombre())) {
            this.nombre = null;
        } else {
            throw new MiembroExcepcion("El miembro no existe");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Miembro other = (Miembro) obj;

        return nombre.equals(other.nombre)
                && rol == other.rol
                && Objects.equals(instrumentos, other.instrumentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, rol, instrumentos);
    }

    @Override
    public String toString() {
        return "Miembro [nombre=" + nombre + ", rol=" + rol + ", instrumentos=" + instrumentos + "]";
    }

}
