package comands;

import modals.People;
import modals.Person;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class Save extends Command {
    public Save() {
        super("save", "Сохранить коллекцию в файл", false, false);
    }

    @Override
    public void execute() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((People.csvCollection))))) {
            String data = "";
            for (Person p: People.people) {
                StringBuilder name = new StringBuilder();
                char c;
                for (int i = 0; i < p.getName().length(); ++i) {
                    c = p.getName().charAt(i);
                    if(c == '\"') {
                        name.append("\"");
                    }
                    name.append(c);
                }
                data += p.getId() + ",\"" +
                        name + "\"," +
                        p.getCoordinates().getCoordinatesForCSV() + "," +
                        p.getCreationDate() + "," +
                        p.getHeight() + "," +
                        ((p.getBirthday() == null) ? null : p.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))) + "," +
                        ((p.getHairColor() == null) ? null : p.getHairColor().name()) + "," +
                        ((p.getNationality() == null) ? null : p.getNationality().name()) + "," +
                        ((p.getLocation() == null) ? null : p.getLocation().getLocationForCSV()) + "\n";
            }
            writer.write(data);
            new FileWriter(People.TMP_PATH, false).close();
            System.out.println("Коллекция сохранена.");
            People.setNoChange();
        } catch (Exception ex) {
            System.out.println("Возникла непредвиденная ошибка. Коллекция не может быть записана в файл. Мне жаль, что всё так вышло.");
        }
    }
}
