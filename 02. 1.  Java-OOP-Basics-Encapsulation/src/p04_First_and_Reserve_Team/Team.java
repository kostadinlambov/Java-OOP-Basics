package p04_First_and_Reserve_Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;


    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    void addPlayer(Person person){
        if(person.getAge() < 40){
            this.firstTeam.add(person);
        }else{
            this.reserveTeam.add(person);
        }
    }

    List<Person> getFirstTeam(){
        return Collections.unmodifiableList(this.firstTeam);
    }

    List<Person> getReserveTeam(){
        return Collections.unmodifiableList(this.reserveTeam);
    }
}
