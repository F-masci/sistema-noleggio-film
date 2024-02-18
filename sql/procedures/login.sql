DROP PROCEDURE IF EXISTS `login`;
CREATE PROCEDURE `login` (in var_username VARCHAR(100), in var_password VARCHAR(100), out var_role ENUM('Proprietario', 'Cassiere', 'Commesso'), out var_employee CHAR(16))
begin
    declare var_check_username VARCHAR(100);

    SELECT username, login.impiegato, mansione
    FROM login
        LEFT JOIN carica_attuale ON login.impiegato = carica_attuale.impiegato
    WHERE username = var_username AND password = MD5(var_password) INTO var_check_username, var_employee, var_role;

	if var_check_username is null then
        signal sqlstate '45000' set message_text = 'Credenziali errate';
    end if;

    if var_employee is null then
		set var_role = 'Proprietario';
    end if;
end