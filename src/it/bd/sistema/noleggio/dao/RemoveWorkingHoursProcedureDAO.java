package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.RegisterEmployeeException;
import it.bd.sistema.noleggio.exception.RemoveWorkingHoursException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.WorkingHour;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RemoveWorkingHoursProcedureDAO {

    public void removeWorkingHourse(Employee employee, int year, int month) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call rimuoviTurnoLavoro(?,?,?)}");
            cs.setString(1, employee.getCf());
            cs.setInt(2, month);
            cs.setInt(3, year);
            cs.execute();
        } catch(SQLException e) {
            throw new RemoveWorkingHoursException(e);
        }
    }

}
