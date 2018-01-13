package p10_Family_Tree;

class Parents {
    private String firstNameOfParent;
    private String lastNameOfParent;
    private String birthdayOfParent;

    public Parents(String firstNameOfParent, String lastNameOfParent) {
        this.firstNameOfParent = firstNameOfParent;
        this.lastNameOfParent = lastNameOfParent;
        this.birthdayOfParent = null;
    }

    public Parents(String birthdayOfParent) {
        this.birthdayOfParent = birthdayOfParent;
        this.firstNameOfParent = null;
        this.lastNameOfParent = null;
    }

    public String getFirstNameOfParent() {
        return firstNameOfParent;
    }

    public void setFirstNameOfParent(String firstNameOfParent) {
        this.firstNameOfParent = firstNameOfParent;
    }

    public String getLastNameOfParent() {
        return lastNameOfParent;
    }

    public void setLastNameOfParent(String lastNameOfParent) {
        this.lastNameOfParent = lastNameOfParent;
    }

    public String getBirthdayOfParent() {
        return birthdayOfParent;
    }

    public void setBirthdayOfParent(String birthdayOfParent) {
        this.birthdayOfParent = birthdayOfParent;
    }
}
