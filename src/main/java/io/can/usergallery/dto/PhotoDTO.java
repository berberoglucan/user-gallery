package io.can.usergallery.dto;

import java.io.Serializable;

public class PhotoDTO implements Serializable {

	private static final long serialVersionUID = 7673384035870198194L;

	private Long id;

	private String title;

	private String url;

	private String thumbnailUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	public String toString() {
		return "PhotoDTO [id=" + id + ", title=" + title + ", url=" + url + ", thumbnailUrl=" + thumbnailUrl + "]";
	}

}
