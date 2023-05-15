package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import jakarta.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    private User userOwner;

    @Column (name = "PostDate")
    private LocalDateTime date;

    @OneToMany (mappedBy = "post")
    private List<React> react;

    @Column (name = "PostTitle")
    private String title;

    @Column (name = "PostContent")
    private String postInfo;

}
