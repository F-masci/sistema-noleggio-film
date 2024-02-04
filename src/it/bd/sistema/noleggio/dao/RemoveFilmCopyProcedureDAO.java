package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RemoveFilmCopyException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.FilmCopy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoveFilmCopyProcedureDAO {

    public void removeFilmCopy(FilmCopy copy) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call rimuoviCopiaFilm(?)}");
            cs.setInt(1, copy.getCode());
            cs.execute();
        } catch(SQLException e) {
            throw new RemoveFilmCopyException(e);
        }
    }

}
