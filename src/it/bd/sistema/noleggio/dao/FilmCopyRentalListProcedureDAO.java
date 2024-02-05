package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.MonthlyReportException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.model.Rental;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmCopyRentalListProcedureDAO extends GenericRentalListProcedureDAO{

    @Override
    public List<Rental> rentalList(Object... objects) throws DaoException {
        FilmCopy copy = (FilmCopy) objects[0];
        List<Rental> rentals = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaNoleggiCopiaFilm(?)}");
            cs.setInt(1, copy.getCode());
            if(cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    rentals.add(super.createRentalFromRs(rs));
                }
            }

        } catch(SQLException e) {
            throw new MonthlyReportException(e);
        }
        return rentals;
    }

}
