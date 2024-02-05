package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.RentalListBean;

import java.util.List;

public class ExpiredRentalListView extends GenericRentalListView {

    public static void printList(List<RentalListBean> list) {
        GenericRentalListView.printList(list, "LISTA NOLEGGI SCADUTI");
    }

}
