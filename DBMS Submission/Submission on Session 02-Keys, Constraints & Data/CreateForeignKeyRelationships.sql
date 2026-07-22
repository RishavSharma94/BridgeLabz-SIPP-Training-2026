CREATE TABLE countries (
    Country VARCHAR(50) PRIMARY KEY,
    Population BIGINT
);

ALTER TABLE covid_cases
ADD CONSTRAINT fk_country
FOREIGN KEY (Country)
REFERENCES countries(Country);