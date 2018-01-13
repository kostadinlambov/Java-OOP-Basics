package avatar;

import avatar.core.GameManager;
import avatar.engines.Engine;
import avatar.io.ConsoleInputReader;
import avatar.io.ConsoleOutputWriter;
import avatar.utilities.InputParser;


public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();

        InputParser inputParser = new InputParser();
        GameManager gameManager = new GameManager();

        Engine engine = new Engine(inputReader, outputWriter, inputParser, gameManager);

        engine.run();
    }
}
