package Repository;

import Model.Post;
import Model.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactRepo extends JpaRepository<React, String> {
    List<React> findByPost(Post post);
}
