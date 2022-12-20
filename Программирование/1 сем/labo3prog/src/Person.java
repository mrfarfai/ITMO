public abstract class Person implements PersonInt {
    public String name;
    public Location location;
    private int energy = 100;
    private int angry_lvl = 0;
    private boolean khrapit = false;

    private boolean is_sleep = false;

    Person(String name, boolean khrapit){
        this.name = name;
        this.khrapit = khrapit;
    }

    public void look(String look){
        System.out.println(this.name + " видит " + look);
    }

    public void say(String text, Person person){
        System.out.println(this.name + " сказал " + person.name + " " + text);
    }

    public void hungry(int hungry){
        System.out.println(this.name + " голоден!");
        this.energy -= hungry;
        if(this.energy < 25) {
            sleep();
        }
    }

    public void tired(int tired){
        System.out.println(this.name + " устал!");
        this.energy -= tired;
        if(this.energy < 25) {
            sleep();
        }
    }

    public void angry(int angry_lvl) {
        this.angry_lvl = this.angry_lvl + angry_lvl;
        if(angry_lvl > 0) {
            System.out.println(this.name + " злой!");
            this.energy -= 50;
        }
    }

    public void sleep() {
        if(!is_sleep) {
            System.out.println(this.name + " хочет спать...");
            if(this.location == Location.IN_TRAIN){
                System.out.println(this.name + " уснул в купе");
            }
            else if(this.location == Location.ON_PLATFORM){
                this.location = Location.ON_BENCH;
                System.out.println(this.name + " уснул " + this.location.trans());
            }

            if(this.khrapit) {
                System.out.println(this.name + " храпит )))");
            }

            this.is_sleep = true;
        }
    }

    public boolean isSleep() {
        return this.is_sleep;
    }

    public void toWake(Person person) {
        System.out.println(this.name + " разбудил " + person.name);
        say("спать здесь не полагается!", person);
        person.toWakeUp();
    }

    public void toWakeUp() {
        System.out.println(this.name + " проснулсся!");
        this.is_sleep = false;
        this.energy += 50;
    }

    public void think(String text){
        System.out.println(this.name + " " + text);
    }

    public void goTo(String text){
        System.out.println(this.name + " идёт в " + text);
    }

    @Override
    public String toString(){
        return "имя: " + this.name;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;

        return name.equals(person.name) && location == person.location && energy == person.energy;

    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (location == null ? 0 : location.hashCode());
        return hash;
    }
}
