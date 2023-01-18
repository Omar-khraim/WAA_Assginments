package WAA.Assignments.Services;

import WAA.Assignments.DTO.PostDTO;
import WAA.Assignments.Domain.Post;

import java.util.List;

public interface PostService {
    public List<PostDTO> findAll();
    public PostDTO findById(long id);
    void addPost(Post post);

    void delete(long id);

    void update(long id ,  PostDTO post);

}
