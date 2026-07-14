SELECT
    c.country_name,
    cc.confirmed_cases,
    cc.date
FROM covid_cases cc
INNER JOIN countries c
ON cc.country_id = c.country_id
WHERE cc.date = '2021-01-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;