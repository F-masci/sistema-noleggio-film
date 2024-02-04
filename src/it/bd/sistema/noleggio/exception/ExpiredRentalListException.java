package it.bd.sistema.noleggio.exception;

public class ExpiredRentalListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la ricerca dei noleggi scaduti: ";

    public ExpiredRentalListException(Throwable e) {
        this(e, e);
    }
    public ExpiredRentalListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public ExpiredRentalListException(String msg) {
        super(msg);
    }
    public ExpiredRentalListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
