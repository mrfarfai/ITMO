package comands;

import modals.People;
import modals.Person;

import java.util.Objects;

public class RemoveById extends Command {
    public RemoveById() {
        super("remove_by_id id", "Удалить элемент из коллекции по его id", true, false);
    }

    @Override
    public void execute() {
        try {
            Integer id = Integer.valueOf(getArgument());
            for(Person p : People.people) {
                if(Objects.equals(p.getId(), id)) {
                    People.people.remove(p);
                    System.out.println("Пользователь с ID " + id + " удалён");
                    SaveTMP.execute();
                    People.setWasChange();
                    return;
                }
            }
            System.out.println("!!! Пользователь с таким ID не найден !!!");
        } catch (NumberFormatException ex) {
            System.out.println("!!! Неверный формат аргумента !!!");
        }
    }
}
