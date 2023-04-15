package comands;

import java.util.HashMap;

public class Help extends Command {
    public Help() {
        super("help", "Вывести справку по доступным командам", false, false);
    }

    @Override
    public void execute() {
        HashMap<String, Command> comands =  ComandsManager.getComands();
        for (String name: comands.keySet()) {
            String key = comands.get(name).getName();
            String value = comands.get(name).getDescription();
            System.out.println(key + ":\n- " + value + "\n");
        }
    }
}
