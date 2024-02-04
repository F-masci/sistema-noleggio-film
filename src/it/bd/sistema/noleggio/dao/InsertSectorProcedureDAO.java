package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.InsertFilmException;
import it.bd.sistema.noleggio.exception.InsertSectorException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.utility.FormatListProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertSectorProcedureDAO {

    public void insertSector(int sector) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call inserisciSettore(?)}");
            cs.setInt(1, sector);
            cs.execute();
        } catch(SQLException e) {
            throw new InsertSectorException(e);
        }
    }

}
