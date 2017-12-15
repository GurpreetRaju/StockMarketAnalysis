package Model;

import java.util.ArrayList;

public class watchList {
    private stockListReader reader = new stockListReader("src/watchlist.csv");
    private stockComponent stocksGroup = new stockGroup();

    public watchList() {
        //initList();
    }

    private void initList() {
        for (String[] stock : reader.getList()) {
        	System.out.println(stock[1]+ " " + stock[0]);
            stocksGroup.add(new Stock(stock[1], stock[0]));
        }
    }

    public String[][] getWatchlistEntities() {
        ArrayList<String[]> watchListEntities = new ArrayList<String[]>();
        System.out.println("Reading watchlist entities");
        int size = ((stockGroup) stocksGroup).size();
        for (int i = 0; i < size; i++) {
            Stock stock = (Stock) ((stockGroup) stocksGroup).get(i);
            String[] str = new String[2];
            str[0] = stock.getStockName();
            str[1] = stock.indicatorSignal(20100);
            watchListEntities.add(str);
        }
        String[][] data = toMultiArray(watchListEntities);
        return data;
    }

    private String[][] toMultiArray(ArrayList<String[]> list) {
        String[][] temp = new String[list.size()][2];
        for (int x = 0; x < list.size(); x++) {
            temp[x] = list.get(x);
        }
        return temp;
    }

    public void addToWatchlist(String stockName, String stockCode) {
    	if(((stockGroup) stocksGroup).get(stockName)==null){
    		reader.saveStock(stockName, stockCode);
    		stockComponent s1 = new Stock(stockName, stockCode);
    		((stockGroup) stocksGroup).add(s1);
    	}
    }

    public void removeFromWatchList(String[] delStocks) {
        reader.deleteStock(delStocks);
        for (String s : delStocks) {
            stockComponent s1 = ((stockGroup) stocksGroup).get(s);
            stocksGroup.remove(s1);
        }
    }
}
