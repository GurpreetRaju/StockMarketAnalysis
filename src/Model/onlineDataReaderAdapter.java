package Model;

import java.util.Date;
import java.util.LinkedList;

public class onlineDataReaderAdapter  implements Data {
	
	private Date[] timeperiod = new Date[2];
	private String stockCode = new String();
	private onlineDataReader reader = new onlineDataReader();
	
	public onlineDataReaderAdapter(Date[] newtimePeriod, String newstockCode) {
		this.timeperiod = newtimePeriod;
		this.stockCode = newstockCode;
	}

	@Override
	public LinkedList<tick> getData() {
		return reader.getData(this.timeperiod, this.stockCode);
	}

}
