package WAA.Assignments.Services.Impl;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.Domain.Post;
import WAA.Assignments.Reposotory.PostRepo;
import WAA.Assignments.Services.PostService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    final
    ModelMapper modelMapper;
    final
    PostRepo postRepo;
    final EntityManager entityManager;

    public PostServiceImpl(ModelMapper modelMapper, PostRepo postRepo, EntityManager entityManager) {
        this.modelMapper = modelMapper;
        this.postRepo = postRepo;
        this.entityManager = entityManager;
    }

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
        postRepo.save(modelMapper.map(post, Post.class));
    }

    @Override
    public List<PostDTO> filter(Optional<String> title, Optional<Integer> id) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> root = cq.from(Post.class);

        List<Predicate> searchCriteria = new ArrayList<>();

        if(title.isPresent()){
            searchCriteria.add(cb.like(root.get("title"), "%"+title.get()+"%"));
        }
        if (id.isPresent()){
            searchCriteria.add(cb.equal(root.get("id"), id.get()));
        }
        cq.select(root).where(cb.and(searchCriteria.toArray(new Predicate[searchCriteria.size()])));

        return Arrays.asList( modelMapper.map( entityManager.createQuery(cq).getResultList() , PostDTO[].class));
    }


}
