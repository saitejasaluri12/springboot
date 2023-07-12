package com.Spring.SpringLearning;

import com.Spring.SpringLearning.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private com.Spring.SpringLearning.service.StudentService StudentService;
    // get
    @GetMapping("/details")
    public List<Student> getStudents(){

        return StudentService.getAllStudents();
    }

//    @GetMapping("/details/{id}")
//    public Student getStudentById(@PathVariable int id) {
//
//        return StudentService.getStudent(id);
//    }

    //post
    @PostMapping("/save")
    public void saveStudent(@RequestBody Student st) {

        StudentService.saveStudent(st);
    }

    //update
    @PutMapping("/edit")
    public void updateStudent(@RequestBody Student st){
        StudentService.updateStudent(st);

    }
// delete
    @DeleteMapping("/delete/{id}")
    public void removeStudent(@PathVariable int id){
        StudentService.removeStudent(id);

    }

    }
