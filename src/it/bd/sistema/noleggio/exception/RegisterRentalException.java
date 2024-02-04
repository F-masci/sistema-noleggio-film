package it.bd.sistema.noleggio.exception;

public class RegisterRentalException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la registrazione del noleggio: ";

    public RegisterRentalException(Throwable e) {
        this(e, e);
    }
    public RegisterRentalException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RegisterRentalException(String msg) {
        super(msg);
    }
    public RegisterRentalException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
