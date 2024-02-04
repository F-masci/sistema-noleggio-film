package it.bd.sistema.noleggio.controller;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.dao.InsertFilmProcedureDAO;
import it.bd.sistema.noleggio.dao.InsertWorkingHoursProcedureDAO;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.WorkingHour;
import it.bd.sistema.noleggio.view.InsertFilmView;
import it.bd.sistema.noleggio.view.InsertWorkingHoursView;

import java.util.ArrayList;
import java.util.List;

public class InsertFilmController implements Controller {

    @Override
    public void start() {
        while(true) {
            try {
                FilmBean bean = InsertFilmView.insertFilm();
                String titleOriginal = bean.getOriginal().getTitle();
                String directorOriginal = bean.getOriginal().getDirector();
                Film original = null;
                if(!titleOriginal.isBlank() && !directorOriginal.isBlank()) {
                    original = new Film(titleOriginal, directorOriginal);
                }
                Film film = new Film(
                        bean.getTitle(),
                        bean.getDirector(),
                        bean.getYear(),
                        bean.getPrice(),
                        original
                );
                film.setActorNames(bean.getActorNames());
                film.setActorSurnames(bean.getActorSurnames());
                InsertFilmProcedureDAO dao = new InsertFilmProcedureDAO();
                dao.insertFilm(film);
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
