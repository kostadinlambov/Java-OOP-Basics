package systemSplit.engine;

import systemSplit.controller.ComponentManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ComponentManager componentManager;

    public Engine(ComponentManager componentManager) {
        this.componentManager = componentManager;
    }

    public void run() throws IOException {

        while (true) {
            String[] tokens = reader.readLine().split("\\(");
            String command = tokens[0];
            if (!command.equalsIgnoreCase("System Split")){
                String parameters = tokens[1].substring(0, tokens[1].length() - 1);
                List<String> commands = new ArrayList<>(Arrays.asList(parameters.split(", ")));

                switch (command) {
                    case "RegisterPowerHardware":
                        componentManager.registerPowerHardware(commands.get(0), Integer.parseInt(commands.get(1)), Integer.parseInt(commands.get(2)));
                        break;
                    case "RegisterHeavyHardware":
                        componentManager.registerHeavyHardware(commands.get(0), Integer.parseInt(commands.get(1)), Integer.parseInt(commands.get(2)));
                        break;
                    case "RegisterExpressSoftware":
                        componentManager.registerExpressSoftware(commands.get(0), commands.get(1), Integer.parseInt(commands.get(2)), Integer.parseInt(commands.get(3)));
                        break;
                    case "RegisterLightSoftware":
                        componentManager.registerLightSoftware(commands.get(0), commands.get(1), Integer.parseInt(commands.get(2)), Integer.parseInt(commands.get(3)));
                        break;
                    case "ReleaseSoftwareComponent":
                        componentManager.releaseSoftwareComponent(commands.get(0), commands.get(1));
                        break;
                    case "Analyze":
                        componentManager.analyze();
                        break;
                    case "Dump":
                        componentManager.dump(commands.get(0));
                        break;
                    case "Restore":
                        componentManager.restore(commands.get(0));
                        break;
                    case "Destroy":
                        componentManager.destroy(commands.get(0));
                        break;
                    case "DumpAnalyze":
                        componentManager.dumpAnalyze();
                        break;
                }
            }else{
                componentManager.split();
                break;
            }
        }
    }
}
