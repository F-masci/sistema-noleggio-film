package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.dao.RemoveClientProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.view.RemoveClientView;
import it.bd.sistema.noleggio.view.RemoveSectorView;

public class RemoveClientController implements Controller {
    @Override
    public void start() {
        while(true) {
            try {
                ClientBean bean = RemoveClientView.removeClient();
                RemoveClientProcedureDAO dao = new RemoveClientProcedureDAO();
                dao.removeClient(new Client(
                        bean.getCard()
                ));
                RemoveClientView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RemoveClientView.showErrorMessage(e);
            }
        }
    }

}
