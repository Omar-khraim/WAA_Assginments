package WAA.Assignments.Services.Impl;

import WAA.Assignments.DTO.Post.PostDTO;
import WAA.Assignments.DTO.User.UserDTO;
import WAA.Assignments.Domain.User;
import WAA.Assignments.Reposotory.UserRepo;
import WAA.Assignments.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

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
        userRepo.save(modelMapper.map(user,User.class));
    }

    @Override
    public List<PostDTO> getUserPosts(long id) {
        return Arrays.asList( modelMapper.map(userRepo.findUserPosts(id) , PostDTO[].class));
    }


}
