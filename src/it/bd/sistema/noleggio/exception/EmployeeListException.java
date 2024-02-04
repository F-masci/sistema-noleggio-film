package it.bd.sistema.noleggio.exception;

public class EmployeeListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione della lista degli impiegati: ";

    public EmployeeListException(Throwable e) {
        this(e, e);
    }
    public EmployeeListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public EmployeeListException(String msg) {
        super(msg);
    }
    public EmployeeListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
