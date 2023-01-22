package WAA.Assignments.Services.Impl;

import WAA.Assignments.DTO.Comment.CommentDTO;
import WAA.Assignments.Domain.Comment;
import WAA.Assignments.Domain.Post;
import WAA.Assignments.Reposotory.CommentRepo;
import WAA.Assignments.Reposotory.PostRepo;
import WAA.Assignments.Services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    final
    ModelMapper modelMapper;
    final
    CommentRepo commentRepo;
    final PostRepo postRepo;

    public CommentServiceImpl(ModelMapper modelMapper, CommentRepo commentRepo, PostRepo postRepo) {
        this.modelMapper = modelMapper;
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    @Override
    public List<CommentDTO> findAll() {
        return Arrays.asList(modelMapper.map(commentRepo.findAll(), CommentDTO[].class));
    }

    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public CommentDTO findById(Long id) {
        if (commentRepo.existsById(id))
            return modelMapper.map(commentRepo.findById(id).get(), CommentDTO.class);
        return null ;
    }

    @Override
    public void addComment(long postId, CommentDTO postComment) {
//        comment.setPost_id(postId);
        Comment comment = new Comment();
        comment.setPost(postRepo.getById(postId));
//        modelMapper.map(postComment, Comment.class);
        comment.setName(postComment.getName());
        commentRepo.save(comment);
    }

    @Override
    public void update(CommentDTO comment) {
        commentRepo.save(modelMapper.map(comment, Comment.class));
    }

    @Override
    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }
}
