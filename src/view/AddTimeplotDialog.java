package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTimeplotDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;
	private Boolean updated = false;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddTimeplotDialog dialog = new AddTimeplotDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddTimeplotDialog() {
		setTitle("Add a New Date to Timeplot");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Month");
			lblNewLabel.setBounds(175, 103, 61, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			monthField = new JTextField();
			monthField.setText("10");
			monthField.setBounds(248, 98, 61, 26);
			contentPanel.add(monthField);
			monthField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("New Date");
			lblNewLabel_1.setBounds(6, 76, 61, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Day");
			lblNewLabel_2.setBounds(321, 103, 61, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			dayField = new JTextField();
			dayField.setText("05");
			dayField.setBounds(383, 98, 61, 26);
			contentPanel.add(dayField);
			dayField.setColumns(10);
		}
		{
			yearField = new JTextField();
			yearField.setText("2018");
			yearField.setBounds(102, 98, 61, 26);
			contentPanel.add(yearField);
			yearField.setColumns(10);
		}
		{
			lblNewLabel_3 = new JLabel("Year");
			lblNewLabel_3.setBounds(29, 103, 61, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = true;
						AddTimeplotDialog.this.setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = false;
						AddTimeplotDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Boolean wasUpdated(){
		return updated;
	}

	public JTextField getMonthField() {
		return monthField;
	}

	public JTextField getDayField() {
		return dayField;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getYearField() {
		return yearField;
	}

}
