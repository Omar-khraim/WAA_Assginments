package WAA.Assignments.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostDTO {
    long id ;
    String title;
    String content;
    String author;
}
