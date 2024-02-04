package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RemoveEmployeeException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class RemoveEmployeeProcedureDAO {

    public void removeEmployee(Employee employee) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call rimuoviImpiegato(?)}");
            cs.setString(1, employee.getCf());
            cs.execute();
        } catch(SQLException e) {
            throw new RemoveEmployeeException(e);
        }
    }

}
