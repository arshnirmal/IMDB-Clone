package dev.arshnirmal.imdb_clone.controllers;

import dev.arshnirmal.imdb_clone.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
}
