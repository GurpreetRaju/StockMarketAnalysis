package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public abstract class onlineDataReader{

    public abstract LinkedList<tick> getData(Date[] timeperiod, String companyName);

    protected String toString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = df.format(date);
        return strDate;
    }
}
