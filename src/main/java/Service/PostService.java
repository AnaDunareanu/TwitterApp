package Service;

import DTO.PostDTO;
import DTO.UserDTO;
import Exceptions.UserNotFound;
import Model.Post;
import Model.User;
import Repository.PostRepo;
import Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService implements PostServiceInterface{

    private final PostRepo postRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final UserRepo userRepository;

    @Override
    public void addPost(PostDTO postDTO)
    {
        Post post = modelMapper.map(postDTO, Post.class);
        post.setDate(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> getOwnPosts(String userID)
    {
        List<Post> currentUserPosts = postRepository.findByUserId(userID);
        return  currentUserPosts.stream()
                .map(p -> modelMapper.map(p, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getFeed (String userId)
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("User not found"));
        List<User> followedUsers = user.getFollowing();
        List <Post> followedPosts = followedUsers.stream()
                .flatMap(p -> p.getPosts().stream())
                .sorted(Comparator.comparing(Post::getDate).reversed())
                .collect(Collectors.toList());
        return followedPosts.stream()
                .map(p -> modelMapper.map(p,PostDTO.class))
                .collect(Collectors.toList());
    }




}
