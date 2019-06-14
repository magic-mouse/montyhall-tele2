package se.regent.kodtest.montyhall.simulator;

import lombok.extern.slf4j.Slf4j;
import se.regent.kodtest.montyhall.calculator.WinningCalculator;

import java.util.Random;

@Slf4j
public class MontyhallSimulator {
    public static WinType randomizeDoorsAndCalculateWins() {

        Random r = new Random();
        int selectedDoor = r.nextInt(3);
        int correctDoor = r.nextInt(3);
        boolean doesSwitch = r.nextBoolean();

        try {
            if (WinningCalculator.calculateIfItIsAWin(selectedDoor, correctDoor, doesSwitch)) {
                if (doesSwitch) return WinType.SWITCHED;
                return WinType.STAYED;
            }
        }catch (Exception e){
            log.error("The program have catched an impossible alternative", e);
            System.exit(-1);
        }
        return WinType.LOST;
    }
}
