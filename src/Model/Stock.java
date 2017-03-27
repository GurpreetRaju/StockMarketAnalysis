package Model;

public class Stock {
	private String companyName;
	
	public Stock(){
	}
	
	public String getCompanyName(){
		return this.companyName;
	}

	public String getStockCode(String stock) {
		
		switch(stock){
			case "Google":
				return "GOOGL";
			case "IBM":
				return "IBM";
			case "Microsoft":
				return "MSFT";
			default:
				return "GOOGL";
		}
	}
}
