package com.library.service;

import com.library.entity.Student;
import com.library.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository=studentRepository;
    }
    //add the student details
    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }
    //add multiple student at a one time
    public List<Student> addAllStudents(List<Student> student)
    {
       List<Student> std=(List<Student>) this.studentRepository.saveAll(student);
       return std;
    }
    //get all student
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    //get single student
    public Student getStudentById(int id)
    {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
    //update the student
    public Student updateStudent(Student student, int id)
    {
        student.setId(id);
        return studentRepository.save(student);
    }
    //delete single student
    public void deleteStudentById(int id)
    {
        this.studentRepository.deleteById(id);
    }
    //delete all student
    public void deleteAllStudents()
    {
        this.studentRepository.deleteAll();
    }

    //Search the student by name
    public List<Student> searchStudent(String name)
    {
        return this.studentRepository.findByNameContainingIgnoreCase(name);
    }

}
