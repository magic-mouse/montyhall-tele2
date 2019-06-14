package se.regent.kodtest.montyhall.calculator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WinningCalculator {

    public static boolean calculateIfItIsAWin(int selectedDoor, int correctDoor, boolean doesSwitch) throws Exception {
        // This method can be refactored but is left this way to improve readability,
        // the refactoring will be handled by the compiler.

        // If the door is correct and he switches there is a 100% chance that he will pick the wrong door
        if(selectedDoor == correctDoor && doesSwitch){
            log.trace("1");
            return false;
            // If the door os wrong and he switches there is a 100% chance he will pick the right door
        }else if(selectedDoor != correctDoor && doesSwitch){
            log.trace("2");
            return true;
            // if the door is correct and he does not switch there is a 100% chance he will pick the right door
        }else if(selectedDoor == correctDoor && !doesSwitch){
            log.trace("3");
            return true;
            // if the door is wrong and he does not switch there is a 100% chance he will pick the wrong door
        }else if(selectedDoor != correctDoor && !doesSwitch){
            log.trace("4");
            return false;
            // if the code goes this far something is wrong
        }else{
            // This alternative is impossible, but exception handling is always nice.
            throw new Exception("The code has failed, woops");
        }
    }
}
