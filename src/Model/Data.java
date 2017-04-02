package Model;

import java.util.Date;
import java.util.LinkedList;

public interface Data {
	public LinkedList<tick> getData(Date[] timeperiod, String companyName);
}