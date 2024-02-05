package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.dao.CurrentRentalListProcedureDAO;
import it.bd.sistema.noleggio.dao.FilmCopyRentalListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.model.Rental;
import it.bd.sistema.noleggio.view.CurrentRentalListView;
import it.bd.sistema.noleggio.view.FilmCopyRentalListView;

import java.util.List;

public class FilmCopyRentalListController extends GenericRentalListController {

    @Override
    public List<Rental> retrieveRental() throws DaoException {
        FilmCopyBean bean = FilmCopyRentalListView.selectCopy();
        return new FilmCopyRentalListProcedureDAO().rentalList(
                new FilmCopy(bean.getCode())
        );
    }

    @Override
    public void printResutl(List<RentalListBean> bean) {
        FilmCopyRentalListView.printList(bean);
    }
}
