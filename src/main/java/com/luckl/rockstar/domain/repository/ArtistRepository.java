package com.luckl.rockstar.domain.repository;

import com.luckl.rockstar.domain.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "artists", path= "artists")
public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {

    Artist findByName(String name);

    @Query("SELECT a FROM Artist a, IN(a.songs) s WHERE s.genre=:genre")
    List<Artist> findArtistsBySongGenre(@Param("genre") String genre);
}