DELETE FROM covid_cases
WHERE Country = 'IN';

DELETE FROM covid_cases
WHERE Country = 'India'
AND Date = '2021-01-01'
LIMIT 1;