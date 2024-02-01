package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.exception.cli.SelectionNotValidException;

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

    public static int printMenu(String menu, int numSelection) throws EscCliException {
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

    protected static String requestString() throws EscCliException {
        return requestString(null);
    }
    protected static String requestString(String msg) throws EscCliException {
        String res = null;
        try {
            if(msg != null) print(msg);
            res = br.readLine();
            if (res.equals("esc")) throw new EscCliException();
        } catch (IOException e) {
            showErrorMessage(e);
            System.exit(-1);
        }
        return res;
    }

    protected static int requestInt() throws EscCliException {
        return requestInt(null);
    }
    protected static int requestInt(String msg) throws EscCliException {
        while (true) {
            try {
                return Integer.parseInt(requestString(msg));
            } catch (NumberFormatException e) {
                showErrorMessage("L'input inserito non è un numero");
            }
        }
    }

    protected static long requestLong() throws EscCliException {
        return requestLong(null);
    }
    protected static long requestLong(String msg) throws EscCliException {
        while (true) {
            try {
                return Long.parseLong(requestString(msg));
            } catch (NumberFormatException e) {
                showErrorMessage("L'input inserito non è un numero");
            }
        }
    }

}
