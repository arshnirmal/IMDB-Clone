package dev.arshnirmal.imdb_clone.services;

import dev.arshnirmal.imdb_clone.models.Movie;
import dev.arshnirmal.imdb_clone.models.Review;
import dev.arshnirmal.imdb_clone.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String imdbId, String reviewBody){
        Review review = reviewRepository.insert(new Review(reviewBody));

//        mongoTemplate.update(Movie.class)
//                .matching(query(where("imdbId").is(imdbId)))
//                .apply(new Update().push("reviewIds", review))
//                .first();
        mongoTemplate.updateFirst(
                query(where("imdbId").is(imdbId)),
                new Update().push("reviewIds", review),
                Movie.class
        );

        return review;
    }
}
