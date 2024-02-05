package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RemoveClientException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoveClientProcedureDAO {

    public void removeClient(Client client) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call rimuoviCliente(?)}");
            cs.setInt(1, client.getCard());
            cs.execute();
        } catch(SQLException e) {
            throw new RemoveClientException(e);
        }
    }

}
