package Model;

import java.util.LinkedList;

public class SMAIndicator{
	
	private boolean buySignal = false;
	private boolean sellSignal = false;

	//public SMAIndicator() {	}
	
	public LinkedList<tick> calculateMA(LinkedList<tick> data, int n){
		LinkedList<tick> listMA = new LinkedList<tick>();
		int j = data.size() - 1;
		while(j>n){
			System.out.println("calculateMA iteration: " + j);
			float addition = sum(data,j,j-n+1);
			float average = addition/n;
			System.out.println("average " + average);
			tick newNode = new tick();
			tick dataNode = data.get(j-n+1);
			newNode.setDate(dataNode.getDate());
			newNode.setData(average);
			listMA.add(newNode);
			System.out.println("node added to listMA");
			j--;
		}
		setIndicator(data.getFirst(),listMA.getLast(),listMA.get(listMA.size()-2));
		return listMA;
	}
	
	
	private void setIndicator(tick currentData, tick currentAv, tick recentAv){
		System.out.println(recentAv.getData() + " " + currentAv.getData() + " " + currentData.getData());
		if(recentAv.getData()<currentAv.getData() && currentAv.getData()<currentData.getData()){
			buySignal = true;
			sellSignal = false;
		}
		else if(recentAv.getData()>currentAv.getData() && currentAv.getData()>currentData.getData()){
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
	
	private Float sum(LinkedList<tick> data,int i,int k){
		tick value = data.get(i);
		if(i==k){
			return value.getData();
		}
		return value.getData() + sum(data,i-1,k);
	}


	public String indicatorSignal() {
		boolean buy = this.getBuySignal();
		boolean sell = this.getSellSignal();
		if(buy){
			return "buy";
		}
		else if(sell){
			return "sell";
		}
		else{
			return "none";
		}
	}
	
}
