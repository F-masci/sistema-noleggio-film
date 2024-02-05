package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.dao.ExpiredRentalListProcedureDAO;
import it.bd.sistema.noleggio.dao.GenericRentalListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Rental;
import it.bd.sistema.noleggio.view.CurrentRentalListView;
import it.bd.sistema.noleggio.view.ExpiredRentalListView;

import java.util.ArrayList;
import java.util.List;

public class ExpiredRentalListController extends GenericRentalListController {


    @Override
    public List<Rental> retrieveRental() throws DaoException {
        return new ExpiredRentalListProcedureDAO().rentalList();
    }

    @Override
    public void printResutl(List<RentalListBean> bean) {
        ExpiredRentalListView.printList(bean);
    }
}
