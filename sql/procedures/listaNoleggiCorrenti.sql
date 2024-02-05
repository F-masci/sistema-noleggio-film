DROP PROCEDURE IF EXISTS `listaNoleggiCorrenti`;
CREATE PROCEDURE `listaNoleggiCorrenti` ()
begin
    SELECT tessera, codice_fiscale, nome, cognome,
           codice, titolo, regista, tipo,
           noleggio, scadenza, restituzione
    FROM noleggio_corrente
        JOIN copia_film ON copia_film = codice
        JOIN cliente ON cliente = tessera
    ORDER BY noleggio DESC, scadenza DESC, restituzione;
end