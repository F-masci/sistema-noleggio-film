package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.dao.InsertSectorProcedureDAO;
import it.bd.sistema.noleggio.dao.SectorListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.view.InsertSectorView;
import it.bd.sistema.noleggio.view.SectorListView;

import java.util.List;

public class SectorListController implements Controller {

    @Override
    public void start() {
            try {
                SectorListProcedureDAO dao = new SectorListProcedureDAO();
                List<Integer> sectors =  dao.sectorList();
                SectorListView.printList(sectors);
            } catch(DaoException e) {
                SectorListView.showErrorMessage(e);
            }
    }

}
