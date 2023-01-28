package WAA.Assignments.DTO.User;

import WAA.Assignments.Domain.Post;
import WAA.Assignments.Domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Post> posts;
    private List<Role> userRoles;
}
