package com.thiTN.webthitracnghiem.repository;

import com.thiTN.webthitracnghiem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {
    @Query(nativeQuery = true,value = "SELECT classes.* FROM classes JOIN subject_classes ON classes.id = subject_classes.class_id " +
            "WHERE subject_classes.subject_id = :id")
    List<Classes> findAllBySubjectClasses(int id);
}
