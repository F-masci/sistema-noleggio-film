DROP PROCEDURE IF EXISTS `_inserisciRecapitiCliente`;
CREATE PROCEDURE `_inserisciRecapitiCliente` (in var_client INT, in var_mobile_phones TEXT, in var_emails TEXT, in var_phones TEXT, out var_affected_rows INT)
begin

    -- La variabile var_mobile_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri di cellulare del cliente
    -- La variabile var_emails contiene un elenco del tipo xxx@xx;xxx@xxx;....; -> indirizzi email del cliente
    -- La variabile var_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri fissi del cliente

    declare var_counter INT;
    declare var_aux TEXT;

    set var_affected_rows = 0;

    -- CELLULARE

    set var_counter = 1;
    insert_mobile_phones_loop: loop
        set var_aux = tokenize_string_list(var_mobile_phones, ';', var_counter);
        if var_aux = ''
        then
            leave insert_mobile_phones_loop;
        end if;
        INSERT INTO cellulare(cellulare, cliente) VALUES (var_aux, var_client);
        set var_affected_rows = var_affected_rows+1;
        set var_counter = var_counter+1;
    end loop;

    -- EMAIL

    set var_counter = 1;
    insert_emails_loop: loop
        set var_aux = tokenize_string_list(var_emails, ';', var_counter);
        if var_aux = ''
        then
            leave insert_emails_loop;
        end if;
        INSERT INTO email(email, cliente) VALUES (var_aux, var_client);
        set var_affected_rows = var_affected_rows+1;
        set var_counter = var_counter+1;
    end loop;

    -- TELEFONO

    set var_counter = 1;
    insert_phones_loop: loop
        set var_aux = tokenize_string_list(var_phones, ';', var_counter);
        if var_aux = ''
        then
            leave insert_phones_loop;
        end if;
        INSERT INTO telefono(telefono, cliente) VALUES (var_aux, var_client);
        set var_affected_rows = var_affected_rows+1;
        set var_counter = var_counter+1;
    end loop;

end
