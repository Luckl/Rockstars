package com.luckl.rockstar.service;

import com.luckl.rockstar.domain.Artist;
import com.luckl.rockstar.domain.Song;
import com.luckl.rockstar.domain.filter.GenreFilter;
import com.luckl.rockstar.domain.repository.ArtistRepository;
import com.luckl.rockstar.domain.repository.SongRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OldMetalFilterServiceTest {

    private OldMetalFilterService oldMetalFilterService;

    @Mock
    private GenreFilter genreFilterMock;
    @Mock
    private ArtistRepository artistRepositoryMock;
    @Mock
    private SongRepository songRepositoryMock;

    @BeforeEach
    void setUp() {
        this.oldMetalFilterService = new OldMetalFilterService(genreFilterMock,artistRepositoryMock, songRepositoryMock);
    }

    @Test
    public void testFilterWorksSuccessfully() {
        Artist artist = new Artist("Spinal Tap");
        Song song = new Song("(Funky) Sex Farm", 2015, "funkysexfarm", 107, 260068, "Metal", "1VfdMD8JguRISrccgLifIZ", "Back From The Dead");
        song.setArtistName(artist.getName());

        when(genreFilterMock.byArtistGenre(artist, List.of(song), "Metal")).thenReturn(true);

        oldMetalFilterService.filterAndSave(List.of(artist), List.of(song));

        verify(artistRepositoryMock).saveAll(List.of(artist));
        verify(songRepositoryMock).saveAll(List.of(song));
    }

    @Test
    public void testFilterUsesResponseFromGenreFilterToFilter() {
        Artist artist = new Artist("Spinal Tap");
        Song song = new Song("(Funky) Sex Farm", 2015, "funkysexfarm", 107, 260068, "Metal", "1VfdMD8JguRISrccgLifIZ", "Back From The Dead");
        song.setArtistName(artist.getName());

        when(genreFilterMock.byArtistGenre(artist, List.of(song), "Metal")).thenReturn(false);

        oldMetalFilterService.filterAndSave(List.of(artist), List.of(song));

        verify(artistRepositoryMock).saveAll(Collections.emptyList());
        verify(songRepositoryMock).saveAll(List.of(song));
    }

    @Test
    public void testFilterUsesTheFilteredSongsListAndNotTheOriginal() {
        Artist artist = new Artist("Spinal Tap");
        Song song = new Song("(Funky) Sex Farm", 2016, "funkysexfarm", 107, 260068, "Metal", "1VfdMD8JguRISrccgLifIZ", "Back From The Dead");
        song.setArtistName(artist.getName());

        when(genreFilterMock.byArtistGenre(artist, Collections.emptyList(), "Metal")).thenReturn(false);

        oldMetalFilterService.filterAndSave(List.of(artist), List.of(song));

        verify(genreFilterMock).byArtistGenre(artist, Collections.emptyList(), "Metal");
        verify(artistRepositoryMock).saveAll(Collections.emptyList());
        verify(songRepositoryMock).saveAll(Collections.emptyList());
    }


//    TODO: Check requirements on filtering whether artist == metal
//    @Test
//    public void testFilterUsesTheOriginalSongListAndNotFiltered() {
//        Artist artist = new Artist("Spinal Tap");
//        Song song = new Song("(Funky) Sex Farm", 2016, "funkysexfarm", 107, 260068, "Metal", "1VfdMD8JguRISrccgLifIZ", "Back From The Dead");
//        song.setArtistName(artist.getName());
//
//        when(genreFilterMock.byArtistGenre(artist, Collections.emptyList(), "Metal")).thenReturn(false);
//
//        oldMetalFilterService.filterAndSave(List.of(artist), List.of(song));
//
//        verify(genreFilterMock).byArtistGenre(artist, List.of(song), "Metal");
//        verify(artistRepositoryMock).saveAll(Collections.emptyList());
//        verify(songRepositoryMock).saveAll(Collections.emptyList());
//    }

}