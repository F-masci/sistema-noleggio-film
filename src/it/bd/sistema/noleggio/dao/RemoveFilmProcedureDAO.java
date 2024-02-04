package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RemoveEmployeeException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.Film;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoveFilmProcedureDAO {

    public void removeFilm(Film film) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call rimuoviFilm(?,?)}");
            cs.setString(1, film.getTitle());
            cs.setString(2, film.getDirector());
            cs.execute();
        } catch(SQLException e) {
            throw new RemoveEmployeeException(e);
        }
    }

}
