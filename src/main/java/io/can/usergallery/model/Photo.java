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
@Table(name = "photo")
public class Photo implements Serializable {

	private static final long serialVersionUID = 2039695069461643535L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "photo_id")
	private Long id;

	private String title;

	private String url;

	private String thumbnailUrl;

	public Photo() {
		super();
	}

	public Photo(String title, String url, String thumbnailUrl) {
		super();
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}

	public Long getPhotoId() {
		return id;
	}

	public void setPhotoId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, thumbnailUrl, title, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Photo)) {
			return false;
		}
		Photo other = (Photo) obj;
		return Objects.equals(id, other.id) && Objects.equals(thumbnailUrl, other.thumbnailUrl)
				&& Objects.equals(title, other.title) && Objects.equals(url, other.url);
	}

}
