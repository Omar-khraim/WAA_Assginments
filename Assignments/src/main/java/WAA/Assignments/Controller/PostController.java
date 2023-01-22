package WAA.Assignments.Controller;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.Domain.Post;
import WAA.Assignments.Services.Impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    final
    PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDTO findById(@PathVariable long id) {
        return postService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Post post) {
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        postService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody PostDTO post) {
        postService.update(post);
    }

    @GetMapping("filter")
    public List<PostDTO> filter(@RequestParam(value = "title", required = false) Optional<String> title,
                                @RequestParam(value = "id", required = false) Optional<Integer> id ) {

        return postService.filter(title, id);
    }
}
