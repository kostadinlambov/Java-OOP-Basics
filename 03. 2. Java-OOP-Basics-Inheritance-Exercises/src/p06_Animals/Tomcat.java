package p06_Animals;

public class Tomcat extends Cat {

    private static final String SOUND = "Give me one million b***h";

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (gender == null ||  !(MALE_GENDER.equals(gender))) {
            throw new IllegalArgumentException("Invalid input!");
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
