package MainFrames;
import Classes.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JScrollPane;

public class ShowMore extends JFrame {

	private JPanel contentPane;
	public static int idCnToShow;
	public static int whichAddressBookShowMore = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowMore frame = new ShowMore();
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
	public ShowMore() {
		Contact contact = new Contact();
		contact = AddressBookSelection.addressBooks.get(whichAddressBookShowMore).getContacts().get(idCnToShow - 1);
		Location location = new Location();
		for(Location ln : AddressBookSelection.addressBooks.get(whichAddressBookShowMore).getLocations()) {
			if (ln.getLocationForID() == contact.getID()) {
				location = ln;
				break;
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		Image imgMain = new ImageIcon(this.getClass().getResource("/showMore.jpg")).getImage();
		
		JLabel label = new JLabel(contact.getFirstName());
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(287, 123, 213, 34);
		contentPane.add(label);
		label.setForeground(new Color(44, 65, 95));
		
		JLabel lblClose = new JLabel("");
		lblClose.setBounds(1029, 0, 53, 57);
		Image imgClose = new ImageIcon(this.getClass().getResource("/closeShowMore.png")).getImage();
		lblClose.setIcon(new ImageIcon(imgClose));
		contentPane.add(lblClose);
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				Main main = new Main();
				main.setVisible(true);
			}
		});
		
		JLabel label_1 = new JLabel(contact.getLastName());
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(287, 151, 213, 34);
		label_1.setForeground(new Color(44, 65, 95));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(contact.getMobielNumber());
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(287, 177, 213, 34);
		label_2.setForeground(new Color(44, 65, 95));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(contact.getBirthDate());
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(287, 204, 213, 34);
		label_3.setForeground(new Color(44, 65, 95));
		contentPane.add(label_3);
		
		String[] cnGroupsInput = contact.getGroup().split("_");
		String cnGroupsOutput = "";
		for (int i = 0; i < cnGroupsInput.length; i++) {
			cnGroupsOutput += " / " + cnGroupsInput[i];
		}
		cnGroupsOutput = cnGroupsOutput.substring(3,cnGroupsOutput.length());
		JLabel label_5 = new JLabel(cnGroupsOutput);
		label_5.setBounds(287, 304, 591, 32);
		contentPane.add(label_5);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_5.setForeground(new Color(44, 65, 95));
		
		JLabel label_6 = new JLabel(contact.geteMail());
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_6.setBounds(287, 234, 180, 34);
		label_6.setForeground(new Color(44, 65, 95));
		contentPane.add(label_6);
		
		JLabel lblProfilePicture = new JLabel();
		lblProfilePicture.setBounds(482, 110, 158, 130);
		try {
			BufferedImage im = ImageIO.read(getClass().getClassLoader().getResourceAsStream(contact.getProfilePictureAddress()));
			lblProfilePicture.setIcon(new ImageIcon(im));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane.add(lblProfilePicture);
		
		JLabel lblGroups = new JLabel("Groups :");
		lblGroups.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGroups.setBounds(204, 305, 62, 27);
		contentPane.add(lblGroups);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(204, 129, 82, 27);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(204, 155, 82, 27);
		contentPane.add(lblLastName);
		
		JLabel lblMobileNumber = new JLabel("Mobile :");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMobileNumber.setBounds(204, 183, 82, 27);
		contentPane.add(lblMobileNumber);
		
		JLabel lblBirthDate = new JLabel("Birth Date :");
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBirthDate.setBounds(204, 210, 82, 27);
		contentPane.add(lblBirthDate);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(204, 240, 82, 27);
		contentPane.add(lblEmail);
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCountry.setBounds(675, 129, 82, 27);
		contentPane.add(lblCountry);
		
		JLabel lblState = new JLabel("State :");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblState.setBounds(675, 155, 82, 27);
		contentPane.add(lblState);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCity.setBounds(675, 183, 82, 27);
		contentPane.add(lblCity);
		
		JLabel lblHood = new JLabel("Hood :");
		lblHood.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHood.setBounds(675, 210, 82, 27);
		contentPane.add(lblHood);
		
		JLabel lblAlley = new JLabel("Alley :");
		lblAlley.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlley.setBounds(675, 240, 82, 27);
		contentPane.add(lblAlley);
		
		JLabel lblLatitude = new JLabel("Latitude :");
		lblLatitude.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLatitude.setBounds(471, 254, 71, 27);
		contentPane.add(lblLatitude);
		
		JLabel lblLongitude = new JLabel("Longitude :");
		lblLongitude.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLongitude.setBounds(563, 254, 71, 27);
		contentPane.add(lblLongitude);
		
		JLabel label_8 = new JLabel(location.getCountry());
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_8.setBounds(737, 123, 141, 34);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel(location.getState());
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_9.setBounds(737, 151, 141, 34);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel(location.getCity());
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_10.setBounds(737, 181, 141, 34);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel(location.getHood());
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_11.setBounds(737, 210, 141, 34);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel(location.getAlley());
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_12.setBounds(737, 238, 141, 34);
		contentPane.add(label_12);
		
		JLabel label_15 = new JLabel(Double.toString(location.getLatitude()));
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_15.setBounds(482, 282, 62, 27);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel(Double.toString(location.getLongitude()));
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_16.setBounds(563, 282, 71, 27);
		contentPane.add(label_16);
		
		JLabel lblRadius = new JLabel("Radius :");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRadius.setBounds(675, 274, 62, 27);
		contentPane.add(lblRadius);
		
		JLabel label_13 = new JLabel(Double.toString(location.getRadius()));
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_13.setBounds(737, 268, 141, 34);
		contentPane.add(label_13);
		
		JLabel lblNewLabel = new JLabel("ID Number : " + contact.getID());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(204, 92, 173, 27);
		contentPane.add(lblNewLabel);
		
		JLabel label_14 = new JLabel("________________________");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_14.setBounds(204, 103, 263, 27);
		contentPane.add(label_14);
		
		JLabel lblMainTheme = new JLabel("");
		lblMainTheme.setBounds(0, 0, 1082, 580);
		lblMainTheme.setIcon(new ImageIcon(imgMain));
		contentPane.add(lblMainTheme);
		

		if (!contact.isLocated) {
			lblCountry.setEnabled(false);
			lblState.setEnabled(false);
			lblCity.setEnabled(false);
			lblAlley.setEnabled(false);
			lblCity.setEnabled(false);
			lblHood.setEnabled(false);
			lblLatitude.setVisible(false);
			lblLongitude.setVisible(false);
			lblRadius.setVisible(false);
			label_13.setVisible(false);
			label_15.setVisible(false);
			label_16.setVisible(false);
		}
	}
}
