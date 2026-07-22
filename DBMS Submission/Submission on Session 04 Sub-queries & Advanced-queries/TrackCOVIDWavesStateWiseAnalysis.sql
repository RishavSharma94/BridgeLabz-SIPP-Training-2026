SELECT c1.State,
       c1.Date,
       c1.Confirmed_Cases
FROM covid_cases c1
WHERE c1.State = 'Mumbai'
AND c1.Confirmed_Cases =
(
    SELECT MAX(c2.Confirmed_Cases)
    FROM covid_cases c2
    WHERE c2.State = c1.State
);