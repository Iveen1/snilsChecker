package com.example.controlsumsnilschecker.controller;

import com.example.controlsumsnilschecker.entity.TestData;
import com.example.controlsumsnilschecker.repository.TestDataRepository;
import com.example.controlsumsnilschecker.utils.SnilsChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;

/*
 * @created 06.11.2021 - 17:13
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
@RestController
@RequestMapping("/api")
class SnilsController {
    @Autowired
    private TestDataRepository repository;

    /**
     *
     * @param snils СНИЛС в любом формате (напр. 126-029-036-24)
     * @return корректность контрольной суммы СНИЛС'а в виде HashMap: {СНИЛС: boolean}
     */
    @GetMapping("/check/{snils}")
    HashMap<String, Boolean> check(@PathVariable String snils) {
        HashMap<String, Boolean> checkSnils = new HashMap<>();
        SnilsChecker snilsChecker = new SnilsChecker(snils);
        checkSnils.put(snilsChecker.getSnils(), snilsChecker.validSnils());
        return checkSnils;
    }
    @GetMapping("/test")
    List<TestData> test() {
        return repository.findAll();
    }
}
