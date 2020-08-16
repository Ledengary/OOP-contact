package Welcome;
import MainFrames.AddressBookSelection;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(11, 17, 10));
		frame.setBounds(100, 100, 990, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);

		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Let's GO !
				frame.dispose();
				AddressBookSelection addressBookSelection = new AddressBookSelection();
				addressBookSelection.setVisible(true);
			}
		});
		btnStart.setForeground(new Color(228, 228, 230));
		btnStart.setBackground(new Color(62, 84, 51));
		btnStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnStart.setBounds(410, 511, 180, 57);
		frame.getContentPane().add(btnStart);
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	

		JLabel lblProjectTheme = new JLabel("");
		lblProjectTheme.setBounds(0, -59, 1056, 705);
		frame.getContentPane().add(lblProjectTheme);
		Image img = new ImageIcon(this.getClass().getResource("/projectTheme.jpg")).getImage();
		lblProjectTheme.setIcon(new ImageIcon(img));
		
	}
}
