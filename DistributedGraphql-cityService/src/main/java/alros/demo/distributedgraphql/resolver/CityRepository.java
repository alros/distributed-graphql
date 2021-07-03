package alros.demo.distributedgraphql.resolver;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;

@Component
//just a stub to have some data
public class CityRepository {
	private static final List<City> ALL_CITIES = Arrays.asList(city(1, "Turin", 1), city(2, "Milan", 1),
			city(3, "Rome", 1), city(4, "Athens", 2), city(5, "Ioannina", 2));

	// just a stub
	public List<City> getAllCities() {
		return ALL_CITIES;
	}

	public City getCity(String id) {
		return ALL_CITIES.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
	}

	public List<City> citiesInCountry(String countryId) {
		return ALL_CITIES.stream().filter(c -> c.getCountryId().equals(countryId)).collect(toList());
	}

	private static City city(int id, String name, int countryId) {
		City country = new City();
		country.setId(Integer.toString(id));
		country.setName(name);
		country.setCountryId(Integer.toString(countryId));
		return country;
	}

}
