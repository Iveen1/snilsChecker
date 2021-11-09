package com.example.controlsumsnilschecker.repository;

import com.example.controlsumsnilschecker.entity.TestData;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 03.11.2021 - 0:15
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
@Repository
public interface TestDataRepository extends JpaRepository<TestData, Long> {
}
