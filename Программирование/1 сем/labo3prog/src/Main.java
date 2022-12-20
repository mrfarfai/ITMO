public class Main {
    public static void main(String[] args) {
        Passenger Skuperfild = new Passenger("Скуперфильд", false, true);
        RailwayWorkers Conductor = new RailwayWorkers("Проводник", JobTitle.conductor, Location.IN_TRAIN);
        RailwayWorkers Chief = new RailwayWorkers("Начальник", JobTitle.railway_chief, Location.ON_PLATFORM);

        Conductor.check_ticket(Skuperfild);
        Chief.check_person(Skuperfild);
        Skuperfild.think("думает...");
        Skuperfild.goTo("город");

        System.out.println("\nИнформации " + Skuperfild.name + ":");
        System.out.println("\t" + Skuperfild.toString() + " (toString)");
        System.out.println("\tequals to Chief: " + Skuperfild.equals(Chief));
        System.out.println("\thashCode: " + Skuperfild.hashCode());

    }
}