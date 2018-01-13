package p09_Google;


import java.util.ArrayList;
import java.util.List;

class Person {

    private String name;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parents> parent;
    private List<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.pokemon = new ArrayList<>();
        this.parent = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany(){
        return this.company;
    }

    List<Pokemon> getPokemon() {
        return this.pokemon;
    }

    List<Parents> getParent() {
        return this.parent;
    }

    List<Children> getChildren() {
        return this.children;
    }

    void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append("\n");
        sb.append("Company:").append("\n");
        if(company != null){
            sb.append(company).append("\n");
        }
        sb.append("Car:").append("\n");
        if(car != null){
            sb.append(car).append("\n");
        }
        sb.append("Pokemon:").append("\n");
        if(pokemon != null){
            pokemon.forEach(x -> sb.append(x).append("\n"));
        }
        sb.append("Parents:").append("\n");
        if(parent != null){
            parent.forEach(x -> sb.append(x).append("\n"));
        }
        sb.append("Children:").append("\n");
        if(children != null){
            children.forEach(x -> sb.append(x).append("\n"));
        }

        return sb.toString();
    }
}
