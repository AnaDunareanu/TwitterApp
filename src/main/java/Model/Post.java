package Model;

import java.time.LocalDate;
import java.util.*;

public class Post {

    private String id;
    private User userOwner;
    private LocalDate date;
    private List<React> react;
    private String postInfo;

    public Post (String id, User userOwner, LocalDate date, List<React> react, String postInfo)
    {
        this.id = id;
        this.userOwner = userOwner;
        this.date = date;
        this.react = react;
        this.postInfo = postInfo;
    }

    public String getUserOwnerId() {return id; }

    public void setUserOwnerId(String id) { this.id = id; }

    public LocalDate getDate() {return date; }

    public void setLocalDate(LocalDate date) { this.date = date; }

    public User getUserOwner() {return userOwner; }

    public void setUserOwner(User userOwner) { this.userOwner = userOwner; }

    public List<React> getReactions() {return  react; }

    public void setReaction(List<React> react) { this.react = react; }

    public String getPostInfo() {return postInfo; }

    public void setPostInfo(String id) { this.postInfo = postInfo; }



}
