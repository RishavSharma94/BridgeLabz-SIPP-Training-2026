EXPLAIN
SELECT c.Country,
       c.Confirmed_Cases,
       d.Deaths,
       v.Vaccinated_Population
FROM covid_cases c
JOIN covid_deaths d
ON c.Country = d.Country
AND c.Date = d.Date
JOIN covid_vaccines v
ON c.Country = v.Country
AND c.Date = v.Date;