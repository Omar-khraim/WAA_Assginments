package WAA.Assignments.DTO.User;

import WAA.Assignments.Domain.Post;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
