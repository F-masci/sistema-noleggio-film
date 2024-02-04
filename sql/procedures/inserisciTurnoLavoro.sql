DROP PROCEDURE IF EXISTS `inserisciTurnoLavoro`;
CREATE PROCEDURE `inserisciTurnoLavoro` (in var_employee CHAR(16), in var_month TINYINT(2), in var_year YEAR, in var_list_days VARCHAR(62), in var_list_hours VARCHAR(372))
begin

    -- La variabile var_list_days contiene un elenco del tipo 1;2;3;4;...; -> giorni a cui si riferiscono gli orari
    -- La variabile var_list_hours contiene un elenco del tipo 00:00-00:00;00:00-00:00;....; -> orari di inizio e fine turno

    declare var_counter INT;  -- Indice del loop
    declare var_day TINYINT(2); -- Contiene il numero del giorno da inserire
    declare var_hours CHAR(17); -- Contiene gli orari del tipo 00:00-00:00
    declare var_start_hour TIME; -- Contiene gli orari del tipo 00:00
    declare var_end_hour TIME; -- Contiene gli orari del tipo 00:00

    declare var_check TINYINT; -- Mantiene il controllo per capire se il turno di quel mese è stato già inserito o meno
    
    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level serializable;

    start transaction;

    /**
      * Il controllo viene eseguito all'interno della procedura e non attraverso un trigger poiché in questo modo lo statement di SELECT viene eseguito una sola volta
      * anziché per ogni riga inserita nella tabella
      */
    SELECT count(*) FROM turno_lavoro WHERE extract(month from data) = var_month AND extract(year from data) = var_year AND impiegato = var_employee INTO var_check;
    if var_check > 0 then
        signal sqlstate '45000' set message_text = 'Turno di lavoro già presente';
    end if;

    set var_counter = 1;
    insert_loop: loop

        set var_hours = tokenize_string_list(var_list_hours, ';', var_counter);
        if var_hours = ''
        then
            leave insert_loop;
        end if;

        set var_day = tokenize_string_list(var_list_days, ';', var_counter);

        set var_start_hour = tokenize_string_list(var_hours, '-', 1);
        set var_end_hour = tokenize_string_list(var_hours, '-', 2);

        INSERT INTO turno_lavoro(impiegato, data, ora_inizio, ora_fine) VALUES (var_employee, CONCAT(var_year, '-', var_month, '-', var_day), var_start_hour, var_end_hour);

        set var_counter = var_counter+1;
    end loop;

    commit;
    set autocommit=1;
end
