package alros.demo.distributedgraphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import alros.demo.distributedgraphql.Country;
import alros.demo.distributedgraphql.service.CityService;
import alros.demo.distributedgraphql.service.CountryService;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private CountryService countryService;

	@Autowired
	private CityService cityService;

	public List<Country> allCountries() {
		return countryService.getAllCountries();
	}

	public List<City> allCities() {
		return cityService.getAllCities();
	}

	public Country country(String id) {
		return countryService.getCountry(id);
	}

	public City city(String id) {
		return cityService.getCity(id);
	}
}
