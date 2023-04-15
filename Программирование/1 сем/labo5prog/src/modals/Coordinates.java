package modals;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Максимальное значение поля: 663, Поле не может быть null

    public Coordinates(String s) {
        String[] xy = s.split(";");
        this.x = Long.valueOf(xy[0]);
        this.y = Integer.valueOf(xy[1]);
    }

    public String getCoordinates(){
        return x + " : " + y;
    }

    public String getCoordinatesForCSV() {
        return x + ";" + y;
    }
}