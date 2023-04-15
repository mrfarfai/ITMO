package modals;

import java.io.File;
import java.util.Date;
import java.util.HashSet;

public class People {

    public static File csvCollection = null;
    public static final File TMP_PATH = new File("tmp.csv");
    public static HashSet<Person> people = new HashSet<>();
    private static Date initDate;

    static {
        initDate = new Date();
    }
    private static boolean wasChange = false;
    public static void setWasChange(){
        wasChange = true;
    }
    public static boolean getChange() { return wasChange;}
    public static void setNoChange(){
        wasChange = false;
    }

    public static Date getInitDate() {
        return initDate;
    }
}
