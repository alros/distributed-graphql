package alros.demo.distributedgraphql.resolver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.Country;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	private static final Logger LOG = LoggerFactory.getLogger(Query.class);

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> allCountries() {
		LOG.info("allCountries");
		return countryRepository.getAllCountries();
	}

	public Country country(String id) {
		LOG.info("country {}", id);
		return countryRepository.getCountry(id);
	}

}
