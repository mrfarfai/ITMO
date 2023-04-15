package comands;

import modals.People;
import modals.Person;

public class FilterSartsWithName extends Command {
    public FilterSartsWithName() {
        super("filter_starts_with_name", "Вывести элементы, значение поля name которых начинается с заданной подстроки", true, false);
    }

    @Override
    public void execute() {
        for (Person person : People.people) {
            if(person.getName().startsWith(getArgument())){
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
}
