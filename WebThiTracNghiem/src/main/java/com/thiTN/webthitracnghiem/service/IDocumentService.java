package com.thiTN.webthitracnghiem.service;

import com.thiTN.webthitracnghiem.model.Document;
import com.thiTN.webthitracnghiem.model.DocumentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IDocumentService {
    Page<Document> findAll(Pageable pageable);
    Document findById(int id);
    Page<Document> findByTitle(String title, Pageable pageable);
    Document save(DocumentRequest documentRequest);
    void remove(Document document);
    List<Document> findAll();
    void save(Document document);
}
