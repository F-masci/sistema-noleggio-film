DROP PROCEDURE IF EXISTS `registraCliente`;
CREATE PROCEDURE `registraCliente` (in var_cf CHAR(16), in var_name VARCHAR(50), in var_surname VARCHAR(50), in var_birth_date DATE, in var_address VARCHAR(100), in var_cap INT(5), in var_number INT,
                                    in var_mobile_phones TEXT, in var_emails TEXT, in var_phones TEXT, out var_card INT)
begin

    declare var_affected_rows INT; -- Contiene i recapiti inseriti per il cliente

    -- La variabile var_mobile_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri di cellulare del cliente
    -- La variabile var_emails contiene un elenco del tipo xxx@xx;xxx@xxx;....; -> indirizzi email del cliente
    -- La variabile var_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri fissi del cliente
    
    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level read uncommitted;

    start transaction;
    INSERT INTO cliente(tessera, codice_fiscale, nome, cognome, data_nascita, indirizzo_via, indirizzo_cap, indirizzo_civico) VALUES (NULL, var_cf, var_name, var_surname, var_birth_date, var_address, var_cap, var_number);
    set var_card = last_insert_id();
    call _inserisciRecapitiCliente(var_card, var_mobile_phones, var_emails, var_phones, var_affected_rows);
    if var_affected_rows <= 0 then
        signal sqlstate '45000' set message_text = 'devi inserire almeno un recapito';
    end if;
    commit;
    set autocommit=1;
end
