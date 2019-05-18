package rsachdev95.moviesapi.model.storagemodel;

import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

public class CommentStorageModel {
    @Field("user")
    private String user;

    @Field("message")
    private String message;

    @Field("dateCreated")
    private LocalDate dateCreated;

    @Field("like")
    private int like;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
