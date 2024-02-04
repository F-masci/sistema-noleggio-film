package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RegisterEmployeeException;
import it.bd.sistema.noleggio.exception.RegisterReturnException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.FilmCopy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RegisterReturnProcedureDAO {

    public void registerReturn(Client client, FilmCopy copy) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call registraRestituzione(?,?)}");
            cs.setInt(1, copy.getCode());
            cs.setInt(2, client.getCard());
            cs.execute();
            if(cs.getUpdateCount() == 0) throw new RegisterReturnException(new RegisterReturnException("nessun noleggio trovato"));
        } catch(SQLException e) {
            throw new RegisterReturnException(e);
        }
    }

}
