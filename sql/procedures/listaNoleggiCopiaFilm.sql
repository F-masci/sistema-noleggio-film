DROP PROCEDURE IF EXISTS `listaNoleggiCopiaFilm`;
CREATE PROCEDURE `listaNoleggiCopiaFilm` (in var_code INT)
begin
    SELECT tessera, codice_fiscale, nome, cognome,
           codice, titolo, regista, tipo,
           noleggio, scadenza, restituzione
    FROM noleggio
        JOIN copia_film ON copia_film = codice
        JOIN cliente ON cliente = tessera
    WHERE copia_film = var_code
    ORDER BY noleggio DESC, scadenza DESC, restituzione;
end