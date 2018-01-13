package avatar.core;

import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;
import avatar.factories.BenderFactory;
import avatar.factories.MonumentFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static avatar.utilities.Constants.*;

public class GameManager {
    private Map<String, List<Bender>> benders;
    private Map<String, List<Monument>> monuments;
    private List<String> issuedWars;

    public GameManager() {
        this.setBenders();
        this.setMonuments();
        this.issuedWars = new ArrayList<>();
    }

    public void createBender(String benderType, String benderName, long power, double secondaryParameter) {
        Bender bender = BenderFactory.makeBender(benderType, benderName, power, secondaryParameter);
        benders.get(benderType).add(bender);
    }

    public void createsMonument(String monumentType, String monumentName, long affinity) {
        Monument monument = MonumentFactory.makeMonument(monumentType, monumentName, affinity);
        monuments.get(monumentType).add(monument);
    }

    public void status(String nation) {
        System.out.println(nation +" Nation");
        if (benders.get(nation).size() > 0) {
            System.out.println("Benders:");
            benders.entrySet().stream()
                    .filter(mapKey -> mapKey.getKey().equals(nation))
                    .forEach(mapKey ->
                            mapKey.getValue()
                                    .forEach(listElement -> System.out.println("###" + listElement.toString()))
                    );
        } else {
            System.out.println("Benders: None");
        }

        if (monuments.get(nation).size() > 0) {
            System.out.println("Monuments:");
            monuments.entrySet().stream()
                    .filter(mapKey -> mapKey.getKey().equals(nation))
                    .forEach(mapKey ->
                            mapKey.getValue()
                                    .forEach(listElement -> System.out.println("###" + listElement.toString()))
                    );
        } else {
            System.out.println("Monuments: None");
        }
    }

    public void war(String nation) {

        issuedWars.add(nation);

        double nationTotalPower = 0;
        long affinitySum = 0L;
        double totalPower = 0L;
        double maxTotalPower = Double.MIN_VALUE;
        String nationWithMaxPower = null;


        for (Map.Entry<String, List<Bender>> bendersType : benders.entrySet()) {
            nationTotalPower = bendersType.getValue().stream().mapToDouble(Bender::getBenderTotalPower).sum();
            for (Map.Entry<String, List<Monument>> monumentsType : monuments.entrySet()) {
                if (monumentsType.getKey().equals(bendersType.getKey())) {
                    affinitySum = monumentsType.getValue().stream().mapToLong(Monument::getMonumentAffinity).sum();
                }
                totalPower = nationTotalPower + nationTotalPower * (affinitySum / 100);

                if (totalPower > maxTotalPower) {
                    maxTotalPower = totalPower;
                    nationWithMaxPower = bendersType.getKey();
                }
            }
        }

        String finalNationWithMaxPower = nationWithMaxPower;
        benders.entrySet().stream().filter(x -> !x.getKey().equals(finalNationWithMaxPower))
                .forEach(x -> x.getValue().clear());
        monuments.entrySet().stream().filter(x -> !x.getKey().equals(finalNationWithMaxPower))
                .forEach(x -> x.getValue().clear());
    }


    public void quit() {
        int counter = 1;
        for (String issuedWarNation : issuedWars) {
            System.out.printf("War %d issued by %s%n", counter, issuedWarNation);
            counter++;
        }
    }

    private void setMonuments() {
        this.monuments = new LinkedHashMap<>();
        this.monuments.put(AIR, new ArrayList<>());
        this.monuments.put(WATER, new ArrayList<>());
        this.monuments.put(FIRE, new ArrayList<>());
        this.monuments.put(EARTH, new ArrayList<>());
    }


    private void setBenders() {
        this.benders = new LinkedHashMap<>();
        this.benders.put(AIR, new ArrayList<>());
        this.benders.put(WATER, new ArrayList<>());
        this.benders.put(FIRE, new ArrayList<>());
        this.benders.put(EARTH, new ArrayList<>());
    }
}
