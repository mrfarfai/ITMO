package comands;

import java.util.HashMap;
public class ComandsManager {
    private static HashMap<String, Command> comands;

    static {
        comands = new HashMap<>();
        comands.put("help", new Help());
        comands.put("info", new Info());
        comands.put("show", new Show());
        comands.put("add", new Add());
        comands.put("update", new Update());
        comands.put("remove_by_id", new RemoveById());
        comands.put("clear", new Clear());
        comands.put("save", new Save());
        comands.put("execute_script", new ExecuteScript());
        comands.put("exit", new Exit());
        comands.put("add_if_min", new AddIfMin());
        comands.put("remove_greater", new RemoveGreater());
        comands.put("remove_lower", new RemoveLower());
        comands.put("filter_starts_with_name", new FilterSartsWithName());
        comands.put("print_ascending", new PrintAscending());
        comands.put("print_descending", new PrintDescending());

    }

    public static HashMap<String, Command> getComands() {
        return comands;
    }
}
