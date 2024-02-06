SET GLOBAL event_scheduler = on;

DELIMITER $$

CREATE EVENT IF NOT EXISTS `sistema_noleggio`.`cleanup_5`
ON SCHEDULE
    EVERY 1 YEAR
        STARTS CONCAT(extract(year from CURDATE() + INTERVAL 1 year), '-01-01 01:00:00')
ON COMPLETION PRESERVE
DO BEGIN
    DELETE FROM `turno_lavoro` WHERE `data` < (CURDATE() - INTERVAL 5 YEAR);
END$$

DELIMITER ;