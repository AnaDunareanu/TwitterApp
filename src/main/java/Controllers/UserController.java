package Controllers;

import DTO.PostDTO;
import DTO.UserDTO;
import Service.PostService;
import Service.UserService;
import Service.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    private PostService postService;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO registerUser(@RequestBody UserDTO user)
    {
        return userService.registerUser(user);
    }

    @GetMapping (value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> search(@RequestParam String searchValue)
    {
        return userService.searchUser(searchValue);
    }

    @PostMapping (value = "/{id}/follow", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void follow(@PathVariable String id, @RequestBody UserDTO userDTO)
    {
        String followedUser = userDTO.getUsername();
        userService.follow(id, followedUser);
    }

    @PostMapping (value = "/addPost", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addPost(@RequestBody PostDTO postDTO)
    {
        postService.addPost(postDTO);
        return "Post added successfully!";
    }

    @GetMapping (value = "/getOwnPosts/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<PostDTO> getOwnPosts (@PathVariable String userId)
    {
        return postService.getOwnPosts(userId);
    }

    @GetMapping (value = "/getFeed/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<PostDTO> getFeed (@PathVariable String userId)
    {
        return postService.getFeed(userId);
    }

    @PostMapping (value = "/addReact/{postId}/{userid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addReactToPost(@PathVariable String postId, @PathVariable String userid)
    {
        postService.addReactToPost(postId, userid);
        return "You reacted to this post";
    }

}
