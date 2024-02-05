package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.dao.ExpiredRentalListProcedureDAO;
import it.bd.sistema.noleggio.dao.GenericRentalListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.model.Rental;
import it.bd.sistema.noleggio.view.ExpiredRentalListView;
import it.bd.sistema.noleggio.view.GenericRentalListView;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericRentalListController implements Controller {

    @Override
    public void start() {
        try {
            List<Rental> rentals = retrieveRental();
            List<RentalListBean> bean = new ArrayList<>();
            for (Rental r : rentals) {
                bean.add(new RentalListBean(
                        r.getCopy().getCode(),
                        r.getCopy().getFilm().getTitle(),
                        r.getCopy().getFilm().getDirector(),
                        r.getCopy().getType(),
                        r.getClient().getCard(),
                        r.getClient().getCf(),
                        r.getClient().getName(),
                        r.getClient().getSurname(),
                        r.getRental(),
                        r.getExpiration(),
                        r.getReturnDate()
                ));
            }
            printResutl(bean);
        } catch (DaoException e) {
            GenericRentalListView.showErrorMessage(e);
        }
    }

    public abstract List<Rental> retrieveRental() throws DaoException;

    public abstract void printResutl(List<RentalListBean> bean);

}
