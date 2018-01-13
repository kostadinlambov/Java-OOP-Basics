package systemSplit.controller;

import systemSplit.factories.HardwareFactory;
import systemSplit.factories.SoftwareFactory;
import systemSplit.models.Software.SoftwareComponent;
import systemSplit.models.hardware.HardwareComponent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ComponentManager {
    private Map<String, HardwareComponent> hardwareComponentMap;
    private Map<String, HardwareComponent> dumpMap;

    public ComponentManager() {
        this.hardwareComponentMap = new LinkedHashMap<>();
        this.dumpMap = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = HardwareFactory.createPowerHardware(name, capacity, memory);
        this.hardwareComponentMap.putIfAbsent(name, hardwareComponent);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = HardwareFactory.createHeavyHardware(name, capacity, memory);
        this.hardwareComponentMap.putIfAbsent(name, hardwareComponent);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {

        SoftwareComponent softwareComponent = SoftwareFactory.createExpressSoftware(name, capacity, memory);
        if (hardwareComponentMap.containsKey(hardwareComponentName)) {
            hardwareComponentMap.get(hardwareComponentName).registerSoftwareComponent(softwareComponent);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {

        SoftwareComponent softwareComponent = SoftwareFactory.createLightSoftware(name, capacity, memory);
        if (hardwareComponentMap.containsKey(hardwareComponentName)) {
            hardwareComponentMap.get(hardwareComponentName).registerSoftwareComponent(softwareComponent);
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (hardwareComponentMap.containsKey(hardwareComponentName)) {
            hardwareComponentMap.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    public void analyze() {

        int softCompCount = 0;
        int totalMemory = 0;
        int totalOperationalMemoryInUse = 0;
        int totalCapacityTaken = 0;
        int maximumCapacity = 0;
        for (HardwareComponent hardwareComponent : hardwareComponentMap.values()) {
            softCompCount += hardwareComponent.getRegSoftCompCount();
            totalMemory += hardwareComponent.getMaximumMemory();
            totalOperationalMemoryInUse += hardwareComponent.getTotalMemoryConsumption();
            totalCapacityTaken += hardwareComponent.getTotalCapacityConsumption();
            maximumCapacity += hardwareComponent.getMaximumCapacity();
        }

        System.out.println("System Analysis");
        System.out.printf("Hardware Components: %d%n", hardwareComponentMap.size());
        System.out.printf("Software Components: %d%n", softCompCount);
        System.out.printf("Total Operational Memory: %d / %d%n", totalOperationalMemoryInUse, totalMemory);
        System.out.printf("Total Capacity Taken: %d / %d%n", totalCapacityTaken, maximumCapacity);
    }

    public void split() {
        Map<String, HardwareComponent> sortedMap = hardwareComponentMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().getType().compareTo(a.getValue().getType()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (Map.Entry<String, HardwareComponent> hardwareComponent : sortedMap.entrySet()) {
            System.out.printf("Hardware Component – %s%n", hardwareComponent.getKey());
            System.out.printf("Express Software Components - %d%n", hardwareComponent.getValue().getExpressSoftwareComponentsCount());
            System.out.printf("Light Software Components - %s%n", hardwareComponent.getValue().getLightSoftwareComponentsCount());
            System.out.printf("Memory Usage: %d / %d%n",
                    hardwareComponent.getValue().getTotalMemoryConsumption(), hardwareComponent.getValue().getMaximumMemory());
            System.out.printf("Capacity Usage: %d / %d%n",
                    hardwareComponent.getValue().getTotalCapacityConsumption(), hardwareComponent.getValue().getMaximumCapacity());
            System.out.printf("Type: %s%n", hardwareComponent.getValue().getType());
            System.out.printf("Software Components: %s%n", hardwareComponent.getValue().getListOfSoftwareComponents());
        }
    }

    public void dump(String hardwareComponentName) {
        if (hardwareComponentMap.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = hardwareComponentMap.remove(hardwareComponentName);
            dumpMap.putIfAbsent(hardwareComponentName, hardwareComponent);
        }
    }

    public void restore(String hardwareComponentName) {
        if (dumpMap.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = dumpMap.remove(hardwareComponentName);
            hardwareComponentMap.putIfAbsent(hardwareComponentName, hardwareComponent);
        }
    }

    public void destroy(String hardwareComponentName) {
        if (dumpMap.containsKey(hardwareComponentName)) {
            dumpMap.remove(hardwareComponentName);
        }
    }

    public void dumpAnalyze() {
        long expressSoftwareComponentsCount = 0;
        long lightSoftwareComponentsCount = 0;
        for (HardwareComponent hardwareComponent : dumpMap.values()) {
            expressSoftwareComponentsCount += hardwareComponent.getExpressSoftwareComponentsCount();
            lightSoftwareComponentsCount += hardwareComponent.getLightSoftwareComponentsCount();
        }

        long powerHCompCount = dumpMap.values().stream()
                .filter(x -> x.getType().equalsIgnoreCase("Power")).count();
        long heavyHCompCount = dumpMap.values().stream()
                .filter(x -> x.getType().equalsIgnoreCase("Heavy")).count();

        int totalDumpedMemory = 0;
        int totalDumpedCapacity = 0;

        for (HardwareComponent hardwareComponent : dumpMap.values()) {
            totalDumpedMemory += hardwareComponent.getTotalMemoryConsumption();
            totalDumpedCapacity += hardwareComponent.getTotalCapacityConsumption();
        }

        System.out.println("Dump Analysis");
        System.out.printf("Power Hardware Components: %d%n", powerHCompCount);
        System.out.printf("Heavy Hardware Components: %d%n", heavyHCompCount);
        System.out.printf("Express Software Components: %d%n", expressSoftwareComponentsCount);
        System.out.printf("Light Software Components: %s%n", lightSoftwareComponentsCount);
        System.out.printf("Total Dumped  Memory: %d%n", totalDumpedMemory);
        System.out.printf("Total Dumped  Taken: %d%n", totalDumpedCapacity);
    }
}



