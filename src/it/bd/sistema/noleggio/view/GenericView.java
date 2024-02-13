package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.FieldNotValidException;
import it.bd.sistema.noleggio.exception.cli.ContinueCliException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.exception.cli.SelectionNotValidException;
import it.bd.sistema.noleggio.utility.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class GenericView {

    protected static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void showErrorMessage(Throwable e) {
        showErrorMessage(e.getMessage());
    }
    public static void showErrorMessage(String msg) {
        System.err.println(msg);
    }

    public static void println(String msg) {
        System.out.println(msg);
    }
    public static void print(String msg) {
        System.out.print(msg);
    }

    public static int printMenu(String menu, int numSelection) throws EscCliException, ContinueCliException {
        int selection;
        println(menu);
        while(true) {
            try {
                selection = requestInt("Selezione: ");
                if(selection <= 0 || selection > numSelection) throw new SelectionNotValidException();
                break;
            } catch (SelectionNotValidException e) {
                showErrorMessage(e);
            }
        }
        return selection;
    }

    public static void printSuccessMessage() {
        println("Operazione effettuata correttamente");
    }

    protected static String requestString() throws EscCliException, ContinueCliException {
        return requestString(null);
    }
    protected static String requestString(String msg) throws EscCliException, ContinueCliException {
        String res = null;
        try {
            if(msg != null) print(msg);
            res = br.readLine();
            if (res.equals("esc")) throw new EscCliException();
            if (res.equals("fine")) throw new ContinueCliException();
        } catch (IOException e) {
            showErrorMessage(e);
            System.exit(-1);
        }
        return res;
    }

    protected static int requestInt() throws EscCliException, ContinueCliException {
        return requestInt(null);
    }
    protected static int requestInt(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                return Integer.parseInt(requestString(msg));
            } catch (NumberFormatException e) {
                showErrorMessage("L'input inserito non è un numero");
            }
        }
    }

    protected static String requestRole() throws EscCliException, ContinueCliException {
        return requestRole("Ruolo (Cassiere | Commesso): ");
    }
    protected static String requestRole(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                return Validator.validateRole(requestString(msg));
            } catch (FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

    protected static long requestPhoneNumber() throws EscCliException, ContinueCliException {
        return requestPhoneNumber(null);
    }
    protected static long requestPhoneNumber(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                return Long.parseLong(Validator.validatePhoneNumber(requestString(msg)));
            } catch (FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

    protected static float requestPrice() throws EscCliException, ContinueCliException {
        return requestPrice(null);
    }
    protected static float requestPrice(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                float price = Float.parseFloat(requestString(msg));
                if(price < 0) throw new FieldNotValidException("Il costo deve essere maggiore o uaguale a 0");
                return price;
            } catch (NumberFormatException e) {
                showErrorMessage("L'input inserito non è un numero");
            } catch(FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

    protected static String requestFiscalCode() throws EscCliException, ContinueCliException {
        return requestFiscalCode("Codice fiscale: ");
    }
    protected static String requestFiscalCode(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                return Validator.validateFiscalCode(requestString(msg));
            } catch (FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

    protected static String requestDate() throws EscCliException, ContinueCliException {
        return requestDate("Data (YYYY-MM-DD): ");
    }
    protected static String requestDate(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                return Validator.validateDate(requestString(msg));
            } catch (FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

    protected static String requestEmail() throws EscCliException, ContinueCliException {
        return requestEmail("Email: ");
    }
    protected static String requestEmail(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                return Validator.validateEmail(requestString(msg));
            } catch (FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

    protected static String requestTypeOfFilmCopy() throws EscCliException, ContinueCliException {
        return requestTypeOfFilmCopy("Tipo di copia (DVD | Videocassetta): ");
    }
    protected static String requestTypeOfFilmCopy(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                return Validator.validateTypeOfFilmCopy(requestString(msg));
            } catch (FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

    protected static String requestWorkingHour() throws EscCliException, ContinueCliException {
        return requestWorkingHour("Orario di lavoro (00:00-00:00): ");
    }
    protected static String requestWorkingHour(String msg) throws EscCliException, ContinueCliException {
        while (true) {
            try {
                String workingHour = requestString(msg);
                if(workingHour.isBlank()) return workingHour;
                return Validator.validateWorkingHour(workingHour);
            } catch (FieldNotValidException e) {
                showErrorMessage(e);
            }
        }
    }

}
