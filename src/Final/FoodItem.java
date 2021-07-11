package Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.lowagie.text.pdf.PdfPublicKeyRecipient;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.components.JSpinField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.Point;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Choice;


public class FoodItem extends JFrame {

	protected static final SpinnerModel spinnerQty = null;
	private JPanel contentPane;
	private JLabel lblTopic;
	private JLabel lblFormTopic1;
	private JButton btnAddButton;
	private JButton btnSearchMeal;
	private JTextField foodNameField;
	private JTextField priceField;
	private JTable tableFood;
	private JTextField textFieldSearch;
	private JTable orderTable;
	private JLayeredPane layeredPane_1;
	private JPanel panel1_1;
	private JPanel panelReport_1;
	private JPanel panelCashier_1;
	private JTextField textFieldOrder;
	private JTextField textFieldItemID;
	private JTextField startOrderField;
	private JLayeredPane layeredPane;
	private JTextField unitpriceField;
	private JTextField totalField;
	private JTextField totalSub;
	private JTextField textFieldItemName;
	private JTable amountTable;
	private JTextField textID;
	private JTextField textFieldpay;
	private JTextField textFieldbal;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodItem frame = new FoodItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel)
	{
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
		
	}

	/**
	 * Create the frame.
	 */
	public FoodItem() {
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1938, 1137);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 30, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Royal Resort");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(607, 23, 668, 91);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 127, 1864, 2);
		separator.setForeground(Color.BLACK);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(32, 23, 125, 105);
		lblNewLabel_1.setIcon(new ImageIcon(FoodItem.class.getResource("/Final/resthouse125-removebg-preview.png")));
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBounds(1766, 66, 105, 46);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(btnLogout);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(201, 128, 2, 870);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_1);
		
		JButton btnNewButton1 = new JButton("Manage Food Items");
		btnNewButton1.setBounds(12, 284, 177, 46);
		btnNewButton1.setFont(new Font("Calibri", Font.BOLD, 17));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				switchPanels(panel1_1);
			}
		});
		contentPane.add(btnNewButton1);
		
		JButton btnNewButton_1 = new JButton("Reports");
		btnNewButton_1.setBounds(12, 633, 177, 46);
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelReport_1);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Cashier");
		btnNewButton_3.setBounds(12, 460, 177, 46);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelCashier_1);
				
			}
		});
		btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 17));
		contentPane.add(btnNewButton_3);
		
		JLabel lblTopic;
		lblTopic = new JLabel("Restaurant");
		lblTopic.setForeground(Color.WHITE);
		lblTopic.setBounds(32, 142, 146, 38);
		lblTopic.setFont(new Font("Candara Light", Font.BOLD, 26));
		contentPane.add(lblTopic);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(215, 142, 1660, 834);
		contentPane.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		panel1_1 = new JPanel();
		
		panel1_1.setBackground(Color.LIGHT_GRAY);
		layeredPane_1.add(panel1_1, "name_288991673431100");
		panel1_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.WHITE);
		panel_3.setForeground(SystemColor.activeCaptionBorder);
		panel_3.setBounds(57, 47, 528, 681);
		panel1_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel foodNamelbl = new JLabel("Food Name");
		foodNamelbl.setFont(new Font("Calibri", Font.BOLD, 19));
		foodNamelbl.setBounds(83, 154, 93, 16);
		panel_3.add(foodNamelbl);
		
		foodNameField = new JTextField();
		foodNameField.setFont(new Font("Calibri", Font.PLAIN, 16));
		foodNameField.setBounds(232, 145, 207, 34);
		panel_3.add(foodNameField);
		foodNameField.setColumns(10);
		
		JLabel foodPricelbl = new JLabel("Price");
		foodPricelbl.setFont(new Font("Calibri", Font.BOLD, 19));
		foodPricelbl.setBounds(83, 232, 93, 16);
		panel_3.add(foodPricelbl);
		
		priceField = new JTextField();
		priceField.setFont(new Font("Calibri", Font.PLAIN, 16));
		priceField.setColumns(10);
		priceField.setBounds(232, 223, 207, 34);
		panel_3.add(priceField);
		
		JLabel categorylbl = new JLabel("Category");
		categorylbl.setFont(new Font("Calibri", Font.BOLD, 19));
		categorylbl.setBounds(83, 307, 93, 16);
		panel_3.add(categorylbl);
		
		Choice choice = new Choice();
		choice.setForeground(Color.BLACK);
		choice.setFont(new Font("Calibri", Font.PLAIN, 16));
		choice.setBackground(SystemColor.inactiveCaptionBorder);
		choice.setBounds(232, 301, 207, 26);
		panel_3.add(choice);
		choice.add("Short Eats");
		choice.add("Sweets");
		choice.add("Set Menu");
		choice.add("Rice And Curry");
		choice.add("Beverages");
		
		JLabel descriptionlbl = new JLabel("Description");
		descriptionlbl.setFont(new Font("Calibri", Font.BOLD, 19));
		descriptionlbl.setBounds(83, 376, 93, 16);
		panel_3.add(descriptionlbl);
		
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setFont(new Font("Calibri", Font.PLAIN, 16));
		descriptionArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		descriptionArea.setCaretColor(SystemColor.desktop);
		descriptionArea.setSelectedTextColor(SystemColor.window);
		descriptionArea.setDisabledTextColor(SystemColor.activeCaptionBorder);
		descriptionArea.setBackground(SystemColor.window);
		descriptionArea.setBounds(232, 373, 207, 83);
		panel_3.add(descriptionArea);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String foodName = foodNameField.getText();
				double fprice = Double.parseDouble(priceField.getText());
				String fCategory = choice.getSelectedItem();
				String fDes = descriptionArea.getText();
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

                    String query = "INSERT INTO fooditems values(000,'" + foodName + "','" + fprice + "','" + fCategory + "','" + fDes + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    
                    
                    
                    connection.close();
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from fooditems";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    tableFood.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				foodNameField.setText("");
				priceField.setText("");
				
				descriptionArea.setText("");
				
				
			}
			
			
		});
		addBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		addBtn.setBounds(40, 559, 112, 39);
		panel_3.add(addBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = tableFood.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableFood.getModel();
				String id = (model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "DELETE FROM fooditems WHERE foodid = "+id;
                    PreparedStatement sta = connection.prepareStatement(query);
                    int rss = sta.executeUpdate(query);
					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
				}
				
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from fooditems";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    tableFood.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				foodNameField.setText("");
				priceField.setText("");
				
				descriptionArea.setText("");
			}
		});
		deleteBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		deleteBtn.setBounds(370, 559, 112, 39);
		panel_3.add(deleteBtn);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow=tableFood.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) tableFood.getModel();
				String id=(model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
                    String sqlq = "update fooditems set foodname = '"+foodNameField.getText()+"',price = '"+priceField.getText()+"',category = '"+choice.getSelectedItem()+"',fdescription = '"+descriptionArea.getText()+"'where foodid = "+id;

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(sqlq);
                    
                    connection.close();
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				try {
					
					
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement", "root", "shehani123@98");
                    String query = "select * from fooditems";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    tableFood.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				
			}
		});
		updateBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		updateBtn.setBounds(201, 559, 117, 39);
		panel_3.add(updateBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Add, Update Food Details");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(131, 26, 249, 32);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 23));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 2));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(695, 217, 885, 434);
		panel1_1.add(scrollPane);
		
		tableFood = new JTable();
		tableFood.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Food ID", "Food Name", "Price", "Category", "Description"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Float.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    Statement sta = connection.createStatement();
                    int row = tableFood.getSelectedRow();
    				String selection = tableFood.getModel().getValueAt(row, 0).toString();
                    String sqlquery = "select * from fooditems where foodid = "+selection;
                    ResultSet rs1 = sta.executeQuery(sqlquery);
                    
                    if(rs1.next()) {
                    	
                    	//textFieldfID.setText(rs1.getString("foodid"));
                    	foodNameField.setText(rs1.getString("foodname"));
                    	priceField.setText(rs1.getString("price"));
                    	choice.getSelectedItem();
                    	descriptionArea.setText(rs1.getString("fdescription"));
                    	
                    }
                    
			}
				catch(Exception exe) {
					exe.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(tableFood);
		
		JButton loadBtn = new JButton("Load Details");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from fooditems";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    tableFood.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			
			}
		});
		loadBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		loadBtn.setBounds(1445, 142, 135, 39);
		panel1_1.add(loadBtn);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Calibri", Font.BOLD, 18));
		searchBtn.setBounds(1522, 30, 90, 39);
		panel1_1.add(searchBtn);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Calibri", Font.PLAIN, 17));
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from fooditems where foodname =?";
                    PreparedStatement stat = (PreparedStatement) connection.prepareStatement(query);
                    stat.setNString(1,textFieldSearch.getText());
                    ResultSet rS = stat.executeQuery();
                    
                    tableFood.setModel(DbUtils.resultSetToTableModel(rS));
                    stat.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			
			}
			
		});
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(1285, 32, 207, 34);
		panel1_1.add(textFieldSearch);
		
		panelCashier_1 = new JPanel();
		panelCashier_1.setBackground(Color.LIGHT_GRAY);
		layeredPane_1.add(panelCashier_1, "name_289000141486100");
		panelCashier_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(481, 55, 538, 130);
		panelCashier_1.add(scrollPane_1);
		
		orderTable = new JTable();
		orderTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		orderTable.setGridColor(Color.WHITE);
		orderTable.setBackground(Color.WHITE);
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID", "Order Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		orderTable.addMouseListener(new MouseAdapter() {
			
			private Component panelOrder;
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = orderTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
				
				startOrderField.setText(model.getValueAt(row, 0).toString());
				textFieldOrder.setText(model.getValueAt(row, 0).toString());
				
				//layeredPane.removeAll();
				//layeredPane.add(panelOrder);
				//layeredPane.repaint();
				//layeredPane.revalidate();
				
				
			}
		});
		scrollPane_1.setViewportView(orderTable);
		
		JLabel datelbl = new JLabel("Date");
		datelbl.setBounds(49, 69, 56, 16);
		datelbl.setFont(new Font("Calibri", Font.BOLD, 17));
		panelCashier_1.add(datelbl);
		
		startOrderField = new JTextField();
		startOrderField.setBounds(1031, 147, 35, 36);
		panelCashier_1.add(startOrderField);
		startOrderField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel Order");
		btnCancel.setBounds(1031, 55, 134, 43);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = orderTable.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
				String id = (model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

                    String query = "DELETE FROM order1 WHERE orderid = "+id;

                    PreparedStatement sta = connection.prepareStatement(query);
                    int rss = sta.executeUpdate(query);
					
					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
				}
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from order1";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    orderTable.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 18));
		panelCashier_1.add(btnCancel);
		
		JPanel panelOrder = new JPanel();
		panelOrder.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelOrder.setBackground(Color.WHITE);
		panelOrder.setBounds(49, 231, 365, 484);
		panelCashier_1.add(panelOrder);
		panelOrder.setLayout(null);
		
		JSpinner txtqty = new JSpinner();
		txtqty.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { 
				
				int qty = Integer.parseInt(txtqty.getValue().toString());
				float price = Float.parseFloat(unitpriceField.getText());
				
				float total = qty*price;
				
				totalSub.setText(String.valueOf(total));
				
			}
		});
		txtqty.setBounds(154, 236, 166, 22);
		panelOrder.add(txtqty);

		
		JLabel orderidlabel = new JLabel("Order ID");
		orderidlabel.setFont(new Font("Calibri", Font.BOLD, 17));
		orderidlabel.setBounds(35, 50, 76, 16);
		panelOrder.add(orderidlabel);
		
		textFieldOrder = new JTextField();
		textFieldOrder.setFont(new Font("Calibri", Font.PLAIN, 16));
		textFieldOrder.setBounds(154, 36, 166, 32);
		panelOrder.add(textFieldOrder);
		textFieldOrder.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Calibri", Font.BOLD, 17));
		lblItemName.setBounds(35, 106, 92, 16);
		panelOrder.add(lblItemName);
		
		JLabel unitPrice = new JLabel("Unit Price");
		unitPrice.setFont(new Font("Calibri", Font.BOLD, 17));
		unitPrice.setBounds(35, 301, 76, 16);
		panelOrder.add(unitPrice);
		
		textFieldItemID = new JTextField();
		textFieldItemID.setFont(new Font("Calibri", Font.PLAIN, 16));
		textFieldItemID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				
				if(evt.getKeyCode() == KeyEvent.VK_ENTER)
		        {
		            String itemcode = textFieldItemName.getText();   
		            try {
		                
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
		                PreparedStatement pst= connection.prepareStatement("select * from fooditems where foodid = ?");
		                pst.setString(1, itemcode);
		                ResultSet rs = pst.executeQuery();
		                
		                if(rs.next() == false)
		                {     
		                    JOptionPane.showInputDialog(this, "Item ID not found");
		                }
		                else
		                {
		                    String fname = rs.getString("foodid");
		                    String fprice = rs.getString("price");
		                    textFieldItemID.setText(fname.trim());
		                    unitpriceField.setText(fprice.trim());
		                }
		            } catch (Exception ex) {

		            		ex.printStackTrace();
		            } 
		        }
				
				
			}
		});
		textFieldItemID.setColumns(10);
		textFieldItemID.setBounds(154, 161, 166, 32);
		panelOrder.add(textFieldItemID);
		
		JButton btnAddOrder = new JButton("Add");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = new DefaultTableModel();
			        model = (DefaultTableModel)amountTable.getModel();
			        
					model.addRow(new Object[] {
			        		
			        		textFieldOrder.getText(),
			        		textFieldItemID.getText(),
			        		textFieldItemName.getText(),
			        		txtqty.getValue().toString(),
			        		unitpriceField.getText(),
			        		totalSub.getText(),
			        });
			        
			        float sum = 0;
			        
			        for(int i =0; i<amountTable.getRowCount();i++) {
			        	
			        	sum = sum + Float.parseFloat(amountTable.getValueAt(i, 5).toString());
			        	
			        	totalField.setText(Float.toString(sum));
			        }
			        
			        int foodid = Integer.parseInt(textFieldItemID.getText());
			        int orderid = Integer.parseInt(textFieldOrder.getText());
			        int qty = (int) txtqty.getValue();
					double fprice = Double.parseDouble(totalSub.getText());
					
					
					try {
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	                    String query = "INSERT INTO foodorder values('" + foodid + "','" + orderid + "','" + qty + "','" + fprice + "')";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    
	                    connection.close();
	                } catch (Exception exception) {
	                	
	                    exception.printStackTrace();
	                }
					
					textFieldItemName.setText("");
					textFieldItemID.setText("");					
					unitpriceField.setText("");
					totalSub.setText("");
			        
			        
				
			}
		});
		btnAddOrder.setFont(new Font("Calibri", Font.BOLD, 17));
		btnAddOrder.setBounds(244, 421, 76, 39);
		panelOrder.add(btnAddOrder);
		
		unitpriceField = new JTextField();
		unitpriceField.setFont(new Font("Calibri", Font.PLAIN, 16));
		unitpriceField.setColumns(10);
		unitpriceField.setBounds(154, 292, 166, 32);
		panelOrder.add(unitpriceField);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Calibri", Font.BOLD, 17));
		lblQuantity.setBounds(35, 240, 76, 16);
		panelOrder.add(lblQuantity);
		
		JLabel totalOrder = new JLabel("Total Amount");
		totalOrder.setFont(new Font("Calibri", Font.BOLD, 17));
		totalOrder.setBounds(35, 358, 104, 16);
		panelOrder.add(totalOrder);
		
		totalSub = new JTextField();
		totalSub.setFont(new Font("Calibri", Font.PLAIN, 16));
		totalSub.setColumns(10);
		totalSub.setBounds(154, 349, 166, 32);
		panelOrder.add(totalSub);
		
		
		
		textFieldItemName = new JTextField();
		textFieldItemName.setFont(new Font("Calibri", Font.PLAIN, 16));
		textFieldItemName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
		        {
		            String itemcode = textFieldItemName.getText();   
		            try {
		                
				         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
		                PreparedStatement pst= connection.prepareStatement("select * from fooditems where foodname = ?");
		                pst.setString(1, itemcode);
		                ResultSet rs = pst.executeQuery();
		                
		                if(rs.next() == false)
		                {     
		                    JOptionPane.showInputDialog(this, "Item ID not found");
		                }
		                else
		                {
		                    String fname = rs.getString("foodid");
		                    String fprice = rs.getString("price");
		                    textFieldItemID.setText(fname.trim());
		                    unitpriceField.setText(fprice.trim());
		                }
		            } catch (Exception ex) {

		            		ex.printStackTrace();
		            } 
		        }
			}
		});
		textFieldItemName.setColumns(10);
		textFieldItemName.setBounds(154, 97, 166, 32);
		panelOrder.add(textFieldItemName);
		
		JLabel lblItemNameID = new JLabel("Item ID");
		lblItemNameID.setFont(new Font("Calibri", Font.BOLD, 17));
		lblItemNameID.setBounds(35, 170, 92, 16);
		panelOrder.add(lblItemNameID);
		
		textFieldpay = new JTextField();
		textFieldpay.setLocation(new Point(20, 0));
		textFieldpay.setForeground(Color.RED);
		textFieldpay.setFont(new Font("Calibri", Font.BOLD, 30));
		textFieldpay.setColumns(10);
		textFieldpay.setBounds(1005, 538, 166, 32);
		panelCashier_1.add(textFieldpay);
		
		textFieldbal = new JTextField();
		textFieldbal.setLocation(new Point(20, 0));
		textFieldbal.setForeground(Color.RED);
		textFieldbal.setFont(new Font("Calibri", Font.BOLD, 30));
		textFieldbal.setColumns(10);
		textFieldbal.setBounds(1005, 610, 166, 32);
		panelCashier_1.add(textFieldbal);
		
		JTextArea textAreaBill = new JTextArea();
		textAreaBill.setBorder(new CompoundBorder(null, new LineBorder(new Color(0, 0, 0))));
		textAreaBill.setFont(new Font("Calibri", Font.PLAIN, 16));
		textAreaBill.setBounds(1240, 231, 380, 450);
		panelCashier_1.add(textAreaBill);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(101, 55, 167, 35);
		panelCashier_1.add(dateChooser);
		
				
		JButton billBtn = new JButton("Print Bill");
		billBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

	                    PreparedStatement sthl = (PreparedStatement) connection.prepareStatement("insert into bill(orderid,total) values (?,?) ");
	                    sthl.setString(1, textFieldOrder.getText());
	                    sthl.setString(2, totalField.getText());
	                  
	                    sthl.execute();	                    
	                   
	                    
				 } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
				
				float total = Float.parseFloat(totalField.getText());
				float pay = Float.parseFloat(textFieldpay.getText());
				float bal = pay-total;
				
				textFieldbal.setText(String.valueOf(bal));
				
				String total1 = totalField.getText();
		        String pay1 = textFieldpay.getText();
		        String bal1 = textFieldbal.getText();
		        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		        String date = sdf.format(dateChooser.getDate()); 
		        
		        
		        DefaultTableModel model = new DefaultTableModel();
		        model = (DefaultTableModel)amountTable.getModel();
		        
		        textAreaBill.setText(textAreaBill.getText() + "*********************************************************************************\n");
		        textAreaBill.setText(textAreaBill.getText() + "                              Royal Resort Restaurant                       \n");
		        textAreaBill.setText(textAreaBill.getText() + "*********************************************************************************\n\n\n");
		        textAreaBill.setText(textAreaBill.getText() + "\t" + "\t" + "            Date : " + date + "\n\n\n");
				
		        textAreaBill.setText(textAreaBill.getText() + "Item" + "\t" + "Price" + "\t" + "Total" + "\n\n"  );
		        
		        for(int i = 0; i < model.getRowCount(); i++)
		          {
		              
		              String fname = (String)model.getValueAt(i, 1);
		              String fprice = (String)model.getValueAt(i, 3);
		              String famount = (String)model.getValueAt(i, 4); 
		              
		           textAreaBill.setText(textAreaBill.getText() +   fname  + "\t" + fprice + "\t" + famount  + "\n"  );
		    
		          }
		        
		        textAreaBill.setText(textAreaBill.getText() + "\n\n");     
		          
		        textAreaBill.setText(textAreaBill.getText() + "\t" + "\t" + "            Subtotal : " + total1 + "\n");
		        textAreaBill.setText(textAreaBill.getText() + "\t" + "\t" + "            Pay        : " + pay1 + "\n");
		        textAreaBill.setText(textAreaBill.getText() + "\t" + "\t" + "            Balance : " + bal1 + "\n");
		        textAreaBill.setText(textAreaBill.getText() + "\n");
		        textAreaBill.setText(textAreaBill.getText() + "*********************************************************************************\n");
		        textAreaBill.setText(textAreaBill.getText() + "                                     Thank You                       \n");
				
				
			}
		});
		billBtn.setBounds(1005, 672, 166, 43);
		billBtn.setFont(new Font("Calibri", Font.BOLD, 19));
		panelCashier_1.add(billBtn);
		
		
		
		JButton goBtn = new JButton("Make Order");
		goBtn.setBounds(280, 55, 134, 35);
		goBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                String query = "INSERT INTO order1 (orderdate) values(?)";
                PreparedStatement pst = connection.prepareStatement(query);
				
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
				String date = sdf.format(dateChooser.getDate());
				pst.setString(1, date);
				
				int data = pst.executeUpdate();
				if(data>0)
				{
					JOptionPane.showMessageDialog(null, "Order Started");
				}
				else {
					JOptionPane.showInternalMessageDialog(null, "can't insert data");
				}
				
				
			}
				catch(Exception exep)
				{
					exep.printStackTrace();
				}
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from order1";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    orderTable.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		goBtn.setFont(new Font("Calibri", Font.BOLD, 17));
		panelCashier_1.add(goBtn);
		
		totalField = new JTextField();
		totalField.setLocation(new Point(20, 0));
		totalField.setForeground(Color.RED);
		totalField.setFont(new Font("Calibri", Font.BOLD, 30));
		totalField.setBounds(627, 538, 166, 32);
		totalField.setColumns(10);
		panelCashier_1.add(totalField);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		scrollPane_2.setBounds(481, 269, 690, 246);
		panelCashier_1.add(scrollPane_2);
		
		amountTable = new JTable();
		amountTable.setFont(new Font("Calibri", Font.PLAIN, 16));
		amountTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID", "Food ID", "Food Name", "Quantity", "Unit Price", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(amountTable);
		
		JLabel totLbl = new JLabel("Sub Total");
		totLbl.setFont(new Font("Calibri", Font.BOLD, 30));
		totLbl.setBounds(481, 542, 124, 24);
		panelCashier_1.add(totLbl);
		
		
		
		JLabel lblPay = new JLabel("Pay");
		lblPay.setFont(new Font("Calibri", Font.BOLD, 30));
		lblPay.setBounds(869, 542, 124, 24);
		panelCashier_1.add(lblPay);
		
		
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Calibri", Font.BOLD, 30));
		lblBalance.setBounds(869, 610, 124, 24);
		panelCashier_1.add(lblBalance);
		
		JButton endBtn = new JButton("End");
		endBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = new DefaultTableModel();
		        model = (DefaultTableModel)amountTable.getModel();
		        
		        model.setNumRows(0);
		        totalField.setText("");
		        textFieldpay.setText("");
		        textFieldbal.setText("");
		        textAreaBill.setText("");
		        
				
			}
		});
		endBtn.setFont(new Font("Calibri", Font.BOLD, 19));
		endBtn.setBounds(1005, 745, 166, 43);
		panelCashier_1.add(endBtn);
		
		
		
		panelReport_1 = new JPanel();
		panelReport_1.setDoubleBuffered(false);
		panelReport_1.setBackground(Color.LIGHT_GRAY);
		layeredPane_1.add(panelReport_1, "name_289003973233700");
		panelReport_1.setLayout(null);
		
		JLabel report = new JLabel("Report");
		report.setBounds(727, 45, 88, 31);
		report.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 28));
		panelReport_1.add(report);
		
		JLabel lblfrom = new JLabel("Order ID");
		lblfrom.setBounds(1036, 126, 88, 16);
		lblfrom.setFont(new Font("Calibri", Font.BOLD, 20));
		panelReport_1.add(lblfrom);
		
		JPanel reportPanl = new JPanel();
		reportPanl.setBounds(268, 191, 996, 564);
		reportPanl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelReport_1.add(reportPanl);
		
		JButton btnFind = new JButton("Generate");
		btnFind.setBounds(1297, 116, 112, 36);
		btnFind.addActionListener(new ActionListener() {
			
			Connection connection;
			
			public void actionPerformed(ActionEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
	                
					}
					catch(Exception exep)
					{
						exep.printStackTrace();
					}
				
				HashMap aHashMap = new HashMap();
				aHashMap.put("orderID", textID.getText());
				
				reportPanl.removeAll();
				reportPanl.repaint();
				reportPanl.revalidate();
				
				try {
					JasperDesign jDesign = JRXmlLoader.load("H:\\SLIIT\\2 year\\sem 2\\ITP\\itp\\kitchenRestaurant\\src\\restaurant\\report.jrxml");
					JasperReport jReport = JasperCompileManager.compileReport(jDesign);
					JasperPrint jPrint = JasperFillManager.fillReport(jReport, aHashMap, connection);
					
					JRViewer v = new JRViewer(jPrint);
					reportPanl.setLayout(new BorderLayout());
					reportPanl.add(v);
					} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnFind.setFont(new Font("Calibri", Font.BOLD, 18));
		panelReport_1.add(btnFind);
		
		textID = new JTextField();
		textID.setBounds(1123, 122, 141, 24);
		panelReport_1.add(textID);
		textID.setColumns(10);
		
		
		}
}
