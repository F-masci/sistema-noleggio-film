package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ExpiredRentalBean;

import java.util.List;

public class ExpiredRentalListView extends GenericView {

    public static void printList(List<ExpiredRentalBean> list) {
        println("--- LISTA NOLEGGI SCADUTI ---");
        for(ExpiredRentalBean l: list) {
            println(l.getSurname() + " " + l.getName() + " (tessera " + l.getClient() + "): " + l.getTitle() + " - " + l.getDirector() + " -> copia #" + l .getCopy() + " (" + l.getType().getType() + ") con scadenza " + l.getExpiration());
        }
    }

}
