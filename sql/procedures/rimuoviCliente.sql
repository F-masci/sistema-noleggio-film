DROP PROCEDURE IF EXISTS `rimuoviCliente`;
CREATE PROCEDURE `rimuoviCliente` (in var_card INT)
begin
    DELETE FROM cliente WHERE tessera = var_card;
end
