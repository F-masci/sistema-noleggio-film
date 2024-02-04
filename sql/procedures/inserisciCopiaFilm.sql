DROP PROCEDURE IF EXISTS `inserisciCopiaFilm`;
CREATE PROCEDURE `inserisciCopiaFilm` (in var_code INT, in var_title VARCHAR(100), in var_director VARCHAR(50), in var_type ENUM('DVD', 'Videocassetta'), in var_sector INT, in var_position VARCHAR(100))
begin
    INSERT INTO copia_film(codice, titolo, regista, tipo, settore, posizione) VALUES(var_code, var_title, var_director, var_type, var_sector, var_position);
end
