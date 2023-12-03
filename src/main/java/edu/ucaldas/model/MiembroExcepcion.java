package edu.ucaldas.model;

/**
 * Clase MiembroExcepcion, representa una excepcion de un miembro.
 * En caso de que el miembro no exista.
 * 
 * @author MJP
 * @version 1.0
 */
public class MiembroExcepcion extends RuntimeException {
    public MiembroExcepcion(String message) {
        super(message);
    }
}
