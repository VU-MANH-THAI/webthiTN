package com.thiTN.webthitracnghiem.service;

import com.thiTN.webthitracnghiem.model.Excel;
import com.thiTN.webthitracnghiem.model.Question;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IUploadExcel {
    String upload(Excel excel);
    List<Question> readExcel(String fileName) throws IOException;
    boolean checkExcel(Excel excel) throws IOException;
    void delete(String fileName) throws FileNotFoundException;
}
