package com.example.be.repository;

import com.example.be.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentRepository extends JpaRepository<Document, Long> {
}
