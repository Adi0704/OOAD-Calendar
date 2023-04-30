

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
		ArrayList<String> cList = new ArrayList<>(); 
		for(Iterator<String> cky = this.frame.curCalendarMgr.keySet().iterator(); cky.hasNext();){
			cList.add(this.frame.curCalendarMgr.get(cky.next()).getString());
		}
		this.frame.textList.setListData((String[]) cList.toArray());
		this.frame.repaint();
	}

	public void ShowDate() {
		SelectDateDialog sdd = new SelectDateDialog();
		if (sdd.wasUpdated()) {
			ArrayList<String> mList = new ArrayList<>(); 
			String year = sdd.getYearField().getText();
			String month = sdd.getMonthField().getText();
			String day = sdd.getDayField().getText();

			int date = Integer.valueOf(year+month+day).intValue();
			// for each calendar, whether it has the day
			for(Iterator<String> itr = this.frame.curCalendarMgr.keySet().iterator(); itr.hasNext();){
				Calendar c = this.frame.curCalendarMgr.get(itr.next());
				if (date >= toInt(c.start) & date <= toInt(c.end)) {
					if (c.timeplotMgr.contains(date)){
					 	Timeplot t = c.timeplotMgr.get(date);
					 	if (t.meetingMgr.size() != 0){
					 		for(Iterator<String> ky = t.meetingMgr.keySet().iterator(); ky.hasNext();){
					 			mList.add(t.meetingMgr.get(ky.next()).toString());
					 		}
						}
					}
				}
			}
			this.frame.textList.setListData((String[]) mList.toArray());
		}
		sdd.dispose();
		frame.repaint();
	}
	
	public void ShowMonth() {
		SelectDateDialog sdd = new SelectDateDialog();
		sdd.getDayField().setVisible(false);
		if (sdd.wasUpdated()) {
			ArrayList<String> mList = new ArrayList<>(); 
			String year = sdd.getYearField().getText();
			String month = sdd.getMonthField().getText();
			
			for(Iterator<String> itr = this.frame.curCalendarMgr.keySet().iterator(); itr.hasNext();){
				Calendar c = this.frame.curCalendarMgr.get(itr.next());
				if (String.valueOf(c.start).startsWith(year+month)) {
					for (Iterator<String> tky = c.timeplotMgr.keySet().iterator(); tky.hasNext();){
						Timeplot t = c.timeplotMgr.get(tky.next()); 

						for (Iterator<String> mky = t.meetingMgr.keySet().iterator(); mky.hasNext();){
							String m = t.meetingMgr.get(mky.next()).getString();
							mList.add(m);
						}
					}
				}
			}
			this.frame.textList.setListData((String[]) mList.toArray());
		}
		sdd.dispose();
		frame.repaint();
	}
}
