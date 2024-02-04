package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.dao.InsertSectorProcedureDAO;
import it.bd.sistema.noleggio.dao.RemoveSectorProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.view.InsertSectorView;
import it.bd.sistema.noleggio.view.RemoveSectorView;

public class InsertSectorController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                int sector = InsertSectorView.insertSector();
                InsertSectorProcedureDAO dao = new InsertSectorProcedureDAO();
                dao.insertSector(sector);
                InsertSectorView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                InsertSectorView.showErrorMessage(e);
            }
        }
    }

}
