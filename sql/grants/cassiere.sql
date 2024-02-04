USE sistema_noleggio;
grant execute on procedure sistema_noleggio.timbra to sn_cassiere@localhost;
grant execute on procedure sistema_noleggio.registraNoleggio to sn_cassiere@localhost;
grant execute on procedure sistema_noleggio.registraRestituzione to sn_cassiere@localhost;
grant execute on procedure sistema_noleggio.listaNoleggiScaduti to sn_cassiere@localhost;
grant execute on procedure sistema_noleggio.registraCliente to sn_cassiere@localhost;
grant execute on procedure sistema_noleggio.inserisciRecapitiCliente to sn_cassiere@localhost;
grant execute on procedure sistema_noleggio._inserisciRecapitiCliente to sn_cassiere@localhost;
FLUSH PRIVILEGES;