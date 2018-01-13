package p06_Animals;

public class Kitten extends Cat{

    private static final String SOUND = "Miau";

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (gender == null ||  !(FEMALE_GENDER.equals(gender))) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
