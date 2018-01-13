package systemSplit;

import systemSplit.controller.ComponentManager;
import systemSplit.engine.Engine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ComponentManager componentManager = new ComponentManager();
        Engine engine = new Engine(componentManager);
        engine.run();
    }
}
