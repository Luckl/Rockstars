package com.luckl.rockstar.domain.filter;

import com.luckl.rockstar.domain.Artist;
import com.luckl.rockstar.domain.Song;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreFilter {

    public boolean byArtistGenre(Artist artist, List<Song> songs, String genre) {
        return songs.stream()
                .filter(song -> song.getArtistName().equals(artist.getName()))
                .anyMatch(song -> song.getGenre().equals(genre));
    }
}
