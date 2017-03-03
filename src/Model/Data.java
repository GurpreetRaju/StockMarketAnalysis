package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.LinkedList;

import org.jfree.data.time.Day;

public class Data {
	
	public LinkedList<String[]> getData() throws Exception {
		LinkedList<String[]> linkedlist = new LinkedList<String[]>();
		
		URL oracle = new URL("http://ichart.finance.yahoo.com/table.csv?s=GOOGL&a=11&b=15&c=2016&d=11&e=27&f=2016&g=d&ignore=.csv");
        URLConnection url = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
        {
        	String[] country = inputLine.split(",");
        	linkedlist.add(country);
        }
        in.close();
		 
		return linkedlist;
	}
	
	/*public static void main(String[] args) throws Exception{
		Data dataObj = new Data();
		LinkedList<String[]> data = dataObj.getData();
		data.remove();
		while(data.size()!=0){
			String[] elt = data.remove();
			System.out.println(elt[0] + " " + Float.parseFloat(elt[1]));//pass a string date and stock price moving average value
		}*
    }*/
}
