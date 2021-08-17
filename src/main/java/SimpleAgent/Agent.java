package SimpleAgent;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void agentmain(String agentArgs, Instrumentation ins) {
        for (Class<?> clazz: ins.getAllLoadedClasses()) {
            System.out.println(clazz.getName());
        }
    }
}
