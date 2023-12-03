package edu.ucaldas.model;

import java.util.Objects;

/**
 * Clase Cancion, representa una cancion de un album.
 * 
 * @author MJP
 * @version 1.0
 */
public class Cancion {

    private String nombre;
    private String duracion;

    public Cancion(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Cancion() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cancion other = (Cancion) obj;

        return nombre.equals(other.nombre) && duracion.equals(other.duracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, duracion);
    }

    @Override
    public String toString() {
        return "Cancion [nombre=" + nombre + ", duracion=" + duracion + "]";
    }

}
