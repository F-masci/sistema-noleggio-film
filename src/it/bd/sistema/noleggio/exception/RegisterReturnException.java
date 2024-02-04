package it.bd.sistema.noleggio.exception;

public class RegisterReturnException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la registrazione della restituzione: ";

    public RegisterReturnException(Throwable e) {
        this(e, e);
    }
    public RegisterReturnException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RegisterReturnException(String msg) {
        super(msg);
    }
    public RegisterReturnException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
