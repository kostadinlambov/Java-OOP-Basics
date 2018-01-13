package exam.entities.colonists.medics;

public class Surgeon extends Medic {

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int ageBonus = 0;
        int classBonus = 0;

        if(super.getAge() > 25 && super.getAge() < 35){
            ageBonus += 2;
        }

        if("precise".equals( super.getSign())){
            classBonus += 3;
        }else if("butcher".equals( super.getSign())){
            classBonus -= 3;
        }

        int totalBonus = ageBonus + classBonus;
        return  super.getPotential() + totalBonus;
        // return  totalBonus;
    }
}
