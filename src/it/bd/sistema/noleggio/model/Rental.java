package it.bd.sistema.noleggio.model;

public class Rental {

    private final Client client;
    private final FilmCopy copy;
    private final String expiration;

    public Rental(Client client, FilmCopy copy) {
        this(client, copy, null);
    }

    public Rental(Client client, FilmCopy copy, String expiration) {
        this.client = client;
        this.copy = copy;
        this.expiration = expiration;
    }

    public Client getClient() {
        return client;
    }

    public FilmCopy getCopy() {
        return copy;
    }

    public String getExpiration() {
        return expiration;
    }

}
