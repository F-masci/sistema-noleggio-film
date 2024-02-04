package it.bd.sistema.noleggio.exception;

public class RoleListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione della lista dei ruoli dell'impiegato: ";

    public RoleListException(Throwable e) {
        this(e, e);
    }
    public RoleListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RoleListException(String msg) {
        super(msg);
    }
    public RoleListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
