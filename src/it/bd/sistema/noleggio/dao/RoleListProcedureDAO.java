package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.SectorListException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleListProcedureDAO {

    public List<Role> roleList(Employee employee) throws DaoException {
        List<Role> roles = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaCariche(?)}");
            cs.setString(1, employee.getCf());

            if(cs.execute()) {

                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    roles.add(new Role(
                            employee,
                            rs.getString("inizio"),
                            rs.getString("fine"),
                            RoleType.createFromString(rs.getString("mansione"))
                    ));
                }

            }

        } catch(SQLException e) {
            throw new SectorListException(e);
        }
        return roles;
    }

}
