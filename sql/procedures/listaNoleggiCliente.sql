DROP PROCEDURE IF EXISTS `listaNoleggiCliente`;
CREATE PROCEDURE `listaNoleggiCliente` (in var_client INT)
begin
    SELECT tessera, codice_fiscale, nome, cognome,
           codice, titolo, regista, tipo,
           noleggio, scadenza, restituzione
    FROM noleggio
        JOIN copia_film ON copia_film = codice
        JOIN cliente ON cliente = tessera
    WHERE cliente = var_client
    ORDER BY noleggio DESC, scadenza DESC, restituzione;
end