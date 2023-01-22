package WAA.Assignments.Controller;


import WAA.Assignments.DTO.Comment.CommentDTO;
import WAA.Assignments.Domain.Comment;
import WAA.Assignments.Services.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    final
    CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDTO> findAll(){
        return commentService.findAll();
    }


//    @GetMapping()
//    public List<Comment> getAll(){
//        return commentService.getAll();
//    }

    @GetMapping("/{id}")
    public CommentDTO findById(@PathVariable long id){
        return commentService.findById(id);
    }

    @PostMapping("/post/{id}")
//    @PostMapping
    void addComment(@PathVariable long id, @RequestBody CommentDTO comment){
//        comment.setPost_id(id);
        commentService.addComment( id,comment);
    }

    @PutMapping
    void update(@RequestBody CommentDTO comment){
        commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id){
        commentService.deleteById(id);
    }


}
