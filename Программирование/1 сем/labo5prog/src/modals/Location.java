package modals;

public class Location {
    private Integer x; //Поле не может быть null
    private double y;
    private int z;

    public Location(String s) {
        String[] xyz = s.split(";");
        this.x = Integer.valueOf(xyz[0]);
        this.y = Double.parseDouble(xyz[1]);
        this.z = Integer.parseInt(xyz[2]);

    }

    public String getLocation() {
        return x + " : " + y + " : " + z;
    }

    public String getLocationForCSV() {
        return x + ";" + y + ";" + z;
    }
}