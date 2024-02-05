package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.MonthlyReportException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.model.Rental;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmRentalListProcedureDAO extends GenericRentalListProcedureDAO {

    @Override
    public List<Rental> rentalList(Object... objects) throws DaoException {
        Film film = (Film) objects[0];
        List<Rental> rentals = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaNoleggiFilm(?,?)}");
            cs.setString(1, film.getTitle());
            cs.setString(2, film.getDirector());
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
