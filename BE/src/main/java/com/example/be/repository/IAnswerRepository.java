package com.example.be.repository;

import com.example.be.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnswerRepository extends JpaRepository<Answers, Long> {
}
