package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.dao.ClientRentalListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.Rental;
import it.bd.sistema.noleggio.view.ClientRentalListView;

import java.util.List;

public class ClientRentalListController extends GenericRentalListController {

    @Override
    public List<Rental> retrieveRental() throws DaoException {
        ClientBean bean = ClientRentalListView.selectClient();
        return new ClientRentalListProcedureDAO().rentalList(
                new Client(bean.getCard())
        );
    }

    @Override
    public void printResutl(List<RentalListBean> bean) {
        ClientRentalListView.printList(bean);
    }
}
