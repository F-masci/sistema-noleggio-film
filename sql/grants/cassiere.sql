USE sistema_noleggio;
grant execute on procedure timbra to sn_cassiere@localhost;
grant execute on procedure registraCliente to sn_cassiere@localhost;
grant execute on procedure listaClienti to sn_cassiere@localhost;
grant execute on procedure rimuoviCliente to sn_cassiere@localhost;
grant execute on procedure inserisciRecapitiCliente to sn_cassiere@localhost;
grant execute on procedure rimuoviRecapitiCliente to sn_cassiere@localhost;
grant execute on procedure registraNoleggio to sn_cassiere@localhost;
grant execute on procedure registraRestituzione to sn_cassiere@localhost;
grant execute on procedure listaNoleggiCorrenti to sn_cassiere@localhost;
grant execute on procedure listaNoleggiScaduti to sn_cassiere@localhost;
grant execute on procedure listaNoleggiCopiaFilm to sn_cassiere@localhost;
grant execute on procedure listaNoleggiCliente to sn_cassiere@localhost;
grant execute on procedure listaNoleggiFilm to sn_cassiere@localhost;
FLUSH PRIVILEGES;