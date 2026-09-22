package com.library.repository;

import com.library.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Optional<Student>  findById(int id);
    public List<Student> findByNameContainingIgnoreCase(String name);

}
