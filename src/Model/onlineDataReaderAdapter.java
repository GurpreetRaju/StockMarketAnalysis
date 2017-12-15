package Model;

import java.util.Date;
import java.util.LinkedList;

public class onlineDataReaderAdapter  implements Data {
	
	private Date[] timeperiod = new Date[2];
	private String stockCode = new String();
	private onlineDataReader reader;
	
	public onlineDataReaderAdapter(Date[] newtimePeriod, String newstockCode, onlineDataReader newReader) {
		this.timeperiod = newtimePeriod;
		this.stockCode = newstockCode;
		this.reader = newReader;
	}

	@Override
	public LinkedList<tick> getData() {
		return reader.getData(this.timeperiod, this.stockCode);
	}

}
