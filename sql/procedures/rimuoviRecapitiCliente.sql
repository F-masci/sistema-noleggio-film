DROP PROCEDURE IF EXISTS `rimuoviRecapitiCliente`;
CREATE PROCEDURE `rimuoviRecapitiCliente` (in var_client INT, in var_mobile_phones TEXT, in var_emails TEXT, in var_phones TEXT)
begin

    -- La variabile var_mobile_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri di cellulare del cliente
    -- La variabile var_emails contiene un elenco del tipo xxx@xx;xxx@xxx;....; -> indirizzi email del cliente
    -- La variabile var_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri fissi del cliente

    declare var_counter INT;
    declare var_aux TEXT;

    declare var_count_mobile_phones INT;
    declare var_count_emails INT;
    declare var_count_phones INT;

    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level repeatable read;

    start transaction;

    -- CELLULARE

    set var_counter = 1;
    remove_mobile_phones_loop: loop
        set var_aux = tokenize_string_list(var_mobile_phones, ';', var_counter);
        if var_aux = ''
        then
            leave remove_mobile_phones_loop;
        end if;
        DELETE FROM cellulare WHERE cellulare = var_aux AND cliente = var_client;
        set var_counter = var_counter+1;
    end loop;

    -- EMAIL

    set var_counter = 1;
    remove_emails_loop: loop
        set var_aux = tokenize_string_list(var_emails, ';', var_counter);
        if var_aux = ''
        then
            leave remove_emails_loop;
        end if;
        DELETE FROM email WHERE email = var_aux AND cliente = var_client;
        set var_counter = var_counter+1;
    end loop;

    -- TELEFONO

    set var_counter = 1;
    remove_phones_loop: loop
        set var_aux = tokenize_string_list(var_phones, ';', var_counter);
        if var_aux = ''
        then
            leave remove_phones_loop;
        end if;
        DELETE FROM telefono WHERE telefono = var_aux AND cliente = var_client;
        set var_counter = var_counter+1;
    end loop;

    SELECT count(*) FROM cellulare WHERE cliente = var_client INTO var_count_mobile_phones;
    SELECT count(*) FROM email WHERE cliente = var_client INTO var_count_emails;
    SELECT count(*) FROM telefono WHERE cliente = var_client INTO var_count_phones;

    if var_count_mobile_phones <= 0 and var_count_emails <= 0 and var_count_phones <= 0 then
        signal sqlstate '45000' set message_text = 'Il cliente deve avere almeno un recapito';
    end if;

    commit;
    set autocommit=1;
end
