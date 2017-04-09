package Model;

import java.util.LinkedList;

public class SMAIndicator {

    private int MADays;
    private LinkedList<tick> listMA = new LinkedList<tick>();

    public SMAIndicator(LinkedList<tick> newdata, int newMA) {
        this.MADays = newMA;
        calculateMA(newdata, this.MADays);
    }

    public LinkedList<tick> getMAList() {
        return listMA;
    }

    private void calculateMA(LinkedList<tick> data, int n) {
        int j = data.size() - 1;
        while (j > n) {
            //System.out.println("calculateMA iteration: " + j);
            float addition = sum(data, j, j - n + 1);
            float average = addition / n;
            //System.out.println("average " + average);
            tick newNode = new tick();
            tick dataNode = data.get(j - n + 1);
            newNode.setDate(dataNode.getDate());
            newNode.setData(average);
            listMA.add(newNode);
            //System.out.println("node added to listMA");
            j--;
        }
        //setIndicator(data.getFirst(),listMA.getLast(),listMA.get(listMA.size()-2));
    }

    public int getType() {
        return MADays;
    }

    public tick get(int index) {
        return listMA.get(index);
    }

    public tick getSameDateNode(tick rt) {
        for (tick t : listMA) {
            if (t.getDate().equals(rt.getDate())) {
                //System.out.print("Function called getsamedatenode");
                return t;
            }
        }
        return listMA.get(listMA.size() - 1);
    }

    public int size() {
        return listMA.size();
    }

    private Float sum(LinkedList<tick> data, int i, int k) {
        tick value = data.get(i);
        if (i == k) {
            return value.getData();
        }
        return value.getData() + sum(data, i - 1, k);
    }
//	public static void main(String[] Arg){
//		Date[] timePeriod = new Date[2]; 
//		Calendar cal = Calendar.getInstance();
//		timePeriod[1] = cal.getTime();
//		cal.add(Calendar.YEAR, -1); // http://stackoverflow.com/questions/14946886/store-current-date-and-date-1-year-from-current-in-java
//		timePeriod[0] = cal.getTime();
//		Data data = new onlineDataReader();
//		LinkedList<tick> newtick = data.getData(timePeriod, "GOOGL");
//		SMAIndicator sma = new SMAIndicator(newtick, 20);
//		tick ntick = sma.getSameDateNode(newtick.getFirst());
//		System.out.println(ntick.getData() + " " + ntick.getDate());
//	}
}
