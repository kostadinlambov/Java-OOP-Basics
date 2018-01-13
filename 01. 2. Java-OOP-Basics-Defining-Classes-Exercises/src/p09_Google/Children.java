package p09_Google;

class Children {
    private String childName;
    private String childBirthday;

    Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return String.format(childName + " " + childBirthday);
    }
}
