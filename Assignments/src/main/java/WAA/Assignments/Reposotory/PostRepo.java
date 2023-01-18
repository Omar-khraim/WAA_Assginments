package WAA.Assignments.Reposotory;

import WAA.Assignments.Domain.Post;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();
    Post findById(long id);

    void addPost(Post post);
    void delete(long id);
    void update(long id ,  Post post);
}
