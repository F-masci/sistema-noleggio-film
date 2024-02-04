package it.bd.sistema.noleggio.model;

public enum FilmCopyType {
    DVD("DVD"), VIDEOTAPE("Videocassetta"), NOT_VALID(null);

    private final String type;
    FilmCopyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static FilmCopyType createFromString(String type) {
        return switch (type) {
            case "DVD" -> DVD;
            case "Videocassetta" -> VIDEOTAPE;
            default -> NOT_VALID;
        };
    }
}
