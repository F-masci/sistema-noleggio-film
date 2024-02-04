package it.bd.sistema.noleggio.exception;

public class SectorListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione della lista dei settori: ";

    public SectorListException(Throwable e) {
        this(e, e);
    }
    public SectorListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public SectorListException(String msg) {
        super(msg);
    }
    public SectorListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
