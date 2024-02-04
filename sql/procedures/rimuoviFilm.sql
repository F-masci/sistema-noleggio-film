DROP PROCEDURE IF EXISTS `rimuoviFilm`;
CREATE PROCEDURE `rimuoviFilm` (in var_title VARCHAR(100), in var_director VARCHAR(100))
begin
    DELETE FROM film WHERE titolo = var_title AND regista = var_director;
end
