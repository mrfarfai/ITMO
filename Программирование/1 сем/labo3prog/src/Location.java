
public enum Location {
    IN_TRAIN("в поезде"),
    ON_PLATFORM("на перроне"),
    ON_BENCH("на лавочке");

    private String translation;

    Location(String translation) {
        this.translation = translation;
    }

    public String trans() {
        return this.translation;
    }


}
