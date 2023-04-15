package comands;

import modals.People;

import java.io.FileWriter;
import java.util.Scanner;

public class Exit extends Command {
    public Exit() {
        super("exit", "Завершить программу", false, false);
    }

    @Override
    public void execute() {
        if(People.getChange()) {
            Scanner save = new Scanner(System.in);
            String ans = "";
            while(!ans.equals("y") && !ans.equals("n")) {
                System.out.print("Вы не сохранили. Хотите ли вы сохранить (y/n): ");
                ans = save.nextLine();
            }
            if(ans.equals("y")) new Save().execute();
            try {
                new FileWriter(People.TMP_PATH, false).close();
            } catch (Exception e) {}

        }
        System.exit(0);
    }
}
