package exam.entities.families;

import exam.entities.colonists.Colonist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Family {
    private String id;
    private List<Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public List<Colonist> getColonists() {
        return this.colonists;
    }

    public void addColonist(Colonist colonist){
        this.colonists.add(colonist);
    }

    public void removeColonist(Colonist colonist){
        this.colonists.remove(colonist);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s:", this.id)).append(System.lineSeparator());
        colonists.stream().sorted(Comparator.comparing(Colonist::getId)).forEach(colonist -> {
            sb.append(String.format("-%s: %d", colonist.getId(), colonist.getPotential()))
                    .append(System.lineSeparator());
        });
        return sb.toString();
    }
}


