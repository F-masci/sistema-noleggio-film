package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.InsertClientAddressException;
import it.bd.sistema.noleggio.exception.InsertFilmException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.utility.FormatListProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertFilmProcedureDAO {

    public void insertFilm(Film film) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserisciFilm(?,?,?,?,?,?,?,?,?)}");
            String titleOriginal = null;
            String directorOriginal = null;
            Film original = film.getOriginal();
            if(original != null) {
                titleOriginal = original.getTitle();
                directorOriginal = original.getDirector();
            }
            cs.setString(1, film.getTitle());
            cs.setString(2, film.getDirector());
            cs.setInt(3, film.getYear());
            cs.setFloat(4, film.getPrice().getDvd());
            cs.setFloat(5, film.getPrice().getVideotape());
            cs.setString(6, titleOriginal);
            cs.setString(7, directorOriginal);
            cs.setString(8, FormatListProcedure.createListFromStrings(film.getActorNames()));
            cs.setString(9, FormatListProcedure.createListFromStrings(film.getActorSurnames()));
            cs.execute();
        } catch(SQLException e) {
            throw new InsertFilmException(e);
        }
    }

}
