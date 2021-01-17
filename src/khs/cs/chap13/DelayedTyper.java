package khs.cs.chap13;

public class DelayedTyper implements Command {
    private long itsDelay;
    private char itsChar;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop = false;

    public DelayedTyper(long delay, char c) {
        itsDelay = delay;
        itsChar = c;
    }

    @Override
    public void execute() {
        System.out.println(itsChar);
        if(!stop) {
            delayAndRepeat();
        }
    }

    private void delayAndRepeat() {
        engine.addCommand(new SleepCommand(itsDelay, engine, this));
    }

    public static void main(String[] args) throws Exception {
        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));
        Command stopCommand = () -> stop = true;
        engine.addCommand(new SleepCommand(10000, engine, stopCommand));
        engine.run();
    }
}
