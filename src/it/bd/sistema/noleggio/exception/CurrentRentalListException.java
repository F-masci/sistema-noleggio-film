package it.bd.sistema.noleggio.exception;

public class CurrentRentalListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la ricerca dei noleggi correnti: ";

    public CurrentRentalListException(Throwable e) {
        this(e, e);
    }
    public CurrentRentalListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public CurrentRentalListException(String msg) {
        super(msg);
    }
    public CurrentRentalListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
