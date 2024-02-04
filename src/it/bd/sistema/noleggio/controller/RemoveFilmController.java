package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.dao.RemoveEmployeeProcedureDAO;
import it.bd.sistema.noleggio.dao.RemoveFilmProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.view.RemoveEmployeeView;
import it.bd.sistema.noleggio.view.RemoveFilmView;

public class RemoveFilmController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                FilmBean bean = RemoveFilmView.removeFilm();
                RemoveFilmProcedureDAO dao = new RemoveFilmProcedureDAO();
                dao.removeFilm(new Film(bean.getTitle(), bean.getDirector()));
                RemoveFilmView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RemoveFilmView.showErrorMessage(e);
            }
        }
    }

}
