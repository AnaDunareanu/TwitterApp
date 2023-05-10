package Model;

import java.util.*;

public class User {
    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<User> followers;

    private List<User> following;

    private List<Post> posts;

    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowers() { return followers; }

    public void setFollowers( List<User> followers ) {this.followers = followers; }

    public List<User> getFollowing() { return following; }

    public void setFollowing( List<User> following ) {this.following = following; }

    public List<Post> getPosts() { return posts; }

    public void setPosts( List<Post> posts ) {this.posts = posts; }


    @Override
    public String toString() {
        return "User{" +
                "id=" + username +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
