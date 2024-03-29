package io.can.usergallery.dto;

import java.io.Serializable;

public class AlbumDTO implements Serializable {

	private static final long serialVersionUID = -3908771971897627710L;

	private Long id;

	private Long userId;

	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "AlbumDTO [id=" + id + ", userId=" + userId + ", title=" + title + "]";
	}

}
