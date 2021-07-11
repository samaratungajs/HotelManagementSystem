package Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Choice;
import java.awt.Button;

import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;
public class Rooms extends JFrame {

	private JPanel contentPane;
	private JPanel panelUsers;
	private JPanel panelRooms;
	private JPanel panelHalls;
	private JPanel panelReports;
	private JLayeredPane layeredPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_17;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table_1;
	private JTable table_2;
	private JTextField srch;
	private JLabel label_3t;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JLabel noroom;
	private JLabel nohall;
	private JLabel nobar;
	private JLabel nores;
	private JLabel rtot;
	private JLabel htot;
	private JLabel bartot;
	private JLabel restot;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel cusmers;
	private JLabel bkings;
	private JLabel bktot;
	private JLabel hallev;
	private JLabel evetot;
	private JLabel tothall;
	private JLabel nosroom;
	private JLabel nodroom;
	private JLabel noquad;
	private JLabel totrooms;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	
	public void rfrsh() {
		 try {
             Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
             
             PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from user ");
             ResultSet rs = st.executeQuery();
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
             
             
		 } catch (SQLException sqlException) {
             sqlException.printStackTrace();
         }
		
	}
	
	private void rfrlable() {
		 try {
             Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

             PreparedStatement st1 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user ");
             ResultSet rs1 = st1.executeQuery();
             PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Admin' ");
             ResultSet rs2 = st2.executeQuery();
             PreparedStatement st3 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Receptionist' ");
             ResultSet rs3 = st3.executeQuery();
             PreparedStatement st4 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='HR manger' ");
             ResultSet rs4 = st4.executeQuery();
             PreparedStatement st5 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Kitchen manger' ");
             ResultSet rs5 = st5.executeQuery();
             PreparedStatement st6 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Stock manger' ");
             ResultSet rs6 = st6.executeQuery();
             PreparedStatement st7 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Bartender' ");
             ResultSet rs7 = st7.executeQuery();
             PreparedStatement st8 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Restaurentcashier' ");
             ResultSet rs8 = st8.executeQuery();
             if (rs1.next()) {

             final String tot =  rs1.getString("COUNT(userid)");
             
             }
		 }
		 catch (SQLException sqlException) {
             sqlException.printStackTrace();
         }
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rooms frame = new Rooms();
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
	public Rooms() {
		
		setExtendedState(MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1386, 815);
		contentPane = new JPanel();
		//contentPane.setBounds(getMaximizedBounds());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Royal Resort");
		lblNewLabel.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 67));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(397, 13, 548, 91);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 129, 1350, 11);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Rooms.class.getResource("resthouse125.png")));
		lblNewLabel_1.setBounds(33, 13, 125, 105);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			  	  dispose();
                  Login ah = new Login();
                  ah.setTitle("Welcome");
                  ah.setVisible(true);
                  JOptionPane.showMessageDialog(btnLogout, "logging out");
			}
		});
		btnLogout.setBackground(new Color(211, 211, 211));
		btnLogout.setBounds(1252, 59, 97, 25);
		contentPane.add(btnLogout);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(184, 129, 2, 587);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Users");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelUsers);
				
			}
		});
		btnNewButton.setBounds(25, 223, 133, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rooms");
		btnNewButton_1.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelRooms);
				
			}
		});
		
		btnNewButton_1.setBounds(25, 338, 133, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Report");
		btnNewButton_2.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelReports);
				
			}
		});
		btnNewButton_2.setBounds(25, 555, 138, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Banquet Halls");
		btnNewButton_3.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelHalls);
				
			}
		});
		btnNewButton_3.setBounds(25, 441, 133, 46);
		contentPane.add(btnNewButton_3);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(196, 138, 1164, 600);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelUsers = new JPanel();
		panelUsers.setBackground(SystemColor.controlShadow);
		layeredPane.add(panelUsers, "name_860106873337500");
		panelUsers.setLayout(null);
		
		Button deleteuser = new Button("Remove");
		deleteuser.setBackground(UIManager.getColor("Button.background"));
		deleteuser.setFont(new Font("Dialog", Font.BOLD, 13));
		deleteuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = table.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
				
				try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
					
					String sql = "DELETE  FROM user WHERE userid = "+id;
					PreparedStatement pst = connection.prepareStatement(sql);
			        int rs=pst.executeUpdate(sql);
	                   JOptionPane.showMessageDialog(null, "Delete Success");
	                   
	                   PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from user ");
	                    ResultSet rss = st.executeQuery();
	                    table.setModel(DbUtils.resultSetToTableModel(rss));

	                    PreparedStatement sttot = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user ");
	                    ResultSet rstot = sttot.executeQuery();

	                    textField_1.setText("");
	    		        textField_2.setText("");
	    		        textField_3.setText("");
	    		        textField_4.setText("");
	    		        textField_5.setText("");
	    		        passwordField.setText("");
	    		        passwordField_1.setText("");  

	        if (rstot.next()) {

	                   String tot =  rstot.getString("COUNT(userid)");
	                   label_3t.setText(tot);
	                    }
	                    
	                    
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
			}
		});
		
		
		String [] type = { "Admin", "Receptionist","HR manger","Kitchen manger","Restaurentcashier"};
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(SystemColor.inactiveCaptionBorder);
		textField_5.setBounds(69, 507, 182, 20);
		panelUsers.add(textField_5);
		
		JLabel lblWhoIsYour = new JLabel("Who is your favorite super hero?");
		lblWhoIsYour.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblWhoIsYour.setBounds(70, 480, 208, 31);
		panelUsers.add(lblWhoIsYour);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.inactiveCaptionBorder);
		textField_4.setBounds(69, 456, 182, 20);
		panelUsers.add(textField_4);
		
		JLabel label_5 = new JLabel("What is your first school name?");
		label_5.setFont(new Font("Georgia", Font.PLAIN, 11));
		label_5.setBounds(70, 428, 208, 31);
		panelUsers.add(label_5);
		
		JLabel lblSetSecurityQuestions = new JLabel("Set security questions ");
		lblSetSecurityQuestions.setFont(new Font("Georgia", Font.BOLD, 11));
		lblSetSecurityQuestions.setBounds(89, 398, 175, 36);
		panelUsers.add(lblSetSecurityQuestions);
		JComboBox comboBox = new JComboBox(type);
		comboBox.setBackground(SystemColor.inactiveCaptionBorder);
		comboBox.setBounds(125, 98, 131, 20);
		panelUsers.add(comboBox);
		
		 passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(SystemColor.inactiveCaptionBorder);
		passwordField_1.setBounds(125, 348, 131, 23);
		panelUsers.add(passwordField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.inactiveCaptionBorder);
		passwordField.setBounds(125, 298, 131, 20);
		panelUsers.add(passwordField);
		deleteuser.setBounds(219, 544, 74, 23);
		panelUsers.add(deleteuser);
		
		lblNewLabel_11 = new JLabel("User Type");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBackground(SystemColor.scrollbar);
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_11.setBounds(396, 72, 178, 23);
		panelUsers.add(lblNewLabel_11);
		
		JLabel lblNewLabel_2 = new JLabel("User Details");
		lblNewLabel_2.setBounds(468, 11, 126, 36);
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		panelUsers.add(lblNewLabel_2);
		
		JLabel lblAddUpdate = new JLabel("Add / Update User ");
		lblAddUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUpdate.setOpaque(true);
		lblAddUpdate.setBackground(SystemColor.scrollbar);
		lblAddUpdate.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblAddUpdate.setBounds(15, 37, 289, 36);
		panelUsers.add(lblAddUpdate);
		
		JLabel lblNewLabel_6 = new JLabel("User Type");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(34, 99, 73, 17);
		panelUsers.add(lblNewLabel_6);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblUsername.setBounds(34, 245, 73, 17);
		panelUsers.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Confirm");
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblPassword.setBounds(34, 329, 94, 31);
		panelUsers.add(lblPassword);
		
		JLabel label = new JLabel("Password:");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		label.setBounds(34, 299, 73, 17);
		panelUsers.add(label);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblEmail.setBounds(34, 144, 117, 17);
		panelUsers.add(lblEmail);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblContactNo.setBounds(34, 192, 117, 17);
		panelUsers.add(lblContactNo);
		
		JLabel label_1 = new JLabel();
		label_1.setForeground(new Color(220, 20, 60));
		label_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		label_1.setBounds(79, 381, 188, 17);
		panelUsers.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.inactiveCaptionBorder);
		textField_1.setBounds(125, 143, 131, 20);
		panelUsers.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.inactiveCaptionBorder);
		textField_2.setBounds(125, 191, 131, 20);
		panelUsers.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.inactiveCaptionBorder);
		textField_3.setBounds(125, 244, 131, 20);
		panelUsers.add(textField_3);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		label_2.setBounds(34, 354, 73, 17);
		panelUsers.add(label_2);

		
		Button button = new Button("Register");
		button.setFont(new Font("Dialog", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					 try {
		                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
		                    PreparedStatement un = (PreparedStatement) connection.prepareStatement("Select * from user ");
		                    ResultSet rsn = un.executeQuery();

		                    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		                    Pattern pattern = Pattern.compile(regex);
		                    Pattern usname = Pattern.compile("^([a-zA-Z])+([\\w]{2,})+$");
		                    PreparedStatement stus = (PreparedStatement) connection.prepareStatement("insert into user(username,password,usertype,email,contactno,secq1,secq2) values (?,?,?,?,?,?,?) ");
		                    stus.setString(1, textField_3.getText());
		                    stus.setString(2, passwordField.getText());
		                    stus.setString(3, (String)comboBox.getSelectedItem());
		                    stus.setString(4, textField_1.getText());
		                    stus.setString(5, textField_2.getText());
		                    stus.setString(6, textField_4.getText());
		                    stus.setString(7, textField_5.getText());
		                    
		                    String tp= textField_2.getText();
		                    
		                    if (rsn.next()) {
			                    String uname =  rsn.getString("username");
			                    if( !(textField_1.getText().matches(regex))) {
				                	   label_1.setText("invalid Email");

				                   }
			                   
			                    else if(textField_2.getText().isEmpty()) {
				                	   label_1.setText("phone number is required");

				                   }
			                    else if(!tp.matches("[0-9]{10}")) {
				                	   label_1.setText("Invalid phone number");

				                   }

			                    else if(textField_3.getText().isEmpty()) {
				                	   label_1.setText("Username is required");

				                   }
			                    else if(!(textField_3.getText().matches("^([a-zA-Z])+([\\w]{2,})+$"))) {
			                	   label_1.setText("invalid username");

			                   }
		                    
		                    else if(textField_3.getText().equals(uname)) {
		                    	
		                	   label_1.setText("Username already exsists");

		                   }else if(passwordField.getText().isEmpty()) {
		                	   label_1.setText("password is required");

		                   }else if(passwordField_1.getText().isEmpty()) {
		                	   label_1.setText("confirm your password");

		                   }
		                   else if(!passwordField.getText().equals(passwordField_1.getText())) {
		                	   label_1.setText("Password fields mismatch");
		                   
		                   }else {
		                	   stus.execute();	                    
			                   JOptionPane.showMessageDialog(null, "Data Saved");
		                   }
		                    }
		                   PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from user ");
		                    ResultSet rs = st.executeQuery();
		                    table.setModel(DbUtils.resultSetToTableModel(rs));
		                    
		                    PreparedStatement sttot = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user ");
		                    ResultSet rstot = sttot.executeQuery();


		        if (rstot.next()) {

		                   String tot =  rstot.getString("COUNT(userid)");
		                   label_3t.setText(tot);
		                    }
		                    
//		        textField_1.setText("");
//		        textField_2.setText("");
//		        textField_3.setText("");
//		        textField_4.setText("");
//		        textField_5.setText("");
//		        passwordField.setText("");
//		        passwordField_1.setText("");            
		                    
					 } catch (SQLException sqlException) {
		                    sqlException.printStackTrace();
		                }
				
			}
		});
		button.setBackground(UIManager.getColor("Button.background"));
		button.setBounds(34, 545, 70, 22);
		panelUsers.add(button);
		
		Button button_1 = new Button("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
                 int row = table.getSelectedRow();
                 String value = (table.getModel().getValueAt(row, 0).toString());
                 String qry = "UPDATE user SET username=?, password=?, usertype=?, email=?, contactno=?, secq1=?, secq2=? where userid="+value;
                 PreparedStatement starm1 = (PreparedStatement) connection.prepareStatement(qry);
               //  starm1.setString(0, textField_6.getText());
                 starm1.setString(1, textField_3.getText());
                 starm1.setString(2, passwordField.getText());
                 starm1.setString(3, (String)comboBox.getSelectedItem());
                 starm1.setString(4, textField_1.getText());
                 starm1.setString(5, textField_2.getText());
                 starm1.setString(6, textField_4.getText());
                 starm1.setString(7, textField_5.getText());

                 starm1.executeUpdate();	   
                 DefaultTableModel mod = (DefaultTableModel)table.getModel();
                 mod.setRowCount(0);
                // show_user();
                JOptionPane.showMessageDialog(null, "Update Saved");
                PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from user ");
                ResultSet rs = st.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
				
                textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        textField_4.setText("");
		        textField_5.setText("");
		        passwordField.setText("");
		        passwordField_1.setText("");  
                    
			 } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				
				
			}
		});
		
		button_1.setFont(new Font("Dialog", Font.BOLD, 13));
		button_1.setBackground(UIManager.getColor("Button.background"));
		button_1.setBounds(125, 545, 70, 22);
		panelUsers.add(button_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(336, 81, 2, 486);
		panelUsers.add(separator_2);
		
		JLabel lblTotalUsers = new JLabel("Total Users :");
		lblTotalUsers.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblTotalUsers.setBounds(363, 48, 94, 17);
		panelUsers.add(lblTotalUsers);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblNewLabel_7.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(15, 35, 289, 554);
		panelUsers.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(396, 300, 716, 289);
		panelUsers.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				textField_3.setText(model.getValueAt(selectedRow, 1).toString());
				passwordField.setText(model.getValueAt(selectedRow, 2).toString());
				comboBox.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
				textField_1.setText(model.getValueAt(selectedRow, 4).toString());
				textField_2.setText(model.getValueAt(selectedRow, 5).toString());
				textField_4.setText(model.getValueAt(selectedRow, 6).toString());
				textField_5.setText(model.getValueAt(selectedRow, 7).toString());

				String ty = model.getValueAt(selectedRow, 3).toString();
				switch (ty) {
				case "Admin":
				
				}
			}
		});
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton_4 = new JButton("Load User Details");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

	                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from user ");
	                    ResultSet rs = st.executeQuery();
	                    table.setModel(DbUtils.resultSetToTableModel(rs));
	                    
				 } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});
		btnNewButton_4.setBounds(965, 279, 147, 23);
		panelUsers.add(btnNewButton_4);
		
		 try {
             Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

             PreparedStatement st1 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user ");
             ResultSet rs1 = st1.executeQuery();
             PreparedStatement st2 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Admin' ");
             ResultSet rs2 = st2.executeQuery();
             PreparedStatement st3 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Receptionist' ");
             ResultSet rs3 = st3.executeQuery();
             PreparedStatement st4 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='HR manger' ");
             ResultSet rs4 = st4.executeQuery();
             PreparedStatement st5 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Kitchen manger' ");
             ResultSet rs5 = st5.executeQuery();
             PreparedStatement st6 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Stock manger' ");
             ResultSet rs6 = st6.executeQuery();
             PreparedStatement st7 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Bartender' ");
             ResultSet rs7 = st7.executeQuery();
             PreparedStatement st8 = (PreparedStatement) connection.prepareStatement("Select COUNT(userid) from user where usertype='Restaurentcashier' ");
             ResultSet rs8 = st8.executeQuery();
             if (rs1.next()) {

             String tot =  rs1.getString("COUNT(userid)");
            
        
		
		     
        label_3t = new JLabel();
		label_3t.setText(tot);
		label_3t.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		label_3t.setBounds(453, 48, 94, 17);
		panelUsers.add(label_3t); }
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(468, 113, 46, 14);
		panelUsers.add(lblAdmin);
		
		JLabel lblReceptionist = new JLabel("Receptionist");
		lblReceptionist.setBounds(461, 138, 102, 14);
		panelUsers.add(lblReceptionist);
	
		JLabel lblHrManagers = new JLabel("HR Manager");
		lblHrManagers.setBounds(461, 166, 102, 14);
		panelUsers.add(lblHrManagers);
		
		lblNewLabel_8 = new JLabel("Kitchen manger");
		lblNewLabel_8.setBounds(457, 191, 117, 20);
		panelUsers.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Stock Manager");
		lblNewLabel_9.setBounds(461, 222, 102, 14);
		panelUsers.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Bartender");
		lblNewLabel_10.setBounds(468, 247, 85, 14);
		panelUsers.add(lblNewLabel_10);
		
		lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBackground(SystemColor.scrollbar);
		lblNewLabel_12.setOpaque(true);
		lblNewLabel_12.setText("No Of Users");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_12.setBounds(572, 72, 147, 23);
		panelUsers.add(lblNewLabel_12);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(572, 88, 2, 194);
		panelUsers.add(separator_5);
		
		 if (rs2.next()) {

             String noa =  rs2.getString("COUNT(userid)");
		
		lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setText(noa);
		 }
		lblNewLabel_13.setBounds(615, 113, 46, 14);
		panelUsers.add(lblNewLabel_13);
		
		if (rs3.next()) {

            String nor =  rs3.getString("COUNT(userid)");
		lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setText(nor);
		}
		lblNewLabel_14.setBounds(615, 134, 73, 14);
		panelUsers.add(lblNewLabel_14);
		
		if (rs4.next()) {

            String noh =  rs4.getString("COUNT(userid)");
		JLabel lblNewLabel_15 = new JLabel();
		lblNewLabel_15.setText(noh);
		lblNewLabel_15.setBounds(615, 166, 46, 14);
		panelUsers.add(lblNewLabel_15);}
		
	
			
		JLabel lblNewLabel_16 = new JLabel();
		
		lblNewLabel_16.setBounds(625, 194, 46, 14);
		panelUsers.add(lblNewLabel_16);
		
		if (rs5.next()) {
			String nok =  rs5.getString("COUNT(userid)");
		JLabel totkm = new JLabel();
		totkm.setText(nok);
		totkm.setBounds(615, 194, 46, 14);
		panelUsers.add(totkm);}
		
		 
		
		lblNewLabel_17 = new JLabel("Restaurant Cashier");
		lblNewLabel_17.setBounds(446, 267, 117, 22);
		panelUsers.add(lblNewLabel_17);
		
		if (rs6.next()) {
			String nos =  rs6.getString("COUNT(userid)");
		JLabel lblNewLabel_18 = new JLabel();
		lblNewLabel_18.setText(nos);
		lblNewLabel_18.setBounds(613, 222, 46, 14);
		panelUsers.add(lblNewLabel_18);}
		
		if (rs7.next()) {
			String nob =  rs7.getString("COUNT(userid)");
		JLabel lblNewLabel_19 = new JLabel();
		lblNewLabel_19.setText(nob);
		lblNewLabel_19.setBounds(613, 247, 46, 14);
		panelUsers.add(lblNewLabel_19);}
		
		if (rs8.next()) {
			String norc =  rs8.getString("COUNT(userid)");
		JLabel lblNewLabel_20 = new JLabel();
		lblNewLabel_20.setText(norc);
		lblNewLabel_20.setBounds(613, 271, 46, 14);
		panelUsers.add(lblNewLabel_20);}
		
		
	
		 } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	        }
		
		 
		JLabel lblNewLabel_31 = new JLabel("");
		lblNewLabel_31.setOpaque(true);
		lblNewLabel_31.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_31.setBackground(Color.WHITE);
		lblNewLabel_31.setBounds(396, 70, 323, 221);
		panelUsers.add(lblNewLabel_31);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(SystemColor.inactiveCaptionBorder);
		textField.setBounds(147, 187, 60, 7);
		panelUsers.add(textField);
		textField.setColumns(10);
		
		
		srch = new JTextField();
		srch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try {
					
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
			         String query = "SELECT userid,username,password,usertype,email,contactno FROM user where username=?";
			     
			         PreparedStatement pst = connection.prepareStatement(query);
			         pst.setString(1,srch.getText());
			         ResultSet rs=pst.executeQuery();
			         table.setModel(DbUtils.resultSetToTableModel(rs));

					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
			}
		});
		
		
		srch.setFont(new Font("Tahoma", Font.PLAIN, 11));		
		srch.setBounds(798, 269, 117, 20);
		panelUsers.add(srch);
		srch.setColumns(10);
		
		
		
		
		
		panelRooms = new JPanel();
		panelRooms.setBackground(SystemColor.controlShadow);
		layeredPane.add(panelRooms, "name_860149763072300");
		panelRooms.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Room Details");
		lblNewLabel_3.setBounds(454, 5, 176, 19);
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		panelRooms.add(lblNewLabel_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(402, 81, 2, 458);
		panelRooms.add(separator_4);
		
		JLabel lblAddUpdate_1 = new JLabel("Add / Update Rooms");
		lblAddUpdate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUpdate_1.setOpaque(true);
		lblAddUpdate_1.setBackground(SystemColor.scrollbar);
		lblAddUpdate_1.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		lblAddUpdate_1.setBounds(30, 81, 332, 58);
		panelRooms.add(lblAddUpdate_1);
		
		JLabel lblNewLabel_21 = new JLabel("Room Number :");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_21.setBounds(66, 194, 96, 19);
		panelRooms.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Room Type :");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_22.setBounds(66, 257, 72, 14);
		panelRooms.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Room Price :");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_23.setBounds(66, 303, 82, 14);
		panelRooms.add(lblNewLabel_23);
		
		JButton btnNewButton_5 = new JButton("Add");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

	                    PreparedStatement starm = (PreparedStatement) connection.prepareStatement("insert into Room values (?,?,?) ");
	                    starm.setString(1, textField_6.getText());
	                    starm.setString(2, textField_7.getText());
	                    starm.setString(3, textField_8.getText());
	                    starm.execute();	      
	                    
	                    PreparedStatement stroom = (PreparedStatement) connection.prepareStatement("Select * from Room ");
	                    ResultSet rsroom = stroom.executeQuery();
	                    table_2.setModel(DbUtils.resultSetToTableModel(rsroom));

	                    PreparedStatement strt = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room ");
	                    ResultSet rsrt = strt.executeQuery();
	                    if (rsrt.next()) {

	                String totr =  rsrt.getString("COUNT(roomno)");
	        		totrooms.setText(totr);
	        		}
	               	 PreparedStatement str1 = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room where roomtype='single' ");
	                 ResultSet rsr1 = str1.executeQuery();
	                 PreparedStatement str2 = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room where roomtype='Deluxe' ");
	                 ResultSet rsr2 = str2.executeQuery();
	                 PreparedStatement str3 = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room where roomtype='Quad' ");
	                 ResultSet rsr3 = str3.executeQuery();


	      if (rsr1.next()) {

	     		String totr1 =  rsr1.getString("COUNT(roomno)");	 
	     		nosroom.setText(totr1);
	     		}
	     		
	       if (rsr2.next()) {

	     	     String totr2 =  rsr2.getString("COUNT(roomno)");
	     		nodroom.setText(totr2);
	     		}
	     		
	      if (rsr3.next()) {

	     		     String totr3 =  rsr3.getString("COUNT(roomno)");
	     			noquad.setText(totr3);
	     		}
	                    
	                   JOptionPane.showMessageDialog(null, "Data Saved");
	                   
	                   textField_6.setText("");
	                   textField_7.setText("");
	                   textField_8.setText("");
	                    
				 } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});
		btnNewButton_5.setBounds(73, 403, 89, 23);
		panelRooms.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Update");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
                 int row = table_2.getSelectedRow();
                 String value = (table_2.getModel().getValueAt(row, 0).toString());
                 String qry = "UPDATE Room SET roomtype=?, roomprice=? where roomno="+value;
                 PreparedStatement starm1 = (PreparedStatement) connection.prepareStatement(qry);
               //  starm1.setString(0, textField_6.getText());
                 starm1.setString(1, textField_7.getText());
                 starm1.setString(2, textField_8.getText());
                 starm1.executeUpdate();	   
                 DefaultTableModel mod = (DefaultTableModel)table_2.getModel();
                 mod.setRowCount(0);
                // show_user();
                 
                 PreparedStatement stroom = (PreparedStatement) connection.prepareStatement("Select * from Room ");
                 ResultSet rsroom = stroom.executeQuery();
                 table_2.setModel(DbUtils.resultSetToTableModel(rsroom));

                JOptionPane.showMessageDialog(null, "Update Saved");
                
                textField_6.setText("");
                textField_7.setText("");
                textField_8.setText("");
                    
			 } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
		btnNewButton_6.setBounds(215, 403, 89, 23);
		panelRooms.add(btnNewButton_6);
		
		textField_6 = new JTextField();
		textField_6.setBackground(SystemColor.inactiveCaptionBorder);
		textField_6.setBounds(180, 194, 124, 20);
		panelRooms.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBackground(SystemColor.inactiveCaptionBorder);
		textField_7.setBounds(180, 255, 124, 20);
		panelRooms.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBackground(SystemColor.inactiveCaptionBorder);
		textField_8.setBounds(180, 301, 124, 20);
		panelRooms.add(textField_8);
		textField_8.setColumns(10);
		
		JButton loadroom = new JButton("View Room Details");
		loadroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

                    PreparedStatement stroom = (PreparedStatement) connection.prepareStatement("Select * from Room ");
                    ResultSet rsroom = stroom.executeQuery();
                    table_2.setModel(DbUtils.resultSetToTableModel(rsroom));
                    
			 } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
		loadroom.setBounds(937, 239, 153, 23);
		panelRooms.add(loadroom);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(477, 273, 613, 270);
		panelRooms.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow1 = table_2.getSelectedRow();
				DefaultTableModel model1 = (DefaultTableModel)table_2.getModel();
				textField_6.setText(model1.getValueAt(selectedRow1, 0).toString());
				textField_7.setText(model1.getValueAt(selectedRow1, 1).toString());
				textField_8.setText(model1.getValueAt(selectedRow1, 2).toString());

				
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_25 = new JLabel("Total Rooms - ");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_25.setBounds(436, 53, 96, 14);
		panelRooms.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Room Type");
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setBackground(SystemColor.scrollbar);
		lblNewLabel_26.setOpaque(true);
		lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_26.setBounds(477, 72, 153, 23);
		panelRooms.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("No Of Rooms");
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setBackground(SystemColor.scrollbar);
		lblNewLabel_27.setOpaque(true);
		lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_27.setBounds(628, 72, 165, 23);
		panelRooms.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("singlel");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_28.setBounds(535, 121, 46, 14);
		panelRooms.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Deluxe");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_29.setBounds(535, 157, 46, 14);
		panelRooms.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Quad");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_30.setBounds(542, 197, 54, 14);
		panelRooms.add(lblNewLabel_30);
		
		try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

            PreparedStatement str = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room ");
            ResultSet rsr = str.executeQuery();
			 PreparedStatement str1 = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room where roomtype='single' ");
            ResultSet rsr1 = str1.executeQuery();
            PreparedStatement str2 = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room where roomtype='Deluxe' ");
            ResultSet rsr2 = str2.executeQuery();
            PreparedStatement str3 = (PreparedStatement) connection.prepareStatement("Select COUNT(roomno) from Room where roomtype='Quad' ");
            ResultSet rsr3 = str3.executeQuery();
			  if (rsr1.next()) {

		     String totr1 =  rsr1.getString("COUNT(roomno)");
		 nosroom = new JLabel();
		nosroom.setText(totr1);
		nosroom.setBounds(686, 122, 46, 14);
		panelRooms.add(nosroom);}
		
			  if (rsr2.next()) {

	     String totr2 =  rsr2.getString("COUNT(roomno)");
		 nodroom = new JLabel();
		nodroom.setText(totr2);
		nodroom.setBounds(686, 158, 46, 14);
		panelRooms.add(nodroom);}
		
			  if (rsr3.next()) {

		     String totr3 =  rsr3.getString("COUNT(roomno)");
		 noquad = new JLabel();
		noquad.setText(totr3);
		noquad.setBounds(686, 198, 46, 14);
		panelRooms.add(noquad);}
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(628, 81, 2, 145);
		panelRooms.add(separator_5);
		
		JLabel frrm = new JLabel("");
		frrm.setOpaque(true);
		frrm.setBackground(Color.WHITE);
		frrm.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frrm.setBounds(30, 83, 332, 400);
		panelRooms.add(frrm);
		
		JLabel tblbl = new JLabel("");
		tblbl.setBackground(Color.WHITE);
		tblbl.setOpaque(true);
		tblbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tblbl.setBounds(476, 72, 317, 179);
		panelRooms.add(tblbl);
		
		
			 
			  if (rsr.next()) {

            String totr =  rsr.getString("COUNT(roomno)");
		
		 totrooms = new JLabel();
		totrooms.setText(totr);
		totrooms.setBounds(535, 53, 46, 14);
		panelRooms.add(totrooms);}
		} catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		panelHalls = new JPanel();
		panelHalls.setBackground(SystemColor.controlShadow);
		layeredPane.add(panelHalls, "name_860154596941400");
		panelHalls.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Hall Details");
		lblNewLabel_4.setBounds(433, 11, 147, 19);
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		panelHalls.add(lblNewLabel_4);
		
		JLabel lblAddUpdate_2 = new JLabel("Add / Update Hall ");
		lblAddUpdate_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUpdate_2.setBackground(SystemColor.scrollbar);
		lblAddUpdate_2.setOpaque(true);
		lblAddUpdate_2.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblAddUpdate_2.setBounds(35, 77, 295, 48);
		panelHalls.add(lblAddUpdate_2);
		
		JLabel lblHallName = new JLabel("Hall Name :");
		lblHallName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblHallName.setBounds(65, 177, 73, 17);
		panelHalls.add(lblHallName);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(365, 68, 2, 458);
		panelHalls.add(separator_3);
		
		JLabel lblNewLabel_24 = new JLabel("Price :");
		lblNewLabel_24.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_24.setBounds(65, 223, 56, 19);
		panelHalls.add(lblNewLabel_24);
		
		JButton btnNewButton_7 = new JButton("Add");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

	                    PreparedStatement sthl = (PreparedStatement) connection.prepareStatement("insert into hall(Hallname,price) values (?,?) ");
	                    sthl.setString(1, textField_9.getText());
	                    sthl.setString(2, textField_10.getText());
	                  
	                    sthl.execute();	                    
	                   JOptionPane.showMessageDialog(null, "Data Saved");
	                   
	                   PreparedStatement sthall = (PreparedStatement) connection.prepareStatement("Select * from Hall ");
	                    ResultSet rshall = sthall.executeQuery();
	                    table_1.setModel(DbUtils.resultSetToTableModel(rshall));
	                    
	                    PreparedStatement sth = (PreparedStatement) connection.prepareStatement("Select COUNT(Hallid) from Hall ");
	                    ResultSet rsh = sth.executeQuery();
	        			
	                    textField_9.setText("");
	                    textField_10.setText("");
	                    
	        			  if (rsh.next()) {

	                    String toth =  rsh.getString("COUNT(Hallid)");
	                    tothall.setText(toth);
	        			  }
	            
	        			                    
				 } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }

				
			}
		});
		btnNewButton_7.setBounds(83, 306, 73, 23);
		panelHalls.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Update");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
                 int rowh = table_1.getSelectedRow();
                 String valueh = (table_1.getModel().getValueAt(rowh, 0).toString());
                 String qryh = "UPDATE hall SET Hallname=?, price=? where Hallid="+valueh;
                 PreparedStatement starmh = (PreparedStatement) connection.prepareStatement(qryh);
               //  starm1.setString(0, textField_6.getText());
                 starmh.setString(1, textField_9.getText());
                 starmh.setString(2, textField_10.getText());
                 starmh.executeUpdate();	   
                 DefaultTableModel modl = (DefaultTableModel)table_1.getModel();
                 modl.setRowCount(0);
                // show_user();
                JOptionPane.showMessageDialog(null, "Update Saved");
                
                PreparedStatement sthall = (PreparedStatement) connection.prepareStatement("Select * from Hall ");
                ResultSet rshall = sthall.executeQuery();
                table_1.setModel(DbUtils.resultSetToTableModel(rshall));
                
                textField_9.setText("");
                textField_10.setText("");
                    
			 } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				
			}
		});
		btnNewButton_8.setBounds(207, 306, 79, 23);
		panelHalls.add(btnNewButton_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(158, 176, 114, 20);
		panelHalls.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(157, 223, 115, 20);
		panelHalls.add(textField_10);
		textField_10.setColumns(10);
		
		JButton loadhall = new JButton("View Hall Details");
		loadhall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

	                    PreparedStatement sthall = (PreparedStatement) connection.prepareStatement("Select * from Hall ");
	                    ResultSet rshall = sthall.executeQuery();
	                    table_1.setModel(DbUtils.resultSetToTableModel(rshall));
	                    
				 } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});
		loadhall.setBounds(915, 175, 134, 23);
		panelHalls.add(loadhall);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(446, 223, 603, 307);
		panelHalls.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow2 = table_1.getSelectedRow();
				DefaultTableModel model2 = (DefaultTableModel)table_1.getModel();
				textField_9.setText(model2.getValueAt(selectedRow2, 1).toString());
				textField_10.setText(model2.getValueAt(selectedRow2, 2).toString());
				
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_32 = new JLabel("Total Halls - ");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_32.setBounds(445, 92, 89, 14);
		panelHalls.add(lblNewLabel_32);
		
		JLabel nhbkk = new JLabel("");
		nhbkk.setOpaque(true);
		nhbkk.setBackground(Color.WHITE);
		nhbkk.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		nhbkk.setBounds(35, 76, 295, 289);
		panelHalls.add(nhbkk);
		
		JLabel lngbl = new JLabel("");
		lngbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lngbl.setBackground(SystemColor.controlShadow);
		lngbl.setOpaque(true);
		lngbl.setBounds(420, 77, 105, 48);
		panelHalls.add(lngbl);
		
		try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

            PreparedStatement sth = (PreparedStatement) connection.prepareStatement("Select COUNT(Hallid) from Hall ");
            ResultSet rsh = sth.executeQuery();
			 
			  if (rsh.next()) {

            String toth =  rsh.getString("COUNT(Hallid)");
			 
			 
         tothall = new JLabel();
		tothall.setText(toth);
		tothall.setBounds(530, 93, 46, 14);
		panelHalls.add(tothall);}}
		catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		panelReports = new JPanel();
		panelReports.setBackground(SystemColor.controlShadow);
		layeredPane.add(panelReports, "name_860168170291800");
		panelReports.setLayout(null);
		
		
		evetot = new JLabel("New label");
		evetot.setOpaque(true);
		evetot.setHorizontalAlignment(SwingConstants.CENTER);
		evetot.setFont(new Font("Tahoma", Font.BOLD, 13));
		evetot.setBackground(SystemColor.scrollbar);
		evetot.setBounds(710, 386, 375, 37);
		panelReports.add(evetot);
		
		hallev = new JLabel("New label");
		hallev.setOpaque(true);
		hallev.setHorizontalAlignment(SwingConstants.CENTER);
		hallev.setFont(new Font("Tahoma", Font.BOLD, 13));
		hallev.setBackground(SystemColor.scrollbar);
		hallev.setBounds(710, 317, 375, 37);
		panelReports.add(hallev);
		
		bktot =	new JLabel("New label");
		bktot.setOpaque(true);
		bktot.setHorizontalAlignment(SwingConstants.CENTER);
		bktot.setFont(new Font("Tahoma", Font.BOLD, 13));
		bktot.setBackground(SystemColor.scrollbar);
		bktot.setBounds(710, 243, 375, 37);
		panelReports.add(bktot);
		
		bkings = new JLabel("New label");
		bkings.setOpaque(true);
		bkings.setHorizontalAlignment(SwingConstants.CENTER);
		bkings.setFont(new Font("Tahoma", Font.BOLD, 13));
		bkings.setBackground(SystemColor.scrollbar);
		bkings.setBounds(710, 176, 375, 37);
		panelReports.add(bkings);
		
		cusmers = new JLabel("New label");
		cusmers.setHorizontalAlignment(SwingConstants.CENTER);
		cusmers.setOpaque(true);
		cusmers.setBackground(SystemColor.scrollbar);
		cusmers.setFont(new Font("Tahoma", Font.BOLD, 13));
		cusmers.setBounds(710, 115, 375, 37);
		panelReports.add(cusmers);
		
		
		try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

            PreparedStatement cus = (PreparedStatement) connection.prepareStatement("Select COUNT(customerid) from customer ");
            ResultSet cuss = cus.executeQuery();
            PreparedStatement bk = (PreparedStatement) connection.prepareStatement("Select COUNT(paymentid) from payment where hid IS NULL ");
            ResultSet bkk = bk.executeQuery(); 
            PreparedStatement bkt = (PreparedStatement) connection.prepareStatement("Select SUM(totalamount) from payment where hid IS NULL ");
            ResultSet bkkt = bkt.executeQuery(); 
            
            PreparedStatement hbk = (PreparedStatement) connection.prepareStatement("Select COUNT(paymentid) from payment where hid IS NOT NULL ");
            ResultSet hbkk = hbk.executeQuery(); 
            PreparedStatement hbkt = (PreparedStatement) connection.prepareStatement("Select SUM(totalamount) from payment where hid IS NOT NULL ");
            ResultSet hbkkt = hbkt.executeQuery(); 
            
			  if (cuss.next()) 
			  {
				  String cu = cuss.getString("COUNT(customerid)");
           cusmers.setText("Registered Customers - "+cu);		
			  }
			  if (bkk.next()) 
			  {
				  String bkkk = bkk.getString("COUNT(paymentid)");
				  bkings.setText("Total Bookings - "+bkkk);		
			  }
			  if (bkkt.next()) 
			  {
				  String bkkkt = bkkt.getString("SUM(totalamount)");
				  bktot.setText("Bookings Income  LKR "+bkkkt+"0");		
			  }
			  
			  if (hbkk.next()) 
			  {
				  String hbkkk = hbkk.getString("COUNT(paymentid)");
				  hallev.setText("Total Events - "+hbkkk);		
			  }
			  if (hbkkt.next()) 
			  {
				  String hbkkkt = hbkkt.getString("SUM(totalamount)");
				  evetot.setText("Events Income  LKR "+hbkkkt+"0");		
			  }
			  
			  }
		catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		
		JLabel subtot = new JLabel("");
		subtot.setFont(new Font("Tahoma", Font.BOLD, 13));
		subtot.setBounds(432, 546, 120, 14);
		panelReports.add(subtot);
		
		restot = new JLabel("");
		restot.setFont(new Font("Tahoma", Font.PLAIN, 13));
		restot.setBounds(456, 441, 81, 14);
		panelReports.add(restot);
		
		bartot = new JLabel("");
		bartot.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bartot.setBounds(456, 358, 81, 14);
		panelReports.add(bartot);
		
		htot = new JLabel("");
		htot.setFont(new Font("Tahoma", Font.PLAIN, 13));
		htot.setBounds(456, 283, 81, 14);
		panelReports.add(htot);
		
		rtot = new JLabel("");
		rtot.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rtot.setBounds(456, 212, 81, 14);
		panelReports.add(rtot);
		
		nores = new JLabel("");
		nores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nores.setBounds(288, 441, 58, 14);
		panelReports.add(nores);
		
		nobar = new JLabel("");
		nobar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nobar.setBounds(288, 358, 58, 14);
		panelReports.add(nobar);
		
		nohall = new JLabel("");
		nohall.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nohall.setBounds(288, 283, 58, 14);
		panelReports.add(nohall);
		
		noroom = new JLabel("");
		noroom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		noroom.setBounds(288, 212, 58, 14);
		panelReports.add(noroom);
		
		JLabel lblTotalIncome = new JLabel("Total Income");
		lblTotalIncome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalIncome.setBounds(261, 544, 97, 19);
		panelReports.add(lblTotalIncome);
		
		JLabel lblRes = new JLabel("Restaurant");
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRes.setBounds(104, 439, 97, 16);
		panelReports.add(lblRes);
		
		JLabel lblBar = new JLabel("Bar");
		lblBar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBar.setBounds(104, 356, 97, 16);
		panelReports.add(lblBar);
		
		JLabel lblHallBookings = new JLabel("Hall Bookings");
		lblHallBookings.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHallBookings.setBounds(104, 281, 97, 19);
		panelReports.add(lblHallBookings);
		
		JLabel lblNewLabel_37 = new JLabel("Room Bookings");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_37.setBounds(104, 210, 97, 19);
		panelReports.add(lblNewLabel_37);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBounds(88, 526, 464, 7);
		panelReports.add(separator_8);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(88, 157, 464, 7);
		panelReports.add(separator_7);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(228, 125, 2, 400);
		panelReports.add(separator_6);
		
		JLabel lblDivisionIncome = new JLabel("Division Income");
		lblDivisionIncome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDivisionIncome.setBounds(425, 133, 112, 19);
		panelReports.add(lblDivisionIncome);
		
		JLabel lblTotalNoOf = new JLabel("Total No Of Orders");
		lblTotalNoOf.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblTotalNoOf.setBounds(261, 127, 128, 31);
		panelReports.add(lblTotalNoOf);
		
		JLabel lblNewLabel_36 = new JLabel("Division");
		lblNewLabel_36.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_36.setBounds(121, 133, 65, 19);
		panelReports.add(lblNewLabel_36);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(398, 127, 2, 449);
		panelReports.add(separator_5);
		
		JLabel lblNewLabel_5 = new JLabel("Report ");
		lblNewLabel_5.setBounds(576, 5, 58, 19);
		lblNewLabel_5.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		panelReports.add(lblNewLabel_5);
		
		JLabel lblNewLabel_34 = new JLabel("From Date:");
		lblNewLabel_34.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_34.setBounds(88, 73, 75, 19);
		panelReports.add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("To Date:");
		lblNewLabel_35.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel_35.setBounds(288, 73, 58, 19);
		panelReports.add(lblNewLabel_35);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(168, 73, 91, 20);
		panelReports.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(356, 73, 91, 20);
		panelReports.add(dateChooser_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setOpaque(true);
		label_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(73, 115, 490, 474);
		panelReports.add(label_3);
		
		
		
		
		JButton repGen = new JButton("Generate");
		repGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String from = sdf.format(dateChooser.getDate());
					SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd");
					String to = sdf2.format(dateChooser_1.getDate());
					
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

		            PreparedStatement str = (PreparedStatement) connection.prepareStatement("Select SUM(b.total) from bill b, order1 o where b.orderid = o.orderid and orderdate between ? and ? and b.foodid IS NOT NULL ");		         
		            str.setString(1, from);
		            str.setString(2, to);
		            ResultSet rsr = str.executeQuery();
		            PreparedStatement reso = (PreparedStatement) connection.prepareStatement("Select COUNT(b.billid) from bill b, order1 o where b.orderid = o.orderid and b.foodid IS NOT NULL and orderdate between ? and ? ");		         
		            reso.setString(1, from);
		            reso.setString(2, to);
		            ResultSet rso = reso.executeQuery();
		            
		            PreparedStatement strb = (PreparedStatement) connection.prepareStatement("Select SUM(b.total) from bill b, order1 o where b.orderid = o.orderid and orderdate between ? and ? and b.liquorid IS NOT NULL ");		         
		            strb.setString(1, from);
		            strb.setString(2, to);
		            ResultSet rsb = strb.executeQuery();
		            PreparedStatement barc = (PreparedStatement) connection.prepareStatement("Select COUNT(b.billid) from bill b, order1 o where b.orderid = o.orderid and b.liquorid IS NOT NULL and orderdate between ? and ? ");		         
		            barc.setString(1, from);
		            barc.setString(2, to);
		            ResultSet bb = barc.executeQuery();
		            
		            PreparedStatement roomb = (PreparedStatement) connection.prepareStatement("Select SUM(totalamount) from payment where paymentdate between ? and ? and hid IS NULL ");		         
		            roomb.setString(1, from);
		            roomb.setString(2, to);
		            ResultSet rmb = roomb.executeQuery();
		            PreparedStatement roomc = (PreparedStatement) connection.prepareStatement("Select COUNT(paymentid) from payment where hid IS NULL and paymentdate between ? and ? ");		         
		            roomc.setString(1, from);
		            roomc.setString(2, to);
		            ResultSet rc = roomc.executeQuery();
		            
		            PreparedStatement hoomb = (PreparedStatement) connection.prepareStatement("Select SUM(totalamount) from payment where paymentdate between ? and ? and hid IS NOT NULL ");		         
		            hoomb.setString(1, from);
		            hoomb.setString(2, to);
		            ResultSet hmb = hoomb.executeQuery();
		            PreparedStatement hoomc = (PreparedStatement) connection.prepareStatement("Select COUNT(paymentid) from payment where hid IS NOT NULL and paymentdate between ? and ? ");		         
		            hoomc.setString(1, from);
		            hoomc.setString(2, to);
		            ResultSet hc = hoomc.executeQuery();
		            
		            double r=0,b=0,h=0,rm=0;
		            
				if (rsr.next()) {
					String rstot =  rsr.getString("SUM(b.total)");
					 r = rsr.getDouble("SUM(b.total)");
					restot.setText(rstot+"0");
				}
				if (rso.next()) {
					String rsoo =  rso.getString("COUNT(b.billid)");  
					nores.setText(rsoo);
				}
				if (rsb.next()) {
					String rsbr =  rsb.getString("SUM(b.total)"); 
					b = rsb.getDouble("SUM(b.total)");
					bartot.setText(rsbr+"0");
				}
				if (bb.next()) {
					String boo =  bb.getString("COUNT(b.billid)");  
					nobar.setText(boo);
				}
				if (rmb.next()) {
					String rmbr =  rmb.getString("SUM(totalamount)");  
					rm = rmb.getDouble("SUM(totalamount)");
					rtot.setText(rmbr+"0");
				}
				if (rc.next()) {
					String rcr =  rc.getString("COUNT(paymentid)");  
					noroom.setText(rcr);
				}
				if (hmb.next()) {
					String hmbr =  hmb.getString("SUM(totalamount)");  
					h = hmb.getDouble("SUM(totalamount)");
					htot.setText(hmbr+"0");
				}
				if (hc.next()) {
					String hcr =  hc.getString("COUNT(paymentid)");  
					nohall.setText(hcr);
				}
				
				double calc = r+b+h+rm;
				String subtotal=String.valueOf(calc);
				subtot.setText("LKR "+subtotal+"0");
				
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
			}
		});
		
		
		
		repGen.setFont(new Font("Tahoma", Font.BOLD, 11));
		repGen.setBounds(463, 72, 89, 23);
		panelReports.add(repGen);
		
		JLabel lblNewLabel_33 = new JLabel("Royal Resort Income Rerport");
		lblNewLabel_33.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_33.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_33.setOpaque(true);
		lblNewLabel_33.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_33.setBackground(Color.WHITE);
		lblNewLabel_33.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_33.setBounds(73, 34, 490, 70);
		panelReports.add(lblNewLabel_33);
		
		JButton btnNewButton_9 = new JButton("Download report");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					File file = new File("C:\\Users\\user\\Desktop\\AdminReport.txt");
					if(!file.exists()) {
						file.createNewFile();
					}
				
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String from = sdf.format(dateChooser.getDate());
					SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd");
					String to = sdf2.format(dateChooser_1.getDate());
					
					bw.write("\t\t\t--------------------Royal Resort Income Report------------------------\n");
					bw.write("\t\t\t-----------------------From: "+from+" To: "+to+"------------------------\n");
					bw.write("\n");
					bw.write("\t\t\t Division \t\t Tot Orders \t\t Tot Income \n");
					bw.write("\n");
					try {
						
						
						
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

			            PreparedStatement str = (PreparedStatement) connection.prepareStatement("Select SUM(b.total) from bill b, order1 o where b.orderid = o.orderid and orderdate between ? and ? and b.foodid IS NOT NULL ");		         
			            str.setString(1, from);
			            str.setString(2, to);
			            ResultSet rsr = str.executeQuery();
			            PreparedStatement reso = (PreparedStatement) connection.prepareStatement("Select COUNT(b.billid) from bill b, order1 o where b.orderid = o.orderid and b.foodid IS NOT NULL and orderdate between ? and ? ");		         
			            reso.setString(1, from);
			            reso.setString(2, to);
			            ResultSet rso = reso.executeQuery();
			            
			            PreparedStatement strb = (PreparedStatement) connection.prepareStatement("Select SUM(b.total) from bill b, order1 o where b.orderid = o.orderid and orderdate between ? and ? and b.liquorid IS NOT NULL ");		         
			            strb.setString(1, from);
			            strb.setString(2, to);
			            ResultSet rsb = strb.executeQuery();
			            PreparedStatement barc = (PreparedStatement) connection.prepareStatement("Select COUNT(b.billid) from bill b, order1 o where b.orderid = o.orderid and b.liquorid IS NOT NULL and orderdate between ? and ? ");		         
			            barc.setString(1, from);
			            barc.setString(2, to);
			            ResultSet bb = barc.executeQuery();
			            
			            PreparedStatement roomb = (PreparedStatement) connection.prepareStatement("Select SUM(totalamount) from payment where paymentdate between ? and ? and hid IS NULL ");		         
			            roomb.setString(1, from);
			            roomb.setString(2, to);
			            ResultSet rmb = roomb.executeQuery();
			            PreparedStatement roomc = (PreparedStatement) connection.prepareStatement("Select COUNT(paymentid) from payment where hid IS NULL and paymentdate between ? and ? ");		         
			            roomc.setString(1, from);
			            roomc.setString(2, to);
			            ResultSet rc = roomc.executeQuery();
			            
			            PreparedStatement hoomb = (PreparedStatement) connection.prepareStatement("Select SUM(totalamount) from payment where paymentdate between ? and ? and hid IS NOT NULL ");		         
			            hoomb.setString(1, from);
			            hoomb.setString(2, to);
			            ResultSet hmb = hoomb.executeQuery();
			            PreparedStatement hoomc = (PreparedStatement) connection.prepareStatement("Select COUNT(paymentid) from payment where hid IS NOT NULL and paymentdate between ? and ? ");		         
			            hoomc.setString(1, from);
			            hoomc.setString(2, to);
			            ResultSet hc = hoomc.executeQuery();
			            
			            double r=0,b=0,h=0,rm=0;
			            
					if (rsr.next()) {
						String rstot =  rsr.getString("SUM(b.total)");
						 r = rsr.getDouble("SUM(b.total)");
						restot.setText(rstot+"0");
					}
					if (rso.next()) {
						String rsoo =  rso.getString("COUNT(b.billid)");  
						nores.setText(rsoo);
					
					bw.write("\t\t\t Resturant \t\t  "+rsoo+" \t\t\t"+r+" \n\n");
					}
					if (rsb.next()) {
						String rsbr =  rsb.getString("SUM(b.total)"); 
						b = rsb.getDouble("SUM(b.total)");
						bartot.setText(rsbr+"0");
					}
					if (bb.next()) {
						String boo =  bb.getString("COUNT(b.billid)");  
						nobar.setText(boo);
						
						bw.write("\t\t\t Bar     \t\t  "+boo+" \t\t\t"+b+" \n\n");
					}
					if (rmb.next()) {
						String rmbr =  rmb.getString("SUM(totalamount)");  
						rm = rmb.getDouble("SUM(totalamount)");
						rtot.setText(rmbr+"0");
					}
					if (rc.next()) {
						String rcr =  rc.getString("COUNT(paymentid)");  
						noroom.setText(rcr);
						
						bw.write("\t\t\t Rooms   \t\t  "+rcr+" \t\t\t"+rm+" \n\n");
					}
					if (hmb.next()) {
						String hmbr =  hmb.getString("SUM(totalamount)");  
						h = hmb.getDouble("SUM(totalamount)");
						htot.setText(hmbr+"0");
					}
					if (hc.next()) {
						String hcr =  hc.getString("COUNT(paymentid)");  
						nohall.setText(hcr);
						
						bw.write("\t\t\t Halls   \t\t  "+hcr+" \t\t\t"+h+" \n\n");
					}
					
					double calc = r+b+h+rm;
					String subtotal=String.valueOf(calc);
					subtot.setText("LKR "+subtotal+"0");
					bw.write("\t\t\t\t     Sub Total  \t\t\t"+subtotal+" \n\n");
					}
					catch (Exception exception) {
				         exception.printStackTrace();
				     }
				
					bw.close();
					fw.close();
					 JOptionPane.showMessageDialog(null, "File Saved");
					
				}
				catch(Exception exception) {
			         exception.printStackTrace();
			     }
				
			}
		});
		btnNewButton_9.setBounds(595, 526, 128, 23);
		panelReports.add(btnNewButton_9);
		
		JLabel lblPerformanceStatistics = new JLabel("Performance Statistics");
		lblPerformanceStatistics.setVerticalTextPosition(SwingConstants.TOP);
		lblPerformanceStatistics.setVerticalAlignment(SwingConstants.TOP);
		lblPerformanceStatistics.setOpaque(true);
		lblPerformanceStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerformanceStatistics.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblPerformanceStatistics.setBackground(Color.WHITE);
		lblPerformanceStatistics.setBounds(644, 70, 490, 384);
		panelReports.add(lblPerformanceStatistics);
		
		
		
		
		
		JLabel lblAdminPanel = new JLabel("ADMIN PANEL");
		lblAdminPanel.setForeground(Color.WHITE);
		lblAdminPanel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 17));
		lblAdminPanel.setBounds(32, 140, 126, 39);
		contentPane.add(lblAdminPanel);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBorder(null);
		label_4.setBackground(new Color(0, 30, 46));
		label_4.setBounds(0, 0, 1370, 749);
		contentPane.add(label_4);
	}
}
