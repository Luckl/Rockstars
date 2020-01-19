package com.luckl.rockstar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckl.rockstar.entity.Artist;
import com.luckl.rockstar.entity.Song;
import com.luckl.rockstar.entity.repository.ArtistRepository;
import com.luckl.rockstar.entity.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class RockstarsApplication {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private SongRepository songRepository;

	public static void main(String[] args) {
		SpringApplication.run(RockstarsApplication.class, args);
	}

	@PostConstruct
	private void init() throws IOException {

		Artist[] artists = objectMapper.readValue(new ClassPathResource("artists.json").getFile(), Artist[].class);
		artistRepository.saveAll(List.of(artists));

		Song[] songs = objectMapper.readValue(new ClassPathResource("songs.json").getFile(), Song[].class);
		for (Song song : songs) {
			song.setArtist(artistRepository.findByName(song.getArtistName()));
		}
		songRepository.saveAll(List.of(songs));
	}

}
