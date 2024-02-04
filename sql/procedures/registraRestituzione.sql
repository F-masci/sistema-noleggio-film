DROP PROCEDURE IF EXISTS `registraRestituzione`;
CREATE PROCEDURE `registraRestituzione` (in var_copy INT, in var_client INT)
begin
    UPDATE noleggio SET restituzione = CURDATE() WHERE copia_film = var_copy AND cliente = var_client;
end