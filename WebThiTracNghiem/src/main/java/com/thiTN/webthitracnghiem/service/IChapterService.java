package com.thiTN.webthitracnghiem.service;

import com.thiTN.webthitracnghiem.model.Chapter;

import java.util.List;

public interface IChapterService {
    List<Chapter> getAll();
    List<Chapter> findBySubjectClass(int id);
    Chapter findById(int id);
    List<Chapter> findBySubjectAndClass(int subId, int classId);
    void remove(Chapter chapter);
    int getSerial(int id);
    Chapter save(Chapter chapter);
}
