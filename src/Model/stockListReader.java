package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class stockListReader{

private LinkedList<String[]> stocklist = new LinkedList<String[]>(); 
	
	public stockListReader(){
		try {
			initializeList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStockCode(String stock) {
		for( String[] s : stocklist ){
			if(s[1].equals(stock)){
				return stocklist.get(stocklist.indexOf(s))[0];
			}
		}
		return null;
	}
	
	private void initializeList() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("src/stocklist.csv"));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
        {
        	String[] line = inputLine.split(",");
        	System.out.println(line[0]+ " " +line[1]);
        	stocklist.add(line);
        }
        stocklist.removeFirst();
        in.close();
	}

	public String[] getStockList() {
		int size = stocklist.size();
		String[] list = new String[size];
		int i=0;
		while(i<size){
			list[i] = stocklist.get(i)[1];
			i++;
		}
		return list;
	}
	
}
