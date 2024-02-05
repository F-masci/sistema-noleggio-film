DROP PROCEDURE IF EXISTS `registraNoleggio`;
CREATE PROCEDURE `registraNoleggio` (in var_copy INT, in var_client INT, in var_expiration_date DATE)
begin

    declare var_check TINYINT;

    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level serializable ;

    start transaction;

    SELECT count(*) FROM noleggio_corrente WHERE copia_film = var_copy INTO var_check;
    if var_check > 0 then
        signal sqlstate '45000' set message_text = 'La copia è attualmente noleggiata';
    end if;

    INSERT INTO noleggio(copia_film, cliente, scadenza) VALUES (var_copy, var_client, var_expiration_date);
    commit;
end
