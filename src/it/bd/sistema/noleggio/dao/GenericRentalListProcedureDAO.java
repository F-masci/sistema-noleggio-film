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

public abstract class GenericRentalListProcedureDAO {

    public Rental createRentalFromRs(ResultSet rs) throws SQLException {
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
        return new Rental(
                client,
                copy,
                rs.getString("noleggio"),
                rs.getString("scadenza"),
                rs.getString("restituzione")
        );
    }

    public abstract List<Rental> rentalList(Object... objects) throws DaoException;

}
