package Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.bea.xml.stream.samples.Parse;

import java.awt.TextField;
import java.awt.Window;

import com.toedter.calendar.JDateChooser;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.components.JLocaleChooser;


public class hotel1 extends JFrame {

	static String pass;
	private JTextField Firstname;
	private JTextField email;
	private JTextField Lastname;
	private JTextField nic;
	private JTextField phone;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hotel1 frame = new hotel1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField textFieldsearch;
	private JTextField cid;
	private JTextField rn;
	private JTextField booktxt;
	private JTable table_1;
	private JTextField cusid;
	private JTable table_2;
	private JTextField cussid;
	private JTextField tottxt;
	private JTextField name;
	private JTextField meal1;
	private JTextField rom;
	private JTable table_3;
	private JTable table_4;
	private JTextField txtsearch;
	private JTable table_5;
	private JTextField txtmeal;
	private JTextField txtroomno;
	private JTextField txtamount;

	/**
	 * Create the frame.
	 */
	public hotel1() {
		//connection=sqlliteconnection.dbconnnector();
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1610, 882);
		JPanel roomt = new JPanel();
		roomt.setBackground(new Color(0, 30, 46));
		roomt.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(roomt);
		roomt.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Royal Resort");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(343, 10, 659, 94);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		roomt.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 128, 1540, 1);
		separator.setForeground(Color.BLACK);
		roomt.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(hotel1.class.getResource("/Final/resthouse125-removebg-preview.png")));
		lblNewLabel_1.setBounds(33, 13, 125, 105);
	
		roomt.add(lblNewLabel_1);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                Login ah = new Login();
                ah.setTitle("Welcome");
                ah.setVisible(true);
                JOptionPane.showMessageDialog(btnLogout, "logging out");
			}
		});
		btnLogout.setBounds(1420, 39, 97, 25);
		roomt.add(btnLogout);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(180, 128, 9, 717);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		roomt.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Receptionist");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(0, 163, 170, 40);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		roomt.add(lblNewLabel_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(190, 139, 1340, 696);
		roomt.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel consumepanel = new JPanel();
		consumepanel.setBackground(SystemColor.controlShadow);
		layeredPane.add(consumepanel, "name_3940546907300");
		consumepanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(23, 10, 450, 676);
		consumepanel.add(panel);
		panel.setLayout(null);
		
		Firstname = new JTextField();
		Firstname.setBounds(43, 100, 371, 33);
		panel.add(Firstname);
		Firstname.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(43, 266, 371, 33);
		panel.add(email);
		
		Lastname = new JTextField();
		Lastname.setColumns(10);
		Lastname.setBounds(43, 177, 371, 33);
		panel.add(Lastname);
		
		nic = new JTextField();
		nic.setColumns(10);
		nic.setBounds(43, 446, 371, 33);
		panel.add(nic);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Registration");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel_3.setBounds(78, 0, 296, 65);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FirstName");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(43, 57, 124, 33);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Email");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1.setBounds(43, 223, 124, 33);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("LastName");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_1.setBounds(43, 134, 124, 33);
		panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("NIC/Passport number");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_2.setBounds(32, 403, 213, 33);
		panel.add(lblNewLabel_4_1_2);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(43, 521, 371, 33);
		panel.add(phone);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Phone number");
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_2_1.setBounds(32, 489, 213, 33);
		panel.add(lblNewLabel_4_1_2_1);
		
		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("Nationality");
		lblNewLabel_4_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_2_1_1.setBounds(34, 309, 95, 33);
		panel.add(lblNewLabel_4_1_2_1_1);
		
		JRadioButton rtsrilankan = new JRadioButton("Sri lankan");
		rtsrilankan.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rtsrilankan.setBounds(43, 348, 152, 37);
		panel.add(rtsrilankan);
		
		JRadioButton rtnonsrilankan = new JRadioButton("Non Sri lankan");
		rtnonsrilankan.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rtnonsrilankan.setBounds(229, 348, 185, 37);
		panel.add(rtnonsrilankan);
		
		JLabel val2 = new JLabel("");
		val2.setBounds(102, 613, 272, 33);
		panel.add(val2);
		
		JButton save = new JButton("save");
		save.setFont(new Font("Tahoma", Font.PLAIN, 21));
		save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName1 = Firstname.getText();
                String lastName1 = Lastname.getText();
                String emailId = email.getText();
                String nation = null;
                if(rtsrilankan.isSelected()) 
                    nation="Srilankan";
                else {
                        nation="Non srilankan";
                }
                String nic1=nic.getText();
                String phone1=phone.getText();
                
               if(firstName1.isEmpty())
               {
            	   JOptionPane.showMessageDialog(null,"Enter the firstname");
               }
               else if(lastName1.isEmpty())
               {
            	   JOptionPane.showMessageDialog(null,"Enter the Lastname");
               }
               else if(emailId.isEmpty())
               {
            	   JOptionPane.showMessageDialog(null,"Enter the email");
               }
              
               else if(!emailId.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"))
               {
            	   JOptionPane.showMessageDialog(null,"Invalid email address");
               }
              
               else if(nic1.isEmpty())
               {
            	   JOptionPane.showMessageDialog(null,"Enter the Nic/passportnumber");
               }
               else if(!nic1.matches("[0-9]{9}[Vv]"))
               {
            	   JOptionPane.showMessageDialog(null,"Invalid NIC");
               }
               else if(phone1.isEmpty())
               {
            	   JOptionPane.showMessageDialog(null,"Enter the phonenumber");
               }
              
               else if(!phone1.matches("[0-9]{10}"))
               {
            	   JOptionPane.showMessageDialog(null,"Invalid phone number");
               }
               
               else {


                try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

                    String query = "INSERT INTO customer (fname,lname,Email,nationality,NICpassport,phone) values('" + firstName1 + "','" + lastName1 + "','" + emailId  + "','" +
                    		 nation + "','" + nic1+ "','" + phone1 + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(save, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(save,
                           "New customer has sucessfully added");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
               
             
            
              
               
            }
        });
		
		save.setBounds(17, 613, 112, 33);
		panel.add(save);
		
		JButton update = new JButton("update");
		update.setFont(new Font("Tahoma", Font.PLAIN, 21));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName1 = Firstname.getText();
                String lastName1 = Lastname.getText();
                String emailId = email.getText();
                String nation = null;
                if(rtsrilankan.isSelected()) 
                    nation="Srilankan";
                else if(rtnonsrilankan.isSelected()) 
                        nation="Non srilankan";

                String nic1=nic.getText();
                String phone1=phone.getText();
                
                String driverName="com.mysql.cj.jdbc.Driver";
                
                int selectedRow=table.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) table.getModel();
                
                  String id=(model.getValueAt(selectedRow, 0).toString());


                try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                  
               
                  
					    String query = "UPDATE customer set fname='"+ Firstname.getText()+"' ,lname='"+lastName1+"' ,Email='"+emailId+"' , nationality='"
					   +nation+"' ,NICpassport='"+ nic1+"' ,phone='"+phone1+"' where customerid= "+id;
					    
                    	 
                    		

                    PreparedStatement pst = connection.prepareStatement(query);
                   
                   
                 int x=pst.executeUpdate(query);
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(update, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(update,
                           "Custoemer row is updated");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }


			}
	        
		});	
		
		update.setBounds(147, 613, 124, 33);
		panel.add(update);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
                String driverName="com.mysql.cj.jdbc.Driver";
                
                int selectedRow=table.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) table.getModel();
                
                  String id=(model.getValueAt(selectedRow, 0).toString());
            

                try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                  
               
                  
					    String query = "Delete from customer where customerid= "+id;
					    
                    	 
                    		

                    PreparedStatement pst = connection.prepareStatement(query);
                   
                   
                 int x=pst.executeUpdate(query);
                    
                    if (x == 0) {
                        JOptionPane.showMessageDialog(update, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(update, "Custoemer row is Deleted");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }


			}
	        
		});	
		
			
		
		btnDelete.setBounds(296, 609, 130, 37);
		panel.add(btnDelete);
		
		
		
		
		
		
		
		JButton load = new JButton("LOAD CUSTOMER DETAILS");
		load.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

					String query="select*from customer";
					PreparedStatement pt=connection.prepareStatement(query);
					ResultSet rs=pt.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));

					
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		load.setBounds(998, 147, 320, 35);
		consumepanel.add(load);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		scrollPane.setBounds(508, 205, 822, 329);
		consumepanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				Firstname.setText(model.getValueAt(i,1).toString());
				booktxt.setText(model.getValueAt(i,0).toString());
				cid.setText(model.getValueAt(i,0).toString());
				Lastname.setText(model.getValueAt(i,2).toString());
				email.setText(model.getValueAt(i,3).toString());
				String nation=model.getValueAt(i,4).toString();
				if(nation.equals("Srilankan"))
				{
					rtsrilankan.setSelected(true);
				}
				else
				{
					rtnonsrilankan.setSelected(true);
				}
				nic.setText(model.getValueAt(i,5).toString());
				phone.setText(model.getValueAt(i,6).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("Search");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_6.setBounds(546, 80, 134, 43);
		consumepanel.add(lblNewLabel_6);
		
		textFieldsearch = new JTextField();
		textFieldsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(tr);
				tr.setRowFilter(javax.swing.RowFilter.regexFilter(textFieldsearch.getText().trim()));
			}
			
		});
		textFieldsearch.setBounds(637, 81, 371, 42);
		consumepanel.add(textFieldsearch);
		textFieldsearch.setColumns(10);
		
		
		
		booktxt =new JTextField();
		booktxt.setBounds(658, 554, 263, 39);
		consumepanel.add(booktxt);
		
		booktxt.setColumns(10);
		 pass=booktxt.getText();
		
		

		 
		
		JPanel transferpanel = new JPanel();
		transferpanel.setBackground(SystemColor.controlShadow);
		layeredPane.add(transferpanel, "name_3945491518600");
		transferpanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(51, 40, 450, 676);
		transferpanel.add(panel_1);
		
		cid = new JTextField();
		cid.setColumns(10);
		cid.setBounds(43, 111, 371, 33);
		panel_1.add(cid);
		cid.setText(pass);
		
		JLabel Booking = new JLabel("BOOKING INFORMATION");
		Booking.setFont(new Font("Times New Roman", Font.BOLD, 29));
		Booking.setBounds(38, 10, 376, 66);
		panel_1.add(Booking);
		
		JLabel Customerid = new JLabel("Customerid");
		Customerid.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Customerid.setBounds(32, 68, 124, 33);
		panel_1.add(Customerid);
		
		JLabel lblNewLabel_4_1_2_2 = new JLabel("Checkoutdate");
		lblNewLabel_4_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_2_2.setBounds(38, 419, 213, 33);
		panel_1.add(lblNewLabel_4_1_2_2);
		
		JLabel lblNewLabel_4_1_2_1_1_1 = new JLabel("Checkindate");
		lblNewLabel_4_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4_1_2_1_1_1.setBounds(38, 338, 213, 33);
		panel_1.add(lblNewLabel_4_1_2_1_1_1);
		
		
		JDateChooser datechooser = new JDateChooser();
		datechooser.setBounds(43, 381, 355, 28);
		panel_1.add(datechooser);
		
		JDateChooser datechooser1 = new JDateChooser();
		datechooser1.setBounds(43, 462, 355, 28);
		panel_1.add(datechooser1);
		
		JComboBox rr = new JComboBox();
		rr.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		rr.setModel(new DefaultComboBoxModel(new String[] {"single", "Deluxe", "Quad"}));
		rr.setBounds(43, 208, 371, 28);
		panel_1.add(rr);
	
		

		JComboBox meal = new JComboBox();
		meal.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		meal.setModel(new DefaultComboBoxModel(new String[] {"Fullboard", "Halfboard", "BB"}));
		meal.setBounds(43, 300, 371, 28);
		panel_1.add(meal);
		
		JButton save_1 = new JButton("save");
		save_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		save_1.addActionListener(new ActionListener() {
		

		

			
			

			

			private JComboBox roomtype;

			public void actionPerformed(ActionEvent e) {
				 String roomtype1=(String)rr.getSelectedItem();
				 String meal1=(String)meal.getSelectedItem();
	               
	               
	                String room1=rn.getText();
	                String cid1=cid.getText();
	                int c=Integer.parseInt(cid1);
	               int rno=Integer.parseInt(room1);
	              
	                
	               
	               

	                try {
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
	                    String driverName="com.mysql.cj.jdbc.Driver";
	                    String insert_data= "INSERT INTO booking (checkindate,checkoutdate,rno,mid,cid) values (?,?,?,(select mealid from mealplan where mealname=?),?)";

	                    PreparedStatement preparedstatment= connection.prepareStatement(insert_data);
	                    
	                    SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
	                    String date=sdf.format(datechooser.getDate());
	                    preparedstatment.setString(1,date);
	                    SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
	                    String date1=sdf1.format(datechooser1.getDate());
	                    preparedstatment.setString(2,date1);
	                   
	                    preparedstatment.setInt(3,rno);
	                    preparedstatment.setString(4,meal1);
	                    preparedstatment.setInt(5,c);
	                  
	                    
	                 int data=preparedstatment.executeUpdate();
	                   if(data>0)
	                   {
	                	   JOptionPane.showMessageDialog(null,"Data successfully inserted");
	                	  
	                   }
	                   else {
	                	   JOptionPane.showMessageDialog(null,"unable to insert data");
	                   }
	                    
	                    
	                } catch (SQLException exception) {
	                    exception.printStackTrace();
	                }
			}
			
		});
		save_1.setBounds(43, 585, 94, 33);
		panel_1.add(save_1);
		
		JButton update_1 = new JButton("update");
		update_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		update_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String room1=rn.getText();
               
               int rno=Integer.parseInt(room1);
               
               SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
               String date1=sdf1.format(datechooser1.getDate());
               String driverName="com.mysql.cj.jdbc.Driver";
               
               int selectedRow=table_1.getSelectedRow();
               DefaultTableModel model=(DefaultTableModel) table_1.getModel();
               
                 String id=(model.getValueAt(selectedRow,0).toString());


               try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                 
              
                 
					   

					    String query = "UPDATE booking set rno='"+rno+"' ,checkoutdate='"+date1+"' where bookingid= "+id;
	                   	
					 	

                   PreparedStatement pst = connection.prepareStatement(query);
                  
                  
                int x=pst.executeUpdate(query);
                   
                   if (x == 0) {
                       JOptionPane.showMessageDialog(update, "This is alredy exist");
                   } else {
                       JOptionPane.showMessageDialog(update,
                          "Custoemer row is updated");
                   }
                   connection.close();
               } catch (Exception exception) {
                   exception.printStackTrace();
               }

			}
		});
		update_1.setBounds(171, 585, 112, 33);
		panel_1.add(update_1);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String driverName="com.mysql.cj.jdbc.Driver";
	                
	                int selectedRow=table_1.getSelectedRow();
	                DefaultTableModel model=(DefaultTableModel) table_1.getModel();
	                
	                  String id=(model.getValueAt(selectedRow, 0).toString());


	                try {
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
	                  
	               
	                  
						    String query = "Delete from booking where bookingid= "+id;
						    
	                    	 
	                    		

	                    PreparedStatement pst = connection.prepareStatement(query);
	                   
	                   
	                 int x=pst.executeUpdate(query);
	                    
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(update, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(update, "Booking row is Deleted");
	                    }
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
			}
		});
		btnDelete_1.setBounds(306, 585, 108, 33);
		panel_1.add(btnDelete_1);
		
		JLabel roomtype_1 = new JLabel("Room type");
		roomtype_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		roomtype_1.setBounds(46, 154, 124, 33);
		panel_1.add(roomtype_1);
		
		JLabel lblMealPlan = new JLabel("Meal plan");
		lblMealPlan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMealPlan.setBounds(32, 257, 124, 33);
		panel_1.add(lblMealPlan);
		
		rn = new JTextField();
		rn.setColumns(10);
		rn.setBounds(43, 533, 355, 28);
		panel_1.add(rn);
		
		JLabel roomno = new JLabel("roomno");
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 19));
		roomno.setBounds(32, 490, 213, 33);
		panel_1.add(roomno);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(541, 293, 789, 301);
		transferpanel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				TableModel model=table_1.getModel();
				 cusid.setText(model.getValueAt(i,7).toString());
				rn.setText(model.getValueAt(i,3).toString());
				cid.setText(model.getValueAt(i,7).toString());
				rr.setSelectedItem(model.getValueAt(i, 4).toString());
				meal.setSelectedItem(model.getValueAt(i, 6).toString());
				
				Date date=(Date) model.getValueAt(i,1);
				datechooser.setDate(date);
			
					Date date1=(Date) model.getValueAt(i,2);
					datechooser1.setDate(date1);
				
				}

			
		
			});
	
		scrollPane_1.setViewportView(table_1);
		
		JLocaleChooser localeChooser = new JLocaleChooser();
		scrollPane_1.setColumnHeaderView(localeChooser);
		
		JButton load_1 = new JButton("LOAD BOOKING DETAILS");
		load_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		load_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

					String query="select bookingid,checkindate,checkoutdate,rno,roomtype,mealid,mealname,cid from booking b,room r,mealplan m where m.mealid=b.mid AND r.roomno=b.rno";
					PreparedStatement pt=connection.prepareStatement(query);
					ResultSet rs=pt.executeQuery();
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					

					
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
			
		load_1.setBounds(998, 221, 342, 32);
		transferpanel.add(load_1);
		
		cusid = new JTextField();
		cusid.setBounds(790, 617, 212, 32);
		transferpanel.add(cusid);
		cusid.setColumns(10);
		
		
		
		
		
		
		
		
		JPanel permanentpanel = new JPanel();
		permanentpanel.setBackground(SystemColor.controlShadow);
		layeredPane.add(permanentpanel, "name_3949065056600");
		permanentpanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
			
	
		scrollPane_2.setBounds(67, 56, 1050, 169);
		permanentpanel.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setBackground(new Color(240, 248, 255));
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_2.getSelectedRow();
				TableModel model=table_2.getModel();
			
				cussid.setText(model.getValueAt(i,0).toString());
				
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JButton load_2 = new JButton("LOAD PAYMENT DETAILS");
		load_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		load_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

					String query="select cid,bookingid,checkindate,checkoutdate,(checkoutdate-checkindate) as Noofdays,rno,roomprice,Mid,price,(checkoutdate-checkindate)*roomprice+(checkoutdate-checkindate)*price as subtotal  from booking b,room r,mealplan m where r.roomno=b.rno and m.mealid=b.Mid";
					PreparedStatement pt=connection.prepareStatement(query);
					ResultSet rs=pt.executeQuery();
					
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					

					
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
			
		});
		load_2.setBounds(1062, 10, 268, 36);
		permanentpanel.add(load_2);
		
		JButton tot = new JButton("Calculate total payment");
		tot.setForeground(new Color(176, 196, 222));
		tot.setFont(new Font("Tahoma", Font.PLAIN, 22));
		tot.setBackground(new Color(255, 255, 255));
		tot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	              

	               try {
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
	   				 String id=cussid.getText();
						   
						  
	                   PreparedStatement pt=connection.prepareStatement("select sum(price*(checkoutdate-checkindate))from booking b,mealplan m where m.mealid=b.Mid and  cid="+id);
	                  
						ResultSet rs=pt.executeQuery();
						if(rs.next()) {
						String tot=rs.getString("sum(price*(checkoutdate-checkindate))");
						meal1.setText(tot);
						
						PreparedStatement pt1=connection.prepareStatement("select sum(roomprice*(checkoutdate-checkindate)) from room r,booking b where r.roomno=b.rno and  cid="+id);
						ResultSet rs1=pt1.executeQuery();
						if(rs1.next()) {
						String tot1=rs1.getString("sum(roomprice*(checkoutdate-checkindate))");
						rom.setText(tot1);
						
						
						PreparedStatement pt2=connection.prepareStatement("select c.fname from customer c,booking b where c.customerid=b.cid and cid="+id);
						ResultSet rs2=pt2.executeQuery();
						if(rs2.next()) {
						String tot2=rs2.getString("c.fname");
						name.setText(tot2);
						
						
						
						double i=Double.parseDouble(tot);
						double y=Double.parseDouble(tot1);
						
						double x=i+y;
						String s=Double.toString(x);
						
						tottxt.setText(s);
						}
						}
						
						}
	               } catch (Exception exception) {
	                   exception.printStackTrace();
	               }
				
			}
		});
		tot.setBounds(290, 235, 343, 35);
		permanentpanel.add(tot);
		
		cussid = new JTextField();
		cussid.setBounds(77, 235, 192, 35);
		permanentpanel.add(cussid);
		cussid.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(51, 290, 597, 396);
		permanentpanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel cusname = new JLabel("Customer Name");
		cusname.setFont(new Font("Tahoma", Font.PLAIN, 21));
		cusname.setBounds(48, 23, 208, 40);
		panel_2.add(cusname);
		
		JLabel mealprice = new JLabel("Totalmealprice");
		mealprice.setFont(new Font("Tahoma", Font.PLAIN, 21));
		mealprice.setBounds(43, 135, 168, 34);
		panel_2.add(mealprice);
		
		JLabel lblTotalroomrent = new JLabel("TotalRoomRent");
		lblTotalroomrent.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblTotalroomrent.setBounds(41, 191, 190, 34);
		panel_2.add(lblTotalroomrent);
		
		JLabel mealprice_1_1 = new JLabel("TotalAmount");
		mealprice_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		mealprice_1_1.setBounds(52, 258, 131, 34);
		panel_2.add(mealprice_1_1);
		
		name = new JTextField();
		name.setBounds(266, 31, 240, 34);
		panel_2.add(name);
		name.setColumns(10);
		
		meal1 = new JTextField();
		meal1.setColumns(10);
		meal1.setBounds(266, 140, 240, 34);
		panel_2.add(meal1);
		
		rom = new JTextField();
		rom.setColumns(10);
		rom.setBounds(266, 196, 240, 34);
		panel_2.add(rom);
		
		tottxt = new JTextField();
		tottxt.setBounds(266, 263, 240, 34);
		panel_2.add(tottxt);
		tottxt.setColumns(10);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(266, 85, 240, 34);
		panel_2.add(date1);
		
		
		JButton Save5 = new JButton("Save");
		Save5.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Save5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cusid=cussid.getText();
				 String tot=tottxt.getText();
	               
	               
	            
	               
	               

	                try {
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
	                    String driverName="com.mysql.cj.jdbc.Driver";
	                    String insert_data= "INSERT INTO payment (paymentdate,cid,totalamount) values (?,?,?)";

	                    PreparedStatement preparedstatment= connection.prepareStatement(insert_data);
	                    
	                    SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
	                    String date2=sdf.format(date1.getDate());
	                    preparedstatment.setString(1,date2);
	                    
	                    preparedstatment.setString(2, cusid);
	                    preparedstatment.setString(3, tot);
	                   
	                   
	                    
	                 int data=preparedstatment.executeUpdate();
	                   if(data>0)
	                   {
	                	   JOptionPane.showMessageDialog(null,"Data successfully inserted");
	                	  
	                   }
	                   else {
	                	   JOptionPane.showMessageDialog(null,"unable to insert data");
	                   }
	                    
	                    
	                } catch (SQLException exception) {
	                    exception.printStackTrace();
	                }
			}
			
		});
		Save5.setBounds(48, 326, 175, 32);
		panel_2.add(Save5);
		
		
		JLabel Date = new JLabel("Date");
		Date.setFont(new Font("Tahoma", Font.PLAIN, 21));
		Date.setBounds(48, 85, 183, 34);
		panel_2.add(Date);
		
		JButton btnPrint = new JButton("print");
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnPrint.setBounds(313, 326, 175, 32);
		panel_2.add(btnPrint);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(667, 301, 615, 286);
		permanentpanel.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		JButton paybutton = new JButton("payment");
		paybutton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		paybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

					String query="select paymentid,paymentdate,cid,totalamount from payment";
					PreparedStatement pt=connection.prepareStatement(query);
					ResultSet rs=pt.executeQuery();
					
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
					

					
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
			}
		});
		paybutton.setBounds(1169, 242, 133, 45);
		permanentpanel.add(paybutton);
		
		JPanel reportpanel = new JPanel();
		reportpanel.setBackground(SystemColor.controlShadow);
		layeredPane.add(reportpanel, "name_3952687485400");
		reportpanel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(68, 64, 497, 520);
		reportpanel.add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton rdbtntoday = new JRadioButton("Check in today");
		rdbtntoday.setBackground(Color.LIGHT_GRAY);
		rdbtntoday.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtntoday.setBounds(128, 149, 243, 41);
		panel_3.add(rdbtntoday);
		
		JRadioButton rdbtnCheckInFrom = new JRadioButton("Check in from");
		rdbtnCheckInFrom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		rdbtnCheckInFrom.setBackground(Color.LIGHT_GRAY);
		rdbtnCheckInFrom.setBounds(128, 248, 243, 41);
		panel_3.add(rdbtnCheckInFrom);
		
		JDateChooser start = new JDateChooser();
		start.setBounds(30, 339, 169, 40);
		panel_3.add(start);
		
		JDateChooser end = new JDateChooser();
		end.setBounds(288, 339, 158, 40);
		panel_3.add(end);
		
		JLabel lblNewLabel_7 = new JLabel("To");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(232, 339, 40, 40);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CHECK IN PREVIEW");
		lblNewLabel_8.setBackground(Color.GRAY);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_8.setBounds(0, 0, 497, 41);
		panel_3.add(lblNewLabel_8);
		
		
		JButton Generate = new JButton("Generate");
		Generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					  
					if(rdbtntoday.isSelected())
					{
						String query="select bookingid,checkindate,checkoutdate,mealname,price,roomno,roomtype,roomprice from booking b,mealplan m,room r where b.rno=r.roomno and b.Mid=m.mealid and checkindate=current_date()";
						PreparedStatement pt=connection.prepareStatement(query);
						ResultSet rs=pt.executeQuery();
						
						table_5.setModel(DbUtils.resultSetToTableModel(rs));
						
						  PreparedStatement pt1= connection.prepareStatement("select sum(price*(checkoutdate-checkindate)) from mealplan m,booking b where b.Mid=m.mealid and checkindate=current_date()");
						  ResultSet rst=pt1.executeQuery();
						  
							if(rst.next())
							{
								String mealprice=rst.getString("sum(price*(checkoutdate-checkindate))");
								txtmeal.setText(mealprice);
								
								  PreparedStatement pt2= connection.prepareStatement("select sum(roomprice*(checkoutdate-checkindate)) from room r,booking b where b.rno=r.roomno and checkindate=current_date()");
								  ResultSet rst1=pt2.executeQuery();
								  
									if(rst1.next())
									{
										String room=rst1.getString("sum(roomprice*(checkoutdate-checkindate))");
										txtroomno.setText(room);
										
										double i=Double.parseDouble(mealprice);
										double y=Double.parseDouble(room);
										double ans=i+y;
										String s1=Double.toString(ans);
										txtamount.setText(s1);
										
									}
							}
							  
							

						
								  
						  
					
					}
					else if( rdbtnCheckInFrom.isSelected())
					{
						   
	                    SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
	                    String check1=sdf.format(start.getDate());
	                    
	                    SimpleDateFormat sdf1=new SimpleDateFormat("YYYY-MM-dd");
	                    String date1=sdf1.format(end.getDate());
	                    
	                    String query="select bookingid,checkindate,checkoutdate,mealname,price,roomno,roomtype,roomprice from booking b,mealplan m,room r where b.rno=r.roomno and b.Mid=m.mealid and checkindate between ? and ? ";
						PreparedStatement pt=connection.prepareStatement(query);
						
						pt.setString(1, check1);
						pt.setString(2, date1);
						ResultSet rs=pt.executeQuery();
						
						table_5.setModel(DbUtils.resultSetToTableModel(rs));
						
						

						  PreparedStatement pt1= connection.prepareStatement("select sum(price*(checkoutdate-checkindate)) from mealplan m,booking b where b.Mid=m.mealid and checkindate between ? and ?");
							pt1.setString(1, check1);
							pt1.setString(2, date1);
						  ResultSet rst=pt1.executeQuery();
						
							if(rst.next())
							{
								String mealprice=rst.getString("sum(price*(checkoutdate-checkindate))");
								txtmeal.setText(mealprice);
								
								  PreparedStatement pt2= connection.prepareStatement("select sum(roomprice*(checkoutdate-checkindate)) from room r,booking b where b.rno=r.roomno and checkindate between ? and ?");
								  pt2.setString(1, check1);
									pt2.setString(2, date1);
								  ResultSet rst1=pt2.executeQuery();
								 
								  
									if(rst1.next())
									{
										String room=rst1.getString("sum(roomprice*(checkoutdate-checkindate))");
										txtroomno.setText(room);
										
										double i=Double.parseDouble(mealprice);
										double y=Double.parseDouble(room);
										double ans=i+y;
										String s1=Double.toString(ans);
										txtamount.setText(s1);
										
									}
	                    
					}
					
				
					
					
					

					
					
					}
					}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
			}
		});
	
		Generate.setBounds(321, 435, 125, 32);
		panel_3.add(Generate);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(657, 64, 660, 317);
		reportpanel.add(scrollPane_5);
		
		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);
		
		JLabel lblNewLabel_9 = new JLabel("Total income from meals");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_9.setBounds(641, 425, 249, 41);
		reportpanel.add(lblNewLabel_9);
		
		txtmeal = new JTextField();
		txtmeal.setBounds(920, 436, 183, 30);
		reportpanel.add(txtmeal);
		txtmeal.setColumns(10);
		
		txtroomno = new JTextField();
		txtroomno.setColumns(10);
		txtroomno.setBounds(920, 502, 183, 30);
		reportpanel.add(txtroomno);
		
		JLabel lblNewLabel_9_1 = new JLabel("Total income from Rooms");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_9_1.setBounds(641, 491, 249, 41);
		reportpanel.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10 = new JLabel("Total amount");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_10.setBounds(641, 566, 170, 30);
		reportpanel.add(lblNewLabel_10);
		
		txtamount = new JTextField();
		txtamount.setColumns(10);
		txtamount.setBounds(920, 566, 183, 30);
		reportpanel.add(txtamount);
		
		JButton btnreportprint = new JButton("print report");
		btnreportprint.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnreportprint.setDefaultCapable(false);
		btnreportprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtntoday.isSelected())
				{
					 
							
					  try {
							
					         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
						

				        
				        
				       
						String meal=txtmeal.getText();
				        String roomno=txtroomno.getText();
				        String amount=txtamount.getText();
				        
				        HashMap a=new HashMap();
				        a.put("Parameter1", amount);
				        a.put("Parameter2", meal);
				        a.put("Parameter3",roomno);
				       
				        
				        
				        
				         

				         JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\S.Shavin Eeswar\\eclipse-workspace\\Integrate1\\src\\Final\\Cherry_Landscape_Table_Based.jrxml");
				         
				         	JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
				         
				         JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, a,connection);
				         
				      JRViewer v=new JRViewer(JasperPrint);
				      JasperViewer.viewReport(JasperPrint,false);
				        
				      
				       }
				       catch (Exception exception) {
				           JOptionPane.showMessageDialog(null, exception);
				       }
				       
				     
				         
				}
				else if(rdbtnCheckInFrom.isSelected())
				{
					
				    	 
				       try {
						
					         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
						

				         SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
				        String fdate=sdf.format(start.getDate());
				        
				        SimpleDateFormat sdf1=new SimpleDateFormat("YYYY-MM-dd");
				        String fdate1=sdf1.format(end.getDate());
				        
				        String meal=txtmeal.getText();
				        String roomno=txtroomno.getText();
				        String amount=txtamount.getText();
				        
				        HashMap a=new HashMap();
				        a.put("Parameter1", fdate);
				        a.put("Parameter2", fdate1);
				        a.put("Parameter3",meal);
				        a.put("Parameter4",roomno);
				        a.put("Parameter5",amount);
				        
				        
				        
				         

				         JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\S.Shavin Eeswar\\eclipse-workspace\\Integrate1\\src\\Final\\Cherry_Landscape2.jrxml");
				         
				         	JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
				         
				         JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, a,connection);
				         
				      JRViewer v=new JRViewer(JasperPrint);
				      JasperViewer.viewReport(JasperPrint,false);
				        
				      
				       }
				       catch (Exception exception) {
				           JOptionPane.showMessageDialog(null, exception);
				       }
				     
				         
				       
				         
				         
				         
				     
				         
				     
				

				
			
				}}}

			
		);
		btnreportprint.setBounds(1139, 593, 178, 41);
		reportpanel.add(btnreportprint);
		
		
		
		JButton btnconsume = new JButton("Customer");
		btnconsume.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnconsume.setBounds(33, 258, 125, 30);
		roomt.add(btnconsume);
		btnconsume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(consumepanel);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		
		
		JButton btnpermanent = new JButton("payment");
		btnpermanent.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnpermanent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(permanentpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnpermanent.setBounds(33, 408, 125, 30);
		roomt.add(btnpermanent);
		
		JButton btntransfer = new JButton("Booking");
		btntransfer.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btntransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(transferpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btntransfer.setBounds(33, 324, 125, 30);
		roomt.add(btntransfer);
		
		JButton btnreport = new JButton("Report");
		btnreport.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(reportpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnreport.setBounds(33, 490, 125, 30);
		roomt.add(btnreport);
		
		
		JButton book = new JButton("Booking");
		book.setFont(new Font("Tahoma", Font.PLAIN, 21));
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(transferpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		book.setBounds(998, 568, 226, 35);
		consumepanel.add(book);
		
		

		JButton payment = new JButton("Payment");
		payment.setFont(new Font("Tahoma", Font.PLAIN, 21));
		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(permanentpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				
				
				
			}
		});
		payment.setBounds(1057, 615, 175, 26);
		transferpanel.add(payment);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(686, 102, 525, 97);
		transferpanel.add(scrollPane_4);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		txtsearch = new JTextField();
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				  try {
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	                   String query="select roomno from room where roomtype=? and roomno Not IN (select rno from booking b,room r where b.rno=r.roomno and roomtype=?) ";
	                   PreparedStatement pt=connection.prepareStatement(query);
	                   pt.setString(1, txtsearch.getText());
	                   pt.setString(2, txtsearch.getText());
	                   ResultSet rs=pt.executeQuery();
	                   table_4.setModel(DbUtils.resultSetToTableModel(rs));
	                   
	                   pt.close(); 
	                    
	                } catch (SQLException exception) {
	                    exception.printStackTrace();
	                }
				
			}
		});
		txtsearch.setColumns(10);
		txtsearch.setBounds(689, 32, 393, 45);
		transferpanel.add(txtsearch);
		
		JLabel lblNewLabel_5 = new JLabel("SEARCH");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_5.setBounds(555, 27, 239, 45);
		transferpanel.add(lblNewLabel_5);
		
		
	
		
}

public void loadreport() 
{
	try{
    	 
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

         String query ="select bookingid,checkindate,checkoutdate,mealname,price,roomno,roomtype,roomprice from booking b,mealplan m,room r where b.rno=r.roomno and b.Mid=m.mealid and checkindate=current_date()";
     
         JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\SINGER\\eclipse-workspace\\itppractice\\src\\itppractice\\Cherry_Landscape_Table_Based.jrxml");
         
         JRDesignQuery updateQuery = new JRDesignQuery();
         
         updateQuery.setText(query);
         
         jdesign.setQuery(updateQuery);
         
         JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
         
         JasperPrint JasperPrint = JasperFillManager.fillReport(Jreport, null,connection);
         
         JasperViewer.viewReport(JasperPrint,false);
         
         
     } catch (Exception exception) {
         JOptionPane.showMessageDialog(null, exception);
     }

}
}
