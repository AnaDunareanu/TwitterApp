package Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Reacts")
public class React {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    private User userOwner;

    @ManyToOne
    private Post post;

}
