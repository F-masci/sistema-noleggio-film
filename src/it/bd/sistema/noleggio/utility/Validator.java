package it.bd.sistema.noleggio.utility;

import it.bd.sistema.noleggio.exception.FieldNotValidException;
import it.bd.sistema.noleggio.model.FilmCopyType;
import it.bd.sistema.noleggio.model.RoleType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    /* REGEX */
    private static final String CF_REGEX = "^[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]$";
    private static final String PHONE_NUMBER_REGEX = "^\\d{10}$";
    private static final String DATE_REGEX = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String WORKING_HOUR_REGEX = "^([01]?[0-9]|2[0-3]):[0-5][0-9]-([01]?[0-9]|2[0-3]):[0-5][0-9]$";

    public static String validateRole(String field) throws FieldNotValidException {
        if(RoleType.createFromString(field) == RoleType.OWNER ||
                RoleType.createFromString(field) == RoleType.NOT_VALID) throw new FieldNotValidException("Ruolo non valido");
        return field;
    }

    public static String validateTypeOfFilmCopy(String field) throws FieldNotValidException {
        if(FilmCopyType.createFromString(field) == FilmCopyType.NOT_VALID) throw new FieldNotValidException("Tipo di copia fisica non valida");
        return field;
    }

    public static String validateFiscalCode(String field) throws FieldNotValidException {
        return validateField(field, CF_REGEX, "Codice fiscale non valido");
    }

    public static String validatePhoneNumber(String field) throws FieldNotValidException {
        return validateField(field, PHONE_NUMBER_REGEX, "Numero di telefono non valido");
    }

    public static String validateDate(String field) throws FieldNotValidException {
        return validateField(field, DATE_REGEX, "Data non valida");
    }

    public static String validateEmail(String field) throws FieldNotValidException {
        return validateField(field, EMAIL_REGEX, "Email non valida");
    }

    public static String validateWorkingHour(String field) throws FieldNotValidException {
        return validateField(field, WORKING_HOUR_REGEX, "Orario di lavoro non valido");
    }

    protected static String validateField(String field, String regex, String error) throws FieldNotValidException {
        if(!field.matches(regex)) throw new FieldNotValidException(error);
        return field;
    }

}
