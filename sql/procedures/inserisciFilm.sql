DROP PROCEDURE IF EXISTS `inserisciFilm`;
CREATE PROCEDURE `inserisciFilm` (in var_title VARCHAR(100), in var_director VARCHAR(50), in var_year YEAR, in var_price_dvd FLOAT, in var_price_videotape FLOAT, in var_original_title VARCHAR(100), in var_original_director VARCHAR(50),
                                  in var_names TEXT, in var_surnames TEXT)
begin

    -- La variabile var_names contiene un elenco del tipo xxx;xxx;....; -> nomi degli attori
    -- La variabile var_surnames contiene un elenco del tipo xxx;xxx;....; -> cognomi degli attori

    declare var_actor_name VARCHAR(50);
    declare var_actor_surname VARCHAR(50);
    declare var_counter INT;

    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level read uncommitted;

    start transaction;
    INSERT INTO film(titolo, regista, anno, costo_dvd, costo_videocassetta, originale_titolo, originale_regista) VALUES (var_title, var_director, var_year, var_price_dvd, var_price_videotape, var_original_title, var_original_director);

    set var_counter = 1;
    insert_loop: loop

        set var_actor_name = tokenize_string_list(var_names, ';', var_counter);
        set var_actor_surname = tokenize_string_list(var_surnames, ';', var_counter);
        if var_actor_name = '' or var_actor_surname = '' then
            leave insert_loop;
        end if;

        INSERT INTO cast_film(attore_nome, attore_cognome, film_titolo, film_regista) VALUES(var_actor_name, var_actor_surname, var_title, var_director);

        set var_counter = var_counter + 1;

    end loop;

    commit;
    set autocommit=1;
end
