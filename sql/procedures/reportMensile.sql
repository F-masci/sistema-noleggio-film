DROP PROCEDURE IF EXISTS `reportMensile`;
CREATE PROCEDURE `reportMensile` (in var_month TINYINT(2))
begin

    if var_month <= 0 or var_month > 12
    then
        signal sqlstate '45000' set message_text = "Il mese selzionato non è valido";
    end if;

    SELECT nome, data, TIMEDIFF(uscita, ingresso) as ore_lavorate
    FROM turno_terminato
        JOIN impiegato ON codice_fiscale = impiegato
    WHERE extract(month from data) = var_month
    ORDER BY nome, data;

end
