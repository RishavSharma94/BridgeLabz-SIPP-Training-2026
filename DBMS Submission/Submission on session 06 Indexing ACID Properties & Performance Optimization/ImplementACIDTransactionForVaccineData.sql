START TRANSACTION;

INSERT INTO covid_vaccines
(Country, Date, Vaccinated_Population)
VALUES
('India', '2021-01-15', 500000);

INSERT INTO covid_vaccines
(Country, Date, Vaccinated_Population)
VALUES
('USA', '2021-01-15', 700000);

COMMIT;

ROLLBACK;