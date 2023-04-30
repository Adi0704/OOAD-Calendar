package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QuitController {
	
	public boolean confirm(JFrame app) {
		int c = JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?");

		if (c == JOptionPane.OK_OPTION) {
			app.dispose();
			return true;
		}

		// don't exit
		return false;
	}
}
