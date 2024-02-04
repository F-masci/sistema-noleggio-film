package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RemoveEmployeeException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Film;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoveSectorProcedureDAO {

    public void removeSector(int sector) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call rimuoviSettore(?)}");
            cs.setInt(1, sector);
            cs.execute();
        } catch(SQLException e) {
            throw new RemoveEmployeeException(e);
        }
    }

}
