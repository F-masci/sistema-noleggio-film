package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.InsertFilmCopyException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.FilmCopy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertFilmCopyProcedureDAO {

    public void insertFilmCopy(FilmCopy copy) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserisciCopiaFilm(?,?,?,?,?,?)}");
            cs.setInt(1, copy.getCode());
            cs.setString(2, copy.getFilm().getTitle());
            cs.setString(3, copy.getFilm().getDirector());
            cs.setString(4, copy.getType().getType());
            cs.setInt(5, copy.getSector());
            cs.setString(6, copy.getPosition());
            cs.execute();
        } catch(SQLException e) {
            throw new InsertFilmCopyException(e);
        }
    }

}
