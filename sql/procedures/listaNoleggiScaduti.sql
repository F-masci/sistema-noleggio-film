DROP PROCEDURE IF EXISTS `listaNoleggiScaduti`;
CREATE PROCEDURE `listaNoleggiScaduti` ()
begin
    SELECT tessera, codice_fiscale, nome, cognome,
           codice, titolo, regista, tipo,
           noleggio, scadenza
    FROM noleggio_scaduto
        JOIN copia_film ON copia_film = codice
        JOIN cliente ON cliente = tessera;
end