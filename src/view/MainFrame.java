package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AddController;
import controller.CloseController;
import controller.LoadController;
import controller.QuitController;
import controller.RemoveController;
import controller.SaveController;
import controller.ShowController;
import model.Calendar;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Window.Type;
import javax.swing.JScrollBar;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public Hashtable<String, Calendar> curCalendarMgr;// = new Hashtable<>();
	public ArrayList<String> closeDateList = new ArrayList<>();
	public ArrayList<String> closeTimeList = new ArrayList<>(); 
	public String curCalendar;
	public String curTimeplot;
	public String curMeeting;
	
	public JTextPane valueField;
	public JTextPane objectField;
	public DefaultListModel textModel = new DefaultListModel();
	public JList textList = new JList(textModel);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public MainFrame() {
		
		setTitle("EMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//textList = new JList<String>();
		textList.setBounds(192, 70, 416, 369);
		contentPane.add(textList);
		
		JButton btnNewButton = new JButton("Add +");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddController(MainFrame.this).add();
			}
		});
		btnNewButton.setBounds(645, 70, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Load =");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoadController(MainFrame.this).load();
			}
		});
		btnNewButton_1.setBounds(645, 134, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Remove -");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveController(MainFrame.this).remove();
			}
		});
		btnNewButton_3.setBounds(645, 202, 117, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Show Date Schedule");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowController(MainFrame.this).ShowDate();
			}
		});
		btnNewButton_4.setBounds(6, 126, 177, 29);
		contentPane.add(btnNewButton_4);
		
		this.objectField = new JTextPane();
		objectField.setEditable(false);
		objectField.setText("Calendars");
		objectField.setBounds(192, 26, 106, 32);
		contentPane.add(objectField);
		
		this.valueField = new JTextPane();
		valueField.setEditable(false);
		valueField.setText("All");
		valueField.setBounds(298, 26, 309, 32);
		contentPane.add(valueField);

		JButton btnShowAllCalendars = new JButton("Show All Calendars");
		btnShowAllCalendars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowController(MainFrame.this).ShowCalendars();
			}
		});
		btnShowAllCalendars.setBounds(6, 70, 177, 29);
		contentPane.add(btnShowAllCalendars);
		
		JButton btnShowMonthSchedule = new JButton("Show Month Schedule");
		btnShowMonthSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowController(MainFrame.this).ShowMonth();
			}
		});
		btnShowMonthSchedule.setBounds(6, 161, 177, 29);
		contentPane.add(btnShowMonthSchedule);
		
		JButton btnCloseTimeplot = new JButton("Close Timeplot");
		btnCloseTimeplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CloseController(MainFrame.this).close();
			}
		});
		btnCloseTimeplot.setBounds(6, 202, 177, 29);
		contentPane.add(btnCloseTimeplot);
		
		JButton btnNewButton_5 = new JButton("Save");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new SaveController(MainFrame.this).save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(6, 379, 117, 29);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("Quit");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuitController().confirm(MainFrame.this);
			}
		});
		btnNewButton_7.setBounds(6, 420, 117, 29);
		contentPane.add(btnNewButton_7);
		
	}
	
	public MainFrame(Hashtable<String, Calendar> calendarMgr, ArrayList<String> closeDateList, ArrayList<String> closeTimeList) {
		this();
		this.curCalendarMgr = calendarMgr;
		if (!this.curCalendarMgr.isEmpty()){
			new ShowController(MainFrame.this).ShowCalendars();
		}
		this.closeDateList = closeDateList;
		this.closeTimeList = closeTimeList;

	}
	
	public String getString(JTextPane field) {
		return field.getText();
	}

	public void setString(JTextPane field, String value) {
		field.setText(value);
	}
}
