DELIMITER //

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(50),
    IN p_date DATE,
    IN p_cases INT,
    IN p_deaths INT,
    IN p_recoveries INT
)
BEGIN
    UPDATE covid_cases
    SET Confirmed_Cases = p_cases,
        Deaths = p_deaths,
        Recoveries = p_recoveries
    WHERE Country = p_country
      AND Date = p_date;
END //

DELIMITER ;