package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.bean.RentalBean;
import it.bd.sistema.noleggio.dao.RegisterClientProcedureDAO;
import it.bd.sistema.noleggio.dao.RegisterRentalProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.utility.Address;
import it.bd.sistema.noleggio.view.RegisterClientView;
import it.bd.sistema.noleggio.view.RegisterRentalView;

public class RegisterClientController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                ClientBean bean = RegisterClientView.registerClient();
                RegisterClientProcedureDAO dao = new RegisterClientProcedureDAO();
                Client client =  new Client(
                                    bean.getCf(),
                                    bean.getName(),
                                    bean.getSurname(),
                                    bean.getBirthDate(),
                                    new Address(
                                            bean.getAddress(),
                                            bean.getCap(),
                                            bean.getNumber()
                                    ),
                                    bean.getEmails(),
                                    bean.getPhones(),
                                    bean.getMobilePhones()
                                );
                dao.registerClient(client);
                RegisterClientView.printCard(client.getCard());
                RegisterClientView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RegisterClientView.showErrorMessage(e);
            }
        }
    }

}
