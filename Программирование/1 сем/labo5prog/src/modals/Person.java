package modals;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Person implements Comparable<Person>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long height; //Значение поля должно быть больше 0
    private java.time.LocalDateTime birthday; //Поле может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    private static Integer lastId = 0;

    public Person(Integer id,
                  String name,
                  Coordinates coordinates,
                  java.time.ZonedDateTime creationDate,
                  long height,
                  java.time.LocalDateTime birthday,
                  Color hairColor,
                  Country nationality,
                  Location location){
        setId(id);
        this.creationDate = creationDate;
        update(name, coordinates, height, birthday, hairColor, nationality, location);
    }

    public Person(String name,
                  Coordinates coordinates,
                  long height,
                  java.time.LocalDateTime birthday,
                  Color hairColor,
                  Country nationality,
                  Location location){
        this.id = ++lastId;
        this.creationDate = java.time.ZonedDateTime.now();
        update(name, coordinates, height, birthday, hairColor, nationality, location);
    }

    private void setId(Integer id){
        this.id = id;
        lastId = Math.max(lastId, id);
    }

    public void setIdToLast(){
        this.id = ++lastId;
    }
    public void update(String name,
                       Coordinates coordinates,
                       long height,
                       java.time.LocalDateTime birthday,
                       Color hairColor,
                       Country nationality,
                       Location location){
        this.name = name;
        this.coordinates = coordinates;
        this.height = height;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;

    }

    public void update(Person p){
        update(p.getName(),
                p.getCoordinates(),
                p.getHeight(),
                p.getBirthday(),
                p.getHairColor(),
                p.getNationality(),
                p.getLocation());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public long getHeight() {
        return height;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int compareTo(Person p) {
        return (int) (this.name.compareTo(p.getName()) +
                (this.coordinates.hashCode() - p.coordinates.hashCode()) +
                (this.height - p.height));
    }

}