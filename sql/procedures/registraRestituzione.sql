DROP PROCEDURE IF EXISTS `registraRestituzione`;
CREATE PROCEDURE `registraRestituzione` (in var_copy INT, in var_client INT)
begin
    declare var_affected_rows TINYINT;
    UPDATE noleggio_corrente SET restituzione = CURDATE() WHERE copia_film = var_copy AND cliente = var_client;
    SELECT ROW_COUNT() INTO var_affected_rows;
    if var_affected_rows <= 0 then
        signal sqlstate '45000' set message_text = 'Nessun noleggio collegato';
    end if;
end