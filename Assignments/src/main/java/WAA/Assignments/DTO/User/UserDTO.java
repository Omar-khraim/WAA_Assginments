package WAA.Assignments.DTO.User;

import WAA.Assignments.Domain.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {

    long id;
    String name;
    List<Post> posts;
}
