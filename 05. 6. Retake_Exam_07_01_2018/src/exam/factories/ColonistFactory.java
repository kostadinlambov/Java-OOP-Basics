package exam.factories;

import exam.entities.colonists.Colonist;
import exam.entities.colonists.Soldier;
import exam.entities.colonists.engineers.HardwareEngineer;
import exam.entities.colonists.engineers.SoftwareEngineer;
import exam.entities.colonists.medics.GeneralPractitioner;
import exam.entities.colonists.medics.Surgeon;

public final class ColonistFactory {

    private ColonistFactory() {
    }

    public static Colonist createColonistMedic(String colonistClass, String colonistId, String familyId,
                                               int talent, int age, String sign) {
        switch (colonistClass) {
            case "GeneralPractitioner":
                return new GeneralPractitioner(colonistId, familyId, talent, age, sign);
            case "Surgeon":
                return new Surgeon(colonistId, familyId, talent, age, sign);
            default:
                return null;
        }
    }
    public static Colonist createColonistEngineerOrSoldier(String colonistClass, String colonistId, String familyId,
                                               int talent, int age) {
        switch (colonistClass) {
            case "SoftwareEngineer":
                return new SoftwareEngineer(colonistId, familyId, talent, age);
            case "HardwareEngineer":
                return new HardwareEngineer(colonistId, familyId, talent, age);
            case "Soldier":
                return new Soldier(colonistId, familyId, talent, age);
            default:
                return null;
        }
    }

}
