package khs.cs.chap13;

import java.util.LinkedList;

/**
 * 커맨드 패턴의 응용사례 중 하나인 액티브 오브젝트 패턴
 * 주로 다중 제어 스레드 구현을 위한 기법
 */
public class ActiveObjectEngine {
    LinkedList<Command> itsCommands = new LinkedList<>();

    public void addCommand(Command c) {
        itsCommands.add(c);
    }

    public void run() throws Exception {
        while(!itsCommands.isEmpty()) {
            itsCommands.poll().execute();
        }
    }
}
