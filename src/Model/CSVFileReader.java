package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileReader;
import java.util.Date;
import java.util.LinkedList;

public class CSVFileReader implements Data {
	private String file = "src/Sample data.csv";
    public LinkedList<tick> getData() {
        LinkedList<tick> dataList = new LinkedList<tick>();
        try{        
        	BufferedReader in = new BufferedReader(new FileReader(this.file));
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

        		newtick.setDate(toDate(line[0]));
        		newtick.setData(line[4]);
        		dataList.add(newtick);
        	}
        	in.close();
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        return dataList;
    }
    private Date toDate(String newDate){
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	Date nDate = null;
    	try {
    		nDate = df.parse(newDate);
    	} catch (ParseException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		return nDate;
    }
}