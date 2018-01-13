package p10_Family_Tree;

class Children {
    private String firstName;
    private String lastName;
    private String birthdayOfChild;

    public Children(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayOfChild = null;
    }

    public Children(String birthdayOfChild) {
        this.birthdayOfChild = birthdayOfChild;
        this.firstName = null;
        this.lastName = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdayOfChild() {
        return birthdayOfChild;
    }

    public void setBirthdayOfChild(String birthdayOfChild) {
        this.birthdayOfChild = birthdayOfChild;
    }
}
