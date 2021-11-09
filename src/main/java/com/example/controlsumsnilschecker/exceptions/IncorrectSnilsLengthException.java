package com.example.controlsumsnilschecker.exceptions;

/*
 * @created 06.11.2021 - 18:24
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
public class IncorrectSnilsLengthException extends RuntimeException{
    public IncorrectSnilsLengthException(int currentLength, int expectedLength) {
        super("Incorrect snils length. Expected length: " + expectedLength + ", got: " + currentLength);
    }
}
