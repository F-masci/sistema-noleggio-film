package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.bean.FilmBean;

import java.util.List;

public class ClientListView extends GenericView {

    public static void printList(List<ClientBean> list) {
        println("--- CLIENTI ---");
        for(ClientBean l: list) {
            print("Tessera #" + l.getCard() + " (" + l.getCf() + ") " + l.getName() + " " + l.getSurname() + ", " + l.getBirthDate() + ", " + l.getAddress() + ", " + l.getNumber() + ", " + String.format("%05d", l.getCap()) + ": ");
            List<Long> mobilePhones = l.getMobilePhones();
            List<Long> phones = l.getPhones();
            List<String> emails = l.getEmails();
            if(!mobilePhones.isEmpty() && !phones.isEmpty() && !emails.isEmpty()) print(": ");
            for(int i = 0; i<mobilePhones.size(); i++) {
                print(String.format("%010d", mobilePhones.get(i)));
                if(i != mobilePhones.size()-1) print(", ");
            }
            if(!phones.isEmpty()) print(", ");
            for(int i = 0; i<phones.size(); i++) {
                print(String.format("%010d", phones.get(i)));
                if(i != phones.size()-1) print(", ");
            }
            if(!emails.isEmpty()) print(", ");
            for(int i = 0; i<emails.size(); i++) {
                print(emails.get(i));
                if(i != emails.size()-1) print(", ");
            }
            println("");
        }
    }

}
