package rsachdev95.moviesapi.model.clientmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Comment {
    @JsonProperty("user")
    private String user;

    @JsonProperty("message")
    private String message;

    @JsonProperty("date_created")
    private LocalDate dateCreated;

    @JsonProperty("like")
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
