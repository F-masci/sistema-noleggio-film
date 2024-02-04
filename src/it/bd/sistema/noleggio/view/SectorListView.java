package it.bd.sistema.noleggio.view;

import java.util.List;

public class SectorListView extends GenericView {

    public static void printList(List<Integer> sectors) {
        println("--- SETTORI ---");
        for(Integer s: sectors) {
            println(s.toString());
        }
    }

}
