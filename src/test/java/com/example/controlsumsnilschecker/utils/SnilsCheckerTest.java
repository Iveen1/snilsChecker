package com.example.controlsumsnilschecker.utils;

import com.example.controlsumsnilschecker.ControlSumSnilsCheckerApplication;
import com.example.controlsumsnilschecker.entity.TestData;
import com.example.controlsumsnilschecker.exceptions.IncorrectSnilsLengthException;
import com.example.controlsumsnilschecker.repository.TestDataRepository;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import static org.junit.Assert.assertEquals;
import java.util.List;

/*
 * @created 06.11.2021 - 21:39
 * @project controlSumSnilsChecker
 * @author Polyakov Anton
 */
//@RunWith(SpringRunner.class)

@SpringBootTest(classes = ControlSumSnilsCheckerApplication.class)
//@RunWith(Parameterized.class)
public class SnilsCheckerTest {
    @ClassRule
    public static final SpringClassRule scr = new SpringClassRule();
    @Rule
    public final SpringMethodRule smr = new SpringMethodRule();

    @Autowired
    private TestDataRepository repository;

    public List<TestData> getRepoData() {
        return repository.findAll();
    }

    @RepeatedTest(124124124)
    public void getData(RepetitionInfo repetitionInfo) {
        try {
            TestData repoData = getRepoData().get(repetitionInfo.getCurrentRepetition()-1);
            System.out.println(repoData.getSnils() + " " + repoData.getCorrect());
            SnilsChecker snilsChecker = new SnilsChecker(repoData.getSnils());
            assertEquals(repoData.getCorrect(), snilsChecker.validSnils());
        } catch (IncorrectSnilsLengthException exception){

        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Тест окончен");
            System.exit(0);
        }
    }
}