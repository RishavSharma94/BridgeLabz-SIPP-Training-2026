SELECT Country, Deaths
FROM covid_deaths
WHERE Deaths >
(
    SELECT AVG(Deaths)
    FROM covid_deaths
);