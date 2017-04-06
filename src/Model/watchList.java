package Model;

import java.util.ArrayList;

public class watchList extends stockComponent{
	ArrayList<stockComponent> stocklist = new ArrayList<stockComponent>();
	
	public void add(stockComponent newComponent){
		this.stocklist.add(newComponent);
	}
	
	public void remove(stockComponent newComponent){
		this.stocklist.remove(newComponent);
	}
		
	public stockComponent get(String stockName){
		for(stockComponent s: this.stocklist){
			if(stockName.equals(s.getStockName())){
				return s;
			}
		}
		return null;
	}
	
	public stockComponent get(int index){
		return this.stocklist.get(index);
	}
}
