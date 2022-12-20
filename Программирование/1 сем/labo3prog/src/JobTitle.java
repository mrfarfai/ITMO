public enum JobTitle {
    conductor("Проводник"),
    railway_chief("Железнодорожный начальник");

    private String translation;

    JobTitle(String translation) {
        this.translation = translation;
    }

    public String trans() {
        return this.translation;
    }
}
