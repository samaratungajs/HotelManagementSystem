package Final;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Employee extends JFrame {
	
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel empDetails;
	private JPanel SalDetails;
	private JPanel DesigDetails;
	private JPanel Reports;

	private JTable table;
	private JTable table_4;
	private JTable table_3;
	private JTable table_5;

	private JLabel lblAddUpED;
	private JLabel lblFName;
	private JLabel lblDOB;
	private JLabel lblAddress;
	private JLabel lblTel;
	private JLabel lblGender;
	private JLabel lblDesignationid;

	private JTextField txtfname;
	private JTextField txtdob;
	private JTextField txtTelephone;
	private JTextField txtaddress;
	private JTextField txtdesignation;

	private JTextField salaryid;
	private JTextField employeeid;
	private JTextField othours;
	private JTextField grossSalary;
	private JRadioButton btnMale;
	private JRadioButton btnFemale;
	private JButton btnAdd;
	private JButton btnloadEmpDetails;
	private JButton btnloadsalarydetails;
	private JButton button_1;
	private JButton delemp;
	private JButton btnSearch;
	private JButton btnSal;
	private JButton btnED;
	private JButton btnLogout;
	private JButton btndesig;
	private JButton btnreport;
	private JButton btnNewButton;
	private JButton btngenerate;
	private JTextField userid;


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void switchPanels(JPanel panel) {

		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}


	/**
	 * Create the frame.
	 */
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 815);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 30, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Royal Resort");
		lblNewLabel.setForeground(UIManager.getColor("ComboBox.background"));
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 67));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(397, 13, 548, 91);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 129, 1350, 11);
		contentPane.add(separator);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBounds(1252, 59, 97, 25);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnLogout);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(184, 129, 2, 587);
		contentPane.add(separator_1);

		JButton btnED = new JButton("Employee Details");
		btnED.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnED.setBackground(new Color(224, 255, 255));
		btnED.setForeground(new Color(0, 0, 0));
		btnED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switchPanels(empDetails);

			}
		});
		btnED.setBounds(24, 224, 147, 32);
		contentPane.add(btnED);

		JButton btnSal = new JButton("Salary Details");
		btnSal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSal.setBackground(new Color(224, 255, 255));
		btnSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switchPanels(SalDetails);

			}
		});

		btnSal.setBounds(24, 331, 147, 32);
		contentPane.add(btnSal);

		JButton btndesig = new JButton("Designation Details");
		btndesig.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btndesig.setBackground(new Color(224, 255, 255));
		btndesig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switchPanels(DesigDetails);

			}
		});
		btndesig.setBounds(20, 434, 147, 32);
		contentPane.add(btndesig);

		JButton btnreport = new JButton("Report");
		btnreport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnreport.setBackground(new Color(224, 255, 255));
		btnreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switchPanels(Reports);

			}
		});
		btnreport.setBounds(20, 548, 147, 32);
		contentPane.add(btnreport);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(196, 138, 1164, 600);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		empDetails = new JPanel();
		layeredPane.add(empDetails, "name_860106873337500");
		empDetails.setLayout(null);

		JButton delemp = new JButton("Delete");
		delemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String id = (model.getValueAt(selectedRow, 0).toString());

				try {
					Class.forName("com.mysql.jdbc.Driver");
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String query = "DELETE  FROM employee WHERE empid = " + id;
					PreparedStatement pst = connection.prepareStatement(query);
					int rs = pst.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Successfully deleted");

				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		delemp.setBounds(213, 496, 89, 23);
		empDetails.add(delemp);

		JLabel lblAddUpED = new JLabel("Add/Update Employee Details ");
		lblAddUpED.setOpaque(true);
		lblAddUpED.setBackground(Color.LIGHT_GRAY);
		lblAddUpED.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddUpED.setBounds(22, 33, 272, 38);
		empDetails.add(lblAddUpED);

		JLabel lblFName = new JLabel("Full Name");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFName.setBounds(22, 123, 73, 17);
		empDetails.add(lblFName);

		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDOB.setBounds(22, 175, 73, 17);
		empDetails.add(lblDOB);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(22, 338, 60, 23);
		empDetails.add(lblAddress);

		JLabel lblTel = new JLabel("Telephone");
		lblTel.setForeground(new Color(0, 0, 0));
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(22, 280, 73, 17);
		empDetails.add(lblTel);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(22, 226, 60, 17);
		empDetails.add(lblGender);

		txtfname = new JTextField();
		txtfname.setColumns(10);
		txtfname.setBackground(SystemColor.inactiveCaptionBorder);
		txtfname.setBounds(133, 119, 182, 28);
		empDetails.add(txtfname);

		JLabel lblDesignationid = new JLabel("Designationid");
		lblDesignationid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesignationid.setBounds(22, 401, 85, 17);
		empDetails.add(lblDesignationid);

		Button btnAdd = new Button("Add");
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String empname = txtfname.getText();
				String dob = txtdob.getText();
				String telephone = txtTelephone.getText();
				String address = txtaddress.getText();
				String designationid = txtdesignation.getText();
				String gender = null;
				if (btnMale.isSelected())
					gender = "Male";
				else if (btnFemale.isSelected())
					gender = "Female";

				if (txtTelephone.getText().isEmpty()) {
					lblTel.setText("Telephone number is required");

				} else if (txtfname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAdd, "" + "Please enter the name ");

				} else if (txtdob.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAdd, "" + "Please enter the dob ");
				} else if (txtaddress.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAdd, "" + "Please enter the address ");
				} else if (txtdesignation.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAdd, "" + "Please enter the  designationid ");
				}

				try {
					Class.forName("com.mysql.jdbc.Driver");
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String qeury = "INSERT INTO employee values('" + 0 + "','" + empname + "','" + dob + "','" + gender
							+ "','" + telephone + ", '" + address + "', '" + designationid + "' )";
					Statement statement = connection.createStatement();

					int x = statement.executeUpdate(qeury);
					if (x == 0) {
						JOptionPane.showMessageDialog(btnAdd, "This is alredy exist");
					} else {
						JOptionPane.showMessageDialog(btnAdd, "Successfully Added");
					}
					connection.close();

				} catch (SQLException | ClassNotFoundException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		btnAdd.setBounds(22, 496, 89, 23);
		empDetails.add(btnAdd);

		Button button_1 = new Button("Update");
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String empname = txtfname.getText();
				String dob = txtdob.getText();
				String telephone = txtTelephone.getText();
				String gender = btnMale.getActionCommand();
				String address = txtaddress.getText();
				String designationid = txtdesignation.getText();

				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				String id = (model.getValueAt(selectedRow, 0).toString());

				try {

			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
			         
					String qeury = "UPDATE employee  set('" + txtfname.getText() + "','" + txtdob.getText() + "','"
							+ btnMale.getActionCommand() + "','" + btnFemale.getActionCommand() + "','"
							+ txtTelephone.getText() + ", '" + txtaddress.getText() + "', '" + txtdesignation.getText()
							+ "' )";
					Statement statement = connection.createStatement();

					int x = statement.executeUpdate(qeury);
					if (x == 0) {
						JOptionPane.showMessageDialog(button_1, "This is alredy exist");
					} else {
						JOptionPane.showMessageDialog(button_1, "Successfully updated");
					}
					connection.close();

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		button_1.setBounds(117, 496, 89, 23);
		empDetails.add(button_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(336, 81, 2, 486);
		empDetails.add(separator_2);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				txtfname.setText(model.getValueAt(selectedRow, 1).toString());
				txtdob.setText(model.getValueAt(selectedRow, 2).toString());
				txtaddress.setText(model.getValueAt(selectedRow, 4).toString());
				txtTelephone.setText(model.getValueAt(selectedRow, 5).toString());
				txtdesignation.setText(model.getValueAt(selectedRow, 6).toString());
			}
		});

		JButton btnloadEmpDetails = new JButton("Load Employee Details");
		btnloadEmpDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select * from employee ");

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnloadEmpDetails.setBounds(1007, 174, 147, 23);
		empDetails.add(btnloadEmpDetails);

		txtdob = new JTextField();
		txtdob.setColumns(10);
		txtdob.setBackground(SystemColor.inactiveCaptionBorder);
		txtdob.setBounds(133, 171, 182, 28);
		empDetails.add(txtdob);

		JRadioButton btnFemale = new JRadioButton("Female");
		btnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFemale.setBounds(220, 223, 74, 23);
		empDetails.add(btnFemale);

		JRadioButton btnMale = new JRadioButton("Male");
		btnMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMale.setBounds(133, 223, 60, 23);
		empDetails.add(btnMale);

		txtTelephone = new JTextField();
		txtTelephone.setColumns(10);
		txtTelephone.setBackground(SystemColor.inactiveCaptionBorder);
		txtTelephone.setBounds(133, 276, 182, 28);
		empDetails.add(txtTelephone);

		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBackground(SystemColor.inactiveCaptionBorder);
		txtaddress.setBounds(133, 337, 182, 28);
		empDetails.add(txtaddress);

		txtdesignation = new JTextField();
		txtdesignation.setColumns(10);
		txtdesignation.setBackground(SystemColor.inactiveCaptionBorder);
		txtdesignation.setBounds(133, 397, 182, 28);
		empDetails.add(txtdesignation);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 208, 796, 311);
		empDetails.add(scrollPane);

		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
				new Object[][] { { null, null, "", "", "", "", "" }, { null, null, null, null, null, null, null }, },
				new String[] { "empid", "empmane", "dob", "gender", "telephone", "address", "designationid" }));
		table_5.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				int selectedRow = table_5.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_5.getModel();
				txtfname.setText(model.getValueAt(selectedRow, 1).toString());
				txtdob.setText(model.getValueAt(selectedRow, 2).toString());
				lblGender.setText(model.getValueAt(selectedRow, 3).toString());
				txtaddress.setText(model.getValueAt(selectedRow, 4).toString());
				txtTelephone.setText(model.getValueAt(selectedRow, 5).toString());
				txtdesignation.setText(model.getValueAt(selectedRow, 6).toString());

			}
		});
		scrollPane.setViewportView(table_5);

		Reports = new JPanel();
		layeredPane.add(Reports, "name_860168170291800");
		Reports.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Monthly Report ");
		lblNewLabel_5.setBounds(465, 59, 156, 39);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		Reports.add(lblNewLabel_5);

		JPanel panel = new JPanel();
		panel.setBounds(164, 115, 691, 382);
		Reports.add(panel);

		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MessageFormat header = new MessageFormat("Printing in progress");
				MessageFormat footer = new MessageFormat("Page{0,number,integer}");
				try {
					table.print();
				} catch (java.awt.print.PrinterException ev) {
					System.err.format("No printer found", ev.getMessage());
				}
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(874, 225, 100, 32);
		Reports.add(btnNewButton);

		JButton btngenerate = new JButton("Generate");
		btngenerate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btngenerate.setBounds(874, 165, 100, 32);
		Reports.add(btngenerate);

		JPanel SalDetails = new JPanel();
		layeredPane.add(SalDetails, "name_262491754973088");
		SalDetails.setLayout(null);

		JLabel lblsalarydetails = new JLabel("Salary Details ");
		lblsalarydetails.setOpaque(true);
		lblsalarydetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblsalarydetails.setBackground(Color.LIGHT_GRAY);
		lblsalarydetails.setBounds(112, 34, 128, 35);
		SalDetails.add(lblsalarydetails);

		JLabel lblSalaryId = new JLabel("Salary id ");
		lblSalaryId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalaryId.setBounds(10, 108, 76, 24);
		SalDetails.add(lblSalaryId);

		JLabel lblEmployeeId = new JLabel("Employee id ");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmployeeId.setBounds(10, 199, 83, 24);
		SalDetails.add(lblEmployeeId);

		salaryid = new JTextField();
		salaryid.setColumns(10);
		salaryid.setBackground(SystemColor.inactiveCaptionBorder);
		salaryid.setBounds(119, 104, 182, 28);
		SalDetails.add(salaryid);

		employeeid = new JTextField();
		employeeid.setColumns(10);
		employeeid.setBackground(SystemColor.inactiveCaptionBorder);
		employeeid.setBounds(119, 199, 182, 28);
		SalDetails.add(employeeid);

		JButton btnloadsalarydetails = new JButton("Load Salary Details");
		btnloadsalarydetails.setBounds(979, 132, 168, 24);
		btnloadsalarydetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select * from salary ");

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnloadsalarydetails.setBounds(1007, 174, 147, 23);
		SalDetails.add(btnloadsalarydetails);

		othours = new JTextField();
		othours.setColumns(10);
		othours.setBackground(SystemColor.inactiveCaptionBorder);
		othours.setBounds(119, 253, 182, 28);
		SalDetails.add(othours);

		grossSalary = new JTextField();
		grossSalary.setColumns(10);
		grossSalary.setBackground(SystemColor.inactiveCaptionBorder);
		grossSalary.setBounds(119, 310, 182, 28);
		SalDetails.add(grossSalary);

		JLabel OTHours = new JLabel("OT Hours");
		OTHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
		OTHours.setBounds(10, 251, 69, 28);
		SalDetails.add(OTHours);

		JLabel GrossSalary = new JLabel("Gross Salary");
		GrossSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GrossSalary.setBounds(10, 310, 76, 24);
		SalDetails.add(GrossSalary);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBounds(314, 91, 2, 486);
		SalDetails.add(separator_2_1);

		JButton btncalSal = new JButton("Calculate Salary");
		btncalSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement("Select * from salary ");

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}

		});
		btncalSal.setBounds(148, 467, 117, 28);
		SalDetails.add(btncalSal);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(387, 166, 767, 308);
		SalDetails.add(scrollPane_1);

		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				int selectedRow = table_3.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_3.getModel();
				salaryid.setText(model.getValueAt(selectedRow, 1).toString());
				employeeid.setText(model.getValueAt(selectedRow, 2).toString());
				userid.setText(model.getValueAt(selectedRow, 3).toString());
				othours.setText(model.getValueAt(selectedRow, 4).toString());
				grossSalary.setText(model.getValueAt(selectedRow, 5).toString());

			}

		});
		scrollPane_1.setViewportView(table_3);

		JLabel lblNewLabel_1 = new JLabel("User id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 147, 76, 24);
		SalDetails.add(lblNewLabel_1);

		userid = new JTextField();
		userid.setBackground(SystemColor.inactiveCaptionBorder);
		userid.setBounds(119, 146, 182, 28);
		SalDetails.add(userid);
		userid.setColumns(10);

		JPanel Desigdetails = new JPanel();
		layeredPane.add(Desigdetails, "name_262589662709472");
		Desigdetails.setLayout(null);

		JLabel lblDesignationDetails = new JLabel("Designation Details ");
		lblDesignationDetails.setBounds(296, 64, 206, 31);
		lblDesignationDetails.setOpaque(true);
		lblDesignationDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDesignationDetails.setBackground(SystemColor.menu);
		Desigdetails.add(lblDesignationDetails);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(35, 194, 587, 275);
		Desigdetails.add(scrollPane_2);

		table_4 = new JTable();
		scrollPane_2.setViewportView(table_4);

		JButton btnloaddesingation = new JButton("Load Desigantion Details");
		btnloaddesingation.setBounds(406, 162, 214, 31);
		Desigdetails.add(btnloaddesingation);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Employee.class.getResource("/Final/resthouse125-removebg-preview.png")));
		lblNewLabel_2.setBounds(24, 13, 130, 108);
		contentPane.add(lblNewLabel_2);

	}
}
