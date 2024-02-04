package it.bd.sistema.noleggio.exception;

import java.sql.SQLException;

public class RemoveEmployeeException extends DaoException {
    private static final String DEFAULT_MSG = "Errore durante la registrazione della restituzione: ";

    public RemoveEmployeeException(Throwable e) {
        this(e, e);
    }
    public RemoveEmployeeException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RemoveEmployeeException(String msg) {
        super(msg);
    }
    public RemoveEmployeeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
