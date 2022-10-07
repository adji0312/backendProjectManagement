package project.ProjectManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.ProjectManagement.exception.ProjectNotFoundException;
import project.ProjectManagement.exception.RoleNotFoundException;
import project.ProjectManagement.model.Project;
import project.ProjectManagement.model.Role;
import project.ProjectManagement.repo.ProjectRepo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProjectService {
    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> getAllProject(){
        return projectRepo.findAll();
    }

    public Project addProject(Project project){
//        project.setCreated_date(new Date());
        return projectRepo.save(project);
    }

    public Project getProjectById(Long id) throws RoleNotFoundException {
        return projectRepo.findProjectById(id).orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
    }

    public Project updateProject(Long id, Project project) throws ProjectNotFoundException {
        Project updatedProject = projectRepo.findProjectById(id).orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
//        updatedRole.setModify_date(new Date());
//        updatedRole.setRole_id(role.getRole_id());
//        updatedRole.setRole_name(role.getRole_name());
//        updatedRole.setRole_desc(role.getRole_desc());
        return projectRepo.save(updatedProject);
    }

    public void deleteProject(Long id) throws ProjectNotFoundException {
        Project deletedProject = projectRepo.findProjectById(id).orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
        projectRepo.delete(deletedProject);
    }
}
