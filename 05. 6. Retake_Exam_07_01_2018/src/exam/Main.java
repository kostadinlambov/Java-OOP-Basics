package exam;


import exam.core.Controller;
import exam.engines.Engine;
import exam.entities.colony.Colony;
import exam.io.ConsoleInputReader;
import exam.io.ConsoleOutputWriter;
import exam.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();

        String[] inputLine = inputReader.readLine().split("\\s+");

        int maxFamilyCount = Integer.parseInt(inputLine[0]);
        int maxFamilyCapacity = Integer.parseInt(inputLine[1]);
        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        Controller manager = new Controller(colony);
        Engine engine = new Engine(inputReader, outputWriter, inputParser, manager);

        engine.run();


    }
}
