package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RemoveSectorView extends GenericView {

    public static int removeSector() throws EscCliException {
        println("ATTENZIONE! Rimuovendo un settore verranno rimosse anche le relative copie in quel settore e i noleggi collegati a tali copie");
        return requestInt("Codice del settore (oppure esc per tornare indietro): ");
    }

}
