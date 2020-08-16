package MainFrames;
import Classes.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LocationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtCountry;
	private JTextField txtState;
	private JTextField txtAlley;
	private JTextField txtEmail;
	private JTextField txtLongitude;
	public static int idCnToLocate;
	private JTextField txtHood;
	private JTextField txtCity;
	private JTextField txtLatitude;
	private JTextField txtRadius;
	public static int whichAddressBookLocationFrame = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationFrame frame = new LocationFrame();
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
	public LocationFrame() {
		Contact contact = new Contact();
		contact = AddressBookSelection.addressBooks.get(whichAddressBookLocationFrame).getContacts().get(idCnToLocate - 1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JLabel lblNewLabel = new JLabel(contact.getFirstName() + " " + contact.getLastName() + " Location Panel");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(27, 10, 383, 53);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Country :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 73, 112, 34);
		contentPane.add(lblNewLabel_1);

		JLabel lblLastName = new JLabel("State :");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(27, 119, 112, 34);
		contentPane.add(lblLastName);

		JLabel lblMobile = new JLabel("City :");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobile.setBounds(27, 163, 100, 34);
		contentPane.add(lblMobile);

		JLabel lblBirthDate = new JLabel("Hood :");
		lblBirthDate.setForeground(Color.WHITE);
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBirthDate.setBounds(27, 207, 112, 34);
		contentPane.add(lblBirthDate);

		JLabel lblCity = new JLabel("Alley :");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(27, 251, 91, 34);
		contentPane.add(lblCity);

		JLabel lblSex = new JLabel("Latitude :");
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSex.setBounds(279, 73, 91, 34);
		contentPane.add(lblSex);

		JLabel lblGroup = new JLabel("Longitude :");
		lblGroup.setForeground(Color.WHITE);
		lblGroup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGroup.setBounds(279, 119, 102, 34);
		contentPane.add(lblGroup);

		JLabel lblClose = new JLabel("");
		lblClose.setBounds(525, 0, 25, 28);
		lblClose.setForeground(new Color(230, 230, 250));
		Image imgClose = new ImageIcon(this.getClass().getResource("/close_16.png")).getImage();
		lblClose.setIcon(new ImageIcon(imgClose));
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(lblClose);
		Image imgMainTheme = new ImageIcon(this.getClass().getResource("/editContactFinal.jpg")).getImage();

		txtCountry = new JTextField("");
		txtCountry.setForeground(Color.BLACK);
		txtCountry.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCountry.setColumns(10);
		txtCountry.setBackground(new Color(249, 130, 31));
		txtCountry.setBounds(116, 73, 153, 36);
		contentPane.add(txtCountry);

		txtState = new JTextField("");
		txtState.setForeground(Color.BLACK);
		txtState.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtState.setColumns(10);
		txtState.setBackground(new Color(249, 130, 31));
		txtState.setBounds(116, 119, 153, 36);
		contentPane.add(txtState);

		txtAlley = new JTextField("");
		txtAlley.setForeground(Color.BLACK);
		txtAlley.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtAlley.setColumns(10);
		txtAlley.setBackground(new Color(249, 130, 31));
		txtAlley.setBounds(116, 251, 156, 36);
		contentPane.add(txtAlley);

		txtLongitude = new JTextField("");
		txtLongitude.setForeground(Color.BLACK);
		txtLongitude.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtLongitude.setColumns(10);
		txtLongitude.setBackground(new Color(249, 130, 31));
		txtLongitude.setBounds(380, 119, 142, 36);
		contentPane.add(txtLongitude);
		JButton btnDone = new JButton("Update");
		btnDone.setBackground(new Color(103, 143, 88));
		btnDone.setForeground(Color.WHITE);
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image imgDone = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		btnDone.setIcon(new ImageIcon(imgDone));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//inja lat o lon o radius o be double tabdil mikonam :)
					Double lat = Double.parseDouble(txtLatitude.getText());
					Double lon = Double.parseDouble(txtLongitude.getText());
					Double rad = Double.parseDouble(txtRadius.getText());
					if (!txtCountry.getText().isEmpty() && !txtState.getText().isEmpty() && !txtCity.getText().isEmpty()
							&& !txtHood.getText().isEmpty() && !txtAlley.getText().isEmpty()
							&& !txtLatitude.getText().isEmpty() && !txtLongitude.getText().isEmpty()
							&& !txtRadius.getText().isEmpty()) {
						//let's clear The Previous Location Of a Contact;
						int clearThePreviousLocationOfaContact = 0;
						boolean thereIs = false;
						for (int i = 0; i < AddressBookSelection.addressBooks.get(whichAddressBookLocationFrame).getLocations().size(); i++) {
							if (AddressBookSelection.addressBooks.get(whichAddressBookLocationFrame).getLocations().get(i).getLocationForID() == idCnToLocate) {
								clearThePreviousLocationOfaContact = i;
								thereIs = true;
							}
						}					
						if (thereIs) {
							AddressBookSelection.addressBooks.get(whichAddressBookLocationFrame).getLocations().remove(clearThePreviousLocationOfaContact);
						}
						//cleared up !
						Location location = new Location(idCnToLocate, txtCountry.getText(), txtState.getText(),
								txtCity.getText(), txtHood.getText(), txtAlley.getText(),
								Double.parseDouble(txtLatitude.getText()), Double.parseDouble(txtLongitude.getText()),
								Double.parseDouble(txtRadius.getText()));
						AddressBookSelection.addressBooks.get(whichAddressBookLocationFrame).getLocations().add(location);
						//hala ke location o dar addressBook add kardim, mirim soragh roshan kardan isLocated karbar morede nazar
						Contact.setLocatedTrue(idCnToLocate);
						Contact contactFinal = new Contact();
						contactFinal = AddressBookSelection.addressBooks.get(whichAddressBookLocationFrame).getContacts().get(idCnToLocate - 1);
						JOptionPane.showMessageDialog(null,
								contactFinal.getFirstName() + " " + contactFinal.getLastName() + " is Located !");
						Main main = new Main();
						dispose();
						main.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Empty Field found !");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Enter the inputs Correctly !");
				}
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDone.setBounds(380, 202, 142, 46);
		contentPane.add(btnDone);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				dispose();
				main.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(380, 247, 142, 38);
		contentPane.add(btnCancel);

		txtCity = new JTextField("");
		txtCity.setForeground(Color.BLACK);
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCity.setColumns(10);
		txtCity.setBackground(new Color(249, 130, 31));
		txtCity.setBounds(116, 163, 156, 36);
		contentPane.add(txtCity);

		txtHood = new JTextField("");
		txtHood.setForeground(Color.BLACK);
		txtHood.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtHood.setColumns(10);
		txtHood.setBackground(new Color(249, 130, 31));
		txtHood.setBounds(116, 207, 156, 36);
		contentPane.add(txtHood);

		txtLatitude = new JTextField("");
		txtLatitude.setForeground(Color.BLACK);
		txtLatitude.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtLatitude.setColumns(10);
		txtLatitude.setBackground(new Color(249, 130, 31));
		txtLatitude.setBounds(380, 71, 142, 36);
		contentPane.add(txtLatitude);

		JLabel lblRadius = new JLabel("Radius :");
		lblRadius.setForeground(Color.WHITE);
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRadius.setBounds(279, 163, 91, 34);
		contentPane.add(lblRadius);

		txtRadius = new JTextField("");
		txtRadius.setForeground(Color.BLACK);
		txtRadius.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtRadius.setColumns(10);
		txtRadius.setBackground(new Color(249, 130, 31));
		txtRadius.setBounds(380, 163, 142, 36);
		contentPane.add(txtRadius);

		JLabel lblMainTheme = new JLabel("");
		lblMainTheme.setBounds(0, 0, 550, 328);
		contentPane.add(lblMainTheme);
		lblMainTheme.setIcon(new ImageIcon(imgMainTheme));

	}
}
