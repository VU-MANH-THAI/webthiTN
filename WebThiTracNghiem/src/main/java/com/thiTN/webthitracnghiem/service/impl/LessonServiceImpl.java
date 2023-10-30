package com.thiTN.webthitracnghiem.service.impl;

import com.thiTN.webthitracnghiem.model.Lesson;
import com.thiTN.webthitracnghiem.repository.LessonRepository;
import com.thiTN.webthitracnghiem.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements ILessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public Page<Lesson> findAll(Pageable pageable) {
        return lessonRepository.findAll(pageable);
    }

    @Override
    public Page<Lesson> findByChapterId(int chapId, Pageable pageable) {
        return lessonRepository.findByChapter(chapId,pageable);
    }

    @Override
    public Lesson findById(int id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lesson> findByChapId(int chapId) {
        return lessonRepository.findByChapterId(chapId);
    }

    @Override
    public void remove(Lesson lesson) {
        lessonRepository.delete(lesson);
    }

    @Override
    public int getSerialMax(int lesson) {
        return lessonRepository.getSerial(lesson).orElse(0);
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
