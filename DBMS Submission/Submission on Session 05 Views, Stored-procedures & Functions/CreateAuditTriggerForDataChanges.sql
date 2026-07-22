CREATE TABLE covid_cases_audit (
    Audit_ID INT AUTO_INCREMENT PRIMARY KEY,
    Country VARCHAR(50),
    Date DATE,
    Old_Confirmed INT,
    New_Confirmed INT,
    Old_Deaths INT,
    New_Deaths INT,
    Old_Recoveries INT,
    New_Recoveries INT,
    Updated_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER BeforeCovidUpdate
BEFORE UPDATE
ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit(
        Country,
        Date,
        Old_Confirmed,
        New_Confirmed,
        Old_Deaths,
        New_Deaths,
        Old_Recoveries,
        New_Recoveries
    )
    VALUES(
        OLD.Country,
        OLD.Date,
        OLD.Confirmed_Cases,
        NEW.Confirmed_Cases,
        OLD.Deaths,
        NEW.Deaths,
        OLD.Recoveries,
        NEW.Recoveries
    );
END //

DELIMITER ;