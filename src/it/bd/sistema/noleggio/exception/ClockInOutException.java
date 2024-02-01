package it.bd.sistema.noleggio.exception;

public class ClockInOutException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la timbratura: ";

    public ClockInOutException(Throwable e) {
        this(e, e);
    }
    public ClockInOutException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public ClockInOutException(String msg) {
        super(msg);
    }
    public ClockInOutException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
