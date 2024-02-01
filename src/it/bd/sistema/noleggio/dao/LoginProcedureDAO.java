package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.LoginException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.Role;
import it.bd.sistema.noleggio.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class LoginProcedureDAO {


    public User execute(String username, String password) throws DaoException {
        Role role;
        String employee;
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call login(?,?,?,?)}");
            cs.setString(1, username);
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.executeQuery();
            role = Role.createFromString(cs.getString(3));
            employee = cs.getString(4);
        } catch(SQLException e) {
            throw new LoginException(e);
        }

        if(role == Role.OWNER) return new User(username, role);
        else return new Employee(username, role, employee);
    }
}
