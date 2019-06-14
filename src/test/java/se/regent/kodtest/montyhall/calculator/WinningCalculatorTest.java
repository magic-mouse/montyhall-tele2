package se.regent.kodtest.montyhall.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WinningCalculatorTest {

    @Test
    public void calculateIfItIsAWin() throws Exception {
        // Test results copied from https://www.statisticshowto.datasciencecentral.com/probability-and-statistics/monty-hall-problem/#Monty1975
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(1, 1, true));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(1, 2, true));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(1, 3, true));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(2, 1, true));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(2, 2, true));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(2, 3, true));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(3, 1, true));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(3, 2, true));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(3, 3, true));

        // Testing result without switching
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(1, 1, false));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(1, 2, false));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(1, 3, false));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(2, 1, false));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(2, 2, false));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(2, 3, false));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(3, 1, false));
        assertFalse("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(3, 2, false));
        assertTrue("Selectig the correct door while switching", WinningCalculator.calculateIfItIsAWin(3, 3, false));
    }
}