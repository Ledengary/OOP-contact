package MainFrames;

import Classes.*;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable tableDisplayAllContacts;
	private JScrollPane scrollPane;
	private JButton btnDeleteContact;
	private JButton btnEditContact;
	private JButton btnAddGroup;
	private JButton btnEditGroup;
	private JButton btnDeleteGroup;
	private JButton btnAddLocation;
	private JButton btnAddContactGroup;
	private JLabel lblWhicAddressBook;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel_1;
	private JLabel lblContacts;
	private JLabel lblGroups;
	private JLabel lblLocation;
	public static int whichAddressBookMain = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		AddressBook addressBook = new AddressBook();
		;
		// to in ghesmat check mikonim agar avalin bar e ke barname run mishe pas hatman
		// ye group i be nam Unasigned dorost kone o save kone to groups e addressbook i
		// ke alan toosh hastims
		if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().size() == 0) {
			Group gpUnasigned = new Group(0, "Unasigned");
			AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().add(0, gpUnasigned);
		} else {
			if (!"Unasigned".equals(
					AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().get(0).getGroupName())) {
				Group gpUnasigned = new Group(0, "Unasigned");
				AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().add(0, gpUnasigned);
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 31, 25));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JLabel lblClose = new JLabel("");
		lblClose.setBounds(960, 0, 32, 32);
		lblClose.setForeground(new Color(230, 230, 250));
		contentPane.add(lblClose);
		Image imgClose = new ImageIcon(this.getClass().getResource("/close_24.png")).getImage();
		lblClose.setIcon(new ImageIcon(imgClose));
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();

			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 42, 946, 294);
		scrollPane.getViewport().setBackground(new Color(26, 31, 25));
		contentPane.add(scrollPane);
		String[] colNames = { "ID", "Name", "Mobile", "Email", "Located", "Group" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		tableDisplayAllContacts = new JTable(model);
		tableDisplayAllContacts.setShowGrid(false);
		tableDisplayAllContacts.setForeground(Color.WHITE);
		tableDisplayAllContacts.setBackground(new Color(26, 31, 25));
		tableDisplayAllContacts.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableDisplayAllContacts.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableDisplayAllContacts.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableDisplayAllContacts.getColumnModel().getColumn(3).setPreferredWidth(169);
		tableDisplayAllContacts.getColumnModel().getColumn(4).setPreferredWidth(49);
		tableDisplayAllContacts.getColumnModel().getColumn(5).setPreferredWidth(49);
		tableDisplayAllContacts.setEnabled(false);
		tableDisplayAllContacts.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableDisplayAllContacts.setRowHeight(30);
		// hala shoroo mikonim be khoondan tak tak contact ha va harkodoomeshoon ro too
		// table insert mikonim (ya be goli add mikonim)
		for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()) {
			String[] Object = { "  " + cn.getID(), cn.getFirstName() + " " + cn.getLastName(), cn.getMobielNumber(),
					cn.geteMail(), (cn.getIsLocated() == true) ? "          YES" : "          NO", cn.getGroup() };
			model.addRow(Object);
		}
		tableDisplayAllContacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// agar rooye yei az row ha ckick shod method toString oon row ro dar ghemat
				// show more neshoon bedatesh
				int row = tableDisplayAllContacts.getSelectedRow();
				ShowMore.whichAddressBookShowMore = whichAddressBookMain;
				ShowMore.idCnToShow = row + 1;
				ShowMore showMoreDetails = new ShowMore();
				dispose();
				showMoreDetails.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				tableDisplayAllContacts.setEnabled(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				tableDisplayAllContacts.setForeground(Color.WHITE);
				tableDisplayAllContacts.setBackground(new Color(103, 143, 88));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				tableDisplayAllContacts.setEnabled(false);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				tableDisplayAllContacts.setForeground(Color.WHITE);
				tableDisplayAllContacts.setBackground(new Color(26, 31, 25));
			}
		});
		JTableHeader tableHeader = tableDisplayAllContacts.getTableHeader();
		tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		tableHeader.setBackground(new Color(26, 31, 25));
		tableHeader.setForeground(Color.WHITE);
		scrollPane.setViewportView(tableDisplayAllContacts);

		JButton btnMain = new JButton("   Add Contact");
		btnMain.setBackground(new Color(245, 245, 245));
		btnMain.setBounds(767, 373, 199, 48);
		btnMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image imgAdd = new ImageIcon(this.getClass().getResource("/addContact.png")).getImage();
		btnMain.setIcon(new ImageIcon(imgAdd));
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddContact addContact = new AddContact();
				addContact.setVisible(true);
				dispose();
			}
		});

		btnMain.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnMain);
		Image imgMainTheme = new ImageIcon(this.getClass().getResource("/projectThemeMain.jpg")).getImage();

		btnDeleteContact = new JButton("   Delete Contact");
		btnDeleteContact.setForeground(Color.BLACK);
		btnDeleteContact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteContact.setBackground(Color.RED);
		Image imgDelete = new ImageIcon(this.getClass().getResource("/removeContact.png")).getImage();
		btnDeleteContact.setIcon(new ImageIcon(imgDelete));
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts().size() != 0) {
					try {
						int deleteByContactIDOrGroup = Integer.parseInt(
								JOptionPane.showInputDialog("Delete by Contact ID (0) / Delete by Group (1)"));
						if (deleteByContactIDOrGroup == 0) {
							// hala ke karbar delete kardan ba asas id ro entekhab karde mitone chandin id
							// bede, ke tebgh farz oonaro ba space joda karde pas ma ham az method split by
							// space estefade mikonim
							String[] ContactToDeleteString = JOptionPane
									.showInputDialog("Enter Contact ID to delete it : (Split IDs by Space)").toString()
									.split("\\s+");
							// variable areYouSureToDeleteAllTheseContacts faghat yek String e baraye
							// namayesh dadan nam va family contact haayi ke motmaene mikhad hameshoono
							// delete kone
							String areYouSureToDeleteAllTheseContacts = "";
							for (int i = 0; i < ContactToDeleteString.length; i++) {
								areYouSureToDeleteAllTheseContacts += " / "
										+ AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
												.get(Integer.parseInt(ContactToDeleteString[i]) - 1).getFirstName()
										+ " "
										+ AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
												.get(Integer.parseInt(ContactToDeleteString[i]) - 1).getLastName();
							}
							// hala bia check konim tak tak id haro bebinim ye vaght id alaki nabashe too
							// beineshoon
							boolean noProblemToDeleteAllContacts = true;
							for (int i = 0; i < ContactToDeleteString.length; i++) {
								if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
										.size() < Integer.parseInt(ContactToDeleteString[i])
										|| Integer.parseInt(ContactToDeleteString[i]) <= 0) {
									noProblemToDeleteAllContacts = false;
								}
							}
							if (noProblemToDeleteAllContacts) {
								areYouSureToDeleteAllTheseContacts = areYouSureToDeleteAllTheseContacts.substring(3,
										areYouSureToDeleteAllTheseContacts.length());
								int dialogButton = 0;
								int dialogResult = JOptionPane
										.showConfirmDialog(null,
												"Are you sure you want to delete => "
														+ areYouSureToDeleteAllTheseContacts + " ?",
												"Warning", dialogButton);
								if (dialogResult == JOptionPane.YES_OPTION) {
									try {
										int howManyIsDeletedTillRightNow = 0;
										System.out.println("ContactToDeleteString.length is " + ContactToDeleteString.length);
										for (int j = 0; j < ContactToDeleteString.length; j++) {
											System.out.println(ContactToDeleteString[j]);
											// agar in contact avalin contact i e ke mikhad delete kone NABOOD
											// hatman -2
											// kon chon id namayeshi table asli ba id i ke too
											// addressbook.getcontacts dare yeki nist &&&& va inke ghablesh hatman
											// yeki dg ham delete shode pas mishe -2 !

											// ye check kuchik ham mikonam ke age is located e contact i ke mikhaim
											// deetesh konim true bood hatman location marboote roham deletesh konim
											// !
											if (AddressBookSelection.addressBooks.get(whichAddressBookMain)
													.getContacts().get((Integer.parseInt(ContactToDeleteString[j]) - 1)
															- howManyIsDeletedTillRightNow)
													.getIsLocated()) {
												for (int k = 0; k < AddressBookSelection.addressBooks
														.get(whichAddressBookMain).getLocations().size(); k++) {
													if (AddressBookSelection.addressBooks.get(whichAddressBookMain)
															.getLocations().get(k).getLocationForID() == Integer
																	.parseInt(ContactToDeleteString[j])) {
														AddressBookSelection.addressBooks.get(whichAddressBookMain)
																.getLocations().remove(k);
													}
												}
											}
											AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
													.remove((Integer.parseInt(ContactToDeleteString[j]) - 1)
															- howManyIsDeletedTillRightNow);
											AddressBook.sortIDs(whichAddressBookMain);
											howManyIsDeletedTillRightNow++;
										}
									} catch (Exception e2) {
										// TODO: handle exception
									}
									if (ContactToDeleteString.length != 1) {
										JOptionPane.showMessageDialog(null,
												areYouSureToDeleteAllTheseContacts + " are Deleted");
									} else {
										JOptionPane.showMessageDialog(null,
												areYouSureToDeleteAllTheseContacts + " is Deleted");
									}
									Main main = new Main();
									dispose();
									main.setVisible(true);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Wrong ID given !");
							}
						} else {
							// karbar select karde ke bekhad by group delete kone
							if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().size() != 1) {
								// hala array i az be andaze kole groups haye mojood dar addressbook dorost
								// mikonim && tak takeshoon ro ba esm group ha por mikonim
								String[] groupsToShowForEditNames = new String[AddressBookSelection.addressBooks
										.get(whichAddressBookMain).getGroups().size() - 1];
								int groupsCounter = 0;
								for (int i = 1; i < AddressBookSelection.addressBooks.get(whichAddressBookMain)
										.getGroups().size(); i++) {
									groupsToShowForEditNames[groupsCounter] = AddressBookSelection.addressBooks
											.get(whichAddressBookMain).getGroups().get(i).getGroupName();
									groupsCounter++;
								}

								JComboBox jcd = new JComboBox(groupsToShowForEditNames);
								String[] options = { "OK" };
								JPanel panel = new JPanel();
								JLabel lbl = new JLabel("Choose your Group to Edit : ");
								JTextField txt = new JTextField(10);
								panel.add(lbl);
								panel.add(jcd);
								int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title",
										JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
								// selectedOption == 0 yani inke rooye ok click karde !
								if (selectedOption == 0) {
									try {
										// hala tak tak contact haro migirm va groups haro mikeshim biroon ke do tahalat
										// dare ya yedoonast ya chanda ke age chandta bashe hatman ba _ az ham split
										// shodan pas check mikonimeshoon
										boolean isThereAnyContactThasHasThisGroupInIt = false;
										for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain)
												.getContacts()) {
											if (cn.getGroup().indexOf("_") != -1) {
												String[] groupsThatExistInContactGroup = cn.getGroup().split("_");
												for (int i = 0; i < groupsThatExistInContactGroup.length; i++) {
													if (groupsThatExistInContactGroup[i]
															.equals(jcd.getSelectedItem().toString())) {
														isThereAnyContactThasHasThisGroupInIt = true;
														break;
													}
												}
											} else {
												if (jcd.getSelectedItem().toString().equals(cn.getGroup())) {
													isThereAnyContactThasHasThisGroupInIt = true;
												}
											}
										}
										if (isThereAnyContactThasHasThisGroupInIt) {
											int dialogButton = 0;
											int dialogResult = JOptionPane
													.showConfirmDialog(
															null, "Are you sure you want to delete "
																	+ jcd.getSelectedItem() + "'s Contacts ?",
															"Warning", dialogButton);
											// hala ma ye variabe i dorost mikonim be nam
											// contactsThatHaveToBeDeletedString, ke aval miaim tak tak contact ha group
											// hashoon ro check mikonim, age yeki az group hashoon ba oon group mad
											// nazar ma barabar bood id contact ro ezafe mikonim too
											// contactsThatHaveToBeDeletedString va harkodoomo ba _ joda mikonim
											if (dialogResult == JOptionPane.YES_OPTION) {
												String contactsThatHaveToBeDeletedString = "";
												for (Contact cn : AddressBookSelection.addressBooks
														.get(whichAddressBookMain).getContacts()) {
													if (cn.getGroup().indexOf("_") != -1) {
														String[] groupsThatExistInContactGroup = cn.getGroup()
																.split("_");
														for (int i = 0; i < groupsThatExistInContactGroup.length; i++) {
															if (groupsThatExistInContactGroup[i]
																	.equals(jcd.getSelectedItem().toString())) {
																contactsThatHaveToBeDeletedString += "_"
																		+ (cn.getID() - 1);
															}
														}
													} else {
														if (jcd.getSelectedItem().toString().equals(cn.getGroup())) {
															contactsThatHaveToBeDeletedString += "_" + (cn.getID() - 1);
														}
													}
												}
												contactsThatHaveToBeDeletedString = contactsThatHaveToBeDeletedString
														.substring(1, contactsThatHaveToBeDeletedString.length());
												String[] contactsThatHaveToBeDeleted = contactsThatHaveToBeDeletedString
														.split("_");
												int howManyIsDeletedTillNow = 0;
												// hala har kodoom az mohtaviat contactsThatHaveToBeDeletedString ro ke
												// id haye contact hayian ke bayesti delete beshan ro delete mikonim
												System.out.println(contactsThatHaveToBeDeleted.length);
												for (int i = 0; i < contactsThatHaveToBeDeleted.length; i++) {
													AddressBookSelection.addressBooks.get(whichAddressBookMain)
															.getContacts()
															.remove(Integer.parseInt(contactsThatHaveToBeDeleted[i])
																	- howManyIsDeletedTillNow);
													howManyIsDeletedTillNow++;
													AddressBook.sortIDs(whichAddressBookMain);
												}
												Main main = new Main();
												dispose();
												main.setVisible(true);
												JOptionPane.showMessageDialog(null,
														jcd.getSelectedItem() + "'s Members got Deleted !");
											}
										} else {
											JOptionPane.showMessageDialog(null, "No Contacts Available in "
													+ jcd.getSelectedItem() + "'s Group to delete !");
										}
									} catch (Exception e2) {
										JOptionPane.showMessageDialog(null, "Failed...");
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "No Groups Available to delete its Contacts !");
							}
						}
					} catch (Exception e4) {

					}
				} else {
					JOptionPane.showMessageDialog(null, "No Contacts Available to delete !");
				}
			}
		});
		btnDeleteContact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteContact.setBackground(new Color(245, 245, 245));
		btnDeleteContact.setBounds(544, 373, 199, 48);
		contentPane.add(btnDeleteContact);

		btnEditContact = new JButton("   Edit Contact");
		btnEditContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts().size() != 0) {
					int contactToEdit = 0;
					contactToEdit = Integer.parseInt(JOptionPane.showInputDialog("Enter Contact ID to edit it :"));
					if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
							.size() >= contactToEdit || contactToEdit <= 0) {
						// id contact i ro ke mikham edit konim ro be safhe morede nazar mifrestim
						EditContact.idCnToEdit = contactToEdit;
						EditContact editContact = new EditContact();
						dispose();
						editContact.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Enter the ID Correctly !");
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Contacts Available to delete !");
				}
			}
		});
		btnEditContact.setForeground(Color.BLACK);
		btnEditContact.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEditContact.setBackground(Color.WHITE);
		btnEditContact.setBounds(321, 373, 199, 48);
		btnEditContact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image imgEdit = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		btnEditContact.setIcon(new ImageIcon(imgEdit));
		contentPane.add(btnEditContact);

		btnAddGroup = new JButton("   Add Group");
		Image imgAddGp = new ImageIcon(this.getClass().getResource("/addGroupFinal.png")).getImage();
		btnAddGroup.setIcon(new ImageIcon(imgAddGp));
		btnAddGroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newGroupName = JOptionPane.showInputDialog("Enter the new Group's Name :");
				boolean gpNameIsNew = true;
				for (Group gp : AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups()) {
					if (newGroupName.equals(gp.getGroupName())) {
						gpNameIsNew = false;
					}
				}
				if (newGroupName != null) {
					if (!"".equals(newGroupName)) {
						try {
							if (gpNameIsNew) {
								Group group = new Group(
										AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().size(),
										newGroupName);
								AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().add(group);
								JOptionPane.showMessageDialog(null, newGroupName + " Group Added !");
							} else {
								JOptionPane.showMessageDialog(null, "Name is already Taken for an another group !");
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Enter the Name Correct !");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Empty Text Field dude -_-");
					}
				}
			}
		});
		btnAddGroup.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddGroup.setBackground(new Color(245, 245, 245));
		btnAddGroup.setBounds(767, 447, 199, 48);
		contentPane.add(btnAddGroup);

		btnEditGroup = new JButton("   Edit Group");
		Image imgbtnEditGroup = new ImageIcon(this.getClass().getResource("/editGroup.png")).getImage();
		btnEditGroup.setIcon(new ImageIcon(imgbtnEditGroup));
		btnEditGroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().size() != 1) {
					String[] groupsToShowForEditNames = new String[AddressBookSelection.addressBooks
							.get(whichAddressBookMain).getGroups().size() - 1];
					int groupsCounter = 0;
					for (int i = 1; i < AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups()
							.size(); i++) {
						groupsToShowForEditNames[groupsCounter] = AddressBookSelection.addressBooks
								.get(whichAddressBookMain).getGroups().get(i).getGroupName();
						groupsCounter++;
					}

					JComboBox jcd = new JComboBox(groupsToShowForEditNames);
					String[] options = { "OK" };
					JPanel panel = new JPanel();
					JLabel lbl = new JLabel("Choose your Group to Edit : ");
					JTextField txt = new JTextField(10);
					panel.add(lbl);
					panel.add(jcd);
					int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title", JOptionPane.NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (selectedOption == 0) {
						// ta alan az beine tamami group haye sakhte shode (be gheir az Unasigned ke
						// mishe avali) hamaro khoonde o dakhel JComboBox rikhte va entekhab shode va ok
						// ro ham click karde, hala mirim soragh edit kardan selectedItem :)
						try {
							String groupToEdit = JOptionPane.showInputDialog(
									"Edit Panel for " + jcd.getSelectedItem().toString() + " :",
									jcd.getSelectedItem().toString());
							if (!groupToEdit.isEmpty()) {
								// to command khat badi esmesh roo dar addressbook's groups edit mionim
								AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups()
										.get(jcd.getSelectedIndex() + 1).setGroupName(groupToEdit);
								// dar command khat haye badi mibinim agar contact i jozv group bood esme oonam
								// update beshe
								// baraye in kar aval do ta variable be nam haye cnGroup va cnGroupFinal taarif
								// mikonim ke avali baraye peida kadan tamami group haye karbar morede nazar ast
								// ke bayesti ba _ az hamdige joda beshan va dovomi ham baraye write kardan
								// majmooe group haye joda shode ba _ dorost to field groups cn morede nazar e
								for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain)
										.getContacts()) {
									if (cn.getGroup().indexOf("_") != -1) {
										String[] cnGroups = cn.getGroup().split("_");
										String cnGroupFinal = "";
										for (int i = 0; i < cnGroups.length; i++) {
											if (cnGroups[i].equals(jcd.getSelectedItem().toString())) {
												cnGroupFinal = cn.getGroup().substring(0,
														cn.getGroup().indexOf(jcd.getSelectedItem().toString()))
														+ groupToEdit
														+ cn.getGroup().substring(
																cn.getGroup().indexOf(jcd.getSelectedItem().toString())
																		+ jcd.getSelectedItem().toString().length(),
																cn.getGroup().length());
												cn.setGroup(cnGroupFinal);
											}
										}
									} else {
										if (jcd.getSelectedItem().toString().equals(cn.getGroup())) {
											cn.setGroup(groupToEdit);
										}
									}
								}
								JOptionPane.showMessageDialog(null,
										jcd.getSelectedItem().toString() + " group edited to : " + groupToEdit);
								Main main = new Main();
								dispose();
								main.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "Empty Text Field -_-");
							}

						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Groups Available !");
				}
			}
		});
		btnEditGroup.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEditGroup.setBackground(new Color(245, 245, 245));
		btnEditGroup.setBounds(321, 447, 199, 48);
		contentPane.add(btnEditGroup);

		btnDeleteGroup = new JButton("   Delete Group");
		Image imgbtnDeleteGroup = new ImageIcon(this.getClass().getResource("/deleteGroup.png")).getImage();
		btnDeleteGroup.setIcon(new ImageIcon(imgbtnDeleteGroup));
		btnDeleteGroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups().size() != 1) {
					String[] groupsToShowForDeleting = new String[AddressBookSelection.addressBooks
							.get(whichAddressBookMain).getGroups().size() - 1];
					int groupsCounter = 0;
					for (int i = 1; i < AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups()
							.size(); i++) {
						groupsToShowForDeleting[groupsCounter] = AddressBookSelection.addressBooks
								.get(whichAddressBookMain).getGroups().get(i).getGroupName();
						groupsCounter++;
					}

					JComboBox jcd = new JComboBox(groupsToShowForDeleting);
					String[] options = { "OK" };
					JPanel panel = new JPanel();
					JLabel lbl = new JLabel("Choose your Group to Delete : ");
					JTextField txt = new JTextField(10);
					panel.add(lbl);
					panel.add(jcd);
					int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title", JOptionPane.NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (selectedOption == 0) {
						int dialogButton = 0;
						int dialogResult = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete " + jcd.getSelectedItem() + "?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain)
									.getContacts()) {
								String tempGroup = cn.getGroup();
								if (cn.getGroup().indexOf("_") != -1) {
									// in this part we try to see if a contact has the specified group in itself, if
									// yes then we delete the group's name from cn's group string
									String[] groupsThatExistInContactGroup = cn.getGroup().split("_");
									for (int i = 0; i < groupsThatExistInContactGroup.length; i++) {
										String newGroupString = "";
										if (groupsThatExistInContactGroup[i].equals(jcd.getSelectedItem().toString())) {
											for (int j = 0; j < groupsThatExistInContactGroup.length; j++) {
												if (j != i) {
													newGroupString += groupsThatExistInContactGroup[j] + "_";
												}
											}
											newGroupString = newGroupString.substring(0, newGroupString.length() - 1);
											cn.setGroup(newGroupString);
											break;
										}
									}
								} else {
									if (jcd.getSelectedItem().toString().equals(cn.getGroup())) {
										cn.setGroup("Unasigned");
									}
								}
							}
							AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups()
									.remove(jcd.getSelectedIndex() + 1);
							JOptionPane.showMessageDialog(null, jcd.getSelectedItem().toString() + " Deleted !");
						}
						Main main = new Main();
						dispose();
						main.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Groups available  to Delete !");
				}
			}

			private String deleteArray(String[] groupsThatExistInContactGroup, int i) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnDeleteGroup.setForeground(Color.BLACK);
		btnDeleteGroup.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteGroup.setBackground(Color.WHITE);
		btnDeleteGroup.setBounds(544, 447, 199, 48);
		contentPane.add(btnDeleteGroup);

		JButton btnNewButton = new JButton("Object Reader");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("----------------------------------");
				System.out.println("Groups :");
				for (Group gp : AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups()) {
					System.out.println(gp.getGroupName());
				}
				System.out.println("----------------------------------");
				System.out.println("Contacts :");
				for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()) {
					System.out.println(cn.getFirstName() + " " + cn.getLastName() + " " + cn.getMobielNumber());
				}
				System.out.println("----------------------------------");
				System.out.println("Contact Locations :");
				for (Location ln : AddressBookSelection.addressBooks.get(whichAddressBookMain).getLocations()) {
					Contact contact1 = new Contact();
					contact1 = AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
							.get(ln.getLocationForID() - 1);
					System.out.println(
							contact1.getFirstName() + " " + contact1.getLastName() + " is at " + ln.getLatitude() + " "
									+ ln.getLongitude() + " (Radius : " + ln.getRadius() + ")" + " | locatedForID : "
									+ ln.getLocationForID() + " | isLocated :" + contact1.getIsLocated());
				}
				System.out.println("----------------------------------");
				System.out.println("Location :");
				for (Location ln : AddressBookSelection.addressBooks.get(whichAddressBookMain).getLocations()) {
					System.out.println(ln.getLocationForID());
				}
				System.out.println("----------------------------------");
				System.out.println("Contacts :");
				for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()) {
					System.out.println(cn.getProfilePictureAddress());
				}
			}
		});
		btnNewButton.setBounds(101, 519, 199, 48);
		contentPane.add(btnNewButton);

		btnAddLocation = new JButton("   Add Location");
		Image imgBtnAddLocation = new ImageIcon(this.getClass().getResource("/location.png")).getImage();
		btnAddLocation.setIcon(new ImageIcon(imgBtnAddLocation));
		btnAddLocation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts().size() != 0) {
					int contactToAddLocationTo = 0;
					// to in ghesmat aval id ye contact ro migirim ke bad etelaateshro begirim ya be
					// estelah "Locate" esh konim
					contactToAddLocationTo = Integer
							.parseInt(JOptionPane.showInputDialog("Enter Contact ID to Locate :"));
					if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
							.size() >= contactToAddLocationTo || contactToAddLocationTo <= 0) {
						LocationFrame.idCnToLocate = contactToAddLocationTo;
						LocationFrame location = new LocationFrame();
						dispose();
						location.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Enter the ID Correctly !");
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Contacts Available to Locate !");
				}
			}
		});
		btnAddLocation.setForeground(Color.BLACK);
		btnAddLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddLocation.setBackground(Color.WHITE);
		btnAddLocation.setBounds(544, 518, 199, 48);
		contentPane.add(btnAddLocation);

		btnAddContactGroup = new JButton("   Group Management");
		Image imgbtnAddContactGroup = new ImageIcon(this.getClass().getResource("/btnAddContactGroup.png")).getImage();
		btnAddContactGroup.setIcon(new ImageIcon(imgbtnAddContactGroup));
		btnAddContactGroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddContactGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts().size() != 0) {
					try {
						int contactToEdit = 0;
						contactToEdit = Integer.parseInt(JOptionPane.showInputDialog("Enter Contact ID to edit it :"));
						if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
								.size() >= contactToEdit || contactToEdit <= 0) {
							if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
									.get(contactToEdit - 1).getGroup().indexOf("_") == -1
									&& AddressBookSelection.addressBooks.get(whichAddressBookMain).getGroups()
											.size() == 1) {
								JOptionPane.showMessageDialog(null, "No Groups Available !");
							} else {
								// aval az hame, mirim soragh checkbox hayi ke gharare az group ha sakhte va
								// namayesh dade beshan, pas ye arraylist az jens JCheckBox dorost mikonim,
								ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
								String[] options = { "OK" };
								JPanel panel = new JPanel();
								JLabel lbl = new JLabel("Choose your Group to Edit : ");
								JTextField txt = new JTextField(10);
								panel.add(lbl);
								String[] groupsThatTheContactIsInThemTillNow;
								String temp = AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
										.get(contactToEdit - 1).getGroup() + "_";
								// dovom inke mibinim contact mored nazar ke ava kar id esh ro vared karde
								// karbar, ozv che gp hayi hast le age faghat Unasigned bood yani hichva age na
								// ke oonaro too array mirizimeshoon
								if (!"Unasigned".equals(temp.substring(0, temp.indexOf("_")))) {
									groupsThatTheContactIsInThemTillNow = AddressBookSelection.addressBooks
											.get(whichAddressBookMain).getContacts().get(contactToEdit - 1).getGroup()
											.split("_");
								} else {
									groupsThatTheContactIsInThemTillNow = new String[] {};
								}
								// sevom inke shoroo mikonim be khoondan gp ha az addressBook,
								for (Group gp : AddressBookSelection.addressBooks.get(whichAddressBookMain)
										.getGroups()) {
									// if Unasigned nabood...
									if (gp.getID() != 0) {
										// hala be ezaye har gp ye checkbox mikhaim ke haminja dorost mikonim
										JCheckBox box = new JCheckBox(gp.getGroupName());
										// hala ye check riz mizanim ke bebinim agar karbar dar hale hazer pzv in gp
										// hast pas baghalesh ro tik dar konim
										for (int i = 0; i < groupsThatTheContactIsInThemTillNow.length; i++) {
											if (gp.getGroupName().equals(groupsThatTheContactIsInThemTillNow[i])) {
												box.setSelected(true);
											}
										}
										// hala checkbox haro be panel add mikonimeshoon
										checkboxes.add(box);
										panel.add(box);
									}
								}
								// khob ta alan marahele neshoon dade panel ba checkBox hash maloom va tamam
								// shod,
								// alan mirim soragh khoondan tak tak checkBox ha ke agar tik dar bood
								// harkodoomeshoon esm oon gp haro ba _ joda mikonim va to field Groups contact
								// add mikonim
								int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title",
										JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
								if (selectedOption == 0) {
									// next line reads the same checkboxes that we have just added to the panel and
									// checks them if they're checked
									String printToContactGroup = "";
									for (JCheckBox boxes : checkboxes) {
										if (boxes.isSelected()) {
											printToContactGroup += boxes.getText() + "_";
										}
									}
									if (printToContactGroup == "") {
										printToContactGroup = "Unasigned_";
									}
									printToContactGroup = printToContactGroup.substring(0,
											printToContactGroup.length() - 1);
									AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
											.get(contactToEdit - 1).setGroup(printToContactGroup);
									Main main = new Main();
									dispose();
									main.setVisible(true);
									JOptionPane.showMessageDialog(null, "Updated !");
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Enter the ID Correctly !");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Contacts Available to Add Groups to !");
				}
			}
		});
		btnAddContactGroup.setForeground(Color.BLACK);
		btnAddContactGroup.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddContactGroup.setBackground(Color.WHITE);
		btnAddContactGroup.setBounds(43, 447, 257, 48);
		contentPane.add(btnAddContactGroup);

		JButton btnFindNeighbour = new JButton("   Find Neighbour");
		btnFindNeighbour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindNeighbour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int deleteByContactIDOrGroup = Integer
							.parseInt(JOptionPane.showInputDialog("Find all (0) / Find by Mutual Group (1)"));
					boolean byGroupOrNot = false;
					if (deleteByContactIDOrGroup != 0 || deleteByContactIDOrGroup != 1) {
						JOptionPane.showMessageDialog(null, "Enter a number of 0 or 1 !");
						Main main = new Main();
						dispose();
						main.setVisible(true);
					} else {
						if (deleteByContactIDOrGroup == 1) {
							byGroupOrNot = true;
						}
					}
					if (Contact.getIsLocateds(whichAddressBookMain) >= 2) {
						int contactToFindNeighbour = 0;
						contactToFindNeighbour = Integer
								.parseInt(JOptionPane.showInputDialog("Enter Contact ID to find it's neighbours :"));
						if (AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
								.size() >= contactToFindNeighbour || contactToFindNeighbour <= 0) {
							if (!"".equals(Contact.findNeighbourAll(contactToFindNeighbour, byGroupOrNot,
									contactToFindNeighbour))) {
								// too khat badi check mikonim ke age neighbour hash yedoonsat ya chandta
								if (Contact
										.findNeighbourAll(contactToFindNeighbour, byGroupOrNot, contactToFindNeighbour)
										.indexOf("_") != -1) {
									String[] findNeighbourAllAnswer = Contact.findNeighbourAll(contactToFindNeighbour,
											byGroupOrNot, contactToFindNeighbour).split("_");
									String findNeighbourFinalAnswer = "";
									// ta inja ma id hayi ke neighbour id morede nazar ma hastan ro darim, hala
									// mirim donba firstName hashoon baraye namayesh dar JOptionPane
									for (int i = 0; i < findNeighbourAllAnswer.length; i++) {
										findNeighbourFinalAnswer += " and " + AddressBookSelection.addressBooks
												.get(whichAddressBookMain).getContacts()
												.get(Integer.parseInt(findNeighbourAllAnswer[i]) - 1).getFirstName();
									}
									JOptionPane.showMessageDialog(null,
											findNeighbourFinalAnswer.substring(5, findNeighbourFinalAnswer.length())
													+ " are all "
													+ AddressBookSelection.addressBooks.get(whichAddressBookMain)
															.getContacts().get(contactToFindNeighbour - 1)
															.getFirstName()
													+ "'s Neighbours !");
								} else {
									JOptionPane.showMessageDialog(null, AddressBookSelection.addressBooks
											.get(whichAddressBookMain).getContacts()
											.get(Integer.parseInt(Contact.findNeighbourAll(contactToFindNeighbour,
													byGroupOrNot, contactToFindNeighbour)) - 1)
											.getFirstName() + " is "
											+ AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
													.get(contactToFindNeighbour - 1).getFirstName()
											+ "'s Neighbour !");
								}
							} else {
								JOptionPane.showMessageDialog(null, "No Neighbours found !");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Enter the ID Correctly !");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Limited Contacts Available found !");
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		Image imgbtnFindNeighbour = new ImageIcon(this.getClass().getResource("/findNeighbour.png")).getImage();
		btnFindNeighbour.setIcon(new ImageIcon(imgbtnFindNeighbour));
		btnFindNeighbour.setForeground(Color.BLACK);
		btnFindNeighbour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnFindNeighbour.setBackground(Color.WHITE);
		btnFindNeighbour.setBounds(767, 518, 199, 48);
		contentPane.add(btnFindNeighbour);

		lblWhicAddressBook = new JLabel("");
		lblWhicAddressBook.setBounds(20, 10, 250, 22);
		contentPane.add(lblWhicAddressBook);
		lblWhicAddressBook
				.setText(AddressBookSelection.addressBooks.get(whichAddressBookMain).getName() + " Address Book");
		lblWhicAddressBook.setForeground(Color.WHITE);
		lblWhicAddressBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWhicAddressBook.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AddressBookSelection addressBookSelection = new AddressBookSelection();
				dispose();
				addressBookSelection.setVisible(true);
			}
		});

		lblContacts = new JLabel("Contacts ( "
				+ AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts().size() + " Available )");
		lblContacts.setForeground(Color.WHITE);
		lblContacts.setBounds(20, 346, 500, 13);
		contentPane.add(lblContacts);

		lblNewLabel = new JLabel(
				"______________________________________________________________________________________________________________________");
		lblNewLabel.setForeground(new Color(108, 144, 98));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 410, 946, 32);
		contentPane.add(lblNewLabel);

		label = new JLabel(
				"______________________________________________________________________________________________________________________");
		label.setForeground(new Color(108, 144, 98));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(20, 341, 946, 32);
		contentPane.add(label);

		label_1 = new JLabel(
				"______________________________________________________________________________________________________________________");
		label_1.setForeground(new Color(108, 144, 98));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(20, 489, 946, 32);
		contentPane.add(label_1);

		lblNewLabel_1 = new JLabel("Project 4");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(458, 15, 71, 13);
		contentPane.add(lblNewLabel_1);

		lblGroups = new JLabel("Groups");
		lblGroups.setForeground(Color.WHITE);
		lblGroups.setBounds(20, 415, 71, 13);
		contentPane.add(lblGroups);

		lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setBounds(20, 519, 71, 13);
		contentPane.add(lblLocation);

		JButton btnDeleteLocation = new JButton("   Delete Location");
		Image imgbtnDeleteLocation = new ImageIcon(this.getClass().getResource("/deleteLocation.png")).getImage();
		btnDeleteLocation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteLocation.setIcon(new ImageIcon(imgbtnDeleteLocation));
		btnDeleteLocation.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int locatedContactsCount = 0;
				for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()) {
					if (cn.getIsLocated()) {
						locatedContactsCount++;
					}
				}
				if (locatedContactsCount != 0) {
					String[] groupsToShowForDeleting = new String[locatedContactsCount];
					int groupsCounter = 0;
					for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()) {
						if (cn.getIsLocated()) {
							groupsToShowForDeleting[groupsCounter] = cn.getFirstName() + " " + cn.getLastName();
							groupsCounter++;
						}
					}
					JComboBox jcd = new JComboBox(groupsToShowForDeleting);
					String[] options = { "OK" };
					JPanel panel = new JPanel();
					JLabel lbl = new JLabel("Choose your Contact to delete it's Location : ");
					JTextField txt = new JTextField(10);
					panel.add(lbl);
					panel.add(jcd);
					int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title", JOptionPane.NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (selectedOption == 0) {
						int dialogButton = 0;
						int dialogResult = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete " + jcd.getSelectedItem() + "'s Location?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							int selectedContactID = -1;
							for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookMain)
									.getContacts()) {
								if ((cn.getFirstName() + " " + cn.getLastName())
										.equals(jcd.getSelectedItem().toString())) {
									selectedContactID = cn.getID();
								}
							}
							// ta ghabl az in coment ma tamami contact hayi ke isLocated eshoon true ro ba
							// name o last name dar JComboBox neshoon dadimeshoon, halabad az entekhabeshoon
							// mirim id eshoon ro too khat 1006 peida mikonim,
							// hala bad az in comment mirim soragh delete kardan oon location az array list
							// locations dar addressBook va isLocated ro false kardan
							int lcCounter = 0;
							for (Location lc : AddressBookSelection.addressBooks.get(whichAddressBookMain)
									.getLocations()) {
								if (lc.getLocationForID() == selectedContactID) {
									AddressBookSelection.addressBooks.get(whichAddressBookMain).getContacts()
											.get(selectedContactID - 1).setIsLocated(false);
									AddressBookSelection.addressBooks.get(whichAddressBookMain).getLocations()
											.remove(lcCounter);
									break;
								}
								lcCounter++;
							}
							JOptionPane.showMessageDialog(null,
									jcd.getSelectedItem().toString() + "'s Location Deleted !");
						}
						Main main = new Main();
						dispose();
						main.setVisible(true);
					}

				} else {
					JOptionPane.showMessageDialog(null, "No Located Contact found !");
				}
			}
		});
		btnDeleteLocation.setForeground(Color.BLACK);
		btnDeleteLocation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteLocation.setBackground(Color.WHITE);
		btnDeleteLocation.setBounds(321, 519, 199, 48);
		contentPane.add(btnDeleteLocation);

		JLabel lblMainTheme = new JLabel("");
		lblMainTheme.setBounds(0, 0, 992, 588);
		contentPane.add(lblMainTheme);
		lblMainTheme.setIcon(new ImageIcon(imgMainTheme));

	}
}
