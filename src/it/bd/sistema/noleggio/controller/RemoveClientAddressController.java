package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.dao.InsertClientAddressProcedureDAO;
import it.bd.sistema.noleggio.dao.RemoveClientAddressProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.view.InsertClientAddressView;
import it.bd.sistema.noleggio.view.RegisterClientView;
import it.bd.sistema.noleggio.view.RemoveClientAddressView;

public class RemoveClientAddressController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                ClientBean clientBean = RemoveClientAddressView.selectClient();
                ClientBean bean = RemoveClientAddressView.removeClientAdress();
                RemoveClientAddressProcedureDAO dao = new RemoveClientAddressProcedureDAO();
                Client client = new Client(clientBean.getCard());
                client.setPhones(bean.getPhones());
                client.setMobilePhones(bean.getMobilePhones());
                client.setEmails(bean.getEmails());
                dao.removeClientAddress(client);
                RemoveClientAddressView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RemoveClientAddressView.showErrorMessage(e);
            }
        }
    }

}
