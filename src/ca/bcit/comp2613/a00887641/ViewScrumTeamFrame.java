package ca.bcit.comp2613.a00887641;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.agile.model.ScrumMaster;
import ca.bcit.comp2613.agile.model.ScrumMember;


public class ViewScrumTeamFrame extends JFrame{
	
	

		private JTable table;
		private JTextField firstNameTextField;
		private JTextField lastNameTextField;
		private JLabel lblLastName;
		private JLabel lblId;
		private MySwingModel swingMemberModel;
		public String[] columnNames = new String[] { "id", "First Name",
				"Last Name" };
		private JTextField idTextField;
		private ScrumMaster master;
		private JButton btnClose;
		
		

		public ViewScrumTeamFrame(ScrumMaster master) {
			this.master = master;
			this.setTitle(master.getFirstName() + " " + master.getLastName() + "' s Class");
			
			initialize();
			initTable();
		}

		private void initTable() {

			// table = new JTable(swingStudentModel);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {

						@Override
						public void valueChanged(ListSelectionEvent e) {
							if (e.getValueIsAdjusting()) {
								populateFields();
							}
						}
					});
			refreshTable();

		}

		private void populateFields() {
			try {
				idTextField.setText(table.getModel()
						.getValueAt(table.getSelectedRow(), 0).toString());
				firstNameTextField.setText(table.getModel()
						.getValueAt(table.getSelectedRow(), 1).toString());
				lastNameTextField.setText(table.getModel()
						.getValueAt(table.getSelectedRow(), 2).toString());
			} catch (Exception e) {
			}
		}

		
		private void refreshTable() {
			// swingStudentModel = new SwingStudentModel();
			Object[][] data = null;
			if (ScrumMaster.getMember() != null) {
				data = new Object[ScrumMaster.getMember().size()][3];
				int i = 0;
				for (ScrumMember member : ScrumMaster.getMember()) {
					data[i][0] = member.getId();
					data[i][1] = member.getFirstName();
					data[i][2] = member.getLastName();
					i++;
				}
				swingMemberModel.setDataVector(data, columnNames);
				table.repaint();
			}
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {

			this.setBounds(100, 100, 600, 600);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.getContentPane().setLayout(null);

			// table = new JTable();
			swingMemberModel = new MySwingModel();

			table = new JTable(swingMemberModel);

			// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			// table.setBounds(0, 11, 585, 247);
			table.setFillsViewportHeight(true);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(0, 11, 585, 247);
			this.getContentPane().add(scrollPane);
			// scrollPane.add(table);
			// frame.getContentPane().add(table);

			JLabel lblFirstName = new JLabel("First Name");
			lblFirstName.setBounds(44, 330, 103, 14);
			this.getContentPane().add(lblFirstName);

			firstNameTextField = new JTextField();
			firstNameTextField.setEditable(false);
			firstNameTextField.setBounds(159, 327, 325, 20);
			this.getContentPane().add(firstNameTextField);
			firstNameTextField.setColumns(10);

			lastNameTextField = new JTextField();
			lastNameTextField.setEditable(false);
			lastNameTextField.setBounds(159, 371, 325, 20);
			this.getContentPane().add(lastNameTextField);
			lastNameTextField.setColumns(10);

			lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(44, 374, 77, 14);
			this.getContentPane().add(lblLastName);

			lblId = new JLabel("id");
			lblId.setBounds(44, 288, 46, 14);
			this.getContentPane().add(lblId);

			
			
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewScrumTeamFrame.this.dispose();
				}
			});
			btnClose.setBounds(300, 500, 89, 23);
			getContentPane().add(btnClose);
			
			
			
		}
	}
	

