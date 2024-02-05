DROP PROCEDURE IF EXISTS `timbra`;
CREATE PROCEDURE `timbra` (in var_employee CHAR(16))
begin

    declare var_started_job TINYINT;

    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level read committed;


    start transaction;

    SELECT count(*) FROM turno_iniziato WHERE impiegato = var_employee AND data = CURDATE() INTO var_started_job;

    if not var_started_job
    then

    -- TIMBRATURA IN INGRESSO
    UPDATE turno_lavoro SET ingresso = CURTIME() WHERE impiegato = var_employee AND data = CURDATE();

    else

    -- TIMBRATURA IN USCITA
    UPDATE turno_lavoro SET uscita = CURTIME() WHERE impiegato = var_employee AND data = CURDATE();

    end if;
    commit;
    set autocommit=1;

end