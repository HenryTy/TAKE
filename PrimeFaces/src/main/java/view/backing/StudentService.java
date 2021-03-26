/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author PIOTREK
 */
@Named(value = "studentService")
@ApplicationScoped
public class StudentService {
    
    private List<Student> students;

    /**
     * Creates a new instance of StudentService
     */
    public StudentService() {
    }
    
    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Optimus", "Prime", 5.0f));
        students.add(new Student("Piotr", "Wojtyniak", 4.61f));
        students.add(new Student("Jan", "Kowalski", 3.5f));
        students.add(new Student("Optimus", "Prime2", 5.2f));
        students.add(new Student("Optimus", "Prime3", 5.3f));
        students.add(new Student("Optimus", "Prime4", 5.4f));
        students.add(new Student("Optimus", "Prime5", 5.5f));
        students.add(new Student("Optimus", "Prime6", 5.6f));
        students.add(new Student("Optimus", "Prime7", 5.7f));
        students.add(new Student("Optimus", "Prime8", 5.8f));
        students.add(new Student("Optimus", "Prime9", 5.9f));
        students.add(new Student("Optimus", "Prime10", 6.0f));
        students.add(new Student("Optimus", "Prime11", 6.1f));
        students.add(new Student("Optimus", "Prime12", 6.2f));
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }
    
    
    
}
