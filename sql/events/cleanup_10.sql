SET GLOBAL event_scheduler = on;

DELIMITER $$

CREATE EVENT IF NOT EXISTS `sistema_noleggio`.`cleanup_10`
ON SCHEDULE
    EVERY 1 YEAR
    STARTS CONCAT(extract(year from CURDATE() + INTERVAL 1 year), '-01-01 01:00:00')
ON COMPLETION PRESERVE
DO BEGIN
    DELETE FROM `noleggio` WHERE `restituzione` < (CURDATE() - INTERVAL 10 YEAR);
    DELETE FROM `carica` WHERE `fine` < (CURDATE() - INTERVAL 10 YEAR);
END$$

DELIMITER ;