package p10_Family_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> personMap = new LinkedHashMap<>();

        String[] firstInputLine = reader.readLine().split("\\s+");

        if (firstInputLine.length > 1) {
            String firstName = firstInputLine[0];
            String lastName = firstInputLine[1];
            String fullNameOfPerson = firstInputLine[0] + " " + firstInputLine[1];
            personMap.put(fullNameOfPerson, new Person(firstName, lastName));

        } else {
            String birthdayOfPersonToFind = firstInputLine[0];
            personMap.put(birthdayOfPersonToFind, new Person(birthdayOfPersonToFind));
        }

        while (true) {
            String inputLine = reader.readLine();
            if ("End".equalsIgnoreCase(inputLine)) {
                break;
            }

            if (inputLine.contains("-")) {
                String[] tokens = inputLine.split("\\s+-\\s+");

                String[] firstTokenSplit = tokens[0].split("\\s+");
                String[] secondTokenSplit = tokens[1].split("\\s+");

                switch (firstTokenSplit.length) {
                    case 2:
                        String firstName = firstTokenSplit[0];
                        String lastName = firstTokenSplit[1];
                        String parentFullName = firstName + " " + lastName;
                        if (!personMap.containsKey(parentFullName)) {
                            personMap.put(parentFullName, new Person(firstName, lastName));
                        }

                        Person person = personMap.get(parentFullName);

                        if (secondTokenSplit.length == 2) {
                            String childFirstName = secondTokenSplit[0];
                            String childLastName = secondTokenSplit[1];
                            String childFullName = childFirstName + " " + childLastName;

                            Children children = new Children(childFirstName, childLastName);
                            person.getChildren().add(children);

                            if (!personMap.containsKey(childFullName)) {
                                personMap.put(childFullName, new Person(childFirstName, childLastName));
                            }

                            Parents parent = new Parents(firstName, lastName);

                            person = personMap.get(childFullName);
                            person.getParents().add(parent);


                        } else {
                            String birthday = secondTokenSplit[0];

                            Children children = new Children(birthday);
                            person.getChildren().add(children);

                            if (!personMap.containsKey(birthday)) {
                                personMap.put(birthday, new Person(birthday));
                            }
                            Parents parent = new Parents(firstName, lastName);
                            person = personMap.get(birthday);
                            person.getParents().add(parent);

                        }
                        break;
                    case 1:
                        String birthday = firstTokenSplit[0];
                        if (!personMap.containsKey(birthday)) {
                            personMap.put(birthday, new Person(birthday));
                        }

                        Person personBirthday = personMap.get(birthday);

                        if (secondTokenSplit.length == 2) {
                            String childFirstName = secondTokenSplit[0];
                            String childLastName = secondTokenSplit[1];
                            String childFullName = childFirstName + " " + childLastName;

                            Children children = new Children(childFirstName, childLastName);

                            personBirthday.getChildren().add(children);

                            if (!personMap.containsKey(firstTokenSplit[0])) {
                                personMap.put(firstTokenSplit[0], new Person(firstTokenSplit[0]));
                            }

                            Parents parent = new Parents(firstTokenSplit[0]);

                            person = personMap.get(firstTokenSplit[0]);
                            person.getParents().add(parent);

                        } else {
                            birthday = secondTokenSplit[0];
                            Children children = new Children(birthday);
                            personBirthday.getChildren().add(children);

                            if (!personMap.containsKey(secondTokenSplit[0])) {
                                personMap.put(secondTokenSplit[0], new Person(secondTokenSplit[0]));
                            }
                            Parents parent = new Parents(firstTokenSplit[0]);
                            person = personMap.get(secondTokenSplit[0]);
                            person.getParents().add(parent);
                        }
                        break;
                }
            } else {
                String[] tokens = inputLine.split("\\s+");

                String firstName = tokens[0];
                String lastName = tokens[1];
                String fullName = firstName + " " + lastName;
                String birthDay = tokens[2];

                if (!personMap.containsKey(fullName)) {
                    personMap.put(fullName, new Person(firstName, lastName));
                }

                Person person = personMap.get(fullName);
                person.setBirthday(birthDay);
//
                for (Map.Entry<String, Person> people : personMap.entrySet()) {
                    if (birthDay.equals(people.getKey())) {
                        people.getValue().getChildren().forEach(person.getChildren()::add);
                    }
                }
            }
        }

        System.out.println();
    }
}

