package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.RentalListBean;

import java.util.List;

public abstract class GenericRentalListView extends GenericView {

    protected static void printList(List<RentalListBean> list, String title) {
        println("--- " + title + " ---");
        for(RentalListBean l: list) {
            print(l.getSurname() + " " + l.getName() + " (tessera " + l.getClient() + "): " + l.getTitle() + " - " + l.getDirector() + " -> copia #" + l .getCopy() + " (" + l.getType().getType() + ") con scadenza " + l.getExpiration() + ", noleggiata in data " + l.getRental());
            String returnDate = l.getReturnDate();
            if(returnDate != null) print(" e restituita il " + returnDate);
            println("");
        }
    }

}
