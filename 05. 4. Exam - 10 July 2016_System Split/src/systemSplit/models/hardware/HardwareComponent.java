package systemSplit.models.hardware;

import systemSplit.models.Component;
import systemSplit.models.Software.SoftwareComponent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class HardwareComponent extends Component {
    private Map<String, SoftwareComponent> registeredComponents;
    private int maximumCapacity;
    private int maximumMemory;

    protected HardwareComponent(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.registeredComponents = new LinkedHashMap<>();
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    private int remainingHardwareCapacity() {
        return this.getMaximumCapacity() - getTotalCapacityConsumption();
    }

    private int remainingHardwareMemory() {
        return this.getMaximumMemory() - getTotalMemoryConsumption();
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {
        if (remainingHardwareMemory() >= softwareComponent.getMemoryConsumption() &&
                remainingHardwareCapacity() >= softwareComponent.getCapacityConsumption()){
            registeredComponents.put(softwareComponent.getName(), softwareComponent);
        }
    }

   public void  releaseSoftwareComponent(String softwareComponentName){
        if(registeredComponents.containsKey(softwareComponentName)){
            registeredComponents.remove(softwareComponentName);
        }
   }

   public int getRegSoftCompCount(){
      return registeredComponents.size();
   }

    public int  getTotalMemoryConsumption(){
        return  this.registeredComponents.entrySet().stream().mapToInt(x -> x.getValue().getMemoryConsumption()).sum();
    }

    public int  getTotalCapacityConsumption(){
        return  this.registeredComponents.entrySet().stream().mapToInt(x -> x.getValue().getCapacityConsumption()).sum();
    }

    public long  getExpressSoftwareComponentsCount(){
        return  this.registeredComponents.entrySet().stream()
                .filter(x -> x.getValue().getType().equalsIgnoreCase("Express")).count();
    }

    public long  getLightSoftwareComponentsCount(){
        return  this.registeredComponents.entrySet().stream()
                .filter(x -> x.getValue().getType().equalsIgnoreCase("Light")).count();
    }

    public String getListOfSoftwareComponents(){
        List<String> listOfComponents = new ArrayList<>();
        listOfComponents.addAll(registeredComponents.keySet());
        if(listOfComponents.size() > 0){
            return String.join(", ", listOfComponents);
        }else{
            return "None";
        }
    }
}
