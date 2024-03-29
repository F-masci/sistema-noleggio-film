DROP FUNCTION IF EXISTS `tokenize_string_list`;
CREATE FUNCTION `tokenize_string_list` (var_string TEXT, var_delimiter CHAR(1), var_occurrence INT)
RETURNS TEXT
DETERMINISTIC
BEGIN
    return substring_index(substring_index(var_string, var_delimiter, var_occurrence), var_delimiter, -1);
END
