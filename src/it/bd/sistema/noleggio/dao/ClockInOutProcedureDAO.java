package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.bean.RegisterEmployeeBean;
import it.bd.sistema.noleggio.exception.ClockInOutException;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.MonthlyReportException;
import it.bd.sistema.noleggio.exception.RegisterEmployeeException;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.Report;
import it.bd.sistema.noleggio.model.Role;
import it.bd.sistema.noleggio.model.User;
import it.bd.sistema.noleggio.utility.LoggedUser;
import it.bd.sistema.noleggio.view.RegisterEmployeeView;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClockInOutProcedureDAO {

    public void clockInOut() throws DaoException {
        try {
            User user = LoggedUser.getLoggedUser();
            if(user.getRole() != Role.OWNER) {
                Connection conn = ConnectionFactory.getConnection();
                CallableStatement cs = conn.prepareCall("{call timbra(?)}");
                cs.setString(1, ((Employee) user).getCf());
                cs.execute();
            }
        } catch(SQLException e) {
            throw new ClockInOutException(e);
        }
    }

}
