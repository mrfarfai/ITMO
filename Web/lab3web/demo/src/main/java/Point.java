import java.time.LocalDateTime;
import java.util.Objects;

public class Point {
    private final int x;
    private final double y;
    private final double r;

    private final boolean isInArea;

    LocalDateTime dt;

    public Point(int x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = isInside(x, y, r);
        this.dt = LocalDateTime.now();
    }

    private boolean isInside(double x, double y, double r) {
        // Top-right quadrant
        if (x >= 0 && y >= 0) {
            return (x <= r / 2) && (y <= r);

        }
        // Top-left quadrant
        if (x < 0 && y >= 0) {
            return (x * x + y * y) <= (r * r);

        }
        // Bottom-left quadrant
        if (x < 0 && y < 0) {
            return (x >= -r / 2) && (y >= -r / 2) && (2 *y - 2*x <= r);
        }

        // Bottom-left quadrant
        return false;
    }

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isInArea() {
        return isInArea;
    }

}
