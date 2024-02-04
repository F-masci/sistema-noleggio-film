package it.bd.sistema.noleggio.model;

public enum RoleType {
    OWNER("Proprietario"), CASHIER("Cassiere"), EMPLOYEE("Impiegato");

    private final String role;
    RoleType(String role) {
        this.role = role;
    }

    public String getConnectionRole() {
        return role.toLowerCase();
    }

    public String getRole() {
        return role;
    }

    public static RoleType createFromString(String role) {
        return switch (role) {
            case "Proprietario" -> OWNER;
            case "Cassiere" -> CASHIER;
            default -> EMPLOYEE;
        };
    }
}
