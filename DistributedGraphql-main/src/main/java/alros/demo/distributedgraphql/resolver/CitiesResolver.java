package alros.demo.distributedgraphql.resolver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import alros.demo.distributedgraphql.Country;
import alros.demo.distributedgraphql.service.CityService;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class CitiesResolver implements GraphQLResolver<Country> {

	private static final Logger LOG = LoggerFactory.getLogger(CitiesResolver.class);

	@Autowired
	private CityService cityService;

	public List<City> cities(Country country) {
		LOG.info("cities {}", country);
		return cityService.getCitiesInCountry(country.getId());
	}
}
