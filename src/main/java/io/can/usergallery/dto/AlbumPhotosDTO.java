package io.can.usergallery.dto;

import java.io.Serializable;

public class AlbumPhotosDTO implements Serializable {

	private static final long serialVersionUID = -7211458950051207182L;

	private Long id;

	private Long albumId;

	private String title;

	private String url;

	private String thumbnailUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
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
		return "AlbumPhotosDTO [id=" + id + ", albumId=" + albumId + ", title=" + title + ", url=" + url
				+ ", thumbnailUrl=" + thumbnailUrl + "]";
	}

}
