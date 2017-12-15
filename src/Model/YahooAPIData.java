package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.LinkedList;

public class YahooAPIData extends onlineDataReader {
	

    public LinkedList<tick> getData(Date[] timeperiod, String companyName) {
        LinkedList<tick> dataList = new LinkedList<tick>();

        String[] datefrom = (toString(timeperiod[0])).split(",");// format MM,DD,YYYY

        String[] dateto = (toString(timeperiod[1])).split(",");//format MM,DD,YYYY
        dateto[0] = Integer.toString(Integer.parseInt(dateto[0])-1);
        datefrom[0] = Integer.toString(Integer.parseInt(datefrom[0])-1);

        String urlString = "https://ichart.finance.yahoo.com/table.csv?s=" + companyName + "&a=" + datefrom[0] + "&b=" + datefrom[1] + "&c=" + datefrom[2] + "&d=" + dateto[0] + "&e=" + dateto[1] + "&f=" + dateto[2] + "&g=d&ignore=.csv";
        //System.out.println(urlString);
        URL oracle;
        try{
            oracle = new URL(urlString);

            URLConnection url = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
            String inputLine;
            int i = 0;
            while ((inputLine = in.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                String[] line = inputLine.split(",");
                System.out.println(line[0] + " " + line[4]);
                tick newtick = new tick();

                newtick.setDate(line[0]);
                newtick.setData(line[4]);
                dataList.add(newtick);
            }
            
            in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Data class list size "+dataList.size());
        return dataList;
    }
	
}
