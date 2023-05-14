package Controllers;

import DTO.UserDTO;
import Model.User;
import Service.UserService;
import Service.UserServiceInterface;
import lombok.AllArgsConstructor;
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


}
