package Repository;

import Model.Post;
import Model.React;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactRepo extends JpaRepository<React, String> {
    List<React> findByPost(Post post);
}
