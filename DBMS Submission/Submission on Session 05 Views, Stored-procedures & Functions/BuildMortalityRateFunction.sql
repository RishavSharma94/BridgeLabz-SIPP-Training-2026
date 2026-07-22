DELIMITER //

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(50),
    p_date DATE
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE rate DECIMAL(10,2);

    SELECT (Deaths * 100.0 / Confirmed_Cases)
    INTO rate
    FROM covid_cases
    WHERE Country = p_country
      AND Date = p_date;

    RETURN rate;
END //

DELIMITER ;