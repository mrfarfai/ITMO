import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "data_record")
public class DataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int x;
    private double y;
    private double r;
    private boolean result;
    private LocalDateTime dt;

    public DataRecord() {}
    public DataRecord(int x, double y, double r, boolean result) {
        try {
            this.x = x;
            this.y = y;
            this.r = r;
            this.result = result;
        } catch (Exception e) {
            this.x = 0;
            this.y = 0.0;
            this.r = 0.0;
            this.result = true;
        }

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult(){
        return result;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    // toString (опционально)
    @Override
    public String toString() {
        return "DataRecord{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result=" + result +
                ", dt=" + dt +
                '}';
    }


}
