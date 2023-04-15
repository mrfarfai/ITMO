import comands.ComandsManager;
import comands.Command;
import modals.FileReader;
import modals.LoadCollection;
import modals.People;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        String collectionPath = System.getenv("labo5prog_data");
        try {
            if (collectionPath == null) throw new FileNotFoundException();
        } catch (FileNotFoundException ex) {
            System.out.println("Путь до файла csv нужно передать через переменную окружения labo5prog_data !");
            System.exit(1);
        }

        if(FileReader.check(new File(collectionPath))) {
            People.csvCollection = new File(collectionPath);
            if(!People.TMP_PATH.exists()) {
                new FileWriter(People.TMP_PATH, false).close();
            }

            String tmpAns = "";
            try{
                if (People.TMP_PATH.length() > 0) {
                    System.out.print("У вас есть не сохранённые данные. ");
                    Scanner tmpScan = new Scanner(System.in);
                    while(!tmpAns.equals("y") && !tmpAns.equals("n")) {
                        System.out.print("Хотите восстановить ? (y/n): ");
                        tmpAns = tmpScan.next();
                    }
                }

            } catch (Exception e) {}

            if(tmpAns.equals("y")) {
                LoadCollection.load(People.TMP_PATH);
                People.setWasChange();
            }
            else {
                try{
                    new FileWriter(People.TMP_PATH, false).close(); // Очистка файла tmp
                } catch (Exception e) {}

                LoadCollection.load(People.csvCollection);
            }

            try(Scanner commandReader = new Scanner(System.in)) {
                String userCommand;
                String[] tokens;
                while (true) {
                    userCommand = commandReader.nextLine();
                    tokens = userCommand.trim().split(" ", 2);

                    if(tokens[0].equals("")) continue;

                    if (ComandsManager.getComands().containsKey(tokens[0])) {
                        Command cmd = ComandsManager.getComands().get(tokens[0]);
                        if(cmd.isWithArgument()) {
                            try {
                                if (tokens.length > 1) cmd.setArgument(tokens[1]);
                                else throw new NullPointerException();
                            } catch (NullPointerException e) {
                                System.out.println("У команды должен быть аргумент! Подробно можно узнать по команде help.");
                            }

                        }

                        cmd.execute();

                    } else {
                        System.out.println("Команда не найдена. Мануал по командам - команда help");
                    }
                }
            } catch (NoSuchElementException ex) {
                System.out.println(ex);
            }

        }
    }
}