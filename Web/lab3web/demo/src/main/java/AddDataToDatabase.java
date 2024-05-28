import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddDataToDatabase {
    public AddDataToDatabase (Point point){
        DataRecord record = new DataRecord();

        record.setX(point.getX());
        record.setY(point.getY());
        record.setR(point.getR());
        record.setResult(point.isInArea());
        record.setDt(point.dt);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(record);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
