package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.RentalBean;
import it.bd.sistema.noleggio.dao.RegisterRentalProcedureDAO;
import it.bd.sistema.noleggio.dao.RegisterReturnProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.view.RegisterRentalView;
import it.bd.sistema.noleggio.view.RegisterReturnView;

public class RegisterReturnController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                RentalBean bean = RegisterReturnView.registerReturn();
                RegisterReturnProcedureDAO dao = new RegisterReturnProcedureDAO();
                dao.registerReturn(
                        new Client(bean.getClient()),
                        new FilmCopy(bean.getCopy())
                );
                RegisterReturnView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RegisterReturnView.showErrorMessage(e);
            }
        }
    }

}
