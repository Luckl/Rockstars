package com.luckl.rockstar.domain.filter;

import com.luckl.rockstar.domain.Artist;
import com.luckl.rockstar.domain.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class GenreFilterTest {
    private GenreFilter genreFilter;

    @BeforeEach
    public void setUp() {
        genreFilter = new GenreFilter();
    }

    @Test
    public void testFilterSuccessfully() {
        Artist artist = new Artist("Spinal Tap");
        Song song = new Song("(Funky) Sex Farm", 2015, "funkysexfarm", 107, 260068, "Metal", "1VfdMD8JguRISrccgLifIZ", "Back From The Dead");
        song.setArtistName(artist.getName());

        boolean isMetal = genreFilter.byArtistGenre(artist, List.of(song), "Metal");

        assertThat(isMetal).isTrue();
    }
}