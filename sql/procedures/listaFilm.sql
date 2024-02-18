DROP PROCEDURE IF EXISTS `listaFilm`;
CREATE PROCEDURE `listaFilm` ()
begin

    declare done bool default false;
    declare var_title VARCHAR(100);
    declare var_director VARCHAR(50);

    declare cur cursor for SELECT titolo, regista FROM film ORDER BY titolo, regista;
    declare continue handler for not found set done = true;

    set transaction isolation level serializable;

    start transaction read only;
        open cur;
        SELECT titolo, regista, anno, costo_dvd, costo_videocassetta, originale_titolo, originale_regista FROM film ORDER BY titolo, regista;
        read_loop: loop

            fetch cur into var_title, var_director;

            SELECT attore_nome as nome, attore_cognome as cognome
            FROM cast_film
            WHERE film_titolo = var_title AND film_regista = var_director;

            if done then
                leave read_loop;
            end if;
        end loop;
    commit;
end