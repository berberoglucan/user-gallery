package io.can.usergallery.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = -3811843380796923273L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	@JsonIgnore
	private Long addressId;

	private String street;

	private String suite;

	private String city;

	@Column(name = "zip_code")
	private String zipCode;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "geo_id")
	private Geo geo;

	public Address() {
		super();
	}

	public Address(String street, String suite, String city, String zipCode, Geo geo) {
		super();
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipCode = zipCode;
		this.geo = geo;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

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

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, city, geo, street, suite, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(city, other.city)
				&& Objects.equals(geo, other.geo) && Objects.equals(street, other.street)
				&& Objects.equals(suite, other.suite) && Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", suite=" + suite + ", city=" + city
				+ ", zipCode=" + zipCode + ", geo=" + geo + "]";
	}

}
