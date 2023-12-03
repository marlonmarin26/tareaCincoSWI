package edu.ucaldas.model;

/**
 * Clase ConciertoException, representa una excepcion de un concierto.
 * En caso de que el concierto no exista.
 * 
 * @author MJP
 * @version 1.0
 */
public class ConciertoException extends RuntimeException {
    public ConciertoException(String message) {
        super(message);
    }
}
