
drop  view countryview;
create view countryview as select country.code , country.name, country.continent,
                                  country.region, country_language.language, country.life_expectancy
from country
left join country_language  on country.code = country_language.country_code;