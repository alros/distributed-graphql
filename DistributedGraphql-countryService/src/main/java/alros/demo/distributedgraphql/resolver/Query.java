package alros.demo.distributedgraphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.Country;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> allCountries() {
		return countryRepository.getAllCountries();
	}

	public Country country(String id) {
		return countryRepository.getCountry(id);
	}
	
}
