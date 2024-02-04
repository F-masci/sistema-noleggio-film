package it.bd.sistema.noleggio.exception;

public class RemoveSectorException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la rimozione del settore: ";

    public RemoveSectorException(Throwable e) {
        this(e, e);
    }
    public RemoveSectorException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RemoveSectorException(String msg) {
        super(msg);
    }
    public RemoveSectorException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
