package Service;

import DTO.PostDTO;
import DTO.UserDTO;
import Exceptions.PostNotFound;
import Exceptions.UserNotFound;
import Model.Post;
import Model.React;
import Model.Reply;
import Model.User;
import Repository.PostRepo;
import Repository.ReactRepo;
import Repository.ReplyRepo;
import Repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService implements PostServiceInterface{

    private final PostRepo postRepository;
    private final ModelMapper modelMapper;
    private final UserRepo userRepository;
    private final ReactRepo reactRepository;
    private final ReplyRepo replyRepository;

    @Override
    public void addPost(PostDTO postDTO)
    {
        Post post = modelMapper.map(postDTO, Post.class);
        post.setDate(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> getOwnPosts(String userId)
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("User not found"));
        List<Post> posts = user.getPosts();

        List<PostDTO> postDTOs = new ArrayList<>();

        for (Post post : posts) {
            List<React> reacts = reactRepository.findByPost(post);

            List<UserDTO> reactUsers = reacts.stream()
                    .map(r -> modelMapper.map(r.getUserOwner(), UserDTO.class))
                    .collect(Collectors.toList());

            PostDTO postDTO = modelMapper.map(post, PostDTO.class);
            postDTO.setUserReacts(reactUsers);

            postDTOs.add(postDTO);
        }

        return postDTOs;
    }

    @Override
    public List<PostDTO> getFeed (String userId)
    {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("User not found"));
        List<User> followedUsers = user.getFollowing();

        List<PostDTO> feedPosts = new ArrayList<>();

        for (User fUser : followedUsers) {
            List<Post> userPosts = fUser.getPosts();

            for (Post post : userPosts) {
                List<React> reacts = reactRepository.findByPost(post);

                List<UserDTO> reactUsers = reacts.stream()
                        .map(r -> modelMapper.map(r.getUserOwner(), UserDTO.class))
                        .collect(Collectors.toList());

                PostDTO postDTO = modelMapper.map(post, PostDTO.class);
                postDTO.setUserReacts(reactUsers);
                feedPosts.add(postDTO);
            }
        }

        return feedPosts;
    }

    @Override
    public void addReactToPost(String postId, String userId)
    {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFound("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("User not found"));
        React react = new React();
        react.setUserOwner(user);
        react.setPost(post);
        reactRepository.save(react);
    }

    @Override
    public void addReplyToPost(String postId, String userId, String message)
    {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFound("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("User not found"));
        Reply reply = new Reply();
        reply.setMessage(message);
        reply.setPost(post);
        reply.setUser(user);
        replyRepository.save(reply);
    }
}
