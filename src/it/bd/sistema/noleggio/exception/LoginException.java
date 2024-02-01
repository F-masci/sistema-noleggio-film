package it.bd.sistema.noleggio.exception;

public class LoginException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante il login: ";

    public LoginException(Throwable e) {
        this(e, e);
    }
    public LoginException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public LoginException(String msg) {
        super(msg);
    }
    public LoginException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
