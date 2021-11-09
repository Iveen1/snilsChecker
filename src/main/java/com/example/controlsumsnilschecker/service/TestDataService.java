package com.example.controlsumsnilschecker.service;

import com.example.controlsumsnilschecker.entity.TestData;

import java.util.List;

/*
 * @created 03.11.2021 - 0:17
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
public interface TestDataService {
    List<TestData> getAll();
}