package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.dao.InsertClientAddressProcedureDAO;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.view.InsertClientAddressView;
import it.bd.sistema.noleggio.view.RegisterClientView;

public class InsertClientAddressController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                int card = InsertClientAddressView.selectClient();
                ClientBean bean = InsertClientAddressView.insertClientAdress();
                InsertClientAddressProcedureDAO dao = new InsertClientAddressProcedureDAO();
                Client client = new Client(card);
                client.setPhones(bean.getPhones());
                client.setMobilePhones(bean.getMobilePhones());
                client.setEmails(bean.getEmails());
                dao.registerClientAddress(client);
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
