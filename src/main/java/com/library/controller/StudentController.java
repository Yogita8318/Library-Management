package com.library.controller;

import com.library.entity.Student;
import com.library.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    //add a single student
    @PostMapping("/std")
    public Student addStudent(@RequestBody Student student)
    {
        return this.studentService.addStudent(student);
    }
    //add the multiple book at a one time
    @PostMapping("/std/all")
    public List<Student> addAllStudents(@RequestBody List<Student> student)
    {
        return this.studentService.addAllStudents(student);
    }
    //get all student
    @GetMapping("/std")
    public List<Student> getAllStudents()
    {
        return this.studentService.getAllStudents();
    }
    //get the single student
    @GetMapping("/std/{id}")
    public Student getStudentById(@PathVariable("id") int id)
    {
        return this.studentService.getStudentById(id);
    }
    //update the student
    @PutMapping("/std/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id)
    {
        return this.studentService.updateStudent(student, id);
    }
    //delete the single data
    @DeleteMapping("/std/{id}")
    public void deleteStudent(@PathVariable("id") int id)
    {
        this.studentService.deleteStudentById(id);
    }
    //DELETE ALL STUDENT
    @DeleteMapping("/std")
    public void deleteAllStudents()
    {
        this.studentService.deleteAllStudents();
    }
    //Search the student by name
    @GetMapping("/search/name")
    public List<Student> searchStudent(@RequestParam String name)
    {
        return this.studentService.searchStudent(name);
    }
}
