DROP PROCEDURE IF EXISTS `listaImpiegati`;
CREATE PROCEDURE `listaImpiegati` ()
begin
    SELECT codice_fiscale, nome, recapito, username, mansione
    FROM impiegato
        JOIN login ON login.impiegato = codice_fiscale
        JOIN carica_attuale ON codice_fiscale = carica_attuale.impiegato
    ORDER BY codice_fiscale;
end