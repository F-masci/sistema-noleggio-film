package it.bd.sistema.noleggio.bean;

import java.util.List;

public class ClientBean {

    private final String cf;
    private final String name;
    private final String surname;
    private final String birthDate;
    private final String address;
    private final int cap;
    private final int number;
    private List<String> emails;
    private List<Long> phones;
    private  List<Long> mobilePhones;

    public ClientBean(String cf, String name, String surname, String birthDate, String address, int cap, int number, List<String> emails, List<Long> phones, List<Long> mobilePhones) {
        this.cf = cf;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.cap = cap;
        this.number = number;
        this.emails = emails;
        this.phones = phones;
        this.mobilePhones = mobilePhones;
    }

    public ClientBean(String cf, String name, String surname, String birthDate, String address, int cap, int number) {
        this(cf, name, surname, birthDate, address, cap, number, null, null, null);
    }

    public ClientBean(List<String> emails, List<Long> phones, List<Long> mobilePhones) {
        this(null, null, null, null, null, -1, -1, emails, phones, mobilePhones);
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

    public String getAddress() {
        return address;
    }

    public int getCap() {
        return cap;
    }

    public int getNumber() {
        return number;
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
