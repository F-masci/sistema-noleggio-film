package it.bd.sistema.noleggio.model;

import it.bd.sistema.noleggio.utility.Price;

import java.util.List;

public class Film {

    private final String title;
    private final String director;
    private final int year;
    private final Price price;
    private final Film original;
    private List<String> actorNames;
    private List<String> actorSurnames;

    public Film(String title, String director) {
        this(title, director, -1, null, null);
    }

    public Film(String title, String director, int year, Price price, Film original) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.price = price;
        this.original = original;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public Price getPrice() {
        return price;
    }

    public Film getOriginal() {
        return original;
    }

    public List<String> getActorNames() {
        return actorNames;
    }

    public List<String> getActorSurnames() {
        return actorSurnames;
    }

    public void setActorNames(List<String> actorNames) {
        this.actorNames = actorNames;
    }

    public void setActorSurnames(List<String> actorSurnames) {
        this.actorSurnames = actorSurnames;
    }

}
