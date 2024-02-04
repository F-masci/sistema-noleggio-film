package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.RentalBean;
import it.bd.sistema.noleggio.dao.RegisterRentalProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.view.RegisterRentalView;

public class RegisterRentalController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                RentalBean bean = RegisterRentalView.registerRental();
                RegisterRentalProcedureDAO dao = new RegisterRentalProcedureDAO();
                dao.registerRental(
                        new Client(bean.getClient()),
                        new FilmCopy(bean.getCopy()),
                        bean.getExpiration()
                );
                RegisterRentalView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RegisterRentalView.showErrorMessage(e);
            }
        }
    }

}
