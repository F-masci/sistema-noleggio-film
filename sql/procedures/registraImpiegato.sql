DROP PROCEDURE IF EXISTS `registraImpiegato`;
CREATE PROCEDURE `registraImpiegato` (in var_username VARCHAR(100), in var_password VARCHAR(100), in var_role ENUM('Cassiere', 'Commesso'), in var_start_date DATE, in var_cf CHAR(16), in var_name VARCHAR(50), in var_phone BIGINT(10))
begin

    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level read uncommitted;
    start transaction;
    INSERT INTO impiegato(codice_fiscale, nome, recapito) VALUES (var_cf, var_name, var_phone);
    INSERT INTO carica(impiegato, inizio,  mansione) VALUES (var_cf, var_start_date, var_role);
    INSERT INTO login (username, password, impiegato) VALUES (var_username, MD5(var_password), var_cf);
    commit;
    set autocommit=1;
end