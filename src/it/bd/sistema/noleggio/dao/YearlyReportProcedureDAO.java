package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.MonthlyReportException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Report;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class YearlyReportProcedureDAO {

    public List<Report> yearlyReport(int year) throws DaoException {
        List<Report> reports = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call reportAnnuale(?)}");
            cs.setInt(1, year);
            if(cs.execute()) {

                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    reports.add(new Report(
                            rs.getString("nome"),
                            rs.getString("mese"),
                            rs.getString("ore_lavorate")
                    ));
                }

            }

        } catch(SQLException e) {
            throw new MonthlyReportException(e);
        }
        return reports;
    }

}
