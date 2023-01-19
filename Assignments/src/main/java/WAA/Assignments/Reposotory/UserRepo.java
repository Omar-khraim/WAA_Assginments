package WAA.Assignments.Reposotory;

import WAA.Assignments.Domain.Post;
import WAA.Assignments.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    User save(User user);


    @Query("Select u.posts from  User  u where u.id = :id")
    List<Post>  findUserPosts(long id);
}
