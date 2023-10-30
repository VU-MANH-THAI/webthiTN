package com.thiTN.webthitracnghiem.service.impl;

import com.thiTN.webthitracnghiem.model.IQ;
import com.thiTN.webthitracnghiem.repository.IQRepository;
import com.thiTN.webthitracnghiem.service.IQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IQServiceImpl implements IQService {
    @Autowired
    private IQRepository iqRepository;

    @Override
    public void save(IQ iq) {
        iq.getUsers().setIq(null);
        iqRepository.save(iq);
    }

    @Override
    public List<IQ> findAll() {
        return iqRepository.findAll();
    }

    @Override
    public List<IQ> findByUser(String un) {
        return iqRepository.findByUsername(un);
    }
}
