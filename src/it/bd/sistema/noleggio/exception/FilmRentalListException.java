package it.bd.sistema.noleggio.exception;

public class FilmRentalListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la ricerca dei noleggi di un film: ";

    public FilmRentalListException(Throwable e) {
        this(e, e);
    }
    public FilmRentalListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public FilmRentalListException(String msg) {
        super(msg);
    }
    public FilmRentalListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
