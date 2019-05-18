package rsachdev95.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

public class Comment {
    @JsonProperty("user")
    @Field("user")
    private String user;

    @JsonProperty("message")
    @Field("message")
    private String message;

    @JsonProperty("date_created")
    @Field("dateCreated")
    private long dateCreated;

    @JsonProperty("like")
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

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
