package comands;

import modals.People;
import modals.Person;

public class AddIfMin extends Command {
    public AddIfMin() {
        super("add_if_min {element}", "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции", false, true);
    }

    @Override
    public void execute() {
        if(People.people.size() > 0) {

            Person person = InputDataForm.inputTemporaryPerson();
            if(person != null) {
                Person minPerson = People.people.iterator().next();
                for(Person p : People.people) {
                    if(minPerson.compareTo(p) > 0) {
                        minPerson = p;
                    }
                }

                if(minPerson.compareTo(person) > 0) {
                    person.setIdToLast();
                    People.people.add(person);
                    System.out.println("Элемент успешно добавлен.");
                    SaveTMP.execute();
                    People.setWasChange();
                }
                else System.out.println("Не удалось добавить элемент.");
            }

            else System.out.println("!!! Ошибка !!!");

        }
        else System.out.println("Элемент не с чем сравнивать. Коллекция пуста.");
    }
}
