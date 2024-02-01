package it.bd.sistema.noleggio.exception;

public class RegisterEmployeeException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante l'inserimento del nuovo impiegato: ";

    public RegisterEmployeeException(Throwable e) {
        this(e, e);
    }
    public RegisterEmployeeException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RegisterEmployeeException(String msg) {
        super(msg);
    }
    public RegisterEmployeeException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
