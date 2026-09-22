package com.library.repository;

import com.library.entity.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IssueBookRepository extends JpaRepository <IssueBook,Integer>{

    public Optional<IssueBook>  findById(int id);
}
