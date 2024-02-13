DROP PROCEDURE IF EXISTS `modificaCarica`;
CREATE PROCEDURE `modificaCarica` (in var_employee CHAR(16), in var_end_date DATE, in var_role ENUM('Cassiere', 'Commesso'))
begin

    declare var_start_date DATE;
    declare var_current_role ENUM('Cassiere', 'Commesso');

    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level serializable;

    set var_start_date = var_end_date + INTERVAL 1 day;

    start transaction;
    SELECT mansione FROM carica WHERE impiegato = var_employee AND fine IS NULL INTO var_current_role;
    if var_current_role = var_role
    then
        signal sqlstate '45000' set message_text = 'La nuova mansione deve essere differente da quella precedente';
    end if;

    UPDATE carica SET fine = var_end_date WHERE impiegato = var_employee AND fine IS NULL;
    INSERT INTO carica(impiegato, inizio, mansione) VALUES(var_employee, var_start_date, var_role);
    commit;
    set autocommit=1;

end
