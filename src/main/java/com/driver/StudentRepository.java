package com.driver;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDB = new HashMap<>();
    HashMap<String,Teacher> teacherDB = new HashMap<>();

    HashMap<String,String> studentTeacherPair = new HashMap<>();
    public void addStudent(Student student){
        studentDB.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherDB.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentTeacherPair.put(student,teacher);
    }

    public Student getStudentByName(String name){
        Student student = studentDB.get(name);
        return student;
    }

    public Teacher getTeacherByName(String name){
        Teacher teacher = teacherDB.get(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String name){
        List<String> students = new ArrayList<>();
        for(Map.Entry<String,String> entry : studentTeacherPair.entrySet()){
            if(entry.getValue().equals(name)){
                students.add(entry.getKey());
            }
        }
        return students;
    }

    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();
        for(Student student : studentDB.values()){
            students.add(student.getName());
        }
        return students;
    }

    public void deleteTeacherByName(String name){
        teacherDB.remove(name);
        for(Map.Entry<String,String> entry : studentTeacherPair.entrySet()){
            if(entry.getValue().equals(name)){
                String student = entry.getKey();
                studentDB.remove(student);
                studentTeacherPair.remove(student);
            }
        }
    }

    public void deleteAll(){
        for(Map.Entry<String,String> entry : studentTeacherPair.entrySet()){
            String student = entry.getKey();
            String teacher = studentTeacherPair.get(student);
            teacherDB.remove(teacher);
            studentDB.remove(student);
            studentTeacherPair.remove(student);
        }
    }
}
