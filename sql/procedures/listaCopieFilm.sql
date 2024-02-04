DROP PROCEDURE IF EXISTS `listaCopieFilm`;
CREATE PROCEDURE `listaCopieFilm` ()
begin
    SELECT codice, titolo, regista, tipo, settore, posizione
    FROM copia_film;
end