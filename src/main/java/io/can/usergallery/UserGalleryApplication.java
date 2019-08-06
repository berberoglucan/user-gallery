package io.can.usergallery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.can.usergallery.dto.AlbumDTO;
import io.can.usergallery.dto.AlbumPhotosDTO;
import io.can.usergallery.dto.UserDTO;
import io.can.usergallery.model.Address;
import io.can.usergallery.model.Album;
import io.can.usergallery.model.Company;
import io.can.usergallery.model.Geo;
import io.can.usergallery.model.Photo;
import io.can.usergallery.model.User;
import io.can.usergallery.repository.AlbumRepository;
import io.can.usergallery.repository.PhotoRepository;
import io.can.usergallery.repository.UserRepository;
import io.can.usergallery.util.BootstrapDataUtil;

@SpringBootApplication
@EnableJpaRepositories
public class UserGalleryApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private BootstrapDataUtil bootstrapDataUtil;

	public static void main(String[] args) {
		SpringApplication.run(UserGalleryApplication.class, args);
	}

	/**
	 * This method was created to save sample data to the database.
	 */
	@Override
	public void run(String... args) throws Exception {

		// manual bootstrap to db for users
		Address address1 = new Address("512.Sk", "No:88", "Istanbul", "34200", new Geo("-37.3159", "81.1496"));
		Company company1 = new Company("Romaguera-Crona", "Multi-layered client-server neural-net",
				"harness real-time e-markets");
		User user1 = new User("Can Berberoglu", "canberberoglu", "can.berberoglu@gmail.com", address1, "1234568",
				"canberberoglu.com", company1);

		Address address2 = new Address("512.Sk", "No:88", "Istanbul", "34200", new Geo("-37.3159", "81.1496"));
		Company company2 = new Company("Deckow-Crist", "Proactive didactic contingency",
				"synergize scalable supply-chains");
		User user2 = new User("Cem Berberoglu", "berberoglucem", "cem.berberoglu@berberoglu.biz", address2, "1234568",
				"cemberberoglu.com", company2);

		userRepository.save(user1);
		userRepository.save(user2);

		// dynamic bootstrap to db for users
		List<User> userListToSave = bootstrapDataUtil.fetchDatasWithHttpGetMethodGivenUrlForBootstrapDb(
				"https://jsonplaceholder.typicode.com/users", UserDTO.class, User.class);
		userRepository.saveAll(userListToSave);

		// dymamic bootstrap to db for single value
		Optional<User> optionalUser = bootstrapDataUtil.fetchSingleDataWithHttpGetMethodGivenUrlForBootstrapDb(
				"https://jsonplaceholder.typicode.com/users/1", UserDTO.class, User.class);
		optionalUser.ifPresent(user -> userRepository.save(user));
		
		// bootstrap to db for albums
		List<Album> albums = bootstrapDataUtil.fetchDatasWithHttpGetMethodGivenUrlForBootstrapDb("https://jsonplaceholder.typicode.com/albums", AlbumDTO.class, Album.class);
		albumRepository.saveAll(albums);
		
		// bootstrap to db for photos
		List<Photo> photos = bootstrapDataUtil.fetchDatasWithHttpGetMethodGivenUrlForBootstrapDb("https://jsonplaceholder.typicode.com/photos", AlbumPhotosDTO.class, Photo.class);
		
		photoRepository.saveAll(photos);
		
	}

}
