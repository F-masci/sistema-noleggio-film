package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.dao.RemoveFilmCopyProcedureDAO;
import it.bd.sistema.noleggio.dao.RemoveFilmProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.view.RemoveFilmCopyView;
import it.bd.sistema.noleggio.view.RemoveFilmView;

public class RemoveFilmCopyController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                FilmCopyBean bean = RemoveFilmCopyView.removeFilmCopy();
                RemoveFilmCopyProcedureDAO dao = new RemoveFilmCopyProcedureDAO();
                dao.removeFilmCopy(new FilmCopy(bean.getCode()));
                RemoveFilmCopyView.printSuccessMessage();
                return;
            } catch(EscCliException e) {
                return;
            } catch(DaoException e) {
                RemoveFilmCopyView.showErrorMessage(e);
            }
        }
    }

}
