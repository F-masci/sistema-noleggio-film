package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.exception.cli.ContinueCliException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.ArrayList;
import java.util.List;

public class InsertClientAddressView extends GenericView {

    public static int selectClient() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return requestInt("Cliente: ");
    }

    public static ClientBean insertClientAdress() throws EscCliException {

        println("\nDurante l'inserimento dei recapiti digitare la parola 'fine' per terminare l'inserimento\n");

        List<String> emails = new ArrayList<>();

        try {
            while (true) {
                emails.add(requestEmail("Email: "));
            }
        } catch(ContinueCliException ignored) {}

        List<Long> phones = new ArrayList<>();

        try {
            while (true) {
                phones.add(requestPhoneNumber("Telefono: "));
            }
        } catch(ContinueCliException ignored) {}

        List<Long> mobilePhones = new ArrayList<>();

        try {
            while (true) {
                mobilePhones.add(requestPhoneNumber("Cellulare: "));
            }
        } catch(ContinueCliException ignored) {}

        return new ClientBean(emails, phones, mobilePhones);

    }

}
