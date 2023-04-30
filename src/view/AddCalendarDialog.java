package view;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class AddCalendarDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;

	public Boolean updated = false;

	public JComboBox<Integer> durationComboBox;
	private JTextField startYearField;
	private JTextField startMonthField;
	private JTextField startDayField;
	private JTextField startDoWField;
	private JTextField endYearField;
	private JTextField endMonthField;
	private JTextField endDayField;
	private JTextField endDoWField;
	private JTextField earlyField;
	private JTextField lateField;
	
	private JButton okButton;
	private JButton cancelButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCalendarDialog dialog = new AddCalendarDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCalendarDialog() {
		System.out.print("Do it ?");
		setTitle("Create A New Calendar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			startYearField = new JTextField();
			startYearField.setText("2018");
			startYearField.setBounds(100, 88, 66, 26);
			contentPanel.add(startYearField);
			startYearField.setColumns(10);
			
			startMonthField = new JTextField();
			startMonthField.setText("09");
			startMonthField.setColumns(10);
			startMonthField.setBounds(217, 88, 66, 26);
			contentPanel.add(startMonthField);
			
			startDayField = new JTextField();
			startDayField.setText("24");
			startDayField.setColumns(10);
			startDayField.setBounds(330, 88, 66, 26);
			contentPanel.add(startDayField);
			
			startDoWField = new JTextField();
			startDoWField.setText("3");
			startDoWField.setBounds(100, 148, 66, 26);
			contentPanel.add(startDoWField);
			startDoWField.setColumns(10);
			startDoWField.setVisible(false);
			
			endYearField = new JTextField();
			endYearField.setText("2018");
			endYearField.setBounds(100, 148, 66, 26);
			contentPanel.add(endYearField);
			endYearField.setColumns(10);

			endMonthField = new JTextField();
			endMonthField.setText("10");
			endMonthField.setColumns(10);
			endMonthField.setBounds(217, 148, 66, 26);
			contentPanel.add(endMonthField);
			
			endDayField = new JTextField();
			endDayField.setText("01");
			endDayField.setColumns(10);
			endDayField.setBounds(330, 148, 66, 26);
			contentPanel.add(endDayField);

			endDoWField = new JTextField();
			endDoWField.setText("1");
			endDoWField.setColumns(10);
			endDoWField.setBounds(330, 148, 66, 26);
			contentPanel.add(endDoWField);
			endDoWField.setVisible(false);
			
			earlyField = new JTextField();
			earlyField.setText("1000");
			earlyField.setColumns(10);
			earlyField.setBounds(100, 194, 66, 26);
			contentPanel.add(earlyField);
			
			lateField = new JTextField();
			lateField.setText("1700");
			lateField.setColumns(10);
			lateField.setBounds(263, 194, 66, 26);
			contentPanel.add(lateField);
			
			nameField = new JTextField();
			nameField.setText("Personal");
			nameField.setBounds(122, 25, 130, 26);
			contentPanel.add(nameField);
			nameField.setColumns(10);
			
		{
			JLabel lblNewLabel = new JLabel("Calendar Name");
			lblNewLabel.setBounds(6, 30, 114, 16);
			contentPanel.add(lblNewLabel);
			
			
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Year");
			lblNewLabel_1.setBounds(62, 93, 44, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Start from");
			lblNewLabel_2.setBounds(6, 58, 114, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblMonth = new JLabel("Month");
			lblMonth.setBounds(172, 93, 44, 16);
			contentPanel.add(lblMonth);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Day");
			lblNewLabel_3.setBounds(286, 93, 32, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Year");
			lblNewLabel_4.setBounds(62, 153, 61, 16);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Month");
			lblNewLabel_5.setBounds(172, 153, 61, 16);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JLabel lblNewLabel_6 = new JLabel("Day");
			lblNewLabel_6.setBounds(286, 153, 61, 16);
			contentPanel.add(lblNewLabel_6);
		}
		{
			JLabel lblNewLabel_7 = new JLabel("End to");
			lblNewLabel_7.setBounds(6, 121, 61, 16);
			contentPanel.add(lblNewLabel_7);
		}
		{
			JLabel lblNewLabel_8 = new JLabel("Early Start by");
			lblNewLabel_8.setBounds(6, 199, 114, 16);
			contentPanel.add(lblNewLabel_8);
		}
		{
			JLabel lblNewLabel_9 = new JLabel("Last Start by");
			lblNewLabel_9.setBounds(172, 199, 125, 16);
			contentPanel.add(lblNewLabel_9);
		}
		{
			JLabel lblNewLabel_10 = new JLabel("Duration");
			lblNewLabel_10.setBounds(286, 30, 61, 16);
			contentPanel.add(lblNewLabel_10);
		}
		
		durationComboBox = new JComboBox<>();
		durationComboBox.setBounds(359, 26, 85, 27);
		contentPanel.add(durationComboBox);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = true;
						AddCalendarDialog.this.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = false;
						AddCalendarDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		
	}

	public Boolean wasUpdated() {
		return updated;
	}

	public JComboBox<Integer> getDurationComboBox() {
		return durationComboBox;
	}

	public JTextField getStartYearField() {
		return startYearField;
	}

	public JTextField getStartMonthField() {
		return startMonthField;
	}

	public JTextField getStartDayField() {
		return startDayField;
	}

	public JTextField getStartDoWField() {
		return startDoWField;
	}

	public JTextField getEndYearField() {
		return endYearField;
	}

	public JTextField getEndMonthField() {
		return endMonthField;
	}

	public JTextField getEndDayField() {
		return endDayField;
	}

	public JTextField getEndDoWField() {
		return endDoWField;
	}

	public JTextField getEarlyField() {
		return earlyField;
	}

	public JTextField getLateField() {
		return lateField;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getNameField() {
		return nameField;
	}

}
