package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.InsertWorkingHoursException;
import it.bd.sistema.noleggio.exception.RegisterEmployeeException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.WorkingHour;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class InsertWorkingHoursProcedureDAO {

    public void insertWorkingHourse(Employee employee, int year, int month, List<WorkingHour> hours) throws DaoException {
        try {
            Connection conn = ConnectionFactory.getConnection();

            StringBuilder list_days = new StringBuilder();
            StringBuilder list_hours = new StringBuilder();
            for(WorkingHour w: hours) {
                list_days.append(w.getDay()).append(";");
                list_hours.append(w.getFormattedHour()).append(";");
            }

            CallableStatement cs = conn.prepareCall("{call inserisciTurnoLavoro(?,?,?,?,?)}");
            cs.setString(1, employee.getCf());
            cs.setInt(2, month);
            cs.setInt(3, year);
            cs.setString(4, list_days.toString());
            cs.setString(5, list_hours.toString());
            cs.execute();
        } catch(SQLException e) {
            throw new InsertWorkingHoursException(e);
        }
    }

}
