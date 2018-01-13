package exam.entities.colonists.engineers;

public class HardwareEngineer extends Engineer {

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int additionalBonus = 0;
        if (super.getAge() < 18) {
            additionalBonus += 2;
        }
        return super.getPotential() + additionalBonus;
        // return  additionalBonus;
    }
}
