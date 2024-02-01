DROP PROCEDURE IF EXISTS `login`;
CREATE PROCEDURE `login` (in var_username VARCHAR(100), in var_password VARCHAR(100), out var_role ENUM('Proprietario', 'Cassiere', 'Impiegato'), out var_employee CHAR(16))
begin
    declare var_success TINYINT;
    declare var_current_role ENUM('Cassiere', 'Commesso');
    SELECT impiegato, count(*) FROM login WHERE username = var_username AND password = MD5(var_password) INTO var_employee, var_success;

	if var_success != 1
	then
        signal sqlstate '45000' set message_text = "credenziali errate";
    end if;

    if var_employee is null
    then
		set var_role = 'Proprietario';
    else
        SELECT mansione FROM carica_attuale WHERE impiegato = var_employee INTO var_current_role;
        if var_current_role is null
        then
            signal sqlstate '45000' set message_text = "l'utente non lavora più all'interno del negozio";
        else if var_current_role = 'Cassiere'
            then
                set var_role = 'Cassiere';
            else
                set var_role = 'Impiegato';
            end if;
        end if;
    end if;
end