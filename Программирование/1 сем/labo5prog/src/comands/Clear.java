package comands;

import modals.People;

public class Clear extends Command {
    public Clear() {
        super("clear", "Очистить коллекцию", false, false);
    }

    @Override
    public void execute() {
        People.people.clear();
        System.out.println("Коллекция очищена.");
        SaveTMP.execute();
        People.setWasChange();
    }
}
