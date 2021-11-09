package com.example.controlsumsnilschecker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
/*
 * @created 02.11.2021 - 23:52
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
@Entity
@Table(name = "testdata")
@Getter
@Setter
/**
 * Класс объекта БД под тесты SnilsChecker
 */
public class TestData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // id записи

    @Column
    private String snils; // СНИЛС

    @Column
    private Boolean correct; // корректность записи
}