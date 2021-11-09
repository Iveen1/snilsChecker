package com.example.controlsumsnilschecker.service.impl;

import com.example.controlsumsnilschecker.entity.TestData;
import com.example.controlsumsnilschecker.repository.TestDataRepository;
import com.example.controlsumsnilschecker.service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @created 03.11.2021 - 0:17
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
@Service
public class TestDataServiceImpl implements TestDataService {
    @Autowired
    private TestDataRepository testDataRepository;

    @Override
    public List<TestData> getAll() {
        return testDataRepository.findAll();
    }
}