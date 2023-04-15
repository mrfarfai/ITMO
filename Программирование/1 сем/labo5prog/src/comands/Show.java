package comands;

import modals.People;
import modals.Person;

import java.util.HashSet;

public class Show extends Command {
    public Show() {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении", false, false);
    }

    @Override
    public void execute() {
        HashSet<Person> people = People.people;
        if(people.size() > 0) {
            for (Person person : people) {
                System.out.println(person.getId() + " | " +
                        person.getName() + " | " +
                        person.getCoordinates().getCoordinates() + " | " +
                        person.getCreationDate() + " | " +
                        person.getHeight() + " | " +
                        person.getBirthday() + " | " +
                        person.getHairColor() + " | " +
                        person.getNationality() + " | " +
                        ((person.getLocation() == null) ? null : person.getLocation().getLocation()));
            }
        }
        else {
            System.out.println("Коллекция пуста!");
        }
    }
}
