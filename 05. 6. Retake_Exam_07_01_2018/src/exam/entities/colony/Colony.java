package exam.entities.colony;

import exam.entities.colonists.Colonist;
import exam.entities.families.Family;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    //private List<Family> families;
    private Map<String, Family> families;


    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        // this.families = new ArrayList<>();
        this.families = new LinkedHashMap<>();
    }


    public Map<String, Family> getFamilies() {
        return Collections.unmodifiableMap(this.families);
    }


    public List<Colonist> getColonistsByFamilyId(String familyId) {

        Family family = families.get(familyId);

        List<Colonist> colonists = family.getColonists().stream()
                .sorted(Comparator.comparing(Colonist::getId))
                .collect(Collectors.toList());

        return colonists;
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public void addColonist(Colonist colonist) {

        if (!families.containsKey(colonist.getFamilyId())) {
            if (families.size() == this.maxFamilyCount) {
                System.out.println("colony is full");
            }else{
                Family family = new Family(colonist.getFamilyId());
                families.put(family.getId(), family);
                this.families.get(colonist.getFamilyId()).getColonists().add(colonist);
            }

        } else if (this.families.get(colonist.getFamilyId()).getColonists().size() == this.getMaxFamilyCapacity()) {
            System.out.println("family is full");
        } else {
//            this.families.get(colonist.getFamilyId()).addColonist(colonist);
            this.families.get(colonist.getFamilyId()).getColonists().add(colonist);
        }

    }

    public void removeColonist(String familyId, String memberId) {

        if (families.containsKey(familyId)) {
            List<Colonist> colonistList = this.families.get(familyId).getColonists();

            if (colonistList.size() > 0) {
                colonistList.removeIf(x -> x.getId().equals(memberId));

                if (colonistList.size() == 0) {
                    this.removeFamily(familyId);
                }
            }
        }
    }

//    public void addFamily(String id) {
//        Family family = new Family(id);
//        families.put(id, family);
////        Family family = this.families.stream()
////                .filter(x -> x.getId().equals(id)).findFirst().get();
////        this.families.remove(family);
//    }


    public void removeFamily(String id) {
        if (this.families.containsKey(id)) {
            this.families.remove(id);
        }
    }


//    public List<Colonist> getColonistsByFamilyId(String familyId){
//
//        return null;
//    }


    public void grow(int years) {
        this.families.forEach((key, value) -> value.getColonists().forEach(colonist -> {
            colonist.grow(years);
        }));
    }

    public int getPotential() {
        final int[] totalPotential = {0};

        this.families.entrySet().forEach(family ->{
            family.getValue().getColonists().stream().forEach(colonist -> {
               totalPotential[0] += colonist.getPotential();
            });
        });

        return totalPotential[0];

//        return this.families.entrySet().stream()
//                .mapToInt(x -> x.getValue().getColonists().stream()
//                        .mapToInt(Colonist::getPotential).sum()).sum();
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d", this.families.size(), this.maxFamilyCount))
                .append(System.lineSeparator());

        this.families.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(family -> {
            sb.append(String.format("-%s: %d/%d", family.getValue().getId(),
                    family.getValue().getColonists().size(), this.maxFamilyCapacity))
                    .append(System.lineSeparator());
        });
        return sb.toString();

    }
}
