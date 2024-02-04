package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RegisterClientException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.utility.FormatListProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class RegisterClientProcedureDAO {

    public void registerClient(Client client) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call registraCliente(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, client.getCf());
            cs.setString(2, client.getName());
            cs.setString(3, client.getSurname());
            cs.setString(4, client.getBirthDate());
            cs.setString(5, client.getAddress().getAddress());
            cs.setInt(6, client.getAddress().getCap());
            cs.setInt(7, client.getAddress().getNumber());
            cs.setString(8, FormatListProcedure.createListFromLongs(client.getMobilePhones()));
            cs.setString(9, FormatListProcedure.createListFromStrings(client.getEmails()));
            cs.setString(10, FormatListProcedure.createListFromLongs(client.getPhones()));
            cs.registerOutParameter(11, Types.INTEGER);
            cs.executeQuery();
            client.setCard(cs.getInt(11));
        } catch(SQLException e) {
            throw new RegisterClientException(e);
        }
    }


}
