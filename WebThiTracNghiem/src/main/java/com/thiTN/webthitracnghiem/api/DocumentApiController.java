package com.thiTN.webthitracnghiem.api;

import com.thiTN.webthitracnghiem.model.Document;
import com.thiTN.webthitracnghiem.model.DocumentRequest;
import com.thiTN.webthitracnghiem.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document")
public class DocumentApiController {
    @Autowired
    private IDocumentService documentService;
    @PostMapping
    public ResponseEntity<Document> save(@ModelAttribute DocumentRequest document){
        return ResponseEntity.ok(documentService.save(document));
    }
}
