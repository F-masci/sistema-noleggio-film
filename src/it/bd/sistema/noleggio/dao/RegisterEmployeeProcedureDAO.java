package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.LoginException;
import it.bd.sistema.noleggio.exception.RegisterEmployeeException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class RegisterEmployeeProcedureDAO {

    public void registerEmployee(String username, String password, String role, String startDate, String cf, String nome, long recapito) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call registraImpiegato(?,?,?,?,?,?,?)}");
            cs.setString(1, username);
            cs.setString(2, password);
            cs.setString(3, role);
            cs.setString(4, startDate);
            cs.setString(5, cf);
            cs.setString(6, nome);
            cs.setLong(7, recapito);
            cs.execute();
        } catch(SQLException e) {
            throw new RegisterEmployeeException(e);
        }
    }

}
