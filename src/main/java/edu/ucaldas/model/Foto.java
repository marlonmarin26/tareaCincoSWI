package edu.ucaldas.model;

/**
 * Clase Foto, representa una foto de la banda.
 */
public class Foto {
    
    private String url;

    public Foto(String url) {
        this.url = url;
    }

    public Foto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
