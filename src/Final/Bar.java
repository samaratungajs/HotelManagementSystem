package Final;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserBeanInfo;

import net.proteanit.sql.DbUtils;

public class Bar extends JFrame {


	private JPanel contentPane;
	private Container layeredPane;
	private JPanel panel3;
	private JPanel panel2;
	private JPanel panel1;
	private JButton btnNewButton;
	private Container layeredPane_1;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable tableorder;
	private JTable tablesave;
	private JTextField textFieldsearch;
	protected Connection connection;
	private JDateChooser dateChooser_1;
	private JDateChooser dateChooser;
	private JLabel nobar;
	private JLabel bartot;
	private JTable table_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar frame = new Bar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void switchPanels(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	

	
	
	public void refreshconsume()
	{
		 try {
	    	 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
	         String query = "SELECT * FROM liquor";
	     
	         PreparedStatement pst = connection.prepareStatement(query);
	         ResultSet rs=pst.executeQuery();
	         table.setModel(DbUtils.resultSetToTableModel(rs));
	         
	         
	         
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }
	}

	
	/**
	 * Create the frame.
	 */
	public Bar() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1281, 762);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Royal Resort");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(343, 13, 521, 91);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(22, 127, 1229, 2);
		contentPane.add(separator);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBounds(1127, 58, 97, 25);
		contentPane.add(btnLogout);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(201, 128, 2, 587);
		contentPane.add(separator_1);
		
