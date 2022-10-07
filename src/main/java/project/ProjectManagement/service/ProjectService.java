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
import java.util.Random;

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
        Random rnd = new Random();
        project.setCreated_date(new Date());
        project.setProject_code(project.getApplication()+rnd.nextInt(9999999));
        project.setKick_off(project.getKick_off());
        return projectRepo.save(project);
    }

    public Project getProjectById(Long id) throws RoleNotFoundException {
        return projectRepo.findProjectById(id).orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
    }

    public Project updateProject(Long id, Project project) throws ProjectNotFoundException {
        Project updatedProject = projectRepo.findProjectById(id).orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
        updatedProject.setKick_off(project.getKick_off());
        updatedProject.setProject_status(project.getProject_status());
        updatedProject.setProject_desc(project.getProject_desc());
        updatedProject.setApplication(project.getApplication());
        updatedProject.setModify_date(new Date());
        updatedProject.setProject_status(project.getProject_status());
        return projectRepo.save(updatedProject);
    }

    public void deleteProject(Long id) throws ProjectNotFoundException {
        Project deletedProject = projectRepo.findProjectById(id).orElseThrow(() -> new ProjectNotFoundException("Project Not Found"));
        projectRepo.delete(deletedProject);
    }
}
