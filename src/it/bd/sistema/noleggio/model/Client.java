package it.bd.sistema.noleggio.model;

import it.bd.sistema.noleggio.utility.Address;

import java.util.List;

public class Client {

    private int card;
    private final String cf;
    private final String name;
    private final String surname;
    private final String birthDate;
    private final Address address;
    private List<String> emails;
    private List<Long> phones;
    private  List<Long> mobilePhones;

    public Client(String cf) {
        this(-1, cf, null, null, null, null, null, null, null);
    }
    public Client(int card) {
        this(card, null, null, null, null, null, null, null, null);
    }
    public Client(int card, String cf, String name, String surname) {
        this(card, cf, name, surname, null, null, null, null, null);
    }
    public Client(String cf, String name, String surname, String birthDate, Address address, List<String> emails, List<Long> phones, List<Long> mobilePhones) {
        this(-1, cf, name, surname, birthDate, address, emails, phones, mobilePhones);
    }
    public Client(int card, String cf, String name, String surname, String birthDate, Address address) {
        this(card, cf, name, surname, birthDate, address, null, null, null);
    }
    public Client(int card, String cf, String name, String surname, String birthDate, Address address, List<String> emails, List<Long> phones, List<Long> mobilePhones) {
        this.card = card;
        this.cf = cf;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.emails = emails;
        this.phones = phones;
        this.mobilePhones = mobilePhones;
    }

    public int getCard() {
        return card;
    }

    public String getCf() {
        return cf;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<Long> getPhones() {
        return phones;
    }

    public List<Long> getMobilePhones() {
        return mobilePhones;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setPhones(List<Long> phones) {
        this.phones = phones;
    }

    public void setMobilePhones(List<Long> mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

}
