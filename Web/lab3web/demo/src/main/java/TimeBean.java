import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@ApplicationScoped
public class TimeBean {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public String getCurrentTime() {
        return sdf.format(new Date());
    }
}
