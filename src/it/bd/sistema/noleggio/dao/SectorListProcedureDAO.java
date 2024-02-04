package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.SectorListException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectorListProcedureDAO {

    public List<Integer> sectorList() throws DaoException {
        List<Integer> sectors = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaSettori()}");

            if(cs.execute()) {

                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    sectors.add(rs.getInt("codice"));
                }

            }

        } catch(SQLException e) {
            throw new SectorListException(e);
        }
        return sectors;
    }

}
