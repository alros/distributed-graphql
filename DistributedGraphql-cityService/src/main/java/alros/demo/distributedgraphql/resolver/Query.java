package alros.demo.distributedgraphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private CityRepository countryRepository;

	public List<City> allCities() {
		return countryRepository.getAllCities();
	}
	
	public City city(String id) {
		return countryRepository.getCity(id);
	}
	
	public List<City> citiesInCountry(String countryId){
		return countryRepository.citiesInCountry(countryId);
	}

}
