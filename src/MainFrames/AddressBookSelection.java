package MainFrames;
import Classes.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AddressBookSelection extends JFrame {
	// dar in safhe ma variable static addressBooks ro darim, ke khodesh dar class
	// AddressBook sakhte mishe ke harkodoom az in addressbook ha khodeshon yek
	// arraylist i az contacts , groups, va locations daran
	private JPanel contentPane;
	private JTable tableDisplayAllContacts;
	private JScrollPane scrollPane;
	public static ArrayList<AddressBook> addressBooks = new ArrayList<AddressBook>();
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressBook addressBook = new AddressBook();
					AddressBookSelection frame = new AddressBookSelection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Main Exception");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddressBookSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 24, 498, 218);
		scrollPane.getViewport().setBackground(new Color(26, 31, 25));
		contentPane.add(scrollPane);
		String[] colNames = { "Name" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		tableDisplayAllContacts = new JTable(model);
		tableDisplayAllContacts.setShowGrid(false);
		tableDisplayAllContacts.setForeground(Color.WHITE);
		tableDisplayAllContacts.setBackground(new Color(26, 31, 25));
		tableDisplayAllContacts.setEnabled(false);
		tableDisplayAllContacts.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableDisplayAllContacts.setRowHeight(30);
		for (AddressBook add : AddressBookSelection.addressBooks) {
			String[] Object = { add.getName() };
			model.addRow(Object);
		}
		tableDisplayAllContacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ba click bar rooye har gozine ma index row click shode ro ke hamoon index
				// addressbook mast ro be kol safahat pass midim va oon ro dar variable haye
				// static har safhe zakhire mikonim ke har safhe bedoone alan ba kodoom
				// addressbook dar ertebate
				int row = tableDisplayAllContacts.getSelectedRow();
				Main.whichAddressBookMain = row;
				Contact.whichAddressBookContact = row;
				ShowMore.whichAddressBookShowMore = row;
				AddContact.whichAddressBookAddContact = row;
				EditContact.whichAddressBookEditContact = row;
				LocationFrame.whichAddressBookLocationFrame = row;
				Main main = new Main();
				dispose();
				main.setVisible(true);
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

		btnAdd = new JButton("Add New");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBackground(new Color(108, 144, 98));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newAddressBookName = JOptionPane.showInputDialog("Enter the new Address Book's Name :");
				boolean AddressBookNameIsNew = true;
				for (AddressBook add : AddressBookSelection.addressBooks) {
					if (newAddressBookName.equals(add.getName())) {
						AddressBookNameIsNew = false;
					}
				}
				if (newAddressBookName != null) {
					if (!"".equals(newAddressBookName)) {
						try {
							if (AddressBookNameIsNew) {
								// hala baraye sakhttan yek addressbook jadid ma bayesti se ta arraylist
								// contacts va groups va locations ro be class AddressBook pass bedim, pas se ta
								// arraylist khali dorost mikonim...
								ArrayList<Contact> contacts1 = new ArrayList<Contact>();
								ArrayList<Group> groups1 = new ArrayList<Group>();
								ArrayList<Location> locations1 = new ArrayList<Location>();
								AddressBook add1 = new AddressBook(AddressBook.count, newAddressBookName, contacts1,
										groups1, locations1);
								AddressBookSelection.addressBooks.add(add1);
								AddressBookSelection addressBookSelection = new AddressBookSelection();
								dispose();
								addressBookSelection.setVisible(true);
								JOptionPane.showMessageDialog(null, newAddressBookName + " added !");
							} else {
								JOptionPane.showMessageDialog(null,
										"Name is already Taken for an Address Book group !");
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
		btnAdd.setBounds(405, 257, 115, 44);
		contentPane.add(btnAdd);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addressBooks.size() != 0) {
					try {
						// hala baraye panel delete kardan niaz be tamami addressbook haye sakhte shode
						// darim ke oonha ro dar khat badi, va esm haye oonaro dar for badi migirim
						String[] groupsToShowForDeleting = new String[AddressBookSelection.addressBooks.size()];
						int groupsCounter = 0;
						for (int i = 0; i < AddressBookSelection.addressBooks.size(); i++) {
							groupsToShowForDeleting[groupsCounter] = AddressBookSelection.addressBooks.get(i).getName();
							groupsCounter++;
						}
						// hala addressbook names ro ke dar variable groupsToShowForDeleting zakhire
						// kardim ro dar yek JComboBox mirizim
						JComboBox jcd = new JComboBox(groupsToShowForDeleting);
						String[] options = { "OK" };
						JPanel panel = new JPanel();
						JLabel lbl = new JLabel("Choose your Group to Delete : ");
						JTextField txt = new JTextField(10);
						panel.add(lbl);
						panel.add(jcd);
						int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title",
								JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if (selectedOption == 0) {
							int dialogButton = 0;
							int dialogResult = JOptionPane.showConfirmDialog(null,
									"Are you sure you want to delete " + jcd.getSelectedItem() + "?", "Warning",
									dialogButton);
							if (dialogResult == JOptionPane.YES_OPTION) {
								// hala ke motmaen shodim kodoom index ro mikhad delete kone oon index ro az
								// arraylist addressbooks delete mikonimesh
								AddressBookSelection.addressBooks.remove(jcd.getSelectedIndex());
								JOptionPane.showMessageDialog(null, jcd.getSelectedItem().toString() + " Deleted !");
							}
							AddressBookSelection addressBookSelection = new AddressBookSelection();
							dispose();
							addressBookSelection.setVisible(true);
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Address Books Available to delete !");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBackground(new Color(108, 144, 98));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(217, 257, 115, 44);
		contentPane.add(btnDelete);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AddressBookSelection.addressBooks.size() != 0) {
					// hala baraye panel edit kardan niaz be tamami addressbook haye sakhte shode
					// darim ke oonha ro dar khat badi, va esm haye oonaro dar for badi migirim
					String[] groupsToShowForEditNames = new String[AddressBookSelection.addressBooks.size()];
					int groupsCounter = 0;
					for (int i = 0; i < AddressBookSelection.addressBooks.size(); i++) {
						groupsToShowForEditNames[groupsCounter] = AddressBookSelection.addressBooks.get(i).getName();
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
						try {
							// hala panel edit asli ro baz kardim va montazerim ke bebinim addressbook
							// entekhab shode ro chejoori edit mikonatesh
							String groupToEdit = JOptionPane.showInputDialog(
									"Edit Panel for " + jcd.getSelectedItem().toString() + " :",
									jcd.getSelectedItem().toString());
							if (!groupToEdit.isEmpty()) {
								// hala oon addressbook morede nazar karbor ro be groupToEdit taghir midimesh
								AddressBookSelection.addressBooks.get(jcd.getSelectedIndex()).setName(groupToEdit);
								JOptionPane.showMessageDialog(null,
										jcd.getSelectedItem().toString() + " Address Book edited to : " + groupToEdit);
								AddressBookSelection addressBookSelection = new AddressBookSelection();
								dispose();
								addressBookSelection.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "Empty Text Field -_-");
							}

						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Address Books Available !");
				}
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBackground(new Color(108, 144, 98));
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.setBounds(22, 257, 106, 44);
		contentPane.add(btnEdit);
		Image imglblMainTheme = new ImageIcon(this.getClass().getResource("/AddressSelectionTheme.jpg")).getImage();

		JLabel lblClose = new JLabel("");
		lblClose.setBounds(530, 0, 20, 22);
		lblClose.setForeground(new Color(230, 230, 250));
		contentPane.add(lblClose);
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();

			}
		});

		JLabel lblMainTheme = new JLabel("");
		lblMainTheme.setBounds(0, 0, 550, 328);
		contentPane.add(lblMainTheme);
		lblMainTheme.setIcon(new ImageIcon(imglblMainTheme));
		Image imgClose = new ImageIcon(this.getClass().getResource("/close_16.png")).getImage();
		lblClose.setIcon(new ImageIcon(imgClose));
	}
}
