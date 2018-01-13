package app.engines;

import app.core.AnimalCenterManager;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.InputParser;

import java.util.List;

import static app.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private AnimalCenterManager animalCenterManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser,
                  AnimalCenterManager animalCenterManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.animalCenterManager = animalCenterManager;
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
            case "RegisterCleansingCenter":
                String name = commandParams.get(0);
                this.animalCenterManager.registerCleansingCenter(name);
                break;
            case "RegisterAdoptionCenter":
                name = commandParams.get(0);
                this.animalCenterManager.registerAdoptionCenter(name);
                break;
            case "RegisterDog":
                name = commandParams.get(0);
                int age = Integer.parseInt(commandParams.get(1));
                int learnedCommands = Integer.parseInt(commandParams.get(2));
                String adoptionCenterName = commandParams.get(3);
                this.animalCenterManager.registerDog(name, age, learnedCommands, adoptionCenterName);
                break;
            case "RegisterCat":
                name = commandParams.get(0);
                age = Integer.parseInt(commandParams.get(1));
                int intelligenceCoefficient = Integer.parseInt(commandParams.get(2));
                adoptionCenterName = commandParams.get(3);
                this.animalCenterManager.registerCat(name, age, intelligenceCoefficient, adoptionCenterName);
                break;
            case "SendForCleansing":
                adoptionCenterName = commandParams.get(0);
                String cleansingCenterName = commandParams.get(1);
                this.animalCenterManager.sendForCleansing(adoptionCenterName, cleansingCenterName);
                break;
            case "Cleanse":
                cleansingCenterName = commandParams.get(0);
                this.animalCenterManager.cleanse(cleansingCenterName);
                break;
            case "Adopt":
                adoptionCenterName = commandParams.get(0);
                this.animalCenterManager.adopt(adoptionCenterName);
                break;
            case INPUT_TERMINATING_COMMAND:
                this.animalCenterManager.printStatistics();
                break;
        }
    }
}
