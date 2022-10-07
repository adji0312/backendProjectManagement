package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ProjectManagement.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
}
