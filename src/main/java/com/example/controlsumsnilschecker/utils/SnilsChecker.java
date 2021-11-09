package com.example.controlsumsnilschecker.utils;

import com.example.controlsumsnilschecker.exceptions.IncorrectSnilsLengthException;
import lombok.Getter;

/*
 * @created 06.11.2021 - 17:29
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
@Getter
public class SnilsChecker {
    private final String snils;
    private final Integer snilsLength = 11; // полная длина СНИЛС'а - 11 символов
    private final Integer snilsControlSumLength = 2; // длина контрольной суммы СНИЛС'а - 2 символа

    /**
     *
     * @param snils СНИЛС в любом формате (напр. 126-029-036-24)
     */
    public SnilsChecker(String snils) {
        this.snils = snils.replaceAll("[^\\d]", ""); // числовой СНИЛС без сторонних символов
    }

    /**
     *
     * @return boolean ответ, правильная ли контрольная сумма СНИЛС'а
     * @throws IncorrectSnilsLengthException в случае некорректной длинны СНИЛС'а
     */
    public boolean validSnils() throws IncorrectSnilsLengthException{
        if (this.snils.length() != snilsLength) {
            throw new IncorrectSnilsLengthException(this.snils.length(), snilsLength);
        }

        int controlSum = Integer.parseInt(this.snils.substring(this.snils.length()-snilsControlSumLength, this.snils.length())); // контрольная сумма из полного СНИЛС'а
        String snilsDigits = this.snils.substring(0, this.snils.length()-snilsControlSumLength); // СНИЛС без контрольной суммы

        int control = 0; // переменная для подсчёта контрольной суммы
        for (int i = 0; i < snilsDigits.length(); i++) { // каждая цифра СНИЛС'а умножается на 9-i и прибавляется к control
            control += Integer.parseInt(String.valueOf(snilsDigits.charAt(i)))*(snilsLength-snilsControlSumLength-i);
        }

        if (control < 100) { // если контрольная сумма меньше 100 - сравниваем с controlSum и возвращаем ответ
            return control == controlSum;
        }
        else if (control == 100) { // если контрольная сумма равна 100 - сравниваем с controlSum и возвращаем ответ
            return controlSum == 00;
        }
        else if (control > 100) { // если контрольная сумма больше 100 - отнимаем первую цифру от двух остальных, сравниваем с controlSum и возвращаем ответ
            return Integer.parseInt(String.valueOf(control).substring(1, 3))-Integer.parseInt(String.valueOf(String.valueOf(control).charAt(0))) == controlSum;
        }
        else {
            throw new NullPointerException("Unknown Error");
        }
    }
}