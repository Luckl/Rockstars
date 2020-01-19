package com.luckl.rockstar.domain.repository;

import com.luckl.rockstar.domain.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "songs", path= "songs")
public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {
}
