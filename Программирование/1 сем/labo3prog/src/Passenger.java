public class Passenger extends Person{
    public boolean ticket;
    Passenger(String name, boolean ticket, boolean khrapit) {
        super(name, khrapit);
        super.location = Location.IN_TRAIN;
        this.ticket = ticket;
    }
}
