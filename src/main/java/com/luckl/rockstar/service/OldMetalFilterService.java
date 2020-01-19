package com.luckl.rockstar.service;

import com.luckl.rockstar.domain.Artist;
import com.luckl.rockstar.domain.Song;
import com.luckl.rockstar.domain.filter.GenreFilter;
import com.luckl.rockstar.domain.repository.ArtistRepository;
import com.luckl.rockstar.domain.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OldMetalFilterService {

    private static final String METAL = "Metal";
    private static final int YEAR = 2016;

    private GenreFilter filter;
    private ArtistRepository artistRepository;
    private SongRepository songRepository;

    @Autowired
    public OldMetalFilterService(GenreFilter filter, ArtistRepository artistRepository, SongRepository songRepository) {
        this.filter = filter;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    public void filterAndSave(List<Artist> artistList, List<Song> songList) {

        // Filter artists by whether they play metal
        List<Artist> metalArtists = artistList.stream()
                .filter(artist -> filter.byArtistGenre(artist, songList, METAL))
                .collect(Collectors.toList());
        artistRepository.saveAll(metalArtists);

        // Filter songs on whether they were released before 2016
        List<Song> metalClassics = songList.stream()
                .filter(song -> song.getYear() < YEAR)
                .filter(song -> getArtist(song).isPresent())
                .peek(song -> song.setArtist(getArtist(song).get()))
                .collect(Collectors.toList());

        songRepository.saveAll(metalClassics);
    }

    private Optional<Artist> getArtist(Song song) {
        return artistRepository.findAll().stream()
                .filter(artist -> artist.getName().equals(song.getArtistName()))
                .findFirst();
                //TODO: Do we need to create new artists if none matching are found?

    }
}
