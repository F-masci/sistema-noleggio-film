package it.bd.sistema.noleggio.exception;

public class InsertClientAddressException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante l'inserimento del recapito: ";

    public InsertClientAddressException(Throwable e) {
        this(e, e);
    }
    public InsertClientAddressException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public InsertClientAddressException(String msg) {
        super(msg);
    }
    public InsertClientAddressException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
