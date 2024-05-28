import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DataBean implements Serializable {
    private List<DataRecord> records;

    @PostConstruct
    public void init() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        records = session.createQuery("from DataRecord order by dt desc", DataRecord.class).list();

        session.close();
        sessionFactory.close();
    }

    public List<DataRecord> getRecords() {
        return records;
    }

    public DataRecord getLast(){
        try {
            return records.get(0);
        } catch (Exception e) {
            return new DataRecord(0, 0.0, 0.0, true);
        }

    }
}
