package WAA.Assignments.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    long id ;
    String title;
    String content;
    String author;

//  public Post(long id , String title, String content, String author  ){
//        this.id = id;
//        this.content =  content;
//        this.title = title;
//        this.author = author;
//    }
}
