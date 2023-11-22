package edu.ucaldas.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase Banda, representa una banda musical.
 */
public class Banda {

    private String genero;
    private LocalDate fechaCreacion;
    private List<Foto> fotos;

    public Banda(String genero, LocalDate fechaCreacion, List<Foto> fotos) {
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = fotos;
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

    @Override
    public String toString() {
        return "Banda [genero=" + genero + ", fechaCreacion=" + fechaCreacion + ", fotos=" + fotos + "]";
    }

}
