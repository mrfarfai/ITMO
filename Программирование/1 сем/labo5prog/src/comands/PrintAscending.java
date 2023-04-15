package comands;

import modals.People;
import modals.Person;

import java.util.TreeSet;

public class PrintAscending extends Command {
    public PrintAscending() {
        super("print_ascending", "Вывести элементы коллекции в порядке возрастания", false, false);
    }

    @Override
    public void execute() {
        TreeSet<Person> tree_set = new TreeSet<>(People.people);

        for (Person person : tree_set) {
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
}
