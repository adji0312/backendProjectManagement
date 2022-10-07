package project.ProjectManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ProjectManagement.model.Project;

import java.util.Optional;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    Optional<Project> findProjectById(Long id);
}
