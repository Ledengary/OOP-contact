package MainFrames;

import Classes.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddContact extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMobile;
	private JTextField txtYear;
	private JTextField txtMonth;
	private JTextField txtDay;
	private JTextField txtCity;
	private JTextField txtEmail;
	private JTextField txtRadio;
	public static int whichAddressBookAddContact = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContact frame = new AddContact();
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
	public AddContact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JLabel lblNewLabel = new JLabel("New Contact");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(211, 13, 145, 53);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name : ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 73, 112, 34);
		contentPane.add(lblNewLabel_1);

		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtFirstName.setForeground(Color.WHITE);
		txtFirstName.setBounds(149, 76, 156, 36);
		txtFirstName.setBackground(new Color(103, 143, 88));
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(27, 119, 112, 34);
		contentPane.add(lblLastName);

		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtLastName.setForeground(Color.WHITE);
		txtLastName.setColumns(10);
		txtLastName.setBounds(149, 122, 156, 36);
		txtLastName.setBackground(new Color(103, 143, 88));
		contentPane.add(txtLastName);

		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobile.setBounds(27, 163, 100, 34);
		contentPane.add(lblMobile);

		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMobile.setForeground(Color.WHITE);
		txtMobile.setBounds(174, 170, 131, 28);
		txtMobile.setBackground(new Color(103, 143, 88));
		contentPane.add(txtMobile);
		txtMobile.setColumns(10);

		JLabel label = new JLabel("09");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(149, 168, 30, 34);
		contentPane.add(label);

		JLabel lblBirthDate = new JLabel("Birth Date :");
		lblBirthDate.setForeground(Color.WHITE);
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBirthDate.setBounds(27, 207, 112, 34);
		contentPane.add(lblBirthDate);

		JLabel label_1 = new JLabel("13");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(149, 208, 30, 34);
		contentPane.add(label_1);

		txtYear = new JTextField("");
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtYear.setForeground(Color.WHITE);
		txtYear.setColumns(10);
		txtYear.setBounds(174, 214, 30, 28);
		txtYear.setBackground(new Color(103, 143, 88));
		contentPane.add(txtYear);

		JLabel label_2 = new JLabel("/");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(211, 208, 18, 34);
		contentPane.add(label_2);

		txtMonth = new JTextField("");
		txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMonth.setForeground(Color.WHITE);
		txtMonth.setColumns(10);
		txtMonth.setBounds(224, 214, 30, 28);
		txtMonth.setBackground(new Color(103, 143, 88));
		contentPane.add(txtMonth);

		JLabel label_3 = new JLabel("/");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(264, 207, 30, 34);
		contentPane.add(label_3);

		txtDay = new JTextField("");
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDay.setColumns(10);
		txtDay.setBounds(274, 214, 30, 28);
		txtDay.setBackground(new Color(103, 143, 88));
		txtDay.setForeground(Color.WHITE);
		contentPane.add(txtDay);

		JLabel lblCity = new JLabel("City :");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(27, 251, 91, 34);
		contentPane.add(lblCity);

		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCity.setForeground(Color.WHITE);
		txtCity.setColumns(10);
		txtCity.setBounds(149, 252, 156, 36);
		txtCity.setBackground(new Color(103, 143, 88));
		contentPane.add(txtCity);

		JLabel lblSex = new JLabel("Sex :");
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSex.setBounds(316, 73, 56, 34);
		contentPane.add(lblSex);
		String[] groupsToShow = new String[AddressBookSelection.addressBooks.get(whichAddressBookAddContact).getGroups()
				.size()];
		int gpCounter = 0;
		for (Group gp1 : AddressBookSelection.addressBooks.get(whichAddressBookAddContact).getGroups()) {
			groupsToShow[gpCounter] = gp1.getGroupName();
			gpCounter++;
		}
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMale.setBackground(new Color(103, 143, 88));
		rdbtnFemale.setBackground(new Color(103, 143, 88));
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnFemale.setForeground(Color.WHITE);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRadio.setText("");
				txtRadio.setText("M");
			}
		});
		rdbtnMale.setBounds(378, 81, 63, 21);
		contentPane.add(rdbtnMale);
		rdbtnFemale.setBounds(443, 81, 79, 21);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRadio.setText("");
				txtRadio.setText("F");
			}
		});
		contentPane.add(rdbtnFemale);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(401, 119, 66, 34);
		contentPane.add(lblEmail);

		txtEmail = new JTextField("");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setColumns(10);
		txtEmail.setBounds(321, 152, 201, 36);
		txtEmail.setBackground(new Color(103, 143, 88));
		contentPane.add(txtEmail);

		JButton btnDone = new JButton("Done");
		btnDone.setBackground(new Color(249, 130, 31));
		btnDone.setForeground(Color.WHITE);
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image imgDone = new ImageIcon(this.getClass().getResource("/imgDone.png")).getImage();
		btnDone.setIcon(new ImageIcon(imgDone));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// alan check mikonam ke field i khali nabashe
				if (!"".equals(txtFirstName.getText()) && !"".equals(txtMobile.getText())) {
					// alan check mikonam ke year o month o day dade shode adad bashan
					boolean dateIsChecked = false;
					boolean dateIsSet = false;
					if (!"".equals(txtYear.getText()) || !"".equals(txtYear.getText())
							|| !"".equals(txtYear.getText())) {
						try {
							Integer.parseInt(txtYear.getText());
							Integer.parseInt(txtMonth.getText());
							Integer.parseInt(txtDay.getText());
							if (txtYear.getText().length() == 2 && txtMonth.getText().length() <= 2
									&& txtDay.getText().length() <= 2) {
								dateIsSet = true;
								dateIsChecked = true;
							} else {
								JOptionPane.showMessageDialog(null, "Enter your Birth Date Correctly !");
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Enter your Birth Date Correctly !");
						}
					} else {
						dateIsChecked = true;
					}
					if (dateIsChecked) {
						try {
							// alan check mikonam ke mobile number dade shode 9 raghami va be adad ghabel
							// tabdil bashe
							Integer.parseInt(txtMobile.getText());
							if (txtMobile.getText().length() == 9) {
								boolean mobileNumberIsNew = true;
								for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookAddContact)
										.getContacts()) {
									if (cn.getMobielNumber().equals("09" + txtMobile.getText())) {
										mobileNumberIsNew = false;
									}
								}
								if (mobileNumberIsNew) {
									if (txtMonth.getText().length() == 1) {
										txtMonth.setText("0" + txtMonth.getText());
									}
									if (txtDay.getText().length() == 1) {
										txtDay.setText("0" + txtDay.getText());
									}
									String BDay = "";
									if (dateIsSet) {
										BDay = "13" + txtYear.getText() + "/" + txtMonth.getText() + "/"
												+ txtDay.getText();
									} else {
										BDay = "N/A";
									}
									Contact contact1 = new Contact(
											AddressBookSelection.addressBooks.get(whichAddressBookAddContact)
													.getContacts().size() + 1,
											txtFirstName.getText(), txtLastName.getText(), "09" + txtMobile.getText(),
											BDay, txtCity.getText(), txtRadio.getText(), "Unasigned".toString(),
											(txtEmail.getText().equals("")) ? "N/A" : txtEmail.getText() );
									AddressBookSelection.addressBooks.get(whichAddressBookAddContact).getContacts()
											.add(contact1);
									JOptionPane.showMessageDialog(null, " Done !");
									dispose();
									Main main = new Main();
									main.dispose();
									main.setVisible(true);
								} else {
									JOptionPane.showMessageDialog(null, "Mobile Number Is Taken !");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Enter your Mobile Number Correctly !");
							}
						} catch (Exception e3) {
							JOptionPane.showMessageDialog(null, "Enter your Mobile Number Correctly !");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Empty Field found !");
				}
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDone.setBounds(378, 198, 100, 46);
		contentPane.add(btnDone);

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
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				dispose();
				main.setVisible(true);
			}
		});
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(378, 247, 100, 44);
		contentPane.add(btnCancel);

		JLabel lblMainTheme = new JLabel("");
		lblMainTheme.setBounds(0, 0, 550, 328);
		contentPane.add(lblMainTheme);
		Image imgMainTheme = new ImageIcon(this.getClass().getResource("/addNewContact.jpg")).getImage();
		lblMainTheme.setIcon(new ImageIcon(imgMainTheme));

		txtRadio = new JTextField();
		txtRadio.setEnabled(false);
		txtRadio.setEditable(false);
		txtRadio.setBounds(401, 58, 96, 19);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);
		txtRadio.setBackground(new Color(103, 143, 88));
		txtRadio.setForeground(new Color(103, 143, 88));
		txtRadio.setVisible(false);
	}
}
