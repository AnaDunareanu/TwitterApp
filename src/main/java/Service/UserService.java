package Service;

import DTO.UserDTO;
import Exceptions.UserNotFound;
import Model.User;
import Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

   /* public List<User> usersList = Arrays.asList(
            new User("marinastamos21","Marina", "Stamos", "stamarina21","maripossa21"),
            new User("Jose_Siccolo17", "Jose", "Siccolo", "josesicco17", "signorina_2705"));*/

    private final UserRepo userRepository;
    private final ModelMapper modelMapper;


    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User registeredUser = userRepository.save(user);
        return modelMapper.map(registeredUser, UserDTO.class);
    }

    @Override
    public List<UserDTO> searchUser(String searchValue) {
      List<User> users = userRepository.findByUsernameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(searchValue,searchValue,searchValue);
      return users.stream()
              .map(u -> modelMapper.map(u,UserDTO.class))
              .collect(Collectors.toList());
    }

    @Override
    public String follow(String id, String followedUsername) {
       User OriginalUser = userRepository.findById(String.valueOf(id)).orElseThrow(() -> new UserNotFound("User not found"));
       User followedUser = userRepository.findById(followedUsername).orElseThrow(() -> new UserNotFound("User not found"));
       OriginalUser.getFollowing().add(followedUser);
       userRepository.save(OriginalUser);
        return "You followed" + followedUser.getUsername();

    }
}
