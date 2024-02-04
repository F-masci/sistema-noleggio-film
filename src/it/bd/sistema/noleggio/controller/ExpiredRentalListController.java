package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.ExpiredRentalBean;
import it.bd.sistema.noleggio.dao.ExpiredRentalListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Rental;
import it.bd.sistema.noleggio.view.ExpiredRentalListView;

import java.util.ArrayList;
import java.util.List;

public class ExpiredRentalListController implements Controller {

    @Override
    public void start() {
        try {
            ExpiredRentalListProcedureDAO dao = new ExpiredRentalListProcedureDAO();
            List<Rental> rentals = dao.expiredReturnList();
            List<ExpiredRentalBean> bean = new ArrayList<>();
            for (Rental r : rentals) {
                bean.add(new ExpiredRentalBean(
                        r.getCopy().getCode(),
                        r.getCopy().getFilm().getTitle(),
                        r.getCopy().getFilm().getDirector(),
                        r.getCopy().getType(),
                        r.getClient().getCard(),
                        r.getClient().getCf(),
                        r.getClient().getName(),
                        r.getClient().getSurname(),
                        r.getExpiration()
                ));
            }
            ExpiredRentalListView.printList(bean);
            return;
        } catch (EscCliException e) {
            return;
        } catch (DaoException e) {
            ExpiredRentalListView.showErrorMessage(e);
        }
    }

}
