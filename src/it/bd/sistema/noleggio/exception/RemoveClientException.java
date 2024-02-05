package it.bd.sistema.noleggio.exception;

public class RemoveClientException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la rimozione del cliente: ";

    public RemoveClientException(Throwable e) {
        this(e, e);
    }
    public RemoveClientException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RemoveClientException(String msg) {
        super(msg);
    }
    public RemoveClientException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
