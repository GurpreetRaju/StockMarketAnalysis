package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.LinkedList;

public class GoogleAPIData extends onlineDataReader {

	@Override
	public LinkedList<tick> getData(Date[] timeperiod, String companyName) {
		
		LinkedList<tick> dataList = new LinkedList<tick>();

        String[] datefrom = (toString(timeperiod[0])).split("-");// format yyyy-MM-dd

        String[] dateto = (toString(timeperiod[1])).split("-");// format yyyy-MM-dd
        int monthTo = Integer.parseInt(dateto[1]);
        int monthfrom = Integer.parseInt(datefrom[1]);

        String urlString = "https://finance.google.com/finance/historical?q="+companyName+"&startdate="+datefrom[2]+"-"+new DateFormatSymbols().getMonths()[monthfrom-1]+"-"+datefrom[0]+"&output=csv";
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

                newtick.setDate(toString(new Date(line[0])));
                newtick.setData(line[4]);
                dataList.add(newtick);
            }
            
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data class list size "+dataList.size());
        return dataList;
	}
	
}
