package com.thiTN.webthitracnghiem.api;

import com.thiTN.webthitracnghiem.model.Classes;
import com.thiTN.webthitracnghiem.model.SubjectClasses;
import com.thiTN.webthitracnghiem.service.IClassesService;
import com.thiTN.webthitracnghiem.service.ISubjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassApiController {
    @Autowired
    private IClassesService classesService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Classes>> getClass(@PathVariable Integer id) {
        return ResponseEntity.ok(classesService.findAllBySubject(id));
    }

    @PostMapping
    public ResponseEntity<Classes> save(@ModelAttribute Classes classes) {
        classesService.save(classes);
        return ResponseEntity.ok(classes);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Classes>> save(@RequestBody List<Classes> classes) {
        for (int i = 0; i < classes.size(); i++) {
            classesService.save(classes.get(i));
        }
        return ResponseEntity.ok(classes);
    }
}
