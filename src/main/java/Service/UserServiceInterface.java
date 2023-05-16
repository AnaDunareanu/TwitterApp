package Service;

import DTO.UserDTO;

import java.util.*;

public interface UserServiceInterface {
    UserDTO registerUser(UserDTO userDTO);
    List<UserDTO> searchUser(String searchValue);
    String follow (String id, String followedUsername);





}
