package comands;

import modals.People;
import modals.Person;

import java.util.Collections;
import java.util.TreeSet;

public class PrintDescending extends Command {
    public PrintDescending() {
        super("print_descending", "Вывести элементы коллекции в порядке убывания", false, false);
    }

    @Override
    public void execute() {
        TreeSet<Person> tree_set = new TreeSet<>(Collections.reverseOrder());
        tree_set.addAll(People.people);

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
