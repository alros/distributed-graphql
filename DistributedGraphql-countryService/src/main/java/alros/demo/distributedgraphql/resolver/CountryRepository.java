package alros.demo.distributedgraphql.resolver;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.Country;

@Component
// just a stub to have some data
public class CountryRepository {

	private static final List<Country> ALL_COUNTRIES = Arrays.asList(country(1, "Italy"), country(2, "Greece"));

	public List<Country> getAllCountries() {
		return ALL_COUNTRIES;
	}

	public Country getCountry(String id) {
		return ALL_COUNTRIES.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
	}

	private static Country country(int id, String name) {
		Country country = new Country();
		country.setId(Integer.toString(id));
		country.setName(name);
		return country;
	}

}
