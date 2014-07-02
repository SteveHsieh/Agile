package ca.bcit.comp2613.a00887641;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.agile.model.ScrumMaster;
import ca.bcit.comp2613.agile.model.ScrumMember;





public class MySwing {

	private JFrame frame;
	private JTable table;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JLabel lblLastName;
	private JLabel lblId;
	private JButton btnViewScrumTeam;
	private MySwingModel swingMasterModel;
	public String[] columnNames = new String[] { "id", "First Name",
			"Last Name" };
	private JTextField idTextField;
	public static List<ScrumMaster> masters;
	
	
	
	public MySwing ()
	{
		masters = UtilScrumMaster.create1000RandomStudents();
		initialize();
		initTable();
		
	}
	
	private void initTable() {

		// table = new JTable(swingTeacherModel);
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
	
	private void refreshTable() {
		// swingTeacherModel = new SwingTeacherModel();
		Object[][] data = null;

		data = new Object[masters.size()][3];
		int i = 0;
		for (ScrumMaster member : masters) {
			data[i][0] = member.getId();
			data[i][1] = member.getFirstName();
			data[i][2] = member.getLastName();
			i++;
		}
		swingMasterModel.setDataVector(data, columnNames);
		table.repaint();
	}

	
	private void populateFields() {
		try {
			idTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString());
			firstNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString());
			lastNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 2).toString());
		} catch (Exception e) {}
	}

	private void doCreate() {
		String id = UUID.randomUUID().toString();
		idTextField.setText(id);
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		
	}

	private void doDelete() {
		// TODO Auto-generated method stub
		String id = idTextField.getText();
		ScrumMaster master = new ScrumMaster(id, null, null);
		UtilScrumMaster.delete(masters, master);
		refreshTable();
	}
	private void doRead() {
		// TODO Auto-generated method stub
		UtilScrumMaster.read(masters);

	}

	private void doRefresh() {
		// TODO Auto-generated method stub
		String id = idTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		ScrumMaster member = new ScrumMaster(id, firstName, lastName);
		UtilScrumMaster.save(masters,member);
		//table.clearSelection();
		refreshTable();
		
		
	}
	private void viewScrumTeam() {
		String id = idTextField.getText();
		ScrumMaster master = null;
		master = UtilScrumMaster.findById(id, masters);
		if (master != null) {
			ViewScrumTeamFrame viewScrumTeamFrame = new ViewScrumTeamFrame(master);
			viewScrumTeamFrame.setVisible(true);
		}	
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// table = new JTable();
		swingMasterModel = new MySwingModel();

		table = new JTable(swingMasterModel);

		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// table.setBounds(0, 11, 585, 247);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 585, 247);
		frame.getContentPane().add(scrollPane);
		// scrollPane.add(table);
		// frame.getContentPane().add(table);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(44, 330, 103, 14);
		frame.getContentPane().add(lblFirstName);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(159, 327, 325, 20);
		frame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(159, 371, 325, 20);
		frame.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 374, 77, 14);
		frame.getContentPane().add(lblLastName);

		lblId = new JLabel("id");
		lblId.setBounds(44, 288, 46, 14);
		frame.getContentPane().add(lblId);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				doCreate();
			}

		});
		btnCreate.setBounds(44, 412, 89, 23);
		frame.getContentPane().add(btnCreate);

		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRefresh();
			}

		});
		btnRefresh.setBounds(169, 412, 89, 23);
		frame.getContentPane().add(btnRefresh);
		
		
		JButton btnDelete = new JButton ("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				doDelete();
				
			}
		});
		btnDelete.setBounds(419, 412, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnReadButton = new JButton("Read");
		btnReadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRead();
			}

		});
		btnReadButton.setBounds(294, 412, 89, 23);
		frame.getContentPane().add(btnReadButton);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(159, 285, 325, 20);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		
		btnViewScrumTeam = new JButton("View Scrum Team");
		btnViewScrumTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewScrumTeam();
			}
		
		});
		btnViewScrumTeam.setBounds(400, 260, 144, 23);
		frame.getContentPane().add(btnViewScrumTeam);
	}

	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing window = new MySwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
