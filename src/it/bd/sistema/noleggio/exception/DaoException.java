package it.bd.sistema.noleggio.exception;

public class DaoException extends Exception {

    private static final String DEFAULT_MSG = "Errore durante l'esecuzione dell'operazione";

    public DaoException() {
        this(DEFAULT_MSG);
    }
    public DaoException(Throwable cause) {
        this(DEFAULT_MSG, cause);
    }

    public DaoException(String msg) {
        super(msg);
    }
    public DaoException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
