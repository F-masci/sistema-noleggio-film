DROP PROCEDURE IF EXISTS `listaNoleggi`;
CREATE PROCEDURE `listaNoleggi` ()
begin
    SELECT tessera, codice_fiscale, nome, cognome,
           codice, titolo, regista, tipo,
           noleggio, scadenza, restituzione
    FROM noleggio_scaduto
             JOIN copia_film ON copia_film = codice
             JOIN cliente ON cliente = tessera;
end