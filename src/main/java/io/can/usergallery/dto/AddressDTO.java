package io.can.usergallery.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = -3679162947029502850L;

	private String street;

	private String suite;

	private String city;

	private String zipCode;

	private GeoDTO geo;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public GeoDTO getGeo() {
		return geo;
	}

	public void setGeo(GeoDTO geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "AddressDTO [street=" + street + ", suite=" + suite + ", city=" + city + ", zipCode=" + zipCode
				+ ", geo=" + geo + "]";
	}

}
