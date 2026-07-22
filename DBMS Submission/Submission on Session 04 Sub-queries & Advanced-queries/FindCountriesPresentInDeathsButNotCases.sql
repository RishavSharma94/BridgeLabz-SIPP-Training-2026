SELECT Country
FROM covid_deaths
WHERE Country NOT IN
(
    SELECT Country
    FROM covid_cases
);