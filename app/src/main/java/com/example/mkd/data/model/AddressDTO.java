package com.example.mkd.data.model;

import java.sql.Date;


public class AddressDTO {

    private Long id;
    private String country;
    private String region;
    private String locality;
    private String street;
    private String created_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "AddressDTO{" +
				"id=" + id +
				", country='" + country + '\'' +
				", region='" + region + '\'' +
				", locality='" + locality + '\'' +
				", street='" + street + '\'' +
				", created_at='" + created_at + '\'' +
				'}';
	}

	public String toPrint() {
		return locality + ", " + street;
	}
}
