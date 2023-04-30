package ems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import model.Calendar;
import storage.SerializableStorage;
import view.MainFrame;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Hashtable<String, Calendar> calendarMgr;
		ArrayList<String> closeDateList;
		ArrayList<String> closeTimeList;
		// load or new data
		SerializableStorage ss = new SerializableStorage();
		
		if (ss.existMgr()) calendarMgr = ss.readMgr();
		else calendarMgr = new Hashtable<>();
		if (ss.existMgr()) closeDateList = ss.readCD();
		else closeDateList = new ArrayList<>();
		if (ss.existMgr()) closeTimeList = ss.readCT();
		else closeTimeList = new ArrayList<>();
		
		MainFrame frame = new MainFrame (calendarMgr, closeDateList, closeTimeList);

		frame.setVisible(true);

	}

}
