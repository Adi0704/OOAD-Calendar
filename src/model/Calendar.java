package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Calendar implements Serializable{
	public String start; // YYYYMMDD
	public String end; // YYYYMMDD
	public String duration;
	public String early; //HHMM
	public String late; //HHMM
	public Hashtable <String, Timeplot> timeplotMgr = new Hashtable<>();
	//public Hashtable <String, Meeting> meetingHT = new Hashtable<>();
	public String name;
	
	public Calendar (String name, String start, String end, 
			String duration, String early, String late) {
		this.start = start; // YYYYMMDD
		this.end = end;
		this.duration = duration;
		this.early = early;
		this.late = late;
		this.name = name;
		// here deal with date
		String key;
		for (int d=toInt(start.substring(6, 8)); d < 31; d ++) {
			if (d < 10)
				key = start.substring(0, 6) + "0" + String.valueOf(d);
			else
				key = start.substring(0, 6) + String.valueOf(d);
			this.timeplotMgr.put(key, new Timeplot(key, duration, early, late));
			
		}
		for (int d=toInt(start.substring(0, 6))+1; d < toInt(end.substring(0, 6)); d++)
			for (int i=0; i< 31; i++) {
				if (i < 10)
					key = String.valueOf(d) + "0" + String.valueOf(i);
				else
					key = String.valueOf(d) + String.valueOf(i);
				this.timeplotMgr.put(key, new Timeplot(key, duration, early, late));
				
			}
		for (int d=0; d<toInt(end.substring(6, 8)); d++) {
			if (d<10)
				key = String.valueOf(end.substring(0,6)) + "0" + String.valueOf(d);
			else
				key = String.valueOf(end.substring(0,6)) + String.valueOf(d);
			
			this.timeplotMgr.put(key, new Timeplot(key, duration, early, late));
			
		}
	}

	public int toInt(String number) {
		return Integer.valueOf(number).intValue();
	}
	
	public int getNumber() {
		return timeplotMgr.size();
	}

	public String getString() {
		return name + " " + getRangeDateStr();
	}

	public String getRangeDateStr() {
		return String.valueOf(this.start) + "-" + String.valueOf(this.end);
	}

	public void addDay(String dateDigit) {
		Timeplot t = new Timeplot(dateDigit, this.duration, this.early, this.late);
		if (toInt(dateDigit) > toInt(end))
			this.end = dateDigit;
		this.timeplotMgr.put(dateDigit, t);
	}

	public void removeDay(String dateDigit) {
		if (this.timeplotMgr.containsKey(dateDigit)) {
			Timeplot t = this.timeplotMgr.get(dateDigit);
			t.close();
			this.timeplotMgr.put(dateDigit, t);
		}
	}
	
	public String getDuration() {
		return duration;
	}

	public String getName() {
		return name;
	}

	public String getstart() {
		return start;
	}

	public String getend() {
		return end;
	}
	
}
