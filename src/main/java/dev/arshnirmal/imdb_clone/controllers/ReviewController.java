package dev.arshnirmal.imdb_clone.controllers;

import dev.arshnirmal.imdb_clone.models.Review;
import dev.arshnirmal.imdb_clone.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/movies")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(
                reviewService.createReview(payload.get("imdbId"), payload.get("reviewBody")),
                HttpStatus.CREATED
        );
    }

}
