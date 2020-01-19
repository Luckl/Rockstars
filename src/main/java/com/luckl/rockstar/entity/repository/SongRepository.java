package com.luckl.rockstar.entity.repository;

import com.luckl.rockstar.entity.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "songs", path= "songs")
public interface SongRepository extends CrudRepository<Song, Integer> {
}
