package exam.entities.colonists.engineers;

import exam.entities.colonists.Colonist;

public abstract class Engineer extends Colonist {

    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int classBonus = 3;
        int ageBonus = 0;
        if(super.getAge() > 30 ){
            ageBonus += 2;
        }
        return super.getTalent() +  classBonus + ageBonus;
    }
}
