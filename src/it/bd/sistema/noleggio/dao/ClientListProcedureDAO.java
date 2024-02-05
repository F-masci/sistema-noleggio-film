package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.EmployeeListException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Client;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.utility.Address;
import it.bd.sistema.noleggio.utility.Price;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientListProcedureDAO {

    public List<Client> clientList() throws DaoException {
        List<Client> clients = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaClienti()}");
            if(cs.execute()) {

                try(ResultSet rs = cs.getResultSet()) {
                    while (rs.next()) {
                        clients.add(new Client(
                                rs.getInt("tessera"),
                                rs.getString("codice_fiscale"),
                                rs.getString("nome"),
                                rs.getString("cognome"),
                                rs.getString("data_nascita"),
                                new Address(
                                        rs.getString("indirizzo_via"),
                                        rs.getInt("indirizzo_cap"),
                                        rs.getInt("indirizzo_civico")
                                )
                        ));
                    }
                }

                for (Client client : clients) {
                    List<Long> mobilePhones = new ArrayList<>();
                    List<String> emails = new ArrayList<>();
                    List<Long> phones = new ArrayList<>();
                    if (cs.getMoreResults()) {
                        try (ResultSet rs = cs.getResultSet()) {
                            while (rs.next()) {
                                mobilePhones.add(rs.getLong("cellulare"));
                            }
                        }
                    }
                    if (cs.getMoreResults()) {
                        try (ResultSet rs = cs.getResultSet()) {
                            while (rs.next()) {
                                emails.add(rs.getString("email"));
                            }
                        }
                    }
                    if (cs.getMoreResults()) {
                        try(ResultSet rs = cs.getResultSet()) {
                            while (rs.next()) {
                                phones.add(rs.getLong("telefono"));
                            }
                        }
                    }
                    client.setMobilePhones(mobilePhones);
                    client.setEmails(emails);
                    client.setPhones(phones);
                }

            }

        } catch(SQLException e) {
            throw new EmployeeListException(e);
        }
        return clients;
    }

}
