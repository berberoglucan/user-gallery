package io.can.usergallery.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geo")
public class Geo implements Serializable {

	private static final long serialVersionUID = -5500052882247294968L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "geo_id")
	private Long geoId;

	private String lat;

	private String lng;

	public Geo() {
		super();
	}

	public Geo(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public Long getGeoId() {
		return geoId;
	}

	public void setGeoId(Long geoId) {
		this.geoId = geoId;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public int hashCode() {
		return Objects.hash(geoId, lat, lng);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Geo)) {
			return false;
		}
		Geo other = (Geo) obj;
		return Objects.equals(geoId, other.geoId) && Objects.equals(lat, other.lat) && Objects.equals(lng, other.lng);
	}

	@Override
	public String toString() {
		return "Geo [geoId=" + geoId + ", lat=" + lat + ", lng=" + lng + "]";
	}

}
