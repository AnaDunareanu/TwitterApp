package Repository;

import Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, String> {
    List<Post> findByUserId(String userId);
}
