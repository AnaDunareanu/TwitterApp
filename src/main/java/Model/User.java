package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table (name = "Users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String id;

    @Column (name = "Username")
    private String username;

    @Column (name = "Username")
    private String firstName;

    @Column (name = "Last Name")
    private String lastName;

    @Column (name = "Email")
    private String email;

    @Column (name = "Password")
    private String password;

    @OneToMany
    private List<User> followers;

    @OneToMany
    private List<User> following;

    @OneToMany
    private List<Post> posts;

    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