		final JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(212, 139, 1039, 576);
		contentPane.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Liquor");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel1);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(44, 243, 97, 25);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Order & Billing");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel2);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setBounds(22, 312, 136, 25);
		contentPane.add(btnNewButton_2);
		

		JButton btnNewButton_3= new JButton("Reports");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane_1.removeAll();
				layeredPane_1.add(panel3);
				layeredPane_1.repaint();
				layeredPane_1.revalidate();
			}
		});
		
		btnNewButton_3.setBackground(new Color(165, 42, 42));
		btnNewButton_3.setBounds(44, 378, 97, 25);
		contentPane.add(btnNewButton_3);
		
		
		Label label = new Label("BAR CASHIER");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setAlignment(Label.CENTER);
		label.setBounds(22, 168, 158, 43);
		contentPane.add(label);
		
		
		
		panel1 = new JPanel();
		layeredPane_1.add(panel1, "name_1104856159819400");
		panel1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(28, 27, 832, 301);
		panel1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add/Edit Liquor Details");
		lblNewLabel_1.setBounds(346, 10, 270, 32);
		lblNewLabel_1.setFont(new Font("Gulim", Font.BOLD, 18));
		panel.add(lblNewLabel_1);
		
		final JTextPane brand = new JTextPane();
		brand.setBounds(107, 62, 197, 32);
		panel.add(brand);
		
		final JTextPane price = new JTextPane();
		price.setBounds(107, 187, 197, 32);
		panel.add(price);
		
		final JTextPane name = new JTextPane();
		name.setBounds(556, 62, 222, 32);
		panel.add(name);
		
		final JTextPane volume = new JTextPane();
		volume.setBounds(556, 187, 222, 32);
		panel.add(volume);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Gulim", Font.BOLD, 14));
		lblBrand.setBounds(31, 62, 57, 32);
		panel.add(lblBrand);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Gulim", Font.BOLD, 14));
		lblPrice.setBounds(31, 199, 57, 15);
		panel.add(lblPrice);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Gulim", Font.BOLD, 14));
		lblNewLabel_3.setBounds(487, 63, 57, 31);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Volume");
		lblNewLabel_4.setFont(new Font("Gulim", Font.BOLD, 14));
		lblNewLabel_4.setBounds(487, 187, 57, 32);
		panel.add(lblNewLabel_4);
		
		final JTextPane Edate = new JTextPane();
		Edate.setBounds(107, 131, 197, 32);
		panel.add(Edate);
		
		JLabel lblNewLabel_6 = new JLabel("Expired date");
		lblNewLabel_6.setFont(new Font("Gulim", Font.BOLD, 14));
		lblNewLabel_6.setBounds(7, 131, 88, 23);
		panel.add(lblNewLabel_6);
		
		final JTextPane Mdate = new JTextPane();
		Mdate.setBounds(556, 129, 222, 34);
		panel.add(Mdate);
		
		final JLabel val = new JLabel("");
		val.setForeground(Color.RED);
		val.setBounds(362, 243, 132, 15);
		panel.add(val);
		
		JLabel lblManufactureDate = new JLabel("Manufacture Date");
		lblManufactureDate.setFont(new Font("Gulim", Font.BOLD, 14));
		lblManufactureDate.setBounds(423, 135, 132, 15);
		panel.add(lblManufactureDate);
		
		final JButton submit = new JButton("SUBMIT");
		submit.setBounds(251, 268, 97, 23);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 
				 String bnd = brand.getText();
				 String exp = Edate.getText();
				 String p = price.getText();
				 String n = name.getText();
				 String mdt = Mdate.getText();
				 String vol = volume.getText();
				;
				String driverName = "com.mysql.jdbc.Driver";
			     
			     
			     
			     if(bnd.isEmpty())
			     {
			    	 val.setText("brad Empty");
			     }
			     else if(exp.isEmpty())
			     {
			    	 val.setText("Expired date Empty");
			     }
			     else if(p.isEmpty())
			     {
			    	 val.setText("price is empty");
			     }
			     else if(n.isEmpty())
			     {
			    	 val.setText("name is empty");
			     }
			     else if(mdt.isEmpty())
			     {
			    	 val.setText("Manufacture date empty");
			     }
			     else if(vol.isEmpty())
			     {
			    	 val.setText("volume empty");
			     }
			     
			     else {
			    
			     try {
			    	 
			    	 val.setText(" ");
			    	 	
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
			         String query = "INSERT INTO liquor" + "(liquorname,brand,manufacturedate,expiry,volume,price) VALUES (" + " '" + n+ "','" + bnd+ "','" + mdt + "','" + exp + "','"+vol+"','"+p+"')";
			     
			         Statement sta = connection.createStatement();
			         int x = sta.executeUpdate(query);
			         if (x == 0) {
			             JOptionPane.showMessageDialog(submit, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(submit,
			                "New liquor is sucessfully added");
			         }
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
			     
			     refreshconsume();
			     }
				
				
			}
		});
		panel.add(submit);
		
		final JButton btnNewButton_5 = new JButton("UPDATE");
		btnNewButton_5.setBounds(412, 268, 97, 23);
		 btnNewButton_5.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		
		
				
			 String bnd = brand.getText();
			 String exp = Edate.getText();
			 String p = price.getText();
			 String n = name.getText();
			 String mdt = Mdate.getText();
			 String vol = volume.getText();
		    
		    
		     String driverName = "com.mysql.jdbc.Driver";
		     
		     int selectedRow = table.getSelectedRow();
		     DefaultTableModel model = (DefaultTableModel) table.getModel();
		     String id =(model.getValueAt(selectedRow, 0).toString());
		     
		     
		    
		     
		     if(bnd.isEmpty())
		     {
		    	 val.setText("brad Empty");
		     }
		     else if(exp.isEmpty())
		     {
		    	 val.setText("Expired date Empty");
		     }
		     else if(p.isEmpty())
		     {
		    	 val.setText("price is empty");
		     }
		     else if(n.isEmpty())
		     {
		    	 val.setText("name is empty");
		     }
		     else if(mdt.isEmpty())
		     {
		    	 val.setText("Manufacture date empty");
		     }
		     else if(vol.isEmpty())
		     {
		    	 val.setText("volume empty");
		     }
		     
		     else {
		    
		     try {
		    	 
		         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
		    	 String query = "UPDATE liquor set liquorname ='"+n+"', brand='"+bnd+"', manufacturedate='"+mdt+"', expiry='"+exp+"', volume='"+vol+"', price='"+p+"' where liquorid="+id;
			     
		     
		         PreparedStatement pst = connection.prepareStatement(query);
		        
		         int x = pst.executeUpdate(query);
		         if (x == 0) {
		             JOptionPane.showMessageDialog(btnNewButton_5, "This is alredy exist");
		         } else {
		             JOptionPane.showMessageDialog(btnNewButton_5,
		                "Consumable liquors successfully updated");
		         }
		         connection.close();
		     } catch (Exception exception) {
		         exception.printStackTrace();
		     }
		     
		     refreshconsume();
		     }
			
			
		}
	});
	panel.add(btnNewButton_5);
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(589, 268, 97, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String sql = "DELETE FROM liquor WHERE liquorid = "+id;
					PreparedStatement pst = connection.prepareStatement(sql);
			        int rs=pst.executeUpdate(sql);
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				refreshconsume();
			}
		});
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 378, 832, 174);
		panel1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				name.setText(model.getValueAt(selectedRow, 1).toString());
				brand.setText(model.getValueAt(selectedRow, 2).toString());
				Mdate.setText(model.getValueAt(selectedRow, 3).toString());
				Edate.setText(model.getValueAt(selectedRow, 4).toString());
				volume.setText(model.getValueAt(selectedRow, 5).toString());
				price.setText(model.getValueAt(selectedRow, 6).toString()); 
			}
		});
		scrollPane.setViewportView(table);
		
		JButton Refresh = new JButton("Refresh");
		Refresh.setBounds(38, 345, 97, 23);
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			refreshconsume();
				
			}
		});
		panel1.add(Refresh);
		
		textFieldsearch = new JTextField();
		textFieldsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String query="select liquorid,liquorname,brand,manufacturedate,expiry,volume,price from liquor where liquorname=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textFieldsearch.getText());
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
				//	while(rs.next())
				//	{
						
				//}
					pst.close();
				}
				catch(Exception ex) {
					ex.printStackTrace();
					
				}
			}
		});
		textFieldsearch.setBounds(678, 345, 182, 23);
		panel1.add(textFieldsearch);
		textFieldsearch.setColumns(10);
		
		
		panel2 = new JPanel();
		layeredPane_1.add(panel2, "name_1104905783928999");
		panel2.setLayout(null);
		
		final JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser_2.setBounds(121, 12, 132, 21);
		panel2.add(dateChooser_2);
		
		JButton btnMakeOrder = new JButton("Make Order");
		btnMakeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String query="INSERT INTO order1(orderdate)values(?)";
					PreparedStatement pst=connection.prepareStatement(query);
					
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String date=sdf.format(dateChooser_2.getDate());
					pst.setString(1, date);
					
					int data=pst.executeUpdate();
					if(data>0)
					{
						JOptionPane.showMessageDialog(null, "order started");
					}
					else {
						JOptionPane.showInternalMessageDialog(null,"can't insert data");
					}
				}
				catch(Exception exep)
				{
					exep.printStackTrace();
				}
			}
		});
		
		btnMakeOrder.setBounds(265, 10, 124, 23);
		panel2.add(btnMakeOrder);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(27, 43, 373, 227);
		panel2.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(120, 10, 222, 28);
		panel_1.add(textPane_7);
		
		JTextPane liquorid = new JTextPane();
		liquorid.setBounds(120, 60, 224, 28);
		panel_1.add(liquorid);
		
		JTextPane qty1 = new JTextPane();
		qty1.setBounds(120, 110, 222, 28);
		panel_1.add(qty1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(27, 319, 373, 205);
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane total = new JTextPane();
		total.setBounds(133, 92, 192, 27);
		panel_2.add(total);
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setBounds(134, 48, 191, 27);
		panel_2.add(textPane_10);
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					

					 String liqid= liquorid.getText();

					 String qty= qty1.getText();


					 String oi = textPane_7.getText();


					 String query2="INSERT INTO liquororder" + "(liquorid,orderid,quantity) VALUES ('" + liqid+ "','" + oi + "','"+qty+"')";

					 Statement pst2=connection.createStatement();



					int x1 = pst2.executeUpdate(query2);



					 String query="SELECT price FROM liquor WHERE liquorid ='"+liqid+"'";

					 PreparedStatement pst=connection.prepareStatement(query);



					ResultSet rs=pst.executeQuery();

					 if(rs.next()) {



					 String price = rs.getString("price");


					 Double p = Double.parseDouble(price) ;


					 double tot = p * Double.parseDouble(qty) ;


					 String t=Double.toString(tot);


					 total.setText(t);

					 textPane_10.setText(oi);


					 //tablesave.setModel(DbUtils.resultSetToTableModel(rs));



					 String query1="INSERT INTO bill" + "(orderid,liquorid,total) VALUES ('" + oi+ "','" + liqid + "','"+t+"')";

					 Statement pst1=connection.createStatement();



					int x = pst1.executeUpdate(query1);



					 }


					 pst.close();


					 String query3="SELECT orderid,liquorid,total FROM bill";

					 PreparedStatement pst3=connection.prepareStatement(query3);



					ResultSet rs3=pst3.executeQuery();


					 tablesave.setModel(DbUtils.resultSetToTableModel(rs3));

				}
				catch(Exception exep)
				{
					exep.printStackTrace();
				}
				
			}		
			
	});
		btnSubmit.setBounds(245, 194, 97, 23);
		panel_1.add(btnSubmit);
		
		JLabel lblOrderId = new JLabel("Order ID");
		lblOrderId.setFont(new Font("Gulim", Font.BOLD, 14));
		lblOrderId.setBounds(37, 10, 58, 28);
		panel_1.add(lblOrderId);
		
		JLabel lblLiquorId = new JLabel("Liquor ID");
		lblLiquorId.setFont(new Font("Gulim", Font.BOLD, 14));
		lblLiquorId.setBounds(37, 61, 82, 15);
		panel_1.add(lblLiquorId);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Gulim", Font.BOLD, 14));
		lblQuantity.setBounds(37, 110, 57, 28);
		panel_1.add(lblQuantity);
		
		JLabel lblBillTotal = new JLabel("Bill Total");
		lblBillTotal.setBounds(148, 10, 177, 34);
		lblBillTotal.setFont(new Font("Gulim", Font.BOLD, 18));
		panel_2.add(lblBillTotal);
		
		JButton btnPrintBill = new JButton("PRINT BILL");
		btnPrintBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
		});
		btnPrintBill.setBounds(206, 151, 119, 23);
		panel_2.add(btnPrintBill);
		
		JLabel lblOrderId_1 = new JLabel("Order ID");
		lblOrderId_1.setFont(new Font("Gulim", Font.BOLD, 14));
		lblOrderId_1.setBounds(30, 48, 92, 27);
		panel_2.add(lblOrderId_1);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Gulim", Font.BOLD, 14));
		lblTotalPrice.setBounds(26, 92, 95, 27);
		panel_2.add(lblTotalPrice);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(429, 10, 7, 538);
		panel2.add(separator_2);
		
		
		JScrollPane scrollPaneorder = new JScrollPane();
		scrollPaneorder.setBounds(467, 86, 516, 156);
		panel2.add(scrollPaneorder);
		
		table_2 = new JTable();
		tableorder = new JTable();
		tableorder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = tableorder.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableorder.getModel();
				
				textPane_7.setText(model.getValueAt(selectedRow, 0).toString());
				
			}
		});
		scrollPaneorder.setViewportView(tableorder);
		
		JScrollPane scrollPanedbsave = new JScrollPane();
		scrollPanedbsave.setBounds(467, 313, 523, 211);
		panel2.add(scrollPanedbsave);
		
		tablesave = new JTable();
		tablesave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = tablesave.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tablesave.getModel();
				
				
			}
		});
		scrollPanedbsave.setViewportView(tablesave);
		
		JButton btnNewButtonorder = new JButton("refresh");
		btnNewButtonorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String query="select orderid,orderdate from order1";
					PreparedStatement pt=connection.prepareStatement(query);
					ResultSet rs=pt.executeQuery();
					
					tableorder.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnNewButtonorder.setBounds(875, 53, 97, 23);
		panel2.add(btnNewButtonorder);
		
		JLabel lblOrder = new JLabel("ORDER");
		lblOrder.setFont(new Font("Gulim", Font.BOLD, 18));
		lblOrder.setBounds(649, 43, 185, 32);
		panel2.add(lblOrder);
		
		
		
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(766, 53, 97, 23);
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = tableorder.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) tableorder.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String sql = "DELETE FROM order1 WHERE orderid = "+id;
					PreparedStatement pst = connection.prepareStatement(sql);
			        int rs=pst.executeUpdate(sql);
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				refreshconsume();
			}
		});
		panel2.add(btnDelete_1);
		
		JButton btnSaveOrder = new JButton("Save order");
		btnSaveOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshconsume();
			}
		});
		btnSaveOrder.setBounds(875, 274, 97, 23);
		panel2.add(btnSaveOrder);
		
		
		JButton btnRefreshmakeorder = new JButton("Refresh");
		Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			refreshconsume();
				
			}
		});
		
		
		
		panel3 = new JPanel();
		layeredPane_1.add(panel3, "name_1104919697125800");
		panel3.setLayout(null);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(118, 149, 209, 30);
		panel3.add(dateChooser_1);
		
		JLabel lblIncomeReport = new JLabel("Income Report");
		lblIncomeReport.setFont(new Font("Gulim", Font.BOLD, 18));
		lblIncomeReport.setBounds(293, 40, 414, 36);
		panel3.add(lblIncomeReport);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(67, 116, 57, 15);
		panel3.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(67, 164, 57, 15);
		panel3.add(lblTo);
		
		JButton btnGenarate = new JButton("Genarate");
		btnGenarate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
					String from = sdf.format(dateChooser.getDate());
					SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd");
					String to = sdf2.format(dateChooser_1.getDate());
					
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
		           
		            
		            PreparedStatement strb = (PreparedStatement) connection.prepareStatement("Select SUM(b.total) from bill b, order1 o where b.orderid = o.orderid and orderdate between ? and ? and b.liquorid IS NOT NULL ");		         
		            strb.setString(1, from);
		            strb.setString(2, to);
		            ResultSet rsb = strb.executeQuery();
		            PreparedStatement barc = (PreparedStatement) connection.prepareStatement("Select COUNT(b.billid) from bill b, order1 o where b.orderid = o.orderid and b.liquorid IS NOT NULL and orderdate between ? and ? ");		         
		            barc.setString(1, from);
		            barc.setString(2, to);
		            ResultSet bb = barc.executeQuery();
		            
		           
		         
						String query="Select billid,b.orderid,liquorid,total from bill b, order1 o where b.orderid = o.orderid and b.liquorid IS NOT NULL and orderdate between ? and ?";
						PreparedStatement pt=connection.prepareStatement(query);
						   pt.setString(1, from);
				            pt.setString(2, to);
						ResultSet rs=pt.executeQuery();
						
						table_3.setModel(DbUtils.resultSetToTableModel(rs));
					
		            
		            
		            
		            double b=0;
		            
				
				if (rsb.next()) {
					String rsbr =  rsb.getString("SUM(b.total)"); 
					b = rsb.getDouble("SUM(b.total)");
					bartot.setText("Total Income - "+rsbr+"0");
				}
				if (bb.next()) {
					String boo =  bb.getString("COUNT(b.billid)");  
					nobar.setText("Total Number of Orders - "+boo);
				}
				
				
	
				
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
			}
		});
		btnGenarate.setBounds(361, 101, 97, 23);
		panel3.add(btnGenarate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(118, 101, 209, 30);
		panel3.add(dateChooser);
		
		nobar = new JLabel("");
		nobar.setFont(new Font("Gulim", Font.BOLD, 14));
		nobar.setHorizontalAlignment(SwingConstants.CENTER);
		nobar.setOpaque(true);
		nobar.setBackground(SystemColor.controlShadow);
		nobar.setBounds(73, 252, 385, 46);
		panel3.add(nobar);
		
		bartot = new JLabel("");
		bartot.setFont(new Font("Gulim", Font.BOLD, 14));
		bartot.setHorizontalAlignment(SwingConstants.CENTER);
		bartot.setOpaque(true);
		bartot.setBackground(SystemColor.controlShadow);
		bartot.setBounds(73, 350, 385, 46);
		panel3.add(bartot);
		
		JButton btnNewButton_4 = new JButton("Download");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					File file = new File("C:\\Users\\User\\Desktop\\barReport.txt");
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
						
						
						
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

			           
			            
			            PreparedStatement strb = (PreparedStatement) connection.prepareStatement("Select SUM(b.total) from bill b, order1 o where b.orderid = o.orderid and orderdate between ? and ? and b.liquorid IS NOT NULL ");		         
			            strb.setString(1, from);
			            strb.setString(2, to);
			            ResultSet rsb = strb.executeQuery();
			            PreparedStatement barc = (PreparedStatement) connection.prepareStatement("Select COUNT(b.billid) from bill b, order1 o where b.orderid = o.orderid and b.liquorid IS NOT NULL and orderdate between ? and ? ");		         
			            barc.setString(1, from);
			            barc.setString(2, to);
			            ResultSet bb = barc.executeQuery();
			            
			        
			            
			            double b=0;
			            
				
			            if (rsb.next()) {
							String rsbr =  rsb.getString("SUM(b.total)"); 
							b = rsb.getDouble("SUM(b.total)");
							bartot.setText("Total Income - "+rsbr+"0");
						}
						if (bb.next()) {
							String boo =  bb.getString("COUNT(b.billid)");  
							nobar.setText("Total Number of Orders - "+boo);
						}
					
					
				
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
		btnNewButton_4.setBounds(361, 156, 97, 23);
		panel3.add(btnNewButton_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(566, 134, 414, 368);
		panel3.add(scrollPane_2);
		
		table_3 = new JTable();
		scrollPane_2.setViewportView(table_3);
	}
}
