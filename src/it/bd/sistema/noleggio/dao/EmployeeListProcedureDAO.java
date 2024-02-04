package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.EmployeeListException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.RoleType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListProcedureDAO {

    public List<Employee> employeeList() throws DaoException {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaImpiegati()}");
            if(cs.execute()) {

                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    employees.add(new Employee(
                            rs.getString("username"),
                            rs.getString("codice_fiscale"),
                            rs.getString("nome"),
                            rs.getLong("recapito"),
                            RoleType.createFromString(rs.getString("mansione"))
                    ));
                }

            }

        } catch(SQLException e) {
            throw new EmployeeListException(e);
        }
        return employees;
    }

}
