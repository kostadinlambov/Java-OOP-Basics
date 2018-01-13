package exam.engines;


import exam.core.Controller;
import exam.io.ConsoleInputReader;
import exam.io.ConsoleOutputWriter;
import exam.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private Controller controller;
    //private Colony colony;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, Controller controller) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.controller = controller;
    }

    public void run() {
        String inputLine;


        while (true) {
            inputLine = this.inputReader.readLine();

            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            if (inputLine.equals("end")) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "insert":
                String colonistClass = commandParams.get(0);
                String colonistId = commandParams.get(1);
                String familyId = commandParams.get(2);
                int talent = Integer.parseInt(commandParams.get(3));
                int age = Integer.parseInt(commandParams.get(4));

                if (commandParams.size() == 6) {
                    String sign = commandParams.get(5);
                    controller.insert(colonistClass, colonistId, familyId, talent, age, sign);
                } else {
                    controller.insert(colonistClass, colonistId, familyId, talent, age);
                }
                break;
            case "remove":
                String modificator = commandParams.get(0);
                familyId = commandParams.get(1);

                if(commandParams.size() == 3){
                     colonistId = commandParams.get(2);
                    controller.remove(modificator, familyId, colonistId);
                }else {
                    controller.remove(modificator, familyId);
                }
                break;
            case "grow":
                int years = Integer.parseInt(commandParams.get(0));
                controller.grow(years);
                break;
            case "potential":
                controller.potential();
                break;
            case "capacity":
                controller.capacity();
                break;
            case "family":
                familyId = commandParams.get(0);
                controller.family(familyId);
                break;
            default:

                break;
        }
    }
}