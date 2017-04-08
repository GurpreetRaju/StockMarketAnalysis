package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tick {
    private Date tickDate = new Date();
    private Float data;

    public Date getDate() {
        return this.tickDate;
    }

    public void setDate(String newDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date nDate = null;
        try {
            nDate = df.parse(newDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.tickDate = nDate;
    }

    public void setDate(Date newDate) {
        this.tickDate = newDate;
    }

    public Float getData() {
        return this.data;
    }

    public void setData(String newData) {
        this.data = Float.valueOf(newData);
    }

    public void setData(float newData) {
        this.data = newData;
    }

}