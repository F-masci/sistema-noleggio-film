package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.dao.RemoveSectorProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.view.RemoveSectorView;

public class RemoveSectorController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                int sector = RemoveSectorView.removeSector();
                RemoveSectorProcedureDAO dao = new RemoveSectorProcedureDAO();
                dao.removeSector(sector);
                RemoveSectorView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RemoveSectorView.showErrorMessage(e);
            }
        }
    }

}
