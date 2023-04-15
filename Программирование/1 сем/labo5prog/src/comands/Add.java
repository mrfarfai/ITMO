package comands;

import modals.People;
import modals.Person;

public class Add extends Command {
    public Add() {
        super("add {element}", "Добавить новый элемент в коллекцию", false, true);
    }

    @Override
    public void execute() {
        Person person = InputDataForm.input();
        if(person != null) {
            People.people.add(person);
            System.out.println("Добавлена в коллекцию.");
            SaveTMP.execute();
            People.setWasChange();
        }
        else System.out.println("!!! Ошибка !!!");
    }
}
