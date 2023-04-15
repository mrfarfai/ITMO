package comands;

import modals.People;
import modals.Person;

import java.util.Objects;

public class Update extends Command {
    public Update() {
        super("update id {element}", "Обновить значение элемента коллекции, id которого равен заданному", true, true);
    }

    @Override
    public void execute() {
        try {
            Integer id = Integer.valueOf(getArgument());

            for (Person p : People.people) {
                if (Objects.equals(p.getId(), id)) {
                    Person person = InputDataForm.inputTemporaryPerson();
                    if(person != null) {
                        p.update(person);
                        System.out.println("Информация пользователя с ID " + id + " успешно обновлены");
                        SaveTMP.execute();
                        People.setWasChange();
                    }
                    else System.out.println("!!! Ошибка !!!");

                    return;
                }
            }

            System.out.println("!!! Пользователь с таким ID не найден !!!");
        } catch (NumberFormatException ex) {
            System.out.println("!!! Неверный формат аргумента !!!");
        }
    }
}
