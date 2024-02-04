package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.dao.InsertFilmCopyProcedureDAO;
import it.bd.sistema.noleggio.dao.InsertFilmProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.view.InsertFilmCopyView;
import it.bd.sistema.noleggio.view.InsertFilmView;

public class InsertFilmCopyController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                FilmCopyBean bean = InsertFilmCopyView.insertFilmCopy();
                InsertFilmCopyProcedureDAO dao = new InsertFilmCopyProcedureDAO();
                dao.insertFilmCopy(new FilmCopy(
                        bean.getCode(),
                        new Film(
                                bean.getFilm().getTitle(),
                                bean.getFilm().getDirector()
                        ),
                        bean.getType(),
                        bean.getSector(),
                        bean.getPosition()
                ));
                InsertFilmView.printSuccessMessage();
                return;
            } catch (EscCliException e) {
                return;
            } catch (DaoException e) {
                InsertFilmView.showErrorMessage(e);
            }
        }
    }

}
