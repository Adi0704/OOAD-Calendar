package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.Calendar;
import model.Timeplot;
import view.MainFrame;
import view.SelectDateDialog;

public class ShowController {
	MainFrame frame;

	public ShowController (MainFrame frame) {
		this.frame = frame;
	}
	
	public int toInt(String number) {
		return Integer.valueOf(number).intValue();
	}
	
	public void ShowCalendars() {
		this.frame.objectField.setText("Calendars");
		this.frame.valueField.setText("All"); 
		this.frame.textModel.clear();
		for(Iterator<String> cky = this.frame.curCalendarMgr.keySet().iterator(); cky.hasNext();)
			this.frame.textModel.addElement(this.frame.curCalendarMgr.get(cky.next()).getString());
		this.frame.repaint();
	}

	public void ShowDate() {
		SelectDateDialog sdd = new SelectDateDialog();
		sdd.setModal(true);
		sdd.setVisible(true);
		
		if (sdd.wasUpdated()) {
			this.frame.textModel.clear();
			String year = sdd.getYearField().getText();
			String month = sdd.getMonthField().getText();
			String day = sdd.getDayField().getText();

			String date = year + month + day;

			for(Iterator<String> itr = this.frame.curCalendarMgr.keySet().iterator(); itr.hasNext();){
				Calendar c = this.frame.curCalendarMgr.get(itr.next());
				if (toInt(date) >= toInt(c.start) & toInt(date) <= toInt(c.end)) {
					if (c.timeplotMgr.containsKey(date)){
					 	Timeplot t = c.timeplotMgr.get(date);
					 	if (!t.meetingMgr.isEmpty()){
					 		for(Iterator<String> ky = t.meetingMgr.keySet().iterator(); ky.hasNext();){
					 			this.frame.textModel.addElement(t.meetingMgr.get(ky.next()).getString());
					 		}
						}
					}
				}
			}
			this.frame.objectField.setText("Meeting");
			this.frame.valueField.setText(date);
		}
		sdd.dispose();
		frame.repaint();
	}
	
	public void ShowMonth() {
		SelectDateDialog sdd = new SelectDateDialog();
		sdd.setModal(true);
		sdd.setVisible(true);
		//sdd.getDayField().setVisible(false);
		//sdd.getDayField().setEnabled(false);
		if (sdd.wasUpdated()) {
			this.frame.textModel.clear();
			String year = sdd.getYearField().getText();
			String month = sdd.getMonthField().getText();
			for(Iterator<String> itr = this.frame.curCalendarMgr.keySet().iterator(); itr.hasNext();){
				Calendar c = this.frame.curCalendarMgr.get(itr.next());
				if (c.start.startsWith(year+month)) {
					for (Iterator<String> tky = c.timeplotMgr.keySet().iterator(); tky.hasNext();){
						Timeplot t = c.timeplotMgr.get(tky.next()); 
						for (Iterator<String> mky = t.meetingMgr.keySet().iterator(); mky.hasNext();){
							String m = t.meetingMgr.get(mky.next()).getString();
							this.frame.textModel.addElement(m);
						}
					}
				}
			}
			this.frame.objectField.setText("Meeting");
			this.frame.valueField.setText(year+month);
		}
		sdd.dispose();
		frame.repaint();
	}
}
