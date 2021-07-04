package alros.demo.distributedgraphql.resolver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	private static final Logger LOG = LoggerFactory.getLogger(Query.class);

	@Autowired
	private CityRepository countryRepository;

	public List<City> allCities() {
		LOG.info("allCities");
		return countryRepository.getAllCities();
	}

	public City city(String id) {
		LOG.info("city {}", id);
		return countryRepository.getCity(id);
	}

	public List<City> citiesInCountry(String countryId) {
		LOG.info("citiesInCountry {}", countryId);
		return countryRepository.citiesInCountry(countryId);
	}

}
