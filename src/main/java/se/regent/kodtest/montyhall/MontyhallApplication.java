package se.regent.kodtest.montyhall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.regent.kodtest.montyhall.simulator.MontyhallSimulator;
import se.regent.kodtest.montyhall.simulator.WinType;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@Slf4j
public class MontyhallApplication implements CommandLineRunner {

    @Value("#{new Long('${montyhall.iterations}')}")
    Long iterations;

    private AtomicInteger winCountSwitched = new AtomicInteger(0);
    private AtomicInteger winCountNonSwitched = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MontyhallApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application Started !!");
        log.info(""); // Added space for easier log readability
        log.info("Simulation where the players always switches");
        simulationBootstrap(true);

        resetCalculator();
        log.info(""); // Added space for easier log readability
        log.info("Simulation where the players never switches");
        simulationBootstrap(false);

        resetCalculator();
        log.info(""); // Added space for easier log readability
        log.info("Simulation where the players change their mind at random");
        simulationBootstrap(null);
    }

    private void resetCalculator() {
        winCountNonSwitched.set(0);
        winCountSwitched.set(0);
    }

    private void simulationBootstrap(Boolean doesSwitch) {
        long startTime = System.currentTimeMillis();

        for(int i  = 0; i < iterations;  i++) {
            WinType winType =  MontyhallSimulator.randomizeDoorsAndCalculateWins(doesSwitch);
            incrementWinningCalculator(winType);
        }

        long endTime = System.currentTimeMillis();

        log.info("Winnings while switching: {}, winnings while not switching: {}, total winnings: {}", winCountSwitched, winCountNonSwitched, winCountNonSwitched.get() + winCountSwitched.get());
        log.info("The system processed everything in: {} ms", endTime - startTime);
    }

    private void incrementWinningCalculator(WinType winType) {
        switch (winType){
            case SWITCHED:
                winCountSwitched.incrementAndGet();
                break;
            case STAYED:
                winCountNonSwitched.incrementAndGet();
                break;
        }
    }


}
