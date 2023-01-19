package WAA.Assignments.Controller;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.Domain.Post;
import WAA.Assignments.Services.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping
    public List<PostDTO> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDTO findById(@PathVariable  long id ){
        return postService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Post post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        postService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody PostDTO post){
        postService.update( post);
    }
}
