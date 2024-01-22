package dev.arshnirmal.imdb_clone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId _id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerUrl;
    private String posterUrl;
    private List<String> genres;
    private List<String> bannerUrls;
    @DocumentReference
    private List<Review> reviewIds;
}
