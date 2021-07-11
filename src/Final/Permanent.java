package Final;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Permanent extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtpname;
	public  JLayeredPane l;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField txtunit;
	private JTable table_3;
	private JTextField txtsearch;
	private JTable table_4;
	/**
	 * Launch the application.
	 */
	
	
	public void refreshconsume()
	{
		 try {
	    	 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	         String query = "SELECT inventoryid as 'Inventory Id',cname as 'Consumable Inventory Name',quantity as 'Qunatity',ctype as 'Type', unit as 'Unit',userid as 'Updated user' FROM consumable WHERE ctype= 'Kitchen'";
	     
	         PreparedStatement pst = connection.prepareStatement(query);
	         ResultSet rs=pst.executeQuery();
	         table.setModel(DbUtils.resultSetToTableModel(rs));
	         
	         String query1 = "SELECT inventoryid as 'Inventory Id',cname as 'Consumable Inventory Name',quantity as 'Qunatity',ctype as 'Type', unit as 'Unit',userid as 'Updated user'  FROM consumable WHERE ctype= 'Restaurant'";
		     
	         PreparedStatement pst1 = connection.prepareStatement(query1);
	         ResultSet rs1=pst1.executeQuery();
	         table_1.setModel(DbUtils.resultSetToTableModel(rs1));
	         
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }
	}
	
	
	public void refreshreport()
	{
		 try {
	    	 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	         String query = "SELECT cname as 'Consumable Inventory Name',quantity as 'Qunatity',ctype as 'Type', unit as 'Unit' FROM consumable ";
	     
	         PreparedStatement pst = connection.prepareStatement(query);
	         ResultSet rs=pst.executeQuery();
	         table_4.setModel(DbUtils.resultSetToTableModel(rs));
	         
	        
	         
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }
	}
	
	
	public void refreshpermanant() 
	{
		try {
	    	 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	         String query = "SELECT inventoryid as 'Inventory Id',pname as 'Premanent Inventory Name',quantity as 'Qunatity',pdescription as 'Description' FROM permenent ";
	     
	         PreparedStatement pst = connection.prepareStatement(query);
	         ResultSet rs=pst.executeQuery();
	         table_2.setModel(DbUtils.resultSetToTableModel(rs));
	         
	         
	         
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }

	}
	
	
	public void loadreport() 
	{
		try {
	    	 
	         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	         String query = "SELECT * FROM consumable ";
	     
	         JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\S.Shavin Eeswar\\eclipse-workspace\\Integrate1\\src\\Final\\Inventory.jrxml");
	         
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
	
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Permanent frame = new Permanent();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		
	}
	
	public void switchPanel(JPanel panel){
		l.removeAll();
		l.repaint();
		l.revalidate();
		l.add(panel);
		l.repaint();
		l.revalidate();
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public Permanent() {
		


		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 828);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 30, 46));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Royal Resort");
		lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(431, 31, 631, 86);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 127, 1514, 2);
		separator.setForeground(Color.BLACK);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(33, 13, 134, 104);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\ITP\\Pics\\resthouse125-removebg-preview.png"));
		
		contentPane.add(lblNewLabel_1);
		
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
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(1379, 69, 125, 40);
		contentPane.add(btnLogout);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(187, 128, 2, 809);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("INVENTORY");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(12, 162, 170, 40);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		contentPane.add(lblNewLabel_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(199, 139, 1327, 652);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel consumepanel = new JPanel();
		consumepanel.setBackground(SystemColor.controlShadow);
		consumepanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		layeredPane.add(consumepanel, "name_190199726687917");
		consumepanel.setLayout(null);
		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(521, 13, 2, 634);
		consumepanel.add(separator_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 13, 473, 615);
		consumepanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddANew = new JLabel("Add a new inventory");
		lblAddANew.setOpaque(true);
		lblAddANew.setBackground(Color.LIGHT_GRAY);
		lblAddANew.setForeground(Color.BLACK);
		lblAddANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddANew.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lblAddANew.setBounds(12, 13, 457, 37);
		panel.add(lblAddANew);
		
		JLabel val = new JLabel("");
		val.setForeground(Color.RED);
		val.setFont(new Font("Tahoma", Font.BOLD, 11));
		val.setBounds(113, 503, 233, 29);
		panel.add(val);
		
		txtname = new JTextField();
		txtname.setBounds(12, 162, 421, 37);
		panel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName.setBounds(12, 112, 89, 22);
		panel.add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblType.setBounds(12, 256, 89, 22);
		panel.add(lblType);
		
		JLabel lblName_1_1 = new JLabel("Unit");
		lblName_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_1_1.setBounds(12, 448, 89, 22);
		panel.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Quantity");
		lblName_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_1_1_1.setBounds(12, 357, 89, 22);
		panel.add(lblName_1_1_1);
		
		JSpinner spinnerCQ = new JSpinner();
		spinnerCQ.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerCQ.setBounds(169, 354, 157, 37);
		panel.add(spinnerCQ);
		
		String [] type = { "Kitchen", "Restaurant"};
		JComboBox combotype = new JComboBox(type);
		combotype.setFont(new Font("Tahoma", Font.BOLD, 12));
		combotype.setBounds(169, 253, 177, 37);
		panel.add(combotype);
		
		String [] unit = { "Kg", "Count"};
		JComboBox comboCU = new JComboBox(unit);
		comboCU.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboCU.setBounds(169, 441, 230, 45);
		panel.add(comboCU);
		
		JButton btnconadd = new JButton("Add");
		btnconadd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnconadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String cname = txtname.getText();
			     String ctype =(String)combotype.getSelectedItem();
			     String unit = (String) comboCU.getSelectedItem();
			     String userid=null;
			     int inventoryid = 1;
			     int quantity = (int) spinnerCQ.getValue();
			     String driverName = "com.mysql.cj.jdbc.Driver";

			     if(cname.isEmpty())
			     {
			    	 val.setText("Inventory Name is Empty");
			     }
			     else if(quantity == 0)
			     {
			    	 val.setText("Inventory Quantity is not be 0");
			     }
			     
			     else {
		     try {
		    	 	val.setText(" ");
		    	 	
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

			         String query = "INSERT INTO consumable" + "(cname,quantity,ctype,unit) VALUES (" + " '" + cname + "','" + quantity + "','" + ctype + "','" +
             unit + "')";
			     
			         Statement sta = connection.createStatement();
			         int x = sta.executeUpdate(query);
			         if (x == 0) {
			             JOptionPane.showMessageDialog(btnconadd, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(btnconadd,
			                "New inventory is sucessfully added");
			         }
			         connection.close();
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
			     } 
			     
			     refreshconsume();
		}
		});
		btnconadd.setBounds(169, 546, 116, 37);
		panel.add(btnconadd);
		
		JButton btnconupdate = new JButton("Update");
		btnconupdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnconupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String cname = txtname.getText();
			     String ctype =(String)combotype.getSelectedItem();
			     String unit = (String) comboCU.getSelectedItem();
			     String userid=null;
			    // int inventoryid = 1;
			     int quantity = (int) spinnerCQ.getValue();
			     String driverName = "com.mysql.cj.jdbc.Driver";
			     
			     int selectedRow = table.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
			     if(cname.isEmpty())
			     {
			    	 val.setText("Inventory Name is Empty");
			     }
			     else if(quantity == 0)
			     {
			    	 val.setText("Inventory Quantity is not be 0");
			     }
			     
			     else {
			    
			     try {
			    	 
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

			         String query = "UPDATE consumable set cname='"+cname+"', quantity='"+quantity+"', ctype='"+ctype+"', unit='"+unit+"' where inventoryid="+id;
			     
			         PreparedStatement pst = connection.prepareStatement(query);
			        
			         int x = pst.executeUpdate(query);
			         if (x == 0) {
			             JOptionPane.showMessageDialog(btnconupdate, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(btnconupdate,
			                "Consumable inventory successfully updated");
			         }
			         connection.close();
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
			     
			     refreshconsume();
			     }
				
				
			}
		});
		btnconupdate.setBounds(25, 546, 122, 37);
		panel.add(btnconupdate);
		
		JButton btncondel = new JButton("Delete");
		btncondel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncondel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int selectedRow = table.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
					String sql = "DELETE  FROM consumable WHERE inventoryid = "+id;
					PreparedStatement pst = connection.prepareStatement(sql);
			        int rs=pst.executeUpdate(sql);
					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				refreshconsume();
			}
			
		});
		btncondel.setBounds(317, 546, 116, 37);
		panel.add(btncondel);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(575, 77, 733, 243);
		consumepanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				txtname.setText(model.getValueAt(selectedRow, 1).toString());
				combotype.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
				spinnerCQ.setValue(model.getValueAt(selectedRow, 2));
				comboCU.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
			
			
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Kitchen Inventory ");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(565, 42, 225, 25);
		consumepanel.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(565, 377, 743, 243);
		consumepanel.add(scrollPane_1);
		
		
		
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table_1.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				
				txtname.setText(model.getValueAt(selectedRow, 1).toString());
				combotype.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
				spinnerCQ.setValue(model.getValueAt(selectedRow, 2));
				comboCU.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			refreshconsume();
				
			}
		});
		btnRefresh.setBounds(1183, 27, 125, 40);
		consumepanel.add(btnRefresh);
		
		
		
		
		JLabel lblNewLabel_3_1 = new JLabel("Restuarant Inventory ");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(575, 352, 233, 25);
		consumepanel.add(lblNewLabel_3_1);
		
		JPanel permanentpanel = new JPanel();
		permanentpanel.setBackground(SystemColor.controlShadow);
		layeredPane.add(permanentpanel, "name_190210044671520");
		permanentpanel.setLayout(null);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(489, 13, 2, 589);
		permanentpanel.add(separator_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(10, 10, 449, 598);
		permanentpanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPermanent = new JLabel("Add new Permanent Invetory");
		lblPermanent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPermanent.setOpaque(true);
		lblPermanent.setBackground(Color.GRAY);
		lblPermanent.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lblPermanent.setBounds(12, 13, 427, 37);
		panel_1.add(lblPermanent);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_1.setBounds(23, 113, 89, 22);
		panel_1.add(lblName_1);
		
		txtpname = new JTextField();
		txtpname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpname.setColumns(10);
		txtpname.setBounds(23, 167, 397, 37);
		panel_1.add(txtpname);
		
		JLabel lblName_1_1_1_1 = new JLabel("Quantity");
		lblName_1_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_1_1_1_1.setBounds(23, 263, 89, 22);
		panel_1.add(lblName_1_1_1_1);
		
		JSpinner spinnerPQ = new JSpinner();
		spinnerPQ.setFont(new Font("Tahoma", Font.BOLD, 12));
		spinnerPQ.setBounds(167, 260, 183, 44);
		panel_1.add(spinnerPQ);
		
		JLabel lblName_1_1_2 = new JLabel("Descriptions");
		lblName_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_1_1_2.setBounds(12, 394, 116, 22);
		panel_1.add(lblName_1_1_2);
		
		JTextArea textDes = new JTextArea();
		textDes.setBounds(167, 357, 253, 94);
		panel_1.add(textDes);
		
		JLabel val2 = new JLabel("");
		val2.setForeground(Color.RED);
		val2.setBounds(95, 473, 228, 26);
		panel_1.add(val2);
		
		JButton btnconupdatep = new JButton("Update");
		btnconupdatep.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnconupdatep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname = txtpname.getText();
			     String userid=null;
			     String description=textDes.getText();
			     int quantity = (int) spinnerPQ.getValue();
			     String driverName = "com.mysql.cj.jdbc.Driver";

			     
			     int selectedRow = table_2.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_2.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
			     if(pname.isEmpty())
			     {
			    	 val2.setText("Inventory Name is Empty");
			     }
			     else if(quantity == 0)
			     {
			    	 val2.setText("Inventory Quantity is not be 0");
			     }
			     
			     else {
			    
			     try {
			    	 
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

			         String query = "UPDATE permenent set pname='"+pname+"', quantity='"+quantity+"', pdescription='"+description+"' where inventoryid="+id;
			     
			         PreparedStatement pst = connection.prepareStatement(query);
			        
			         int x = pst.executeUpdate(query);
			         if (x == 0) {
			             JOptionPane.showMessageDialog(btnconupdate, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(btnconupdate,
			                "Consumable inventory successfully updated");
			         }
			         connection.close();
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
			     refreshpermanant();
			}
			}	     
		});
		btnconupdatep.setBounds(13, 509, 126, 37);
		panel_1.add(btnconupdatep);
		
		JButton btnconaddp = new JButton("Add");
		btnconaddp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnconaddp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String pname = txtpname.getText();
			     String userid=null;
			     String description=textDes.getText();
			     int quantity = (int) spinnerPQ.getValue();
			     String driverName = "com.mysql.cj.jdbc.Driver";

			     if(pname.isEmpty())
			     {
			    	 val2.setText("Inventory Name is Empty");
			     }
			     else if(quantity == 0)
			     {
			    	 val2.setText("Inventory Quantity is not be 0");
			     }
			     
			     else {
			     
			     try {
			    	 val.setText(" ");
			    	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
			    	 String query = "INSERT INTO permenent" + "(pname,quantity,pdescription) VALUES (" + " '" + pname + "','" + quantity + "','" + description + "')";
			     
 				Statement sta = connection.createStatement();
				int x = sta.executeUpdate(query);
				if (x == 0) {
			             JOptionPane.showMessageDialog(btnconadd, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(btnconadd,
			                "New inventory is sucessfully added");
			         }
			         connection.close();
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
			     refreshpermanant();
			     }
				
			}
			
		});
		btnconaddp.setBounds(167, 509, 116, 37);
		panel_1.add(btnconaddp);
		
		JButton btncondelp = new JButton("Delete");
		btncondelp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btncondelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					String sql = "DELETE FROM permenent WHERE inventoryid = "+id;
					PreparedStatement pst = connection.prepareStatement(sql);
			        int rs=pst.executeUpdate(sql);
					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				refreshpermanant();
			}
		});
		btncondelp.setBounds(304, 509, 116, 37);
		panel_1.add(btncondelp);
		
				
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(501, 147, 818, 346);
		permanentpanel.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table_2.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
				
				txtpname.setText(model.getValueAt(selectedRow, 1).toString());
				spinnerPQ.setValue(model.getValueAt(selectedRow, 2));
				textDes.setText(model.getValueAt(selectedRow, 3).toString());
			



			}
		});
		scrollPane_2.setViewportView(table_2);
		
		
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshpermanant();
				
			}
		});
		btnNewButton.setBounds(1202, 10, 125, 40);
		permanentpanel.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Permanent Inventory");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lblNewLabel_4.setBounds(536, 84, 238, 24);
		permanentpanel.add(lblNewLabel_4);
		
		JPanel transferpanel = new JPanel();
		transferpanel.setBackground(SystemColor.controlShadow);
		layeredPane.add(transferpanel, "name_190213308632912");
		transferpanel.setLayout(null);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(498, 16, 2, 589);
		transferpanel.add(separator_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 16, 462, 589);
		transferpanel.add(panel_2);
		
		JLabel lblAddANew_1 = new JLabel("Transfer an item from inventory");
		lblAddANew_1.setOpaque(true);
		lblAddANew_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddANew_1.setForeground(Color.BLACK);
		lblAddANew_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		lblAddANew_1.setBackground(Color.LIGHT_GRAY);
		lblAddANew_1.setBounds(12, 13, 440, 31);
		panel_2.add(lblAddANew_1);
		
		JLabel lblName_2 = new JLabel("Name");
		lblName_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_2.setBounds(196, 120, 89, 22);
		panel_2.add(lblName_2);
		
		JLabel lblName_1_1_3 = new JLabel("User id");
		lblName_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_1_1_3.setBounds(196, 386, 89, 22);
		panel_2.add(lblName_1_1_3);
		
		JLabel lblName_1_1_1_2 = new JLabel("Transfer quantity");
		lblName_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblName_1_1_1_2.setBounds(143, 234, 190, 22);
		panel_2.add(lblName_1_1_1_2);
		
		JSpinner spinnerTQ = new JSpinner();
		spinnerTQ.setFont(new Font("Tahoma", Font.BOLD, 13));
		spinnerTQ.setBounds(131, 285, 214, 48);
		panel_2.add(spinnerTQ);
		
		JButton btnconupdate_1 = new JButton("Transfer");
		btnconupdate_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnconupdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
			     String userid= txtunit.getText();;
			     int tqty = (int) spinnerTQ.getValue();
			     String driverName = "com.mysql.cj.jdbc.Driver";
			     
			     int selectedRow = table_3.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_3.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     int qty = (int) (model.getValueAt(selectedRow, 2));
			    
			     
			     
			     try {
			    	 
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
			         
				     int quantity= (qty - tqty);
				     
			         String query = "UPDATE consumable set quantity='"+quantity+"', userid='"+userid+"' WHERE inventoryid="+id;
			         PreparedStatement pst1 = connection.prepareStatement(query);
			         int x = pst1.executeUpdate(query);
			         
			         
			         if (x == 0) {
			             JOptionPane.showMessageDialog(btnconupdate, "This is alredy exist");
			         } else {
			             JOptionPane.showMessageDialog(btnconupdate,
			                "Consumable inventory successfully tranfered");
			         }
			         connection.close();
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
				
				
			}
		});
		btnconupdate_1.setBounds(174, 516, 128, 37);
		panel_2.add(btnconupdate_1);
		
		txtunit = new JTextField();
		txtunit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtunit.setColumns(10);
		txtunit.setBounds(47, 422, 370, 48);
		panel_2.add(txtunit);
		
		JLabel txttname = new JLabel("");
		txttname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txttname.setHorizontalAlignment(SwingConstants.CENTER);
		txttname.setBounds(65, 152, 339, 48);
		panel_2.add(txttname);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(519, 233, 800, 168);
		transferpanel.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table_3.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_3.getModel();
				
				txttname.setText(model.getValueAt(selectedRow, 1).toString());
				//spinnerTQ.setValue(model.getValueAt(selectedRow, 2));
				
				
			}
		});
		scrollPane_3.setViewportView(table_3);
		
		txtsearch = new JTextField();
		txtsearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					 String search = txtsearch.getText();
					
					 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

			         String query = "SELECT inventoryid,cname,quantity,unit FROM consumable where cname LIKE '%"+search+"%'";
			     
			         PreparedStatement pst = connection.prepareStatement(query);

			         ResultSet rs=pst.executeQuery();
			         table_3.setModel(DbUtils.resultSetToTableModel(rs));
			         

					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
			}
		});
		txtsearch.setBounds(677, 150, 583, 41);
		transferpanel.add(txtsearch);
		txtsearch.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Search Inventory by the inventory name");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_5.setBounds(748, 90, 390, 37);
		transferpanel.add(lblNewLabel_5);
		
		JPanel reportpanel = new JPanel();
		reportpanel.setBackground(SystemColor.controlShadow);
		layeredPane.add(reportpanel);
		reportpanel.setLayout(null);
		
		table_4 = new JTable();
		table_4.setBounds(56, 103, 1241, 418);
		reportpanel.add(table_4);
		
		JLabel lblNewLabel_6 = new JLabel("Monthly Report Of Consumable Inventory ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(441, 37, 532, 32);
		reportpanel.add(lblNewLabel_6);
		
		JButton printrep = new JButton("Print");
		printrep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		printrep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadreport();
			}
		});
		printrep.setBounds(1169, 551, 122, 40);
		reportpanel.add(printrep);
		
		JButton btnconsume = new JButton("Consumable");
		
		btnconsume.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnconsume.setBounds(33, 276, 125, 30);
		contentPane.add(btnconsume);
		btnconsume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(consumepanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				refreshconsume();
				
			}
		});
		
		
		JButton btnpermanent = new JButton("Permanent");
		btnpermanent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnpermanent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(permanentpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				refreshpermanant();
			}
		});
		btnpermanent.setBounds(33, 395, 125, 30);
		contentPane.add(btnpermanent);
		
		JButton btntransfer = new JButton("Transfer Item");
		btntransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btntransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(transferpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btntransfer.setBounds(33, 524, 125, 30);
		contentPane.add(btntransfer);
		
		JButton btnreport = new JButton("Report");
		btnreport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(reportpanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				refreshreport();
			}
		});
		btnreport.setBounds(33, 653, 125, 30);
		contentPane.add(btnreport);
	}
}
