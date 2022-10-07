package project.ProjectManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.ProjectManagement.exception.UserNotFoundException;
import project.ProjectManagement.model.User;
import project.ProjectManagement.repo.RoleRepo;
import project.ProjectManagement.repo.UserRepo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }


    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User addUser(User user){

//        Role role = roleRepo.findRoleById(id).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
//        user.setRole(role);
        user.setCreated_date(new Date());
        return userRepo.save(user);
    }

    public User getUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    public User updateUser(Long id, User user){
        User updatedUser = userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        updatedUser.setModify_date(new Date());
        updatedUser.setUser_id(user.getUser_id());
        updatedUser.setUser_name(user.getUser_name());
        updatedUser.setRole(user.getRole());
        return userRepo.save(updatedUser);
    }

    public void deleteUser(Long id){
        User deletedUser = userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userRepo.delete(deletedUser);
    }

}
