package avatar.engines;

import avatar.core.GameManager;
import avatar.io.ConsoleInputReader;
import avatar.io.ConsoleOutputWriter;
import avatar.utilities.InputParser;

import java.util.List;

import static avatar.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private GameManager gameManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, GameManager gameManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.gameManager = gameManager;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "Bender":
                String benderType = commandParams.get(0);
                String benderName = commandParams.get(1);
                long power = Long.parseLong(commandParams.get(2));
                double secondaryParameter = Double.parseDouble(commandParams.get(3));
                this.gameManager.createBender(benderType, benderName, power, secondaryParameter);
                break;
            case "Monument":
                String monumentType = commandParams.get(0);
                String monumentName = commandParams.get(1);
                long affinity = Long.parseLong(commandParams.get(2));
                this.gameManager.createsMonument(monumentType, monumentName, affinity);
                break;
            case "Status":
                String nation = commandParams.get(0);
                this.gameManager.status(nation);
                break;
            case "War":
                nation = commandParams.get(0);
                this.gameManager.war(nation);
                break;
            case "Quit":
                this.gameManager.quit();
                break;
        }
    }
}
