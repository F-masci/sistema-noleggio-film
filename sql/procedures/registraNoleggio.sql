DROP PROCEDURE IF EXISTS `registraNoleggio`;
CREATE PROCEDURE `registraNoleggio` (in var_copy INT, in var_client INT, in var_expiration_date DATE)
begin
    INSERT INTO noleggio(copia_film, cliente, scadenza) VALUES (var_copy, var_client, var_expiration_date);
end
