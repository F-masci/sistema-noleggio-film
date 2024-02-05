package it.bd.sistema.noleggio.exception;

public class ClientRentalListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la ricerca dei noleggi di una cliente: ";

    public ClientRentalListException(Throwable e) {
        this(e, e);
    }
    public ClientRentalListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public ClientRentalListException(String msg) {
        super(msg);
    }
    public ClientRentalListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
