package WAA.Assignments.Services;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.DTO.User.UserDTO;
import WAA.Assignments.Domain.Users;

import java.util.List;

public interface UserService {


    List<UserDTO> findAll();

    UserDTO findById(Long aLong);

    void deleteById(Long aLong);

    void save(UserDTO user);

    List<PostDTO> getUserPosts(long id);

    List<UserDTO> findAllByPostsGreaterThanEqual(int count);

}
