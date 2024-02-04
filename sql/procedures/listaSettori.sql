DROP PROCEDURE IF EXISTS `listaSettori`;
CREATE PROCEDURE `listaSettori` ()
begin
    SELECT codice
    FROM settore;
end