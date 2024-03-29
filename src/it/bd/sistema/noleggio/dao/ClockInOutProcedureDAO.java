package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.ClockInOutException;
import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.RoleType;
import it.bd.sistema.noleggio.model.User;
import it.bd.sistema.noleggio.utility.LoggedUser;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ClockInOutProcedureDAO {

    public void clockInOut() throws DaoException {
        try {
            User user = LoggedUser.getLoggedUser();
            if(user.getRole() != RoleType.OWNER) {
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
