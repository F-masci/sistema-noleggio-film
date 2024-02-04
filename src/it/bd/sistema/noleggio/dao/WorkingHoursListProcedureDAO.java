package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.MonthlyReportException;
import it.bd.sistema.noleggio.exception.WorkingHoursListException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.Report;
import it.bd.sistema.noleggio.model.WorkingHour;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkingHoursListProcedureDAO {

    public List<WorkingHour> workingHoursList(Employee employee, int year, int month) throws DaoException {
        List<WorkingHour> hours = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaTurni(?,?,?)}");
            cs.setString(1, employee.getCf());
            cs.setInt(2, month);
            cs.setInt(3, year);

            if(cs.execute()) {

                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    hours.add(new WorkingHour(
                            rs.getInt("giorno"),
                            rs.getString("ora_inizio") + "-" + rs.getString("ora_fine")
                    ));
                }

            }

        } catch(SQLException e) {
            throw new WorkingHoursListException(e);
        }
        return hours;
    }

}
