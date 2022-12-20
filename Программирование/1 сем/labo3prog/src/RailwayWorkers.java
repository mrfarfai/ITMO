public class RailwayWorkers extends Person implements RailwayWorkersInt{
    private JobTitle job_title;
    RailwayWorkers(String name, JobTitle job_title, Location location) {
        super(name, false);
        super.location = location;
        this.job_title = job_title;
    }

    public void check_ticket(Passenger passenger){
        if(!passenger.ticket) {
            passenger.location = Location.ON_PLATFORM;
            System.out.println(job_title.trans() + " высадил из вагона " + passenger.name);
            passenger.angry(50);
            passenger.tired(15);
            passenger.hungry(15);
        }
    }

    public void check_person(Person person){
        if(person.location == Location.ON_BENCH && person.isSleep()) {
            super.toWake(person);
        }
    }
}
