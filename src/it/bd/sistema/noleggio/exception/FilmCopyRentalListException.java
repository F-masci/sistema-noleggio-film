package it.bd.sistema.noleggio.exception;

public class FilmCopyRentalListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la ricerca dei noleggi di una copia: ";

    public FilmCopyRentalListException(Throwable e) {
        this(e, e);
    }
    public FilmCopyRentalListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public FilmCopyRentalListException(String msg) {
        super(msg);
    }
    public FilmCopyRentalListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
