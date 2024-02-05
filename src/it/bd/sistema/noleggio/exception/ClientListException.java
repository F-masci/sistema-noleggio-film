package it.bd.sistema.noleggio.exception;

public class ClientListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione della lista dei clienti: ";

    public ClientListException(Throwable e) {
        this(e, e);
    }
    public ClientListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public ClientListException(String msg) {
        super(msg);
    }
    public ClientListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
