set @var_title = 'Il mio terzo film';
set @var_director = 'Masci F.';
set @var_year = 2024;
set @var_price_dvd = 19.50;
set @var_price_videotape = 21.30;
set @var_original_title = 'Il mio primo film';
set @var_original_director = 'Masci F.';
set @var_names = 'Francesco;Marco;Alessio;';
set @var_surnames = 'Msci;Mizzoni;Noce;';
call inserisciFilm(
        @var_title,
        @var_director,
        @var_year,
        @var_price_dvd,
        @var_price_videotape,
        @var_original_title,
        @var_original_director,
        @var_names,
        @var_surnames
     );