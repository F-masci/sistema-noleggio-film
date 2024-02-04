package it.bd.sistema.noleggio.exception.cli;
public class ContinueCliException extends CliException {

    private static final String DEFAULT_MSG = "Hai inserito fine";

    public ContinueCliException() {
        this(DEFAULT_MSG);
    }
    public ContinueCliException(Throwable cause) {
        this(DEFAULT_MSG, cause);
    }

    public ContinueCliException(String msg) {
        super(msg);
    }
    public ContinueCliException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
