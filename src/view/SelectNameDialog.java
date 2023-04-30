package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectNameDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private Boolean updated = false;
	public Boolean wasUpdated() {
		return updated;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectNameDialog dialog = new SelectNameDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectNameDialog() {
		setTitle("Select Calendar by Name");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Enter Calendar Name");
			lblNewLabel.setBounds(16, 113, 147, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			nameField = new JTextField();
			nameField.setText("Personal");
			nameField.addInputMethodListener(new InputMethodListener() {
				public void caretPositionChanged(InputMethodEvent event) {
				}
				public void inputMethodTextChanged(InputMethodEvent event) {
				}
			});
			nameField.setBounds(165, 108, 130, 26);
			contentPanel.add(nameField);
			nameField.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updated = true;
						SelectNameDialog.this.setVisible(false);
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
						SelectNameDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JTextField getNameField() {
		return nameField;
	}

}
