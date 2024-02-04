package it.bd.sistema.noleggio.exception;

public class RemoveWorkingHoursException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la rimozione del turno di lavoro: ";

    public RemoveWorkingHoursException(Throwable e) {
        this(e, e);
    }
    public RemoveWorkingHoursException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RemoveWorkingHoursException(String msg) {
        super(msg);
    }
    public RemoveWorkingHoursException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
