package fliperama;

public class Premios {
    private final String BIG_PRIZE = "Premio grande", MEDIUM_PRIZE = "Premio medio", SMALL_PRIZE = "Premio pequeno";
    private final int TICKETS_TO_BIG = 30, TICKETS_TO_MEDIUM = 20, TICKETS_TO_SMALL = 10;
    private int bigRemaining, mediumRemaining, smallRemaining;

    public Premios() {
        bigRemaining = 5;
        mediumRemaining = 10;
        smallRemaining = 20;
    }
}
