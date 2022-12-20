public interface PersonInt {
    void look(String look);
    void say(String text, Person person);
    void hungry(int hungry);
    void tired(int tired);
    void angry(int angry_lvl);
    void sleep();
    boolean isSleep();
    void toWake(Person person);
    void toWakeUp();
    void think(String text);
    void goTo(String text);
}
