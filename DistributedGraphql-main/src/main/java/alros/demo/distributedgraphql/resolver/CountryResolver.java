package alros.demo.distributedgraphql.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import alros.demo.distributedgraphql.Country;
import alros.demo.distributedgraphql.service.CountryService;
import graphql.kickstart.tools.GraphQLResolver;

@Component
public class CountryResolver implements GraphQLResolver<City> {

	private static final Logger LOG = LoggerFactory.getLogger(CountryResolver.class);

	@Autowired
	private CountryService countryService;

	public Country country(City city) {
		LOG.info("country {}", city);
		return countryService.getCountry(city.getCountryId());
	}
}
