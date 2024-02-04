package it.bd.sistema.noleggio.exception;

public class RegisterClientException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante l'inserimento del nuovo cliente: ";

    public RegisterClientException(Throwable e) {
        this(e, e);
    }
    public RegisterClientException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RegisterClientException(String msg) {
        super(msg);
    }
    public RegisterClientException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
