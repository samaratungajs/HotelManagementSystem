package Final;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.result.Row;
//import com.sun.java.util.jar.pack.ConstantPool.Index;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.awt.SystemColor;


public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1 ;
	private JPanel contentPane;
	private JPanel report;
	private JPanel menu;
	private JPanel invoice;
	private JPanel function_reg;
	private JPanel customer_reg;
	
	private JLayeredPane layeredPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField nationality;
	private JTextField nicpass;
	private JTextField mobile;
	private JButton btn_add;
	DefaultTableModel model;
	DefaultTableModel model2;

	
	//function details
	private JTextField fun_cusID;
	private JTextField event_type;
	private JTextField guest_count;
	private JTextField package_price;
	private JButton fun_add;
	private JTextField invo_cid;
	private JTextField invo_hallname;
	private JTextField txt_invo_pprice;
	private JTextField txt_invo_gcount;
	private JTextField txt_sub_pcal;
	private JTextField txt_invo_rent;
	private JTextField txt_invo_charge;
	private JTextField txt_sub_hcal;
	private JTable table_cus;
	private JButton btn_invo_submit;
	private JTable table_fun;
	private JTextField invo_grand;
	private JTable table_invo;
	private JTextField menuCus;
	private JTextField menuOP;
	private JTextField txt_search;
	private JTextField txt_fun_search;

	/**
	 * Launch the application.
	 * 
	 */
	public void refreshcustomer()
	{
		 try {
	    	 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	         String query = "SELECT * FROM customer ";
	     
	         PreparedStatement pst = connection.prepareStatement(query);
	         ResultSet rs=pst.executeQuery();
	         table_cus.setModel(DbUtils.resultSetToTableModel(rs));
	         
	        
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setExtendedState(MAXIMIZED_BOTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1306, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 30, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Royal Resort");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(371, 13, 521, 91);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(201, 128, 2, 587);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(22, 105, 1229, 2);
		contentPane.add(separator);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new  Color(0, 30, 46));
		panel_1.setBounds(14, 115, 181, 600);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JButton btncustomer = new JButton("CUSTOMER DETAILS");
		//btncustomer.setBackground(Color.WHITE);
		btncustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btncustomer.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				switchPanels(customer_reg);
				
				
			}
		});
		btncustomer.setBounds(12, 41, 150, 52);
		panel_1.add(btncustomer);
		
		JButton btnfunction = new JButton("FUNCTION DETAILS");
		//btnfunction.setBackground(Color.WHITE);
		btnfunction.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnfunction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanels(function_reg);
				
			}
		});
		btnfunction.setBounds(12, 148, 150, 52);
		panel_1.add(btnfunction);
		
		JButton btninvoice = new JButton("INVOICE");
	//	btninvoice.setBackground(Color.WHITE);
		btninvoice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btninvoice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				switchPanels(invoice);
				
			}
		});
		btninvoice.setBounds(12, 258, 150, 52);
		panel_1.add(btninvoice);
		
		JButton btnmenu = new JButton("MENU DETAILS");
	//	btnmenu.setBackground(Color.WHITE);
		btnmenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnmenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanels(menu);
			}
		});
		btnmenu.setBounds(12, 374, 150, 52);
		panel_1.add(btnmenu);
		
		JButton btnreport = new JButton("REPORT");
		//btnreport.setBackground(Color.WHITE);
		btnreport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnreport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchPanels(report);
				
			}
		});
		btnreport.setBounds(12, 483, 150, 52);
		panel_1.add(btnreport);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(212, 115, 1064, 600);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		//customer register
		customer_reg = new JPanel();
		customer_reg.setBackground(Color.GRAY);
		layeredPane.add(customer_reg, "name_5031094669145800");
		customer_reg.setLayout(null);
		
		JPanel panel_cus_reg = new JPanel();
		panel_cus_reg.setBackground(Color.WHITE);
		panel_cus_reg.setBounds(10, 80, 376, 510);
		customer_reg.add(panel_cus_reg);
		panel_cus_reg.setLayout(null);
		
		JLabel fname = new JLabel("First Name");
		fname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fname.setHorizontalAlignment(SwingConstants.LEFT);
		fname.setBounds(10, 47, 96, 32);
		panel_cus_reg.add(fname);
		
		JLabel lname = new JLabel("Last Name");
		lname.setHorizontalAlignment(SwingConstants.LEFT);
		lname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lname.setBounds(10, 89, 96, 32);
		panel_cus_reg.add(lname);
		
		JLabel mail = new JLabel("Email");
		mail.setHorizontalAlignment(SwingConstants.LEFT);
		mail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mail.setBounds(10, 144, 96, 32);
		panel_cus_reg.add(mail);
		
		JLabel nation = new JLabel("Nationality");
		nation.setHorizontalAlignment(SwingConstants.LEFT);
		nation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nation.setBounds(10, 202, 96, 32);
		panel_cus_reg.add(nation);
		
		JLabel nic = new JLabel("NIC/Passport");
		nic.setHorizontalAlignment(SwingConstants.LEFT);
		nic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nic.setBounds(10, 266, 96, 32);
		panel_cus_reg.add(nic);
		
		JLabel phone = new JLabel("Contact NO");
		phone.setHorizontalAlignment(SwingConstants.LEFT);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setBounds(10, 327, 96, 32);
		panel_cus_reg.add(phone);
		
		firstName = new JTextField();
		firstName.setBounds(183, 56, 142, 19);
		panel_cus_reg.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(183, 98, 142, 19);
		panel_cus_reg.add(lastName);
		
		email = new JTextField();
		
		email.setColumns(10);
		email.setBounds(183, 153, 142, 19);
		panel_cus_reg.add(email);
		
		nationality = new JTextField();
		nationality.setColumns(10);
		nationality.setBounds(183, 211, 142, 19);
		panel_cus_reg.add(nationality);
		
		nicpass = new JTextField();
		nicpass.setColumns(10);
		nicpass.setBounds(183, 275, 142, 19);
		panel_cus_reg.add(nicpass);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(183, 336, 142, 19);
		panel_cus_reg.add(mobile);
	
		//customer information connection
		btn_add = new JButton("Add");
		btn_add.addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				
				
				
				String fName = firstName.getText();
				String lName = lastName.getText();
				String emailId = email.getText();
				String national = nationality.getText();
				String nICpass = nicpass.getText();
				int nlen = nICpass.length();
				String mobilenum = mobile.getText();
				int mlen = mobilenum.length();
				
				
				
				String msg = "" + fName;
				msg += "\n";
				
					  
                
				try {
					
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					String query = "INSERT INTO customer values('" + 0 + "','" + fName  + "','" + lName + "','" + emailId + "','" +
							national + "','" + nICpass+ "','" + mobilenum + "')";
					
					Statement statement = connection.createStatement();
					
					int x = statement.executeUpdate(query);
					

					if(nlen !=10) {
						JOptionPane.showMessageDialog(btn_add, "Enter a valid NIC/Passport number");
						
					}
					
					else if(mlen !=10) {
						JOptionPane.showMessageDialog(btn_add, "Enetr a valid phone numder");
					}
					
					
					else if (!emailId.contains("@")) {
						JOptionPane.showMessageDialog(btn_add, "Enter a valid email adrress");
						
					}
					
						   
					else if(x == 0) {
						JOptionPane.showMessageDialog(btn_add, "This is alredy exist");
						
					}else {
						JOptionPane.showMessageDialog(btn_add, "Welcome, " + msg + "Your account is sucessfully created");
						
					}
					
					 connection.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
						 String query = "select * from customer";
		                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
		                    
		                    ResultSet rs = st.executeQuery();
		                   
		                    table_cus.setModel(DbUtils.resultSetToTableModel(rs));
		                    
		                    
		                    st.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
				 firstName.setText("");
					lastName.setText("");
					email.setText("");
					nationality.setText("");
					nicpass.setText("");
					mobile.setText("");
					
					
					
					
					
					
					
					
				}
		});
		
		btn_add.setBounds(204, 463, 75, 21);
		panel_cus_reg.add(btn_add);
		
		JButton cus_delete = new JButton("Delete");
		cus_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_cus.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_cus.getModel();
			     String customer_id =(model.getValueAt(selectedRow, 0).toString());
			     
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					String query = "DELETE  FROM customer WHERE customerid = "+customer_id;
					PreparedStatement pst = connection.prepareStatement(query);
					int rs = pst.executeUpdate(query);		  
					
					if (rs == 0) {
			             JOptionPane.showMessageDialog(cus_delete, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(cus_delete,"Customer details successfully Deleted");
			         }
			         connection.close();
                   
					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
				
				firstName.setText("");
				lastName.setText("");
				email.setText("");
				nationality.setText("");
				nicpass.setText("");
				mobile.setText("");
				
				refreshcustomer();
				
				
			}
		});
		cus_delete.setBounds(192, 412, 87, 21);
		panel_cus_reg.add(cus_delete);
		
		JButton cus_update = new JButton("Update");
		cus_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fName = firstName.getText();
				String lName = lastName.getText();
				String emailId = email.getText();
				String national = nationality.getText();
				String nICpass = nicpass.getText();
				
				String mobilenum = mobile.getText();
				String driverName = "com.mysql.cj.jdbc.Driver";
				
				int selectedRow = table_cus.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_cus.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					 String query = "UPDATE customer set fname='"+fName+"', lname='"+lName+"', Email='"+emailId+"', nationality='"+national+"' ,NICpassport='"+nICpass+"',phone='"+mobilenum+"' where customerid='"+id+"'";
					 PreparedStatement pst = connection.prepareStatement(query);
						
					 int x = pst.executeUpdate(query);

					if (x == 0) {
			             JOptionPane.showMessageDialog(cus_update, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(cus_update,
			                "Customer details successfully updated");
			         }

                    
                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		cus_update.setBounds(69, 412, 79, 21);
		panel_cus_reg.add(cus_update);
		
		JButton btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstName.setText("");
				lastName.setText("");
				email.setText("");
				nationality.setText("");
				nicpass.setText("");
				mobile.setText("");
				
				
				
			}
		});
		btn_clear.setBounds(61, 463, 87, 21);
		panel_cus_reg.add(btn_clear);
		
		
		JLabel lblNewLabel_2 = new JLabel("Add,Update Customer Details");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(32, 22, 291, 48);
		customer_reg.add(lblNewLabel_2);
		
		JButton btn_loader = new JButton("Display customer details");
		btn_loader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					 String query = "select * from customer";
	                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
	                    
	                    ResultSet rs = st.executeQuery();
	                   
	                    table_cus.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	                    
	                    st.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_loader.setBounds(811, 81, 187, 21);
		customer_reg.add(btn_loader);
		
		JLabel lblNewLabel_2_1 = new JLabel("Customer Details");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBackground(Color.RED);
		lblNewLabel_2_1.setBounds(671, 22, 291, 48);
		customer_reg.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(461, 139, 489, 364);
		customer_reg.add(scrollPane);
		
		
		//customer table
		table_cus = new JTable();
		table_cus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table_cus.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) table_cus.getModel(); 
					
					//txt_booking.setText(model.getValueAt(row, 1).toString());
					fun_cusID.setText(model.getValueAt(row, 0).toString());
					
					
					//customer_id.setText(model.getValueAt(row, 0).toString());
					firstName.setText(model.getValueAt(row, 1).toString());
					lastName.setText(model.getValueAt(row, 2).toString());
					email.setText(model.getValueAt(row, 3).toString());
					nationality.setText(model.getValueAt(row, 4).toString());
					nicpass.setText(model.getValueAt(row, 5).toString());
					mobile.setText(model.getValueAt(row, 6).toString());
					
					
					String cusID_ =(table_cus.getModel().getValueAt(row, 0).toString());
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String query = "select * from customer where customerid='"+cusID_+"'";
					PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
		             
		             ResultSet rs = st.executeQuery();
		             
		             while(rs.next()) {
		            	 
		            	 //customer_id.setText(rs.getString("customerid"));
		            	 firstName.setText(rs.getString("fname"));
		            	 lastName.setText(rs.getString("lname"));
		            	 email.setText(rs.getString("Email"));
		            	 nationality.setText(rs.getString("nationality"));
		            	 nicpass.setText(rs.getString("NICpassport"));
		            	 mobile.setText(rs.getString("phone"));
		            	 
		             }
					
					st.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		try {
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
			
			 String query = "select * from customer";
             PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
             
             ResultSet rs = st.executeQuery();
            
             table_cus.setModel(DbUtils.resultSetToTableModel(rs));
             
             
             st.close();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model=new DefaultTableModel();
		Object[] column = {"customerid","fname","lname","Email","nationality","NICpassport","phone"};
		final Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table_cus.setModel(model);
		scrollPane.setViewportView(table_cus);
		
		
		
		table_cus.setBackground(Color.PINK);
		
		JButton btn_booking = new JButton("New Booking");
		btn_booking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				layeredPane.removeAll();
				layeredPane.add(function_reg);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				
				
			}
		});
		btn_booking.setBounds(791, 533, 120, 21);
		customer_reg.add(btn_booking);
		
		txt_search = new JTextField();
		txt_search.setToolTipText("");
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from customer where fname=?";
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
                    st.setNString(1, txt_search.getText());
                    ResultSet rs = st.executeQuery();
                   
                    table_cus.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    
                    st.close();
                    
			 } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
			}
		});
		txt_search.setColumns(10);
		txt_search.setBounds(622, 82, 142, 20);
		customer_reg.add(txt_search);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch.setBounds(505, 80, 96, 22);
		customer_reg.add(lblSearch);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(422, 10, 2, 587);
		customer_reg.add(separator_1_1);
		
		
		
		
		
		//function Details
		
		function_reg = new JPanel();
		function_reg.setBackground(Color.GRAY);
		layeredPane.add(function_reg, "name_5031122172510600");
		function_reg.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Add,Update Customer Details");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2.setBackground(Color.RED);
		lblNewLabel_2_2.setBounds(10, 10, 291, 36);
		function_reg.add(lblNewLabel_2_2);
		
		JPanel panel_fun_reg = new JPanel();
		panel_fun_reg.setBounds(20, 56, 329, 520);
		function_reg.add(panel_fun_reg);
		panel_fun_reg.setLayout(null);
		
		JLabel fun_cus_id = new JLabel("Customer Name");
		fun_cus_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fun_cus_id.setHorizontalAlignment(SwingConstants.LEFT);
		fun_cus_id.setBounds(10, 25, 124, 13);
		panel_fun_reg.add(fun_cus_id);
		
		JLabel fun_cus_evtype = new JLabel("Event Type");
		fun_cus_evtype.setHorizontalAlignment(SwingConstants.LEFT);
		fun_cus_evtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fun_cus_evtype.setBounds(10, 180, 91, 20);
		panel_fun_reg.add(fun_cus_evtype);
		
		JLabel fun_cus_evdate = new JLabel("Event Date");
		fun_cus_evdate.setHorizontalAlignment(SwingConstants.LEFT);
		fun_cus_evdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fun_cus_evdate.setBounds(10, 146, 91, 13);
		panel_fun_reg.add(fun_cus_evdate);
		
		JLabel fun_cus_dateres = new JLabel("Date Reserved");
		fun_cus_dateres.setHorizontalAlignment(SwingConstants.LEFT);
		fun_cus_dateres.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fun_cus_dateres.setBounds(10, 232, 110, 13);
		panel_fun_reg.add(fun_cus_dateres);
		
		JLabel fun_cus_guest = new JLabel("Guest Count");
		fun_cus_guest.setHorizontalAlignment(SwingConstants.LEFT);
		fun_cus_guest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fun_cus_guest.setBounds(10, 396, 91, 13);
		panel_fun_reg.add(fun_cus_guest);
		
		JLabel fun_cus_pact = new JLabel("Package Type");
		fun_cus_pact.setHorizontalAlignment(SwingConstants.LEFT);
		fun_cus_pact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fun_cus_pact.setBounds(10, 283, 110, 20);
		panel_fun_reg.add(fun_cus_pact);
		
		JLabel fun_cus_pacp = new JLabel("Package Price");
		fun_cus_pacp.setHorizontalAlignment(SwingConstants.LEFT);
		fun_cus_pacp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fun_cus_pacp.setBounds(10, 337, 110, 20);
		panel_fun_reg.add(fun_cus_pacp);
		
		fun_cusID = new JTextField();
		fun_cusID.setBounds(162, 24, 140, 19);
		panel_fun_reg.add(fun_cusID);
		fun_cusID.setColumns(10);
		
		event_type = new JTextField();
		event_type.setColumns(10);
		event_type.setBounds(162, 183, 140, 19);
		panel_fun_reg.add(event_type);
		
		guest_count = new JTextField();
		guest_count.setColumns(10);
		guest_count.setBounds(162, 395, 140, 19);
		panel_fun_reg.add(guest_count);
		
		package_price = new JTextField();
		package_price.setColumns(10);
		package_price.setBounds(162, 337, 140, 19);
		panel_fun_reg.add(package_price);
		
		String[] type = {"King","Queen","Princess"};
		JComboBox combo_hall = new JComboBox(type);
		panel_fun_reg.add(combo_hall);
		
		JDateChooser event_date = new JDateChooser();
		event_date.setBounds(162, 140, 140, 19);
		panel_fun_reg.add(event_date);
		
		JDateChooser date_reserved = new JDateChooser();
		date_reserved.setBounds(162, 226, 140, 19);
		panel_fun_reg.add(date_reserved);
		
		JComboBox package_type = new JComboBox(new Object[]{"Amythest","Sapphire","Ruby"});
		package_type.setBounds(162, 285, 140, 21);
		panel_fun_reg.add(package_type);
		
		//function details
		fun_add = new JButton("Add");
		fun_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int c_id= Integer.parseInt(fun_cusID.getText());

				
				
				String hallname = (String)combo_hall.getSelectedItem();
				
				
				
				String eventtype = event_type.getText();
				
				
				
				String p_type=(String)package_type.getSelectedItem();
				
				 double p_price = Double.parseDouble(package_price.getText());
				
				String g_count = guest_count.getText();
				
			
				

				
				
				
				
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					String query = "INSERT INTO hallbooking (cid,hallname,Eventdate,Eventname,Reservedate,packagetype,packageprice,guestcount) values (?,?,?,?,?,?,?,?)";
					
					
					PreparedStatement pst = connection.prepareStatement(query);
					
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String date = sdf.format(event_date.getDate());
					pst.setString(3, date);
					
					SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
					String date1 = sdf1.format(date_reserved.getDate());
					pst.setString(5, date1);
					
					pst.setInt(1,c_id);
					pst.setString(2, hallname);
					pst.setString(4, eventtype);
					
					pst.setString(6, p_type);
					pst.setDouble(7,p_price );
					pst.setString(8, g_count);
					
					
					
					int data = pst.executeUpdate();
					if(data>0)
					{
						JOptionPane.showMessageDialog(null, "Data added");
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "can't insert data");
					}
					
					
					
				
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					 String query = "select * from hallbooking";
	                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
	                    
	                    ResultSet rs = st.executeQuery();
	                   
	                    table_fun.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	                    
	                    st.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fun_cusID.setText("");
				combo_hall.setSelectedItem("");
				event_date.setDateFormatString("");
				event_type.setText("");
				date_reserved.setDateFormatString("");
				package_type.setSelectedItem("");
				package_price.setText("");
				guest_count.setText("");
				
				
				


				
				
			}
		});
		fun_add.setBounds(217, 448, 85, 21);
		panel_fun_reg.add(fun_add);
		
		JButton fun_update = new JButton("Update");
		fun_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String hallname = (String)combo_hall.getSelectedItem();
				
				
				
				String eventtype = event_type.getText();
				
				
				
				String p_type=(String)package_type.getSelectedItem();
				
				 double p_price = Double.parseDouble(package_price.getText());
				
				String g_count = guest_count.getText();
				
				
				 
				 /*SimpleDateFormat dateFormat1 = new SimpleDateFormat("YYYY-MM-dd");
				 int row11 = table_fun.getSelectedRow();
				 String thedate1 = dateFormat.format(date_reserved.getDate());
				 DefaultTableModel model21 = (DefaultTableModel)table_fun.getModel();
				 model21.setValueAt(thedate, row11, 3);*/
				 
				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
				 
				 String thedate = dateFormat.format(event_date.getDate());
				 String thedate2 = dateFormat.format(date_reserved.getDate());
					//String date = sdf.format(event_date.getDate());
				
				
				
				
						
					//SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
					//String date1 = sdf1.format(date_reserved.getDate());	
				

				
				
				String driverName = "com.mysql.cj.jdbc.Driver";
				
				//int selectedRow = table_fun.getSelectedRow();
			     //DefaultTableModel model2 = (DefaultTableModel) table_fun.getModel();
			    
				int row1 = table_fun.getSelectedRow();
				 DefaultTableModel model2 = (DefaultTableModel)table_fun.getModel();
				
				 String id =(model2.getValueAt(row1, 0).toString());
				 
				
				
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					 String query = "UPDATE hallbooking set hallname='"+hallname+"', Eventdate='"+thedate+"', Eventname='"+eventtype +"', Reservedate='"+thedate2+"' ,packagetype='"+p_type+"',packageprice='"+p_price+"',guestcount='"+g_count+"' where cid='"+id+"' ";
					 PreparedStatement pst = connection.prepareStatement(query);
						
					 int x = pst.executeUpdate(query);
					 
					

					

					if (x == 0) {
			             JOptionPane.showMessageDialog(fun_update, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(fun_update,
			                "Function details successfully updated");
			         }

                    
                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		fun_update.setBounds(35, 448, 85, 21);
		panel_fun_reg.add(fun_update);
		
		
		
		
		
		JLabel hall_name = new JLabel("Hall Name");
		hall_name.setHorizontalAlignment(SwingConstants.LEFT);
		hall_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hall_name.setBounds(10, 71, 91, 20);
		panel_fun_reg.add(hall_name);
		
		
		
		
		
		combo_hall.setBounds(162, 73, 140, 21);
		panel_fun_reg.add(combo_hall);
		
		JButton clear_fun = new JButton("Clear");
		clear_fun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fun_cusID.setText("");
				combo_hall.setSelectedItem("");
				event_date.setDateFormatString("");
				event_type.setText("");
				date_reserved.setDateFormatString("");
				package_type.setSelectedItem("");
				package_price.setText("");
				guest_count.setText("");
				
			}
			
		});
		clear_fun.setBounds(217, 489, 85, 21);
		panel_fun_reg.add(clear_fun);
		
		JButton fun_delete = new JButton("Delete");
		fun_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_fun.getSelectedRow();
			     DefaultTableModel model2 = (DefaultTableModel) table_fun.getModel();
			     String customer_id =(model2.getValueAt(selectedRow, 0).toString());
			     
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					String query = "DELETE  FROM hallbooking WHERE cid = "+customer_id;
					PreparedStatement pst = connection.prepareStatement(query);
					int rs = pst.executeUpdate(query);		  
					
					if (rs == 0) {
			             JOptionPane.showMessageDialog(fun_delete, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(fun_delete,"Customer details successfully updated");
			         }
			         connection.close();
                  
					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
			}
		});
		fun_delete.setBounds(35, 489, 85, 21);
		panel_fun_reg.add(fun_delete);
		
		
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Function Details");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2_1.setBackground(Color.RED);
		lblNewLabel_2_2_1.setBounds(605, 10, 291, 36);
		function_reg.add(lblNewLabel_2_2_1);
		
		JButton fun_loader = new JButton("Dispaly Function Details");
		fun_loader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					 String query = "select * from hallbooking";
	                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
	                    
	                    ResultSet rs = st.executeQuery();
	                   
	                    table_fun.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	                    
	                    st.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fun_loader.setBounds(825, 73, 192, 21);
		function_reg.add(fun_loader);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(414, 150, 629, 293);
		function_reg.add(scrollPane_1);
		
		table_fun = new JTable();
		table_fun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row1 = table_fun.getSelectedRow();
					DefaultTableModel model2 = (DefaultTableModel) table_fun.getModel(); 
					
					//txt_cid.setText(model2.getValueAt(row1, 0).toString());
					invo_cid.setText(model2.getValueAt(row1, 0).toString());
					
					//txt_hallname.setText(model2.getValueAt(row1, 1).toString());
					invo_hallname.setText(model2.getValueAt(row1, 1).toString());
					
					
					//txt_p_price.setText(model2.getValueAt(row1, 6).toString());
					txt_invo_pprice.setText(model2.getValueAt(row1, 6).toString());
					
					//txt_g_count.setText(model2.getValueAt(row1, 7).toString());
					txt_invo_gcount.setText(model2.getValueAt(row1, 7).toString());
					
					
					fun_cusID.setText(model2.getValueAt(row1, 0).toString());
					combo_hall.setSelectedItem(model2.getValueAt(row1, 1).toString());
					Date date = (Date) model2.getValueAt(row1, 2);
	            	event_date.setDate(date);
	            	event_type.setText(model2.getValueAt(row1, 3).toString());
	            	Date date2 = (Date) model2.getValueAt(row1, 4);
	            	date_reserved.setDate(date2);
	            	package_type.setSelectedItem(model2.getValueAt(row1, 5).toString());
	            	package_price.setText(model2.getValueAt(row1, 6).toString());
	            	guest_count.setText(model2.getValueAt(row1, 7).toString());
	            	
					
					
					
					
					String cusID =(table_fun.getModel().getValueAt(row1, 0).toString());
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String query = "select * from hallbooking where cid='"+cusID+"'";
					PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
		             
		             ResultSet rs = st.executeQuery();
		             
		             while(rs.next()) {
		            	 
		            	 fun_cusID.setText(rs.getString("cid"));
		            	 combo_hall.setSelectedItem("hallname");
		            	 event_date.setDate(rs.getDate("EventDate"));
		            	 event_type.setText(rs.getString("Eventname"));
		            	 date_reserved.setDate(rs.getDate("Reservedate"));
		            	 package_type.setSelectedItem("packagetype");
		            	 package_price.setText(rs.getString("packageprice"));
		            	 guest_count.setText(rs.getString("guestcount"));
		            	 
		            	 
		            	 
		             }
					
					st.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		try {
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
			
			 String query = "select * from hallbooking";
             PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
             
             ResultSet rs = st.executeQuery();
            
             table_fun.setModel(DbUtils.resultSetToTableModel(rs));
             
             
             st.close();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model2 = new DefaultTableModel();
		Object[] column1 = {"cid","hallname","Eventdate","Eventname","Reservedate","packagetype","packageprice","guestcount"};
		final Object[] row1 = new Object[0];
		model2.setColumnIdentifiers(column1);
		table_fun.setModel(model2);
		
		
		
		table_fun.setBackground(Color.PINK);
		scrollPane_1.setViewportView(table_fun);
		
		JButton btn_invoice = new JButton("New Invoice");
		btn_invoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(invoice);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			
		});
		btn_invoice.setBounds(852, 486, 107, 21);
		function_reg.add(btn_invoice);
		
		txt_fun_search = new JTextField();
		txt_fun_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					
							 
			        String query = "select * from hallbooking where Eventname=?";
			        PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
			        st.setString(1, txt_fun_search.getText());
			        ResultSet rs = st.executeQuery();
			       
			        table_fun.setModel(DbUtils.resultSetToTableModel(rs));
			        
			        
			        st.close();
					
						
                    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		txt_fun_search.setToolTipText("");
		txt_fun_search.setColumns(10);
		txt_fun_search.setBounds(638, 74, 142, 20);
		function_reg.add(txt_fun_search);
		
		JLabel lblSearch_1 = new JLabel("Search");
		lblSearch_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearch_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearch_1.setBounds(546, 72, 68, 22);
		function_reg.add(lblSearch_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setBounds(371, 13, 2, 587);
		function_reg.add(separator_1_2);
		
		invoice = new JPanel();
		invoice.setBackground(Color.GRAY);
		layeredPane.add(invoice, "name_5031125236780000");
		invoice.setLayout(null);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Invoice");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2_2.setBackground(Color.RED);
		lblNewLabel_2_2_2.setBounds(49, 10, 291, 36);
		invoice.add(lblNewLabel_2_2_2);
		
		JPanel txt_fun_invoid = new JPanel();
		txt_fun_invoid.setBackground(Color.WHITE);
		txt_fun_invoid.setBounds(10, 56, 434, 534);
		invoice.add(txt_fun_invoid);
		txt_fun_invoid.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Cus ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 10, 70, 13);
		txt_fun_invoid.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hall Name");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 50, 70, 13);
		txt_fun_invoid.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Date");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(212, 10, 70, 13);
		txt_fun_invoid.add(lblNewLabel_3_2);
		
		invo_cid = new JTextField();
		invo_cid.setBounds(84, 9, 96, 19);
		txt_fun_invoid.add(invo_cid);
		invo_cid.setColumns(10);
		
		invo_hallname = new JTextField();
		invo_hallname.setColumns(10);
		invo_hallname.setBounds(84, 49, 96, 19);
		txt_fun_invoid.add(invo_hallname);
		
		JDateChooser invo_date = new JDateChooser();
		invo_date.setBounds(311, 10, 96, 19);
		txt_fun_invoid.add(invo_date);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(10, 99, 219, 138);
		txt_fun_invoid.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Package Price");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(10, 10, 93, 19);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Guest Count");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(10, 51, 93, 13);
		panel.add(lblNewLabel_3_1_2);
		
		txt_invo_pprice = new JTextField();
		txt_invo_pprice.setColumns(10);
		txt_invo_pprice.setBounds(113, 9, 96, 19);
		panel.add(txt_invo_pprice);
		
		txt_invo_gcount = new JTextField();
		txt_invo_gcount.setColumns(10);
		txt_invo_gcount.setBounds(113, 50, 96, 19);
		panel.add(txt_invo_gcount);
		
		JButton btn_sub_pcal = new JButton("Calculate");
		btn_sub_pcal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			double three = Double.parseDouble(txt_invo_pprice.getText());

				int four = Integer.parseInt(txt_invo_gcount.getText());
				Double d = new Double(four);
				
				String answer2 = String.valueOf(three*four);
				
				txt_sub_pcal.setText(answer2);
			}
		});
		btn_sub_pcal.setBounds(111, 93, 98, 21);
		panel.add(btn_sub_pcal);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Sub Total");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1.setBounds(20, 248, 70, 13);
		txt_fun_invoid.add(lblNewLabel_3_1_2_1);
		
		txt_sub_pcal = new JTextField();
		txt_sub_pcal.setColumns(10);
		txt_sub_pcal.setBounds(122, 247, 96, 19);
		txt_fun_invoid.add(txt_sub_pcal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 220, 220));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 270, 219, 138);
		txt_fun_invoid.add(panel_2);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Hall Rent");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(10, 10, 70, 13);
		panel_2.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Service Charge");
		lblNewLabel_3_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_2.setBounds(10, 51, 93, 18);
		panel_2.add(lblNewLabel_3_1_2_2);
		
		txt_invo_rent = new JTextField();
		txt_invo_rent.setColumns(10);
		txt_invo_rent.setBounds(113, 9, 96, 19);
		panel_2.add(txt_invo_rent);
		
		txt_invo_charge = new JTextField();
		txt_invo_charge.setColumns(10);
		txt_invo_charge.setBounds(113, 50, 96, 19);
		panel_2.add(txt_invo_charge);
		
		JButton btn_sub_hcal = new JButton("Calculate");
		btn_sub_hcal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double one  = Double.parseDouble(txt_invo_rent.getText());
				double two =  Double.parseDouble(txt_invo_charge.getText());
				
				String answer = String.valueOf(one+two);
				
				txt_sub_hcal.setText(answer);
			}
		});
		btn_sub_hcal.setBounds(111, 93, 98, 21);
		panel_2.add(btn_sub_hcal);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("Sub Total");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1_1.setBounds(20, 426, 70, 13);
		txt_fun_invoid.add(lblNewLabel_3_1_2_1_1);
		
		txt_sub_hcal = new JTextField();
		txt_sub_hcal.setColumns(10);
		txt_sub_hcal.setBounds(133, 418, 96, 19);
		txt_fun_invoid.add(txt_sub_hcal);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 449, 397, 2);
		txt_fun_invoid.add(separator_2);
		
		JButton btn_gtot = new JButton("Grand Tot");
		btn_gtot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*double three = Double.parseDouble(txt_invo_pprice.getText());

				int four = Integer.parseInt(txt_invo_gcount.getText());
				
				String answer2 = String.valueOf(three*four);
				
				txt_sub_pcal.setText(answer2);
				
				
				double one  =  Double.parseDouble(txt_invo_rent.getText());
				double two = Double.parseDouble(txt_invo_charge.getText());
				
				String answer = String.valueOf(one+two);
				
				txt_sub_hcal.setText(answer);*/
				
				double tot =  Double.parseDouble(txt_sub_hcal.getText());
				double tot2 =  Double.parseDouble(txt_sub_pcal.getText());
				
				String answerfinal = String.valueOf(tot+tot2);
				
				invo_grand.setText(answerfinal);
				
			}
		});
		btn_gtot.setBounds(289, 417, 98, 21);
		txt_fun_invoid.add(btn_gtot);
		
		JLabel lblNewLabel_3_1_2_1_1_1 = new JLabel("Grand Total");
		lblNewLabel_3_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1_1_1.setBounds(20, 461, 85, 19);
		txt_fun_invoid.add(lblNewLabel_3_1_2_1_1_1);
		
		 btn_invo_submit = new JButton("Submit");
		btn_invo_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int c_id= Integer.parseInt(invo_cid.getText());
				String hallname = invo_hallname.getText();
				
				String i_grand =invo_grand.getText();
				
				//double i_grand = Double.parseDouble(invo_grand.getText());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					
					String query = "INSERT INTO payment (paymentid,paymentdate,cid,Amount,hname) values (0,?,?,?,?)";
					
					
					PreparedStatement pst = connection.prepareStatement(query);
					
					SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY-MM-dd");
					String date3 = sdf3.format(invo_date.getDate());
					pst.setString(1, date3);
					
					pst.setInt(2,c_id);
					pst.setString(4, hallname);
					
					
					pst.setString(3,i_grand);
					
					
					
					
					int data = pst.executeUpdate();
					if(data>0)
					{
						JOptionPane.showMessageDialog(null, "Data added");
					}
					else {
						JOptionPane.showInternalMessageDialog(null, "can't insert data");
					}
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btn_invo_submit.setBounds(322, 503, 85, 21);
		txt_fun_invoid.add(btn_invo_submit);
		
		invo_grand = new JTextField();
		invo_grand.setColumns(10);
		invo_grand.setBounds(133, 463, 96, 19);
		txt_fun_invoid.add(invo_grand);
		
		
		
		JButton btn_invoice_loader = new JButton("Display Invoice Details");
		btn_invoice_loader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					 String query = "select * from payment";
	                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
	                    
	                    ResultSet rs = st.executeQuery();
	                   
	                    table_invo.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	                    
	                    st.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_invoice_loader.setBounds(844, 73, 177, 21);
		invoice.add(btn_invoice_loader);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(552, 155, 487, 216);
		invoice.add(scrollPane_2);
		
		table_invo = new JTable();
		scrollPane_2.setViewportView(table_invo);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.setBounds(948, 470, 85, 21);
		invoice.add(btnNewButton_3);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_1_3.setBounds(484, 10, 2, 587);
		invoice.add(separator_1_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					table_invo.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		menu = new JPanel();
		menu.setBackground(Color.GRAY);
		layeredPane.add(menu, "name_5031127059569500");
		menu.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Customer Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(27, 85, 147, 28);
		menu.add(lblNewLabel_4);
		
		JTextArea text_choice = new JTextArea();
		text_choice.setForeground(Color.BLACK);
		text_choice.setBackground(Color.WHITE);
		text_choice.setBounds(217, 262, 186, 128);
		menu.add(text_choice);
		
		menuCus = new JTextField();
		menuCus.setBounds(217, 88, 159, 28);
		menu.add(menuCus);
		menuCus.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Function Date");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(27, 144, 147, 28);
		menu.add(lblNewLabel_4_1);
		
		JDateChooser menuFun = new JDateChooser();
		menuFun.setBounds(220, 144, 156, 28);
		menu.add(menuFun);
		
		JComboBox combo_pack = new JComboBox(new Object[]{"Amythest","Sapphire","Ruby"});
		combo_pack.setBounds(222, 202, 154, 28);
		menu.add(combo_pack);
		
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Package Type");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(27, 202, 147, 28);
		menu.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Customer Choices");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1.setBounds(27, 297, 147, 28);
		menu.add(lblNewLabel_4_1_1_1);
		
		JTextArea txtReceipt = new JTextArea();
		txtReceipt.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtReceipt.setBackground(SystemColor.control);
		txtReceipt.setBounds(478, 56, 562, 405);
		menu.add(txtReceipt);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Menu Details");
		lblNewLabel_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2_2_1.setBackground(Color.RED);
		lblNewLabel_2_2_2_1.setBounds(401, 10, 291, 36);
		menu.add(lblNewLabel_2_2_2_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("For Royal Resort Office");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(27, 471, 172, 28);
		menu.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Operator Name");
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1_1_2.setBounds(27, 509, 147, 28);
		menu.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1_3 = new JLabel("Date");
		lblNewLabel_4_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1_1_3.setBounds(27, 562, 147, 28);
		menu.add(lblNewLabel_4_1_1_3);
		
		menuOP = new JTextField();
		menuOP.setColumns(10);
		menuOP.setBounds(184, 509, 159, 28);
		menu.add(menuOP);
		
		JDateChooser opdate = new JDateChooser();
		opdate.setBounds(184, 562, 156, 28);
		menu.add(opdate);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("For Royal Resort Office");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2_1.setBounds(638, 471, 172, 28);
		menu.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("Customer Signature");
		lblNewLabel_4_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1_1_2_1.setBounds(448, 509, 147, 28);
		menu.add(lblNewLabel_4_1_1_2_1);
		
		JLabel lblNewLabel_4_1_1_3_1 = new JLabel("Date");
		lblNewLabel_4_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1_1_3_1.setBounds(448, 562, 147, 28);
		menu.add(lblNewLabel_4_1_1_3_1);
		
		JDateChooser cusdate = new JDateChooser();
		cusdate.setBounds(628, 562, 156, 28);
		menu.add(cusdate);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(627, 535, 183, 2);
		menu.add(separator_3);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					txtReceipt.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(936, 553, 85, 21);
		menu.add(btnNewButton);
		
		JButton btn_record = new JButton("Add Record");
		btn_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String date = sdf.format(menuFun.getDate());
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
				String date1 = sdf.format(opdate.getDate());
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd");
				String date2 = sdf.format(cusdate.getDate());
				
				
				
				txtReceipt.append("Customer Name:\t"+menuCus.getText() + "\n\n" +"Function Date:\t" +menuFun.getDate() + "\n\n" + "Package Type:\t"+combo_pack.getSelectedItem() + "\n\n" + "Customer Choices:\n"+text_choice.getText()+
						"\n================================================================\n"+"For Royal Resort Office\n"+"Operator's Name:\t"+menuOP.getText()+"\n"+"Date:\t"+opdate.getDate()+"\n\n" 
						+"For Customer\n"+"Customer Sidnature:____________\n"+"Date:\t"+cusdate.getDate());
				
			}
		});
		btn_record.setBounds(936, 509, 85, 21);
		menu.add(btn_record);
		
		
		report = new JPanel();
		report.setBackground(Color.GRAY);
		layeredPane.add(report, "name_5031129366377800");
		report.setLayout(null);
		
		JLabel lblNewLabel_2_2_2_1_1 = new JLabel("Report");
		lblNewLabel_2_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2_2_1_1.setBackground(Color.RED);
		lblNewLabel_2_2_2_1_1.setBounds(384, 27, 291, 36);
		report.add(lblNewLabel_2_2_2_1_1);
		
		JTextArea txtReport = new JTextArea();
		txtReport.setFont(new Font("NSimSun", Font.PLAIN, 18));
		txtReport.setBackground(Color.WHITE);
		txtReport.setText("");
		txtReport.setBounds(180, 73, 724, 419);
		report.add(txtReport);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtReport.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(733, 532, 123, 26);
		report.add(btnNewButton_1);
		
		JButton btn_repo = new JButton("Generate Report");
		btn_repo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String date = sdf.format(event_date.getDate());
				
				txtReport.append("\t\t\t Event Summery \t\t\t"+"\n\n"+"Customer Name: \t"+firstName.getText()+"\n"+"Hall Type: \t"+ combo_hall.getSelectedItem()+"\n"+"Function Date: \t"+event_date.getDate()+"\n"+"Function Type: \t"+event_type.getText()+"\n"+"Package Type: \t"+package_type.getSelectedItem()+"\n"
						+"Package Price: \t"+ package_price.getText()+"\n"+"Guest Count: \t"+guest_count.getText()+"\n"+"Grand Total: \t"+invo_grand.getText()+"\n");
			}
		});
		btn_repo.setBounds(207, 532, 199, 26);
		report.add(btn_repo);
		
		JButton btn_rep_clear = new JButton("Clear");
		btn_rep_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*firstName.setText(null);
				combo_hall.setSelectedItem(null);
				event_date.setDateFormatString(null);
				event_type.setText(null);
				package_type.setSelectedItem(null);
				package_price.setText(null);
				guest_count.setText(null);
				invo_grand.setText(null);*/
				txtReport.setText(null);
				
				
				
				
			}
		});
		btn_rep_clear.setBounds(505, 532, 123, 26);
		report.add(btn_rep_clear);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		 lblNewLabel_1.setIcon(new ImageIcon("E:\\ITP\\Pics\\resthouse125-removebg-preview.png"));
		lblNewLabel_1.setBounds(33, 13, 143, 91);
		contentPane.add(lblNewLabel_1);
		
		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 dispose();
                 Login ah = new Login();
                 ah.setTitle("Welcome");
                 ah.setVisible(true);
                 JOptionPane.showMessageDialog(btnlogout, "logging out");
			}
		});
		//btnlogout.setBackground(Color.LIGHT_GRAY);
		btnlogout.setBounds(1127, 58, 97, 25);
		contentPane.add(btnlogout);
	}
}
