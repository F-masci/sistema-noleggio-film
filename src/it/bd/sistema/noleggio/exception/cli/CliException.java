package it.bd.sistema.noleggio.exception.cli;

public class CliException extends RuntimeException {

    private static final String DEFAULT_MSG = "Errore";

    public CliException() {
        this(DEFAULT_MSG);
    }
    public CliException(Throwable cause) {
        this(DEFAULT_MSG, cause);
    }

    public CliException(String msg) {
        super(msg);
    }
    public CliException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
