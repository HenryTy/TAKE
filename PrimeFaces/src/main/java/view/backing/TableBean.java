/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author PIOTREK
 */
@Named(value = "tableBean")
@ViewScoped
public class TableBean implements Serializable {
    
    @Inject
    private StudentService service;
    
    private List<Student> students;

    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
    }
    
    @PostConstruct
    public void init() {
        students = service.getStudents();
    }
    
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param service the service to set
     */
    public void setService(StudentService service) {
        this.service = service;
    }
    
}
