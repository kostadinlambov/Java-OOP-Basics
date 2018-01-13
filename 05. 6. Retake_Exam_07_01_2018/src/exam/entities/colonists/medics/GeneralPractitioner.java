package exam.entities.colonists.medics;

public class GeneralPractitioner extends Medic {

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int ageBonus = 0;
        int classBonus = 0;

        if (super.getAge() > 15) {
            ageBonus += 1;
        }

        if ("caring".equals(super.getSign())) {
            classBonus += 1;
        } else if ("careless".equals(super.getSign())) {
            classBonus -= 2;
        }

        int totalBonus = ageBonus + classBonus;
        return super.getPotential() + totalBonus;
    }

}
