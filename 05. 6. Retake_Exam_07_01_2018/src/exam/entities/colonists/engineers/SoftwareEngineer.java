package exam.entities.colonists.engineers;

public class SoftwareEngineer extends Engineer {

    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }
    @Override
    public int getPotential() {
        int additionalBonus = 2;
        return super.getPotential() + additionalBonus ;
    }
}
