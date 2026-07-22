CREATE INDEX idx_infection_rate
ON covid_cases(Infection_Rate);

SELECT Country, Infection_Rate
FROM covid_cases
ORDER BY Infection_Rate DESC
LIMIT 10;