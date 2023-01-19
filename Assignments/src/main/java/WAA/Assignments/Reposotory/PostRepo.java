package WAA.Assignments.Reposotory;

import WAA.Assignments.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAll();

    @Override
    Optional<Post> findById(Long aLong);

    void deleteById(long id);
    Post save( Post post);

//    List<Post> getAllByUser(long id);



}
