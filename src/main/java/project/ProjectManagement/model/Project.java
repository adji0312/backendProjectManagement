package project.ProjectManagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "created_by", length = 10, updatable = false)
    private Date created_by;

    @Column(name = "created_date", updatable = false)
    private Date created_date;

    @Column(name = "modify_by", length = 10)
    private Date modify_by;

    @Column(name = "modify_date")
    private Date modify_date;

    @Column(name = "application")
    private String application;

    @Column(name = "project_type")
    private String project_type;

    @Column(name = "project_code", updatable = false)
    private String project_code;

    @Column(name = "project_bpro", unique = true)
    private String project_bpro;

    @Column(name = "project_desc")
    private String project_desc;

    @Column(name = "kick_off")
    private Date kick_off;

    @Column(name = "project_status")
    private String project_status;

}
