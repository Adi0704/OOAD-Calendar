package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SelectDateTimeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;
	private Boolean updated = false;
	JRadioButton byDateRadioButton;
	private JTextField timeField;
	public Boolean wasUpdated() {
		return updated;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectDateTimeDialog dialog = new SelectDateTimeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectDateTimeDialog() {
		setTitle("Close Timeplot");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			yearField = new JTextField();
			yearField.setText("2018");
			yearField.setBounds(89, 103, 66, 26);
			contentPanel.add(yearField);
			yearField.setColumns(10);
			
			monthField = new JTextField();
			monthField.setText("11");
			monthField.setBounds(206, 103, 66, 26);
			monthField.setColumns(10);
			contentPanel.add(monthField);
			
			dayField = new JTextField();
			dayField.setText("01");
			dayField.setBounds(305, 103, 66, 26);
			dayField.setColumns(10);
			contentPanel.add(dayField);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Year");
			lblNewLabel_4.setBounds(51, 108, 61, 16);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Month");
			lblNewLabel_5.setBounds(161, 108, 61, 16);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Day");
			lblNewLabel_6.setBounds(275, 108, 61, 16);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Time of Day");
			lblNewLabel_1.setBounds(51, 154, 85, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Enter Date and/or Time");
			lblNewLabel_2.setBounds(51, 33, 151, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			timeField = new JTextField();
			timeField.setText("1400");
			timeField.setBounds(142, 149, 130, 26);
			contentPanel.add(timeField);
			timeField.setColumns(10);
		}
		
		byDateRadioButton = new JRadioButton("By Date");
		byDateRadioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		byDateRadioButton.setSelected(true);
		byDateRadioButton.setBounds(51, 61, 141, 23);
		contentPanel.add(byDateRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("By Time");
		rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		rdbtnNewRadioButton_1.setBounds(206, 61, 141, 23);
		contentPanel.add(rdbtnNewRadioButton_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = true;
						SelectDateTimeDialog.this.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = false;
						SelectDateTimeDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JTextField getTimeField() {
		return timeField;
	}
	public JTextField getYearField() {
		return yearField;
	}
	public JTextField getMonthField() {
		return monthField;
	}
	public JTextField getDayField() {
		return dayField;
	}
	public JRadioButton getByDateRadioButton() {
		return byDateRadioButton;
	}
}
