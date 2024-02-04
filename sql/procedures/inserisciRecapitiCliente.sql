DROP PROCEDURE IF EXISTS `inserisciRecapitiCliente`;
CREATE PROCEDURE `inserisciRecapitiCliente` (in var_client INT, in var_mobile_phones TEXT, in var_emails TEXT, in var_phones TEXT)
begin

    -- La variabile var_mobile_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri di cellulare del cliente
    -- La variabile var_emails contiene un elenco del tipo xxx@xx;xxx@xxx;....; -> indirizzi email del cliente
    -- La variabile var_phones contiene un elenco del tipo 0000000000;0000000000;....; -> numeri fissi del cliente

    declare var_affected_rows INT;

    declare exit handler for sqlexception
    begin
        rollback;
        set autocommit=1;
        resignal;
    end;

    set autocommit=0;
    set transaction isolation level read uncommitted;

    start transaction;
    call _inserisciRecapitiCliente(var_client, var_mobile_phones, var_emails, var_phones, var_affected_rows);
    commit;
    set autocommit=1;
end
