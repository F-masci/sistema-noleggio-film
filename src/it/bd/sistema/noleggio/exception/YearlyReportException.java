package it.bd.sistema.noleggio.exception;

public class YearlyReportException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione del report annuale: ";

    public YearlyReportException(Throwable e) {
        this(e, e);
    }
    public YearlyReportException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public YearlyReportException(String msg) {
        super(msg);
    }
    public YearlyReportException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
