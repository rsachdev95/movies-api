package rsachdev95.moviesapi.model.storagemodel;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection="movies")
public class MovieStorageModel {
    @Field("movie_id")
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("producer")
    private String producer;

    @Field("available_in_3d")
    private boolean availableIn3d;

    @Field("age_rating")
    private String ageRating;

    @Field("likes")
    private int likes;

    @Field("comments")
    private List<CommentStorageModel> comments;

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

    public List<CommentStorageModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentStorageModel> comments) {
        this.comments = comments;
    }
}
