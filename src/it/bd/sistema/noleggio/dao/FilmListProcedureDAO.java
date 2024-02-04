package it.bd.sistema.noleggio.dao;

import it.bd.sistema.noleggio.exception.DaoException;
import it.bd.sistema.noleggio.exception.EmployeeListException;
import it.bd.sistema.noleggio.factory.ConnectionFactory;
import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.utility.Price;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmListProcedureDAO {

    public List<Film> filmList() throws DaoException {
        List<Film> films = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call listaFilm()}");
            if(cs.execute()) {

                try(ResultSet rs = cs.getResultSet()) {
                    while (rs.next()) {
                        films.add(new Film(
                                rs.getString("titolo"),
                                rs.getString("regista"),
                                rs.getInt("anno"),
                                new Price(
                                        rs.getFloat("costo_dvd"),
                                        rs.getFloat("costo_videocassetta")
                                ),
                                new Film(
                                        rs.getString("originale_titolo"),
                                        rs.getString("originale_regista")
                                )));
                    }
                }

                for (Film film : films) {
                    List<String> actorNames = new ArrayList<>();
                    List<String> actorSurnames = new ArrayList<>();
                    if (cs.getMoreResults()) {
                        try(ResultSet rs = cs.getResultSet()) {
                            while (rs.next()) {
                                actorNames.add(rs.getString("nome"));
                                actorSurnames.add(rs.getString("cognome"));
                            }
                        }
                    }
                    film.setActorNames(actorNames);
                    film.setActorSurnames(actorSurnames);
                }

            }

        } catch(SQLException e) {
            throw new EmployeeListException(e);
        }
        return films;
    }

}
