package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.bean.YearlyReportBean;
import it.bd.sistema.noleggio.dao.FilmListProcedureDAO;
import it.bd.sistema.noleggio.dao.YearlyReportProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.Report;
import it.bd.sistema.noleggio.view.FilmListView;
import it.bd.sistema.noleggio.view.ReportView;

import java.util.ArrayList;
import java.util.List;

public class FilmListController implements Controller {

    @Override
    public void start() {
        try {
            FilmListProcedureDAO dao = new FilmListProcedureDAO();
            List<Film> films = dao.filmList();
            List<FilmBean> bean = new ArrayList<>();
            for (Film f: films) {
                String titleOriginal = f.getOriginal().getTitle();
                String directorOriginal = f.getOriginal().getDirector();
                FilmBean original = null;
                if(titleOriginal != null && directorOriginal != null) {
                    original = new FilmBean(titleOriginal, directorOriginal);
                }
                FilmBean b = new FilmBean(
                        f.getTitle(),
                        f.getDirector(),
                        f.getYear(),
                        f.getPrice(),
                        original
                );
                b.setActorNames(f.getActorNames());
                b.setActorSurnames(f.getActorSurnames());
                bean.add(b);
            }
            FilmListView.printList(bean);
        } catch (DaoException e) {
            FilmListView.showErrorMessage(e);
        }
    }

}
