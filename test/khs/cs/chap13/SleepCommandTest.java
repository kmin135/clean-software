package khs.cs.chap13;

import org.junit.Test;

import static org.junit.Assert.*;

public class SleepCommandTest {

    private boolean commandExecuted = false;

    @Test
    public void testSleep() throws Exception {
        Command wakeup = () -> commandExecuted = true;

        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = (stop - start);

        assertTrue("SleepTime " + sleepTime + " expected >= 1000", sleepTime >= 1000);
        assertTrue("SleepTime " + sleepTime + " expected < 1100", sleepTime < 1100);
        assertTrue("Command Executed", commandExecuted);
    }
}