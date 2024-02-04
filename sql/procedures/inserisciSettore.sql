DROP PROCEDURE IF EXISTS `inserisciSettore`;
CREATE PROCEDURE `inserisciSettore` (in var_code INT)
begin
    INSERT INTO settore(codice) VALUES(var_code);
end
