package it.bd.sistema.noleggio.exception;

public class RemoveClientAddressException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la rimozione del recapito: ";

    public RemoveClientAddressException(Throwable e) {
        this(e, e);
    }
    public RemoveClientAddressException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RemoveClientAddressException(String msg) {
        super(msg);
    }
    public RemoveClientAddressException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
