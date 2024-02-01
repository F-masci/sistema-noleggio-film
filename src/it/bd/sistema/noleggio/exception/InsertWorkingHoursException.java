package it.bd.sistema.noleggio.exception;

public class InsertWorkingHoursException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante l'inserimento del turno di lavoro: ";

    public InsertWorkingHoursException(Throwable e) {
        this(e, e);
    }
    public InsertWorkingHoursException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public InsertWorkingHoursException(String msg) {
        super(msg);
    }
    public InsertWorkingHoursException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
