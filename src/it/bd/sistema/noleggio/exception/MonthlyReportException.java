package it.bd.sistema.noleggio.exception;

public class MonthlyReportException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione del report mensile: ";

    public MonthlyReportException(Throwable e) {
        this(e, e);
    }
    public MonthlyReportException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public MonthlyReportException(String msg) {
        super(msg);
    }
    public MonthlyReportException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
