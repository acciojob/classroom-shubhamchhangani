package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name){
        Student student = studentRepository.getStudentByName(name);
        return student;
    }

    public Teacher getTeacherByName(String name){
        Teacher teacher = studentRepository.getTeacherByName(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String name){
        List<String> students = studentRepository.getStudentsByTeacherName(name);
        return students;
    }

    public List<String> getAllStudents(){
        List<String> students = studentRepository.getAllStudents();
        return students;
    }

    public void deleteTeacherByName(String name){
        studentRepository.deleteTeacherByName(name);
    }

    public void deleteAll(){
        studentRepository.deleteAll();
    }
}
