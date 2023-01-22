package WAA.Assignments.Services;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.Domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<PostDTO> findAll();

    public PostDTO findById(long id);

    void addPost(Post post);

    void delete(long id);

    void update(PostDTO post);

//    List<PostDTO> findAllByTitleContaining(String title);

    List<PostDTO> filter(Optional<String> title, Optional<Integer> id);


}
