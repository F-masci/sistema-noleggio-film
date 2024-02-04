package it.bd.sistema.noleggio.utility;

public class Address {

    private final String address;
    private final int cap;
    private final int number;

    public Address(String address, int cap, int number) {
        this.address = address;
        this.cap = cap;
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public int getCap() {
        return cap;
    }

    public int getNumber() {
        return number;
    }



}
