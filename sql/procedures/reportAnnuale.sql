DROP PROCEDURE IF EXISTS `reportAnnuale`;
CREATE PROCEDURE `reportAnnuale` (in var_year YEAR)
begin
    SELECT nome, extract(month from data) as mese, SEC_TO_TIME(SUM(TIME_TO_SEC(TIMEDIFF(uscita, ingresso)))) as ore_lavorate
    FROM turno_terminato
        JOIN impiegato ON codice_fiscale = impiegato
    WHERE extract(year from data) = var_year
    GROUP BY impiegato, extract(month from data)
    ORDER BY nome, mese;
end
