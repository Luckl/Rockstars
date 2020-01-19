package com.luckl.rockstar.entity.repository;

import com.luckl.rockstar.entity.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artists", path= "artists")
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
}
