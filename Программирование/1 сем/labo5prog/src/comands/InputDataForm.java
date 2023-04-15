package comands;
import modals.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputDataForm {

    public static ArrayList<String> executeScriptData = new ArrayList<>(7);

    public static Person inputTemporaryPerson(){
        Person person;
        if(executeScriptData.size() > 0) {
            person = executeScript("inputTemporaryPerson");
        }
        else {
            person = new Person(
                    -1,
                    inputName(),
                    inputCoordinates(),
                    java.time.ZonedDateTime.now(),
                    inputHeight(),
                    inputBirthday(),
                    inputHairColor(),
                    inputNationality(),
                    inputLocation()
            );
        }

        return person;
    }
    public static Person input(){
        Person person;
        if(executeScriptData.size() > 0) {
            person = executeScript("input");
        }
        else {
            person = new Person(
                    inputName(),
                    inputCoordinates(),
                    inputHeight(),
                    inputBirthday(),
                    inputHairColor(),
                    inputNationality(),
                    inputLocation()
            );
        }
        return person;
    }

    private static Person executeScript(String input) {
        String name;
        Coordinates coordinates;
        long height;
        java.time.LocalDateTime birthday;
        Color hairColor;
        Country nationality;
        Location location;

        try {
            System.out.println("Введите имя: " + executeScriptData.get(0));
            if (executeScriptData.get(0).length() > 0) name = executeScriptData.get(0);
            else throw new Exception();

            System.out.println("Введите координаты (формат: X;Y (X, Y - целые числа)): " + executeScriptData.get(1));
            coordinates = new Coordinates(executeScriptData.get(1));

            System.out.println("Введите рост: " + executeScriptData.get(2));
            height = Long.parseLong(executeScriptData.get(2));
            if(height < 1) throw new Exception();

            System.out.println("Введите день рождения (может быть пустым, формат: гггг-мм-дд чч:мм:сс): " + executeScriptData.get(3));
            birthday = (executeScriptData.get(3).equals("")) ? null : LocalDateTime.parse(executeScriptData.get(3), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            System.out.println("Выберите цвет волос (может быть пустым, варианты: " + executeScriptData.get(4));
            hairColor = (executeScriptData.get(4).equals("")) ? null : Color.valueOf(executeScriptData.get(4));

            System.out.println("Выберите национальность (может быть пустым, варианты: " + executeScriptData.get(5));
            nationality = (executeScriptData.get(5).equals("")) ? null : Country.valueOf(executeScriptData.get(5));

            System.out.println("Введите локацию (может быть пустым, формат: X;Y;Z (X, Z - целые числа, Y - вещественное число)): " + executeScriptData.get(6));
            location = (executeScriptData.get(6).equals("")) ? null : new Location(executeScriptData.get(6));
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
        if(input.equals("input"))
            return new Person(name, coordinates, height, birthday, hairColor, nationality, location);
        else
            return new Person(-1, name, coordinates, java.time.ZonedDateTime.now(), height, birthday, hairColor, nationality, location);
    }

    public static String inputName() {
        String name = null;
        String input = "";
        Scanner inputReader = new Scanner(System.in);

        while(name == null || name.length() < 1) {
            System.out.print("Введите имя: ");
            input = inputReader.nextLine();
            name = input;
            if(name.length() < 1) System.out.println("!!! Поле не может быть пустым !!!");
        }
        inputReader.close();
        return name;
    }
    public static Coordinates inputCoordinates(){
        Coordinates coordinates = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Введите координаты (формат: X;Y (X, Y - целые числа)): ");
                input = inputReader.nextLine();
                coordinates = new Coordinates(input);
            } catch (NumberFormatException ex) {
                System.out.println("!!! Некорректный формат !!!");
                error = true;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("!!! Введите X и Y !!!");
                error = true;
            }
        }
        inputReader.close();
        return coordinates;
    }
    public static long inputHeight(){
        long height = 0;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Введите рост: ");
                input = inputReader.nextLine();
                height = Long.parseLong(input);
                if(height < 1) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.out.println("!!! Введите целое число больше 0 !!!");
                error = true;
            }
        }
        inputReader.close();
        return height;
    }
    public static java.time.LocalDateTime inputBirthday() {
        java.time.LocalDateTime birthday = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Введите день рождения (может быть пустым, формат: гггг-мм-дд чч:мм:сс): ");
                input = inputReader.nextLine();
                birthday = (input.equals("")) ? null : LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            } catch (DateTimeParseException ex) {
                System.out.println("!!! Некорректный формат !!!");
                error = true;
            }
        }
        inputReader.close();
        return birthday;
    }
    public static Color inputHairColor(){
        Color hairColor = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Выберите цвет волос (может быть пустым, варианты: ");
                for (Color c: Color.values()) {
                    System.out.print(c.name() + " ");
                }
                System.out.print("): ");

                input = inputReader.nextLine();
                hairColor = (input.equals("")) ? null : Color.valueOf(input);
            } catch (IllegalArgumentException ex) {
                System.out.println("!!! Ведена строка не из списка !!!");
                error = true;
            }
        }
        inputReader.close();
        return hairColor;
    }
    public static Country inputNationality(){
        Country nationality = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Выберите национальность (может быть пустым, варианты: ");
                for (Country c : Country.values()) {
                    System.out.print(c.name() + " ");
                }
                System.out.print("): ");

                input = inputReader.nextLine();
                nationality = (input.equals("")) ? null : Country.valueOf(input);
            } catch (IllegalArgumentException ex) {
                System.out.println("!!! Ведена строка не из списка !!!");
                error = true;
            }
        }
        inputReader.close();
        return nationality;
    }
    public static Location inputLocation(){
        Location location = null;
        String input = "";
        boolean error = true;
        Scanner inputReader = new Scanner(System.in);

        while(error) {
            error = false;
            try {
                System.out.print("Введите локацию (может быть пустым, формат: X;Y;Z (X, Z - целые числа, Y - вещественное число)): ");
                input = inputReader.nextLine();
                location = (input.equals("")) ? null : new Location(input);
            } catch (NumberFormatException ex) {
                System.out.println("!!! Некорректный формат !!!");
                error = true;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("!!! Введите X, Y и Z !!!");
                error = true;
            }
        }
        inputReader.close();
        return location;
    }
}
