package comands;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import modals.FileReader;
import modals.People;

public class ExecuteScript extends Command {

    private static Set<String> executeSet = new HashSet<String>();
    public ExecuteScript() {
        super("execute_script file_name", "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме", true, false);
    }

    public void executeScript(BufferedReader inputStreamReader) throws IOException {
        System.out.println("Выполнение команд.");
        String nextLine;;
        String[] tokens;
        boolean data = false;

        Command cmd = null;
        while ((nextLine = inputStreamReader.readLine()) != null) {
            tokens = nextLine.trim().split(" ", 2);

            if(data) {
                InputDataForm.executeScriptData.add(nextLine);
                if(InputDataForm.executeScriptData.size() == 7) {
                    data = false;
                    cmd.execute();
                    InputDataForm.executeScriptData.clear();
                }
                continue;
            }
            if (ComandsManager.getComands().containsKey(tokens[0])) {
                cmd = ComandsManager.getComands().get(tokens[0]);
                System.out.println(nextLine);
                if(cmd.isWithInput()) data = true;
                if(cmd.isWithArgument()) {
                    try {
                        if (tokens.length > 1) cmd.setArgument(tokens[1]);
                        else throw new NullPointerException();
                    } catch (NullPointerException e) {
                        data = false;
                        System.out.println("У команды должен быть аргумент! Подробно можно узнать по команде help.");
                    }
                }
                if(!data) cmd.execute();

            } else {
                System.out.println("Команда не найдена. Мануал по командам - команда help");
            }
        }
        if(InputDataForm.executeScriptData.size() != 0) {
            System.out.println("!!! Не хватает данных на файле !!!");
            InputDataForm.executeScriptData.clear();
        }
    }

    @Override
    public void execute() {
        if(!executeSet.contains(getArgument())) {
            executeSet.add(getArgument());
            File file;
            try {
                file = new File(getArgument());
            } catch (NullPointerException e) {
                System.out.println("Файл не найден!");
                return;
            }

            if (!FileReader.check(file)) return;

            try (BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                System.out.println("Чтение из файла " + People.csvCollection.getAbsolutePath());

                executeScript(inputStreamReader);
                executeSet.remove(getArgument());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Упс, такой файл уже запущен. Рекурсия ЗАПРЕЩЕНА!!!");
        }
    }
}
