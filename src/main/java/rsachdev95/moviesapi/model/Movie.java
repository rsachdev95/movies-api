package rsachdev95.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "movies")
public class Movie {
    @JsonProperty("movie_id")
    @Field("_id")
    private String id;

    @JsonProperty("title")
    @Field("title")
    private String title;

    @JsonProperty("description")
    @Field("description")
    private String description;

    @JsonProperty("producer")
    @Field("producer")
    private String producer;

    @JsonProperty("available_in_3d")
    @Field("available_in_3d")
    private boolean availableIn3d;

    @JsonProperty("age_rating")
    @Field("age_rating")
    private String ageRating;

    @JsonProperty("likes")
    @Field("likes")
    private int likes;

    @JsonProperty("comments")
    @Field("comments")
    private List<Comment> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isAvailableIn3d() {
        return availableIn3d;
    }

    public void setAvailableIn3d(boolean availableIn3d) {
        this.availableIn3d = availableIn3d;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
