package p09_Google;

class Parents {
    private String parentName;
    private String parentBirthday;

    Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format(parentName + " " + parentBirthday);
    }
}
