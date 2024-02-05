package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.InsertClientAddressException;
import it.bd.sistema.noleggio.exception.RemoveClientException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.utility.FormatListProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoveClientAddressProcedureDAO {

    public void removeClientAddress(Client client) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call rimuoviRecapitiCliente(?,?,?,?)}");
            cs.setInt(1, client.getCard());
            cs.setString(2, FormatListProcedure.createListFromLongs(client.getMobilePhones()));
            cs.setString(3, FormatListProcedure.createListFromStrings(client.getEmails()));
            cs.setString(4, FormatListProcedure.createListFromLongs(client.getPhones()));
            cs.execute();
        } catch(SQLException e) {
            throw new RemoveClientException(e);
        }
    }

}
