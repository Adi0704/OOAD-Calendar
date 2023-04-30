

import java.util.ArrayList;
import java.util.Iterator;

import model.Calendar;
import model.Meeting;
import model.Timeplot;
import view.MainFrame;
import view.SelectDateDialog;
import view.SelectNameDialog;
import view.SelectTimeDialog;

public class RemoveController {
	MainFrame frame;

	public RemoveController (MainFrame frame) {
		this.frame = frame;
	}

	public void remove () {
		String object = this.frame.getString(frame.objectField);
		String value = this.frame.getString(frame.valueField);

		if (object.equals("calendars") & value.equals("all"))
			removeCalendar();
		else if (object.equals("timeplots"))
			removeTimeplot();
		else if (object.equals("meetings"))
			removeMeeting();
		else ;
	}

	public void removeCalendar () {
		SelectNameDialog sbd = new SelectNameDialog();
		sbd.setModal(true);
		sbd.setVisible(true);

		if (sbd.wasUpdated()) {
			String name = sbd.getNameField().getText();
			this.frame.curCalendarMgr.remove(name);

			this.frame.textModel.clear();
			for(Iterator<String> itr = this.frame.curCalendarMgr.keySet().iterator(); itr.hasNext();)
				this.frame.textModel.addElement(this.frame.curCalendarMgr.get(itr.next()).getString());
		}
		sbd.dispose();
		frame.repaint();
	}

	public void removeTimeplot () {
		SelectDateDialog sdd = new SelectDateDialog();
		sdd.setModal(true);
		sdd.setVisible(true);

		if (sdd.wasUpdated()) {
			String year = sdd.getYearField().getText();
			String month = sdd.getMonthField().getText();
			String day = sdd.getDayField().getText();

			String date = year+month+day;
			Calendar c = this.frame.curCalendarMgr.get(this.frame.curCalendar);
			c.timeplotMgr.remove(date);
			this.frame.curCalendarMgr.put(this.frame.curCalendar, c);

			this.frame.textModel.clear();
			for(Iterator<String> itr = c.timeplotMgr.keySet().iterator(); itr.hasNext();)
				this.frame.textModel.addElement(c.timeplotMgr.get(itr.next()).getString());
		}
		sdd.dispose();
		frame.repaint();
	}

	public void removeMeeting () {
		SelectTimeDialog std = new SelectTimeDialog();
		std.setModal(true);
		std.setVisible(true);

		if (std.wasUpdated()) {
			String time = std.getTimeField().getText();

			Calendar c = this.frame.curCalendarMgr.get(this.frame.curCalendar); 
			Timeplot t = c.timeplotMgr.get(this.frame.curTimeplot);
			t.meetingMgr.remove(time);

			c.timeplotMgr.put(this.frame.curTimeplot,t);
			this.frame.curCalendarMgr.put(this.frame.curCalendar, c);

			this.frame.textModel.clear();
			for(Iterator<String> itr = t.meetingMgr.keySet().iterator(); itr.hasNext();)
				this.frame.textModel.addElement(t.meetingMgr.get(itr.next()).getString());

		}
		std.dispose();

		frame.repaint();
	}

	public void removePerson () {
		SelectNameDialog sbd = new SelectNameDialog();
		if (sbd.wasUpdated()) {
			String name = sbd.getNameField().getText();
			
			Calendar c = this.frame.curCalendarMgr.get(this.frame.curCalendar); 
			Timeplot t = c.timeplotMgr.get(this.frame.curTimeplot);
			Meeting m = t.meetingMgr.get(this.frame.curMeeting);

			m.people.remove(name);

			t.meetingMgr.put(this.frame.curMeeting, m);
			c.timeplotMgr.put(this.frame.curTimeplot, t);
			this.frame.curCalendarMgr.put(this.frame.curCalendar, c);

			this.frame.textModel.clear();
			for (int i=0; i< m.people.size(); i++)
				this.frame.textModel.addElement(m.people.get(i));

		}
		sbd.dispose();
		frame.repaint();
	}
}
