package it.bd.sistema.noleggio.utility;

public class Price {

    private final float dvd;
    private final float videotape;

    public Price(float dvd, float videotape) {
        this.dvd = dvd;
        this.videotape = videotape;
    }

    public float getDvd() {
        return dvd;
    }

    public float getVideotape() {
        return videotape;
    }

}
