package it.bd.sistema.noleggio.bean;

public class RentalBean {

    private final int copy;
    private final int client;
    private final String expiration;

    public RentalBean(int copy, int client) {
        this(copy, client, null);
    }
    public RentalBean(int copy, int client, String expiration) {
        this.copy = copy;
        this.client = client;
        this.expiration = expiration;
    }

    public int getCopy() {
        return copy;
    }

    public int getClient() {
        return client;
    }

    public String getExpiration() {
        return expiration;
    }



}
