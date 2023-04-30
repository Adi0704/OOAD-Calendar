

import java.util.ArrayList;
import java.util.Iterator;

import model.Calendar;
import model.Meeting;
import model.Timeplot;
import view.MainFrame;
import view.SelectDateDialog;
import view.SelectNameDialog;
import view.SelectTimeDialog;

public class LoadController {
	MainFrame frame;

	public LoadController (MainFrame frame) {
		this.frame = frame;
	}

	public void load () {
		String object = this.frame.getString(frame.objectField);
		String value = this.frame.getString(frame.valueField);

		if (object.equals("calendars") & value.equals("all"))
			loadCalendar();
		else if (object.equals("timeplots"))
			loadTimeplot();
		else if (object.equals("meetings"))
			loadMeeting();
		else ;

	}

	public void loadCalendar () {
		SelectNameDialog sbd = new SelectNameDialog();
		
		if (sbd.wasUpdated()) {
			String name = sbd.getNameField().getText();

			Calendar c = this.frame.curCalendarMgr.get(name);
			this.frame.valueField.setText(c.name + " " + c.getRangeDateStr()); 

			this.frame.curCalendar = name;

			ArrayList<String> arr = new ArrayList<>();
			for(Iterator<String> itr = c.timeplotMgr.keySet().iterator(); itr.hasNext();)
				arr.add(c.timeplotMgr.get(itr.next()).getString());
			this.frame.textList.setListData((String[]) arr.toArray());
		}
		sbd.dispose();

		frame.repaint();
	}

	public void loadTimeplot ()  {
		SelectDateDialog sdd = new SelectDateDialog();
		if (sdd.wasUpdated()) {
			String year = sdd.getYearField().getText();
			String month = sdd.getMonthField().getText();
			String day = sdd.getDayField().getText();

			String date = year+month+day;
			Calendar c = this.frame.curCalendarMgr.get(this.frame.curCalendar);
			Timeplot t = c.timeplotMgr.get(date); 
			this.frame.valueField.setText(year+month+day); 

			ArrayList<String> arr = new ArrayList<>();
			this.frame.curTimeplot = date;
			for(Iterator<String> itr = t.meetingMgr.keySet().iterator(); itr.hasNext();)
				arr.add(t.meetingMgr.get(itr.next()).getString());
			
			this.frame.textList.setListData((String[]) arr.toArray());

		}
		sdd.dispose();

		frame.repaint();
	}

	public void loadMeeting () {
		SelectTimeDialog std = new SelectTimeDialog();
		if (std.wasUpdated()) {
			String time = std.getTimeField().getText();

			Calendar c = this.frame.curCalendarMgr.get(this.frame.curCalendar);
			Timeplot t = c.timeplotMgr.get(this.frame.curTimeplot);
			Meeting m = t.meetingMgr.get(time);

			ArrayList<String> arr = new ArrayList<>();
			this.frame.curMeeting = time;
			for(int i=0; i < m.people.size(); i++)
				arr.add(m.people.get(i));

			this.frame.textList.setListData((String[]) arr.toArray());

		}
		std.dispose();

		frame.repaint();
	}

}
