package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.RoleBean;

import java.util.List;

public class RoleListView extends GenericView {

    public static RoleBean roleList() {
        return new RoleBean(
                requestString("Codice fiscale dell'impiegato (oppure esc per tornare indietro): ")
        );
    }

    public static void printList(List<RoleBean> roles) {
        println("--- RUOLI ---");
        for(RoleBean r: roles) {
            println(r.getRole().getRole() + ": " + r.getStart() + " - " + r.getEnd());
        }
    }

}
