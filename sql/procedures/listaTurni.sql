DROP PROCEDURE IF EXISTS `listaTurni`;
CREATE PROCEDURE `listaTurni` (in var_employee CHAR(16), in var_month TINYINT(2), in var_year YEAR)
begin
    SELECT extract(day from data) as giorno, ora_inizio, ora_fine
    FROM turno_lavoro
    WHERE extract(month from data) = var_month AND extract(year from data) = var_year
    AND impiegato = var_employee
    ORDER BY data;
end
