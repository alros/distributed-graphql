package alros.demo.distributedgraphql.resolver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import alros.demo.distributedgraphql.Country;
import alros.demo.distributedgraphql.service.CityService;
import alros.demo.distributedgraphql.service.CountryService;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	private static final Logger LOG = LoggerFactory.getLogger(Query.class);

	@Autowired
	private CountryService countryService;

	@Autowired
	private CityService cityService;

	public List<Country> allCountries() {
		LOG.info("allCountries");
		return countryService.getAllCountries();
	}

	public List<City> allCities() {
		LOG.info("allCities");
		return cityService.getAllCities();
	}

	public Country country(String id) {
		LOG.info("country {}", id);
		return countryService.getCountry(id);
	}

	public City city(String id) {
		LOG.info("city {}", id);
		return cityService.getCity(id);
	}
}
