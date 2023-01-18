package WAA.Assignments.Services.Impl;

import WAA.Assignments.DTO.PostDTO;
import WAA.Assignments.Domain.Post;
import WAA.Assignments.Reposotory.impl.PostRepoImpl;
import WAA.Assignments.Services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PostRepoImpl postRepo;

    @Override
    public List<PostDTO> findAll() {
        return Arrays.asList(modelMapper.map(postRepo.findAll(), PostDTO[].class));
    }

    @Override
    public PostDTO findById(long id) {
        return modelMapper.map(postRepo.findById(id), PostDTO.class);
    }

    @Override
    public void addPost(Post post) {
        postRepo.addPost(post);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, PostDTO post) {
        postRepo.update(id, modelMapper.map(post , Post.class ));
    }


}
