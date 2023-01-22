package WAA.Assignments.Services;

import WAA.Assignments.DTO.Comment.CommentDTO;
import WAA.Assignments.Domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<CommentDTO> findAll();


    CommentDTO findById(Long aLong);

    void addComment(long postId,CommentDTO comment);
    void update(CommentDTO comment);

    void deleteById(Long id);
}
