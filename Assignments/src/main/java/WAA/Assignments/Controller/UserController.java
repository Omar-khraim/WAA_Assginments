package WAA.Assignments.Controller;


import WAA.Assignments.Annotation.ExecutionTime;
import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.DTO.User.UserDTO;
import WAA.Assignments.Services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    final
    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserDTO> findAll() {
        return userService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    UserDTO findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PutMapping
    public void update(UserDTO user) {
        userService.save(user);
    }

    @PostMapping
    public void addUser(UserDTO user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDTO> userPosts(@PathVariable long id) {
        return userService.getUserPosts(id);
    }

    @GetMapping("/postcoutn/{count}")
    List<UserDTO> getUsersWithPostNum(@PathVariable int count) {
        return userService.findAllByPostsGreaterThanEqual(count);
    }
}

