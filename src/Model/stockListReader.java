package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class stockListReader{
	
	private String fileName = new String();
	private LinkedList<String[]> stocklist = new LinkedList<String[]>(); 
	
	public stockListReader(String newfile){
		try {
			this.fileName = newfile;
			initializeList();
		} catch (IOException e) {
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
		BufferedReader in = new BufferedReader(new FileReader(this.fileName));
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
	public LinkedList<String[]> getList(){
		return this.stocklist;
	}

	public void saveStock(String stockName, String stockCode) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileOutputStream(new File(this.fileName),true));
		
			StringBuilder sb = new StringBuilder();
	        sb.append(stockCode);
	        sb.append(',');
	        sb.append(stockName);
	        sb.append('\n');
	        
	        pw.append(sb.toString());
	        pw.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}

	public void deleteStock(String[] delStocks) {
		for(String nstockname : delStocks){
			String newstock = nstockname;
			int i = contains(newstock);
			if(i!=-1){
				stocklist.remove(i);
			}
		}		
		try {
			PrintWriter pw = new PrintWriter(new File(this.fileName));
			
			StringBuilder sb = new StringBuilder();
			sb.append("code");
        	sb.append(',');
        	sb.append("name");
        	sb.append('\n');
	        for(String[] s:stocklist){
	        	sb.append(s[0]);
	        	sb.append(',');
	        	sb.append(s[1]);
	        	sb.append('\n');
	        	
	        }
	        pw.write(sb.toString());
	        pw.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public int contains(String newStock){
		int i = 0;
		int j = -1;
		while(i < stocklist.size()){
			if(stocklist.get(i)[1] == newStock){
				j=i;
				break;
			}
			i++;
		}
		return j;
	}
	
}
