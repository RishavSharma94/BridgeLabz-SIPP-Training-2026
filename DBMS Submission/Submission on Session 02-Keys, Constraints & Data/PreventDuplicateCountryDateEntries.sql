ALTER TABLE covid_cases
ADD CONSTRAINT unique_country_date
UNIQUE (Country, Date);