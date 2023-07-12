package com.Spring.SpringLearning.service;

import com.Spring.SpringLearning.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> list = new ArrayList<>();

//    public StudentService() {
//
//
//    }

    public List<Student> getAllStudents(){
        list.add(new Student(1, "Venkat"));
        list.add(new Student(2, "Ak"));
        list.add(new Student(3, "Srihari"));

        return this.list;
    }

//    public Student getStudent(int id){
//        for(Student s : list){
//            if(s.getId() == id){
//                return s;
//            }
//        }
//        return null;
//    }

    public void saveStudent(Student st) {
        this.list.add(st);

    }

    public void updateStudent(Student st){
        for (Student s:list){
            if(s.getId()==st.getId()){
                s.setName(st.getName());
            }
        }
    }
    public void removeStudent(int id){

        this.list.remove(id);
    }
}
