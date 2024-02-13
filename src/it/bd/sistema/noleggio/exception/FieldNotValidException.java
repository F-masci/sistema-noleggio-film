package it.bd.sistema.noleggio.exception;

public class FieldNotValidException extends Exception {

    private static final String DEFAULT_MSG = "Errore";

    public FieldNotValidException() {
        this(DEFAULT_MSG);
    }
    public FieldNotValidException(Throwable cause) {
        this(DEFAULT_MSG, cause);
    }

    public FieldNotValidException(String msg) {
        super(msg);
    }
    public FieldNotValidException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
