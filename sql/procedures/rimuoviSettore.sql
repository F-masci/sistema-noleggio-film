DROP PROCEDURE IF EXISTS `rimuoviSettore`;
CREATE PROCEDURE `rimuoviSettore` (in var_code INT)
begin
    DELETE FROM settore WHERE codice = var_code;
end
