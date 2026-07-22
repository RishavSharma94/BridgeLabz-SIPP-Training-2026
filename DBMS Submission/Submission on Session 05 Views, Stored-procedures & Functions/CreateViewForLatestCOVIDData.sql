CREATE VIEW LatestCovidData AS
SELECT Country,
       Date,
       Confirmed_Cases,
       Deaths,
       Recoveries
FROM covid_cases c1
WHERE Date = (
    SELECT MAX(c2.Date)
    FROM covid_cases c2
    WHERE c2.Country = c1.Country
);