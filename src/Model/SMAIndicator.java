package Model;

import java.util.LinkedList;

public class SMAIndicator{
	
	private boolean buySignal = false;
	private boolean sellSignal = false;

	//public SMAIndicator() {	}
	
	public LinkedList<String[]> calculateMA(LinkedList<String[]> data, int n){
		LinkedList<String[]> listMA = new LinkedList<String[]>();
		int j = data.size() - 1;
		while(j>n){
			System.out.println("calculateMA iteration: " + j);
			float addition = sum(data,j,j-n+1);
			float average = addition/n;
			System.out.println("average " + average);
			String[] node = new String[2];
			String[] date = data.get(j-n+1);
			node[0] = date[0];
			System.out.println("date " + node[0]);
			node[1] = String.valueOf(average);
			listMA.add(node);
			System.out.println("node added to listMA");
			j--;
		}
		
		setIndicator(data.getLast(),listMA.getLast(),listMA.get(listMA.size()-2));
		
		return listMA;
	}
	
	
	private void setIndicator(String[] price, String[] currentAv, String[] prevAv){
		if(Float.valueOf(prevAv[1])<Float.valueOf(currentAv[1]) && Float.valueOf(currentAv[1])<Float.valueOf(price[1])){
			buySignal = true;
			sellSignal = false;
		}
		else if(Float.valueOf(prevAv[1])>Float.valueOf(currentAv[1]) && Float.valueOf(currentAv[1])>Float.valueOf(price[1])){
			buySignal = false;
			sellSignal = true;
		}
	}
	
	public boolean getBuySignal(){
		return buySignal;
	}
	
	public boolean getSellSignal(){
		return sellSignal;
	}
	
	private Float sum(LinkedList<String[]> data,int i,int k){
		String[] value = data.get(i);
		if(i==k){
			return Float.parseFloat(value[4]);
		}
		return Float.parseFloat(value[4]) + sum(data,i-1,k);
	}
	
}
