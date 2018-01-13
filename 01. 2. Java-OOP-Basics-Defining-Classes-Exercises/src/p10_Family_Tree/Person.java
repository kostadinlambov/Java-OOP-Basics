package p10_Family_Tree;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String firstName;
    private String lastName;
    private String birthday;
    private List<Parents> parents;
    private List<Children> children;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String birthday) {
        this.firstName = null;
        this.lastName = null;
        this.birthday = birthday;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
