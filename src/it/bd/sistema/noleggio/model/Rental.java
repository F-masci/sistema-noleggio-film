package it.bd.sistema.noleggio.model;

public class Rental {

    private final Client client;
    private final FilmCopy copy;
    private final String expiration;
    private final String rental;
    private final String returnDate;

    public Rental(Client client, FilmCopy copy) {
        this(client, copy, null, null, null);
    }

    public Rental(Client client, FilmCopy copy, String rental, String expiration, String returnDate) {
        this.client = client;
        this.copy = copy;
        this.expiration = expiration;
        this.rental = rental;
        this.returnDate = returnDate;
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

    public String getRental() {
        return rental;
    }

    public String getReturnDate() {
        return returnDate;
    }

}
