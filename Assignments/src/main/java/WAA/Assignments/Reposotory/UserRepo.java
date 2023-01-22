package WAA.Assignments.Reposotory;

import WAA.Assignments.Domain.Post;
import WAA.Assignments.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

    List<Users> findAll();

    Optional<Users> findById(Long aLong);

    void deleteById(Long aLong);


    @Query("Select u.posts from  Users  u where u.id = :id")
    List<Post> findUserPosts(long id);

    @Override
    boolean existsById(Long aLong);

    @Query("select u from Users u where size(u.posts) >= :num")
    List<Users> findUsersWithPosts(int num);
}
