package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Meeting;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddMeetingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JTextField locationField;
	private JTextField timeField;
	private JButton okButton;
	private JButton cancelButton;
	public ArrayList<String> people = new ArrayList<>();
	public DefaultListModel textModel = new DefaultListModel();
	public JList personList = new JList(textModel);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddMeetingDialog dialog = new AddMeetingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Meeting m;
	boolean updated = false;
	private JTextField textField_1;
	/**
	 * Create the dialog.
	 */
	public AddMeetingDialog() {
		setTitle("Create a New Meeting");
		setBounds(100, 100, 562, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel selectTimeLable = new JLabel("Select Time");
		selectTimeLable.setBounds(6, 46, 79, 16);
		contentPanel.add(selectTimeLable);
		
		{
			JLabel lblNewLabel_1 = new JLabel("Enter or Select Person");
			lblNewLabel_1.setBounds(6, 106, 145, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			nameField = new JTextField();
			nameField.setText("Jack");
			nameField.setBounds(163, 101, 130, 26);
			contentPanel.add(nameField);
			nameField.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("Add +");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = getNameField().getText();
					people.add(name);
					textModel.clear();
					for (String p:people)
						textModel.addElement(p);
					getNameField().setText(null);
				}
			});
			btnNewButton.setBounds(297, 101, 117, 29);
			contentPanel.add(btnNewButton);
		}
		{
			//personList = new JList();
			personList.setBounds(6, 134, 537, 116);
			contentPanel.add(personList);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Enter or Select Location");
			lblNewLabel_2.setBounds(6, 73, 160, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			locationField = new JTextField();
			locationField.setText("Fuller Lab");
			locationField.setBounds(163, 68, 130, 26);
			contentPanel.add(locationField);
			locationField.setColumns(10);
		}
		{
			timeField = new JTextField();
			timeField.setText("1000");
			timeField.setBounds(163, 41, 130, 26);
			contentPanel.add(timeField);
			timeField.setColumns(10);
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
						AddMeetingDialog.this.setVisible(false);
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
						AddMeetingDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Boolean wasUpdated() {
		return updated;
	}

	public Boolean nameWasUpdated() {
		return updated;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getLocationField() {
		return locationField;
	}

	public JList getPersonList() {
		return personList;
	}

	public void setPersonList(JList personList) {
		this.personList = personList;
	}

	public JTextField getTimeField() {
		return timeField;
	}
}
