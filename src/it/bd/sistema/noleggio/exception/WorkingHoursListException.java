package it.bd.sistema.noleggio.exception;

public class WorkingHoursListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione della lista dei turni di lavoro: ";

    public WorkingHoursListException(Throwable e) {
        this(e, e);
    }
    public WorkingHoursListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public WorkingHoursListException(String msg) {
        super(msg);
    }
    public WorkingHoursListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
