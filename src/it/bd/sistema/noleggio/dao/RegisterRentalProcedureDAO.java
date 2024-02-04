package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RegisterEmployeeException;
import it.bd.sistema.noleggio.exception.RegisterRentalException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.FilmCopy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterRentalProcedureDAO {

    public void registerRental(Client client, FilmCopy copy, String expiration_date) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call registraNoleggio(?,?,?)}");
            cs.setInt(1, copy.getCode());
            cs.setInt(2, client.getCard());
            cs.setString(3, expiration_date);
            cs.execute();
        } catch(SQLException e) {
            throw new RegisterRentalException(e);
        }
    }

}
