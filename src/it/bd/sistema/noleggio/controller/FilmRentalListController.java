package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.dao.FilmCopyRentalListProcedureDAO;
import it.bd.sistema.noleggio.dao.FilmRentalListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.model.Rental;
import it.bd.sistema.noleggio.view.FilmCopyRentalListView;
import it.bd.sistema.noleggio.view.FilmRentalListView;

import java.util.List;

public class FilmRentalListController extends GenericRentalListController {

    @Override
    public List<Rental> retrieveRental() throws DaoException {
        FilmBean bean = FilmRentalListView.selectFilm();
        return new FilmRentalListProcedureDAO().rentalList(
                new Film(
                        bean.getTitle(),
                        bean.getDirector()
                )
        );
    }

    @Override
    public void printResutl(List<RentalListBean> bean) {
        FilmRentalListView.printList(bean);
    }
}
