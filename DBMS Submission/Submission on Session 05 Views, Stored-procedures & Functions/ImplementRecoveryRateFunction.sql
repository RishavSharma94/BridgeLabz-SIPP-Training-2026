DELIMITER //

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(50)
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE rate DECIMAL(10,2);

    SELECT (Recoveries * 100.0 / Confirmed_Cases)
    INTO rate
    FROM covid_cases
    WHERE Country = p_country
    ORDER BY Date DESC
    LIMIT 1;

    RETURN rate;
END //

DELIMITER ;