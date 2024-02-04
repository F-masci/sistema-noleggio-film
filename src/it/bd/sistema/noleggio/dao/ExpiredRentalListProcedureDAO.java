package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.MonthlyReportException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpiredRentalListProcedureDAO {

    public List<Rental> expiredReturnList() throws DaoException {
        List<Rental> rentals = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaNoleggiScaduti()}");
            if(cs.execute()) {

                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    Client client = new Client(
                            rs.getInt("tessera"),
                            rs.getString("codice_fiscale"),
                            rs.getString("nome"),
                            rs.getString("cognome")
                    );
                    Film film = new Film(
                            rs.getString("titolo"),
                            rs.getString("regista")
                    );
                    FilmCopy copy = new FilmCopy(
                            rs.getInt("codice"),
                            film,
                            FilmCopyType.createFromString(rs.getString("tipo"))
                    );
                    rentals.add(new Rental(
                            client,
                            copy,
                            rs.getString("scadenza")
                    ));
                }

            }

        } catch(SQLException e) {
            throw new MonthlyReportException(e);
        }
        return rentals;
    }

}
