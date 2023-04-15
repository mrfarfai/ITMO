package comands;

import modals.People;

public class Info extends Command {
    public Info() {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", false, false);
    }

    @Override
    public void execute() {
        System.out.println("Тип коллекции: " + People.people.getClass() +
                "\nДата инициализации: " + People.getInitDate() +
                "\nКоличество элементов: " + People.people.size());
    }
}
