package com.thiTN.webthitracnghiem.service;

import com.thiTN.webthitracnghiem.model.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassesService {
    Iterable<Classes> findAll();
    Page<Classes> findAll(Pageable pageable);
    Classes findById(int id);
    void save(Classes classes);
    void remove(Classes classes);
    List<Classes> findAllBySubject(int id);
}
