package io.can.usergallery.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album implements Serializable{

	private static final long serialVersionUID = 2930253238331503973L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_id")
	private Long id;
	
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
	private List<Photo> photos = new ArrayList<>();


	public Long getAlbumId() {
		return id;
	}


	public void setAlbumId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Photo> getPhotos() {
		return photos;
	}


	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, title, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Album)) {
			return false;
		}
		Album other = (Album) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title)
				&& Objects.equals(user, other.user);
	}

	
}
