package it.bd.sistema.noleggio.exception;

public class ChangeRoleException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la modifica della carica: ";

    public ChangeRoleException(Throwable e) {
        this(e, e);
    }
    public ChangeRoleException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public ChangeRoleException(String msg) {
        super(msg);
    }
    public ChangeRoleException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
