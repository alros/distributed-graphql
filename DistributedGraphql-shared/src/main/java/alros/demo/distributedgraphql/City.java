package alros.demo.distributedgraphql;

public class City {

	private String id;
	private String name;
	private String countryId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryId=" + countryId + "]";
	}

}
