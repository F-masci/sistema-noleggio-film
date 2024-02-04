package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RegisterEmployeeException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ChangeRoleProcedureDAO {

    public void changeRole(Employee employee, String date, String role) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call modificaCarica(?,?,?)}");
            cs.setString(1, employee.getCf());
            cs.setString(2, date);
            cs.setString(3, role);
            cs.execute();
        } catch(SQLException e) {
            throw new RegisterEmployeeException(e);
        }
    }

}
