package exam.core;

import exam.entities.colonists.Colonist;
import exam.entities.colonists.Soldier;
import exam.entities.colonists.engineers.HardwareEngineer;
import exam.entities.colonists.engineers.SoftwareEngineer;
import exam.entities.colonists.medics.GeneralPractitioner;
import exam.entities.colonists.medics.Surgeon;
import exam.entities.colony.Colony;
import exam.factories.ColonistFactory;

import java.util.List;

public class Controller {

    private Colony colony;

    public Controller(Colony colony) {
        this.colony = colony;
    }


    public void insert(String colonistClass, String colonistId, String familyId,
                       int talent, int age, String sign) {
         int maxFamilyCount = colony.getMaxFamilyCount();
         int maxFamilyCapacity = colony.getMaxFamilyCapacity();

         if(maxFamilyCapacity > 0 && maxFamilyCount > 0){
             Colonist colonist = ColonistFactory.createColonistMedic( colonistClass,
                     colonistId,  familyId, talent,  age,  sign);
             colony.addColonist(colonist);
         }
    }

    public void insert(String colonistClass, String colonistId, String familyId, int talent, int age) {
        int maxFamilyCount = colony.getMaxFamilyCount();
        int maxFamilyCapacity = colony.getMaxFamilyCapacity();
        if(maxFamilyCapacity > 0 && maxFamilyCount > 0){
            Colonist colonist = ColonistFactory.createColonistEngineerOrSoldier( colonistClass,  colonistId,
                    familyId, talent,  age);
            colony.addColonist(colonist);
        }
    }


    public void remove(String modificator, String... params ) {
        String familyId = params[0];

        if(modificator.equals("colonist")){
            String colonistId = params[1];
            colony.removeColonist(familyId, colonistId);
        }else if(modificator.equals("family")){
            colony.removeFamily(familyId);
        }

    }

    public void grow(int years) {
        colony.grow(years);
    }

    public void potential() {

        System.out.println(String.format("potential: %d", this.colony.getPotential()));

    }

    public void capacity() {
        System.out.println(this.colony.getCapacity().trim());
    }

    public void family(String familyId) {
        if (this.colony.getFamilies().containsKey(familyId)) {
            System.out.println(this.colony.getFamilies().get(familyId).toString().trim());
        }else{
            System.out.println("family does not exist");
        }
    }
}

