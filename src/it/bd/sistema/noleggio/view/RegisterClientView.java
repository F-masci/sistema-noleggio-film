package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.exception.cli.ContinueCliException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.ArrayList;
import java.util.List;

public class RegisterClientView extends InsertClientAddressView {

    public static ClientBean registerClient() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        ClientBean bean = new ClientBean(
                requestString("Codice fiscale: "),
                requestString("Nome: "),
                requestString("Cognome: "),
                requestString("Data di nascita (YYYY-MM-DD): "),
                requestString("Indirizzo: "),
                requestInt("CAP: "),
                requestInt("Numero civico: ")
        );

        ClientBean addresses = InsertClientAddressView.insertClientAdress();

        bean.setEmails(addresses.getEmails());
        bean.setPhones(addresses.getPhones());
        bean.setMobilePhones(addresses.getMobilePhones());
        return bean;

    }

    public static void printCard(int card) {
        println("La tessera cliente è: " + card);
    }

}
