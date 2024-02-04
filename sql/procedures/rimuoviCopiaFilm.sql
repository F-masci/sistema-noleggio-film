DROP PROCEDURE IF EXISTS `rimuoviCopiaFilm`;
CREATE PROCEDURE `rimuoviCopiaFilm` (in var_code INT)
begin
    DELETE FROM copia_film WHERE codice = var_code;
end
