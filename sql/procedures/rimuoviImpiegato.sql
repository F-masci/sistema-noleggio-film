DROP PROCEDURE IF EXISTS `rimuoviImpiegato`;
CREATE PROCEDURE `rimuoviImpiegato` (in var_cf CHAR(16))
begin
    DELETE FROM impiegato WHERE codice_fiscale = var_cf;
end
