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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;

public class EditContact extends JFrame {

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
	public static int idCnToEdit;
	public static int whichAddressBookEditContact = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditContact frame = new EditContact();
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
	public EditContact() {
		Contact contact = new Contact();
		for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()) {
			if (idCnToEdit == cn.getID()) {
				contact = cn;
				break;
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JLabel lblNewLabel = new JLabel("Edit Contact");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(211, 13, 145, 53);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name : ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 73, 112, 34);
		contentPane.add(lblNewLabel_1);

		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(27, 119, 112, 34);
		contentPane.add(lblLastName);

		JLabel lblMobile = new JLabel("Mobile :");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobile.setBounds(27, 163, 100, 34);
		contentPane.add(lblMobile);

		JLabel label = new JLabel("09");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(149, 168, 30, 34);
		contentPane.add(label);

		JLabel lblBirthDate = new JLabel("Birth Date :");
		lblBirthDate.setForeground(Color.WHITE);
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBirthDate.setBounds(27, 207, 112, 34);
		contentPane.add(lblBirthDate);

		JLabel label_1 = new JLabel("13");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(149, 208, 30, 34);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("/");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(211, 208, 18, 34);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("/");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(264, 207, 30, 34);
		contentPane.add(label_3);

		JLabel lblCity = new JLabel("City :");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(27, 251, 91, 34);
		contentPane.add(lblCity);

		JLabel lblSex = new JLabel("Sex :");
		lblSex.setForeground(Color.WHITE);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSex.setBounds(316, 73, 56, 34);
		contentPane.add(lblSex);

		txtRadio = new JTextField();
		txtRadio.setEditable(false);
		txtRadio.setEnabled(false);
		txtRadio.setBounds(394, 56, 96, 19);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);
		txtRadio.setColumns(10);
		txtRadio.setBackground(new Color(249, 130, 31));
		txtRadio.setForeground(new Color(103, 143, 88));
		txtRadio.setVisible(false);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMale.setBackground(new Color(249, 130, 31));
		rdbtnFemale.setBackground(new Color(249, 130, 31));
		rdbtnMale.setForeground(Color.BLACK);
		rdbtnFemale.setForeground(Color.BLACK);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		if ("M".equals(contact.getSex())) {
			rdbtnMale.setSelected(true);
			txtRadio.setText("M");
		} else {
			rdbtnFemale.setSelected(true);
			txtRadio.setText("F");
		}
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
		lblEmail.setBounds(394, 119, 66, 34);
		contentPane.add(lblEmail);

		txtEmail = new JTextField((contact.getBirthDate().equals("N/A")) ? "" : contact.geteMail());
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setColumns(10);
		txtEmail.setBounds(316, 163, 201, 36);
		txtEmail.setBackground(new Color(249, 130, 31));
		contentPane.add(txtEmail);

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

		txtFirstName = new JTextField(contact.getFirstName());
		txtFirstName.setForeground(Color.BLACK);
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(new Color(249, 130, 31));
		txtFirstName.setBounds(138, 76, 156, 36);
		contentPane.add(txtFirstName);

		txtLastName = new JTextField(contact.getLastName());
		txtLastName.setForeground(Color.BLACK);
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtLastName.setColumns(10);
		txtLastName.setBackground(new Color(249, 130, 31));
		txtLastName.setBounds(138, 122, 156, 36);
		contentPane.add(txtLastName);

		txtMobile = new JTextField(contact.getMobielNumber().substring(2, contact.getMobielNumber().length()));
		txtMobile.setForeground(Color.BLACK);
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMobile.setColumns(10);
		txtMobile.setBackground(new Color(249, 130, 31));
		txtMobile.setBounds(177, 172, 117, 28);
		contentPane.add(txtMobile);

		txtYear = new JTextField((contact.getBirthDate().equals("N/A")) ? "" : Character.toString(contact.getBirthDate().charAt(2))
				+ Character.toString(contact.getBirthDate().charAt(3)));
		txtYear.setForeground(Color.BLACK);
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtYear.setColumns(10);
		txtYear.setBackground(new Color(249, 130, 31));
		txtYear.setBounds(177, 212, 30, 28);
		contentPane.add(txtYear);

		txtMonth = new JTextField((contact.getBirthDate().equals("N/A")) ? "" : Character.toString(contact.getBirthDate().charAt(5))
				+ Character.toString(contact.getBirthDate().charAt(6)));
		txtMonth.setForeground(Color.BLACK);
		txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMonth.setColumns(10);
		txtMonth.setBackground(new Color(249, 130, 31));
		txtMonth.setBounds(224, 211, 30, 28);
		contentPane.add(txtMonth);

		txtDay = new JTextField((contact.getBirthDate().equals("N/A")) ? "" : Character.toString(contact.getBirthDate().charAt(8))
				+ Character.toString(contact.getBirthDate().charAt(9)));
		txtDay.setForeground(Color.BLACK);
		txtDay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDay.setColumns(10);
		txtDay.setBackground(new Color(249, 130, 31));
		txtDay.setBounds(275, 211, 30, 28);
		contentPane.add(txtDay);

		txtCity = new JTextField(contact.getLivingOhrt());
		txtCity.setForeground(Color.BLACK);
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCity.setColumns(10);
		txtCity.setBackground(new Color(249, 130, 31));
		txtCity.setBounds(138, 251, 156, 36);
		contentPane.add(txtCity);

		String[] groupsToShow = new String[AddressBookSelection.addressBooks.get(whichAddressBookEditContact)
				.getGroups().size()];
		for (int i = 0; i < AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getGroups()
				.size(); i++) {
			groupsToShow[i] = AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getGroups().get(i)
					.getGroupName().toString();
		}
		JButton btnDone = new JButton("Update");
		btnDone.setBackground(new Color(103, 143, 88));
		btnDone.setForeground(Color.WHITE);
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image imgDone = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
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
								for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookEditContact)
										.getContacts()) {
									if (cn.getMobielNumber().equals("09" + txtMobile.getText())) {
										if (cn.getID() != idCnToEdit) {
											mobileNumberIsNew = false;
										}
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
									// hala miram oon jadidaro too field hash set mikonam, ya khodeshe, ya taghir
									// dade shodast :)
									AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()
											.get(idCnToEdit - 1).setFirstName(txtFirstName.getText());
									AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()
											.get(idCnToEdit - 1).setLastName(txtLastName.getText());
									AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()
											.get(idCnToEdit - 1).setMobielNumber("09" + txtMobile.getText());
									AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()
											.get(idCnToEdit - 1).setBirthDate(BDay);
									AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()
											.get(idCnToEdit - 1).setLivingOhrt(txtCity.getText());
									AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()
											.get(idCnToEdit - 1).setSex(txtRadio.getText());
									AddressBookSelection.addressBooks.get(whichAddressBookEditContact).getContacts()
											.get(idCnToEdit - 1).seteMail((txtEmail.getText().equals("")) ? "N/A" : txtEmail.getText());
									JOptionPane.showMessageDialog(null, " Done !");
									dispose();
									Main main = new Main();
									main.dispose();
									main.setVisible(true);
								} else {
									JOptionPane.showMessageDialog(null, "Mobile Number Is Taken !");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Enter your Mobile Number Correctly !!!");
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
		btnDone.setBounds(401, 246, 121, 46);
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
		btnCancel.setBounds(316, 247, 81, 44);
		contentPane.add(btnCancel);

		JLabel lblMainTheme = new JLabel("");
		lblMainTheme.setBounds(0, 0, 550, 328);
		contentPane.add(lblMainTheme);
		lblMainTheme.setIcon(new ImageIcon(imgMainTheme));

	}
}
