DROP PROCEDURE IF EXISTS `rimuoviTurnoLavoro`;
CREATE PROCEDURE `rimuoviTurnoLavoro` (in var_employee CHAR(16), in var_month TINYINT(2), in var_year YEAR)
begin

    declare var_check TINYINT; -- Mantiene il controllo per capire se il turno di quel mese è stato già iniziato o meno

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
    SELECT count(*) FROM turno_iniziato WHERE extract(month from data) = var_month AND extract(year from data) = var_year AND impiegato = var_employee INTO var_check;
    if var_check > 0 then
        signal sqlstate '45000' set message_text = 'Turni di lavoro già iniziati';
    end if;

    SELECT count(*) FROM turno_terminato WHERE extract(month from data) = var_month AND extract(year from data) = var_year AND impiegato = var_employee INTO var_check;
    if var_check > 0 then
        signal sqlstate '45000' set message_text = 'Turni di lavoro già terminati';
    end if;

    DELETE FROM turno_lavoro WHERE extract(month from data) = var_month AND extract(year from data) = var_year AND impiegato = var_employee;

    commit;
    set autocommit=1;
end