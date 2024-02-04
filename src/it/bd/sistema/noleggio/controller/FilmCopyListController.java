package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.dao.FilmCopyListProcedureDAO;
import it.bd.sistema.noleggio.dao.FilmListProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.view.FilmCopyListView;
import it.bd.sistema.noleggio.view.FilmListView;

import java.util.ArrayList;
import java.util.List;

public class FilmCopyListController implements Controller {

    @Override
    public void start() {
        try {
            FilmCopyListProcedureDAO dao = new FilmCopyListProcedureDAO();
            List<FilmCopyBean> bean = new ArrayList<>();
            List<FilmCopy> copies = dao.filmCopyList();
            for (FilmCopy c: copies) {
                bean.add(new FilmCopyBean(
                        c.getCode(),
                        new FilmBean(
                                c.getFilm().getTitle(),
                                c.getFilm().getDirector()
                        ),
                        c.getType(),
                        c.getSector(),
                        c.getPosition()
                ));
            }
            FilmCopyListView.printList(bean);
        } catch (DaoException e) {
            FilmListView.showErrorMessage(e);
        } catch (EscCliException ignored) {}
    }

}
