package khs.cs.chap13;

public class SleepCommand implements Command {
    private Command wakeupCommand;
    private ActiveObjectEngine engine;
    private long sleepTime;
    private long startTime = 0;
    private boolean started = false;

    public SleepCommand(long milliseconds, ActiveObjectEngine e, Command wakeupCommand) {
        sleepTime = milliseconds;
        engine = e;
        this.wakeupCommand = wakeupCommand;
    }

    @Override
    public void execute() {
        long currentTime = System.currentTimeMillis();
        if(!started) {
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else if((currentTime - startTime) < sleepTime) {
            engine.addCommand(this);
        } else {
            engine.addCommand(wakeupCommand);
        }
    }
}
