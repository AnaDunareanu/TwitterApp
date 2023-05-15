package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Replies")
public class Reply {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    @Column (name = "ReplyContent")
    private String message;

}
