package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.SectorListException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.FilmCopy;
import it.bd.sistema.noleggio.model.FilmCopyType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmCopyListProcedureDAO {

    public List<FilmCopy> filmCopyList() throws DaoException {
        List<FilmCopy> copies = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaCopieFilm()}");

            if(cs.execute()) {

                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    copies.add(new FilmCopy(
                            rs.getInt("codice"),
                            new Film(
                                    rs.getString("titolo"),
                                    rs.getString("regista")
                            ),
                            FilmCopyType.createFromString(rs.getString("tipo")),
                            rs.getInt("settore"),
                            rs.getString("posizione")
                    ));
                }

            }

        } catch(SQLException e) {
            throw new SectorListException(e);
        }
        return copies;
    }

}
