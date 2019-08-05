package io.can.usergallery.dto;

import java.io.Serializable;

public class GeoDTO implements Serializable {

	private static final long serialVersionUID = -4785437270506483084L;

	private String lat;

	private String lng;

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
	public String toString() {
		return "GeoDTO [lat=" + lat + ", lng=" + lng + "]";
	}

}
