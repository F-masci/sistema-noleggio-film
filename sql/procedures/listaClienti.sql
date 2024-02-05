DROP PROCEDURE IF EXISTS `listaClienti`;
CREATE PROCEDURE `listaClienti` ()
begin

    declare done bool default false;
    declare var_client INT;

    declare cur cursor for SELECT tessera FROM cliente ORDER BY tessera;
    declare continue handler for not found set done = true;

    set transaction isolation level serializable;

    start transaction read only;
        open cur;
        SELECT * FROM cliente ORDER BY tessera;

        read_loop: loop
            fetch cur into var_client;
            SELECT cellulare FROM cellulare WHERE cliente = var_client;
            SELECT email FROM email WHERE cliente = var_client;
            SELECT telefono FROM telefono WHERE cliente = var_client;
            if done then
                leave read_loop;
            end if;
        end loop;

    commit;
end