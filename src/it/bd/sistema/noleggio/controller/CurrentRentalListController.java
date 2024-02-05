package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.dao.CurrentRentalListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.model.Rental;
import it.bd.sistema.noleggio.view.CurrentRentalListView;

import java.util.List;

public class CurrentRentalListController extends GenericRentalListController {


    @Override
    public List<Rental> retrieveRental() throws DaoException {
        return new CurrentRentalListProcedureDAO().rentalList();
    }

    @Override
    public void printResutl(List<RentalListBean> bean) {
        CurrentRentalListView.printList(bean);
    }
}
