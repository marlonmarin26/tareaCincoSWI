package edu.ucaldas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Banda, representa una banda musical.
 * 
 * @author MJP
 * @version 1.0 
 */
public class Banda {

    private String genero;
    private LocalDate fechaCreacion;
    private List<Foto> fotos = new ArrayList<>();
    private List<Miembro> miembros = new ArrayList<>();

    public Banda(String genero, LocalDate fechaCreacion, List<Foto> fotos) {
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = fotos;
    }

    public Banda(String genero, LocalDate fechaCreacion, List<Foto> fotos, List<Miembro> miembros) {
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = fotos;
        this.miembros = miembros;
    }

    public Banda() {
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Banda other = (Banda) obj;

        return genero.equals(other.genero) && fechaCreacion.equals(other.fechaCreacion)
                && Objects.equals(fotos, other.fotos) && Objects.equals(miembros, other.miembros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genero, fechaCreacion, fotos, miembros);
    }

    @Override
    public String toString() {
        return "Banda [genero=" + genero + ", fechaCreacion=" + fechaCreacion + ", fotos=" + fotos + ", miembros="
                + miembros + "]";
    }

}
