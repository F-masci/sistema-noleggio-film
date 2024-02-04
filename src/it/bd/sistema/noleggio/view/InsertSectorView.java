package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class InsertSectorView extends GenericView {

    public static int insertSector() throws EscCliException {
        return requestInt("Codice del settore (oppure esc per tornare indietro): ");
    }

}
