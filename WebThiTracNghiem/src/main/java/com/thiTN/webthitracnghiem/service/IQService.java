package com.thiTN.webthitracnghiem.service;

import com.thiTN.webthitracnghiem.model.IQ;
import com.thiTN.webthitracnghiem.model.Result;

import java.util.List;

public interface IQService {
    void save(IQ iq);
    List<IQ> findAll();
    List<IQ> findByUser(String un);
}
