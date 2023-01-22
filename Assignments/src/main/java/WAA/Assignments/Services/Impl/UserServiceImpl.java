package WAA.Assignments.Services.Impl;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.DTO.User.UserDTO;
import WAA.Assignments.Domain.Users;
import WAA.Assignments.Reposotory.UserRepo;
import WAA.Assignments.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@Service
//@Transactional
public class UserServiceImpl implements UserService {

    final
    UserRepo userRepo;

    final
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        return Arrays.asList(modelMapper.map(userRepo.findAll(), UserDTO[].class));
    }
//
//    public List<User> getAll(){
//        return userRepo.findAll();
//    }

    @Override
    public UserDTO findById(Long id) {
        return modelMapper.map(userRepo.findById(id).get() , UserDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public  void save(UserDTO user) {
        userRepo.save(modelMapper.map(user, Users.class));
    }

    @Override
    public List<PostDTO> getUserPosts(long id) {
        return Arrays.asList( modelMapper.map(userRepo.findUserPosts(id) , PostDTO[].class));
    }

    @Override
    public List<UserDTO> findAllByPostsGreaterThanEqual(int count) {

//        return  userRepo.findUsersWithPosts(count);
        return Arrays.asList(modelMapper.map(userRepo.findUsersWithPosts(count), UserDTO[].class));
    }


}
