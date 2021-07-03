package alros.demo.distributedgraphql.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.Country;
import alros.demo.distributedgraphql.apollo.client.countryService.GetAllCountriesQuery;
import alros.demo.distributedgraphql.apollo.client.countryService.GetCountryQuery;
import alros.demo.distributedgraphql.apollo.client.countryService.fragment.CountryFragment;

@Component
public class CountryService extends BaseService {

	private final static String serverUrl = "http://localhost:8090/graphql";

	public CountryService() {
		super(serverUrl);
	}

	public List<Country> getAllCountries() {
		RemoteServerCallback<GetAllCountriesQuery.Data, List<Country>> callback = new RemoteServerCallback<>(
				data -> data.allCountries().stream().map(d -> d.fragments().countryFragment()).map(CountryService::map)
						.collect(toList()));

		GetAllCountriesQuery query = new GetAllCountriesQuery();

		return performQuery(callback, query);
	}

	public Country getCountry(String countryId) {
		RemoteServerCallback<GetCountryQuery.Data, Country> callback = new RemoteServerCallback<>(
				data -> map(data.country().fragments().countryFragment()));

		GetCountryQuery query = new GetCountryQuery(countryId);

		return performQuery(callback, query);

	}

	private static Country map(CountryFragment data) {
		Country country = new Country();
		country.setId(data.id());
		country.setName(data.name());
		return country;
	}

}
