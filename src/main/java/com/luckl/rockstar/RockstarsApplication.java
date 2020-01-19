package com.luckl.rockstar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckl.rockstar.domain.Artist;
import com.luckl.rockstar.domain.Song;
import com.luckl.rockstar.service.OldMetalFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class RockstarsApplication {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private OldMetalFilterService oldMetalFilterService;

	public static void main(String[] args) {
		SpringApplication.run(RockstarsApplication.class, args);
	}

	@PostConstruct
	private void init() throws IOException {

		// Read resources to arrays
		Artist[] artists = objectMapper.readValue(new ClassPathResource("artists.json").getFile(), Artist[].class);
		Song[] songs = objectMapper.readValue(new ClassPathResource("songs.json").getFile(), Song[].class);

		List<Artist> artistList = List.of(artists);
		List<Song> songList = List.of(songs);

		oldMetalFilterService.filterAndSave(artistList, songList);
	}
}
