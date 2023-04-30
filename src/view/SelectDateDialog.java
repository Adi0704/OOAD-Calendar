package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SelectDateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;
	private Boolean updated=false;
	public Boolean wasUpdated() {
		return updated;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectDateDialog dialog = new SelectDateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectDateDialog() {
		setTitle("Select Timplot Date");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Year");
		lblNewLabel.setBounds(6, 107, 61, 16);
		contentPanel.add(lblNewLabel);
		
		yearField = new JTextField();
		yearField.setText("2018");
		yearField.setBounds(79, 102, 61, 26);
		contentPanel.add(yearField);
		yearField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Month");
		lblNewLabel_1.setBounds(152, 107, 61, 16);
		contentPanel.add(lblNewLabel_1);
		
		monthField = new JTextField();
		monthField.setText("09");
		monthField.setBounds(225, 102, 61, 26);
		contentPanel.add(monthField);
		monthField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Day");
		lblNewLabel_2.setBounds(298, 107, 61, 16);
		contentPanel.add(lblNewLabel_2);
		
		dayField = new JTextField();
		dayField.setText("27");
		dayField.setBounds(371, 102, 61, 26);
		contentPanel.add(dayField);
		dayField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = true;
						SelectDateDialog.this.setVisible(false);
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
						SelectDateDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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
	
}
