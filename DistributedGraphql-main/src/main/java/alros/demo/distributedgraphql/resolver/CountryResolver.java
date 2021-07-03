package alros.demo.distributedgraphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import alros.demo.distributedgraphql.Country;
import alros.demo.distributedgraphql.service.CountryService;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class CountryResolver implements GraphQLResolver<City> {

	@Autowired
	private CountryService countryService;
	
	public Country country(City city) {
		return countryService.getCountry(city.getCountryId());
	}
}
