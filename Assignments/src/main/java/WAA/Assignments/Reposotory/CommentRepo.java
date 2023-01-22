package WAA.Assignments.Reposotory;

import WAA.Assignments.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Override
    List<Comment> findAll();

    @Override
    Optional<Comment> findById(Long aLong);

    @Override
    Comment save(Comment comment);

    @Override
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);
}
