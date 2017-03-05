package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

public class Data {
	
	public LinkedList<String[]> getData(String[] timeperiod) throws Exception {
		LinkedList<String[]> linkedlist = new LinkedList<String[]>();
		
		String[] datefrom = timeperiod[0].split(",");// format MM,DD,YYYY
		String[] dateto = timeperiod[1].split(",");//format MM,DD,YYYY
		String urlString = "http://ichart.finance.yahoo.com/table.csv?s=GOOGL&a="+ datefrom[0] +"&b=" + datefrom[1] + "&c=" + datefrom[2] + "&d=" + dateto[0] + "&e=" + dateto[1] + "&f=" + dateto[2] + "&g=d&ignore=.csv";
		System.out.println(urlString);
		URL oracle = new URL(urlString);
        URLConnection url = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
        {
        	String[] country = inputLine.split(",");
        	linkedlist.add(country);
        }
        in.close();
        linkedlist.removeFirst();
		 
		return linkedlist;
	}
}