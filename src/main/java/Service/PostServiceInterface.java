package Service;

import DTO.PostDTO;
import DTO.UserDTO;

import java.util.List;

public interface PostServiceInterface {
    void addPost(PostDTO postDTO);
    List<PostDTO> getOwnPosts (String userdId);
    List<PostDTO> getFeed (String userId);
}
