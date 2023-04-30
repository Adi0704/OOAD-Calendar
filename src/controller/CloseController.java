package controller;

import java.util.Iterator;

import model.Calendar;
import view.MainFrame;
import view.SelectDateTimeDialog;

public class CloseController {
	MainFrame frame;

	public CloseController (MainFrame frame) {
		this.frame = frame;
	}

	public void close() {
		
		SelectDateTimeDialog sdtd = new SelectDateTimeDialog();
		sdtd.setModal(true);
		sdtd.setVisible(true);
		String year = sdtd.getYearField().getText();
		String month = sdtd.getMonthField().getText();
		String day = sdtd.getDayField().getText();
		String date = year + month + day;
		String time = sdtd.getTimeField().getText(); 
		Boolean isByDate = sdtd.getByDateRadioButton().isSelected(); 

		if (isByDate) {
			this.frame.closeDateList.add(date);
			for(Iterator<String> itr = this.frame.curCalendarMgr.keySet().iterator(); itr.hasNext();){
				String name = itr.next();
				Calendar c = this.frame.curCalendarMgr.get(name);
				c.removeDay(date);
				this.frame.curCalendarMgr.put(name,c);
			}		
		}
		else{
			this.frame.closeTimeList.add(time);
		}
		sdtd.dispose();
		frame.repaint();
	}

}
