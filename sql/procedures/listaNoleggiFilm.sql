DROP PROCEDURE IF EXISTS `listaNoleggiFilm`;
CREATE PROCEDURE `listaNoleggiFilm` (in var_title VARCHAR(100), in var_director VARCHAR(50))
begin
    SELECT tessera, codice_fiscale, nome, cognome,
           codice, titolo, regista, tipo,
           noleggio, scadenza, restituzione
    FROM noleggio
        JOIN copia_film ON copia_film = codice
        JOIN cliente ON cliente = tessera
    WHERE titolo = var_title AND regista = var_director
    ORDER BY noleggio DESC, scadenza DESC, restituzione;
end