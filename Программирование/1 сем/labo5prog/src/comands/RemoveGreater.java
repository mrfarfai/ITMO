package comands;

import modals.People;
import modals.Person;

public class RemoveGreater extends Command {
    public RemoveGreater() {
        super("remove_greater {element}", "Удалить из коллекции все элементы, превышающие заданный", false, true);
    }

    @Override
    public void execute() {
        if(People.people.size() > 0) {
            Person person = InputDataForm.inputTemporaryPerson();

            if(person != null) {
                int removeCount = 0;
                for (Person p : People.people) {
                    if(p.compareTo(person) > 0) {
                        People.people.remove(p);
                        removeCount++;
                    }
                }

                System.out.println("Удалено " + removeCount + " колекции.");
                if(removeCount > 0) {
                    SaveTMP.execute();
                    People.setWasChange();
                }
            }
            else System.out.println("!!! Ошибка !!!");

        }
        else System.out.println("Элемент не с чем сравнивать. Коллекция пуста.");
    }
}
