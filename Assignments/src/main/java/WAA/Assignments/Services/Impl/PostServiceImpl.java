package WAA.Assignments.Services.Impl;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.Domain.Post;
import WAA.Assignments.Reposotory.PostRepo;
import WAA.Assignments.Services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PostRepo postRepo;

    @Override
    public List<PostDTO> findAll() {
        return Arrays.asList(modelMapper.map(postRepo.findAll(), PostDTO[].class));
    }

    @Override
    public PostDTO findById(long id) {
        return modelMapper.map(postRepo.findById(id).get(), PostDTO.class);
    }

    @Override
    public void addPost(Post post) {
        postRepo.save(post);
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(PostDTO post) {
        postRepo.save( modelMapper.map(post , Post.class ));
    }


}
