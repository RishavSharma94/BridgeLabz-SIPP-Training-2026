SELECT Country,
       Vaccinated_Population AS Population,
       'Vaccinated' AS Status
FROM covid_vaccines

UNION

SELECT Country,
       (Population - Vaccinated_Population) AS Population,
       'Unvaccinated' AS Status
FROM covid_vaccines;