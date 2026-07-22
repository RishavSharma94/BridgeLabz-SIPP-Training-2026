ALTER TABLE covid_cases
MODIFY Country VARCHAR(50) NOT NULL,
MODIFY Date DATE NOT NULL,
MODIFY Confirmed_Cases INT NOT NULL;

ALTER TABLE covid_cases
ADD CONSTRAINT chk_deaths
CHECK (Deaths <= Confirmed_Cases);