package alros.demo.distributedgraphql.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import alros.demo.distributedgraphql.City;
import alros.demo.distributedgraphql.apollo.client.cityService.GetAllCitiesQuery;
import alros.demo.distributedgraphql.apollo.client.cityService.GetCitiesInCountryQuery;
import alros.demo.distributedgraphql.apollo.client.cityService.GetCityQuery;
import alros.demo.distributedgraphql.apollo.client.cityService.fragment.CityFragment;

@Component
public class CityService extends BaseService {

	private final static String serverUrl = "http://localhost:8091/graphql";

	public CityService() {
		super(serverUrl);
	}

	public List<City> getAllCities() {
		RemoteServerCallback<GetAllCitiesQuery.Data, List<City>> callback = new RemoteServerCallback<>(data -> data
				.allCities().stream().map(d -> d.fragments().cityFragment()).map(CityService::map).collect(toList()));
		return performQuery(callback, new GetAllCitiesQuery());

	}

	public City getCity(String id) {
		RemoteServerCallback<GetCityQuery.Data, City> callback = new RemoteServerCallback<>(
				data -> map(data.city().fragments().cityFragment()));
		return performQuery(callback, new GetCityQuery(id));
	}

	public List<City> getCitiesInCountry(String countryId) {
		RemoteServerCallback<GetCitiesInCountryQuery.Data, List<City>> callback = new RemoteServerCallback<>(
				data -> data.citiesInCountry().stream().map(d -> d.fragments().cityFragment()).map(CityService::map)
						.collect(toList()));
		return performQuery(callback, new GetCitiesInCountryQuery(countryId));
	}

	private static City map(CityFragment data) {
		City country = new City();
		country.setId(data.id());
		country.setName(data.name());
		country.setCountryId(data.countryId());
		return country;
	}

}
