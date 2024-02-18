DROP PROCEDURE IF EXISTS `reportMensile`;
CREATE PROCEDURE `reportMensile` (in var_month TINYINT(2), in var_year YEAR)
begin
    SELECT nome, data, TIMEDIFF(uscita, ingresso) as ore_lavorate
    FROM turno_terminato
        JOIN impiegato ON codice_fiscale = impiegato
    WHERE extract(month from data) = var_month AND extract(year from data) = var_year
    ORDER BY impiegato, data;
end
