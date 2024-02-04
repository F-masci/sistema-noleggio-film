DROP PROCEDURE IF EXISTS `listaCariche`;
CREATE PROCEDURE `listaCariche` (in var_employee CHAR(16))
begin
    SELECT inizio, COALESCE(fine, 'corrente') as fine, mansione
    FROM carica
    WHERE impiegato = var_employee
    ORDER BY inizio DESC, fine DESC;
end