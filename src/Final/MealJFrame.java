package Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;


public class MealJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField mNameField;
	private JTextField MPriceField;
	private JTextField mealSearchField;
	private JButton btnNewAdd;
	private JButton btnNewSearch;
	private JButton btnNewMeal;
	private JLabel lblAddMealPlan;
	private JTable tableMeal;
	private JTextField mDesArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MealJFrame frame = new MealJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MealJFrame() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1577, 975);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 30, 46));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 128, 1871, 1);
		separator.setForeground(Color.LIGHT_GRAY);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Reset.class.getResource("/Final/resthouse125-removebg-preview.png")));
		lblNewLabel_1.setBounds(33, 13, 125, 105);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogoutk = new JButton("LOGOUT");
		btnLogoutk.setBounds(1430, 42, 105, 46);
		btnLogoutk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogoutk.setFont(new Font("Calibri", Font.BOLD, 16));
		contentPane.add(btnLogoutk);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(201, 128, 2, 787);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_1);
		
		JButton btnNewButton;
		btnNewMeal = new JButton("Manage Meal Plans");
		btnNewMeal.setBounds(12, 269, 177, 46);
		btnNewMeal.setFont(new Font("Calibri", Font.BOLD, 17));
		btnNewMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewMeal);
		
		JLabel lblAddMealPlan_1;
		
		JButton btnNewButton_1;
		
		JLabel lblKitchen = new JLabel("Kitchen");
		lblKitchen.setForeground(SystemColor.window);
		lblKitchen.setBounds(43, 142, 105, 35);
		lblKitchen.setFont(new Font("Candara Light", Font.BOLD, 24));
		contentPane.add(lblKitchen);
		
		JLabel lblNewLabel_2 = new JLabel("Royal Resort");
		lblNewLabel_2.setBounds(556, 13, 668, 91);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Algerian", Font.BOLD, 70));
		contentPane.add(lblNewLabel_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(225, 142, 1300, 748);
		layeredPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(layeredPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 1321, 748);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		btnNewSearch = new JButton("Search");
		btnNewSearch.setBounds(1163, 73, 105, 35);
		panel_1.add(btnNewSearch);
		btnNewSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewSearch.setFont(new Font("Calibri", Font.BOLD, 20));
		
		mealSearchField = new JTextField();
		mealSearchField.setBounds(973, 73, 165, 35);
		panel_1.add(mealSearchField);
		mealSearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from mealplan where mealname =?";
                    PreparedStatement stat = (PreparedStatement) connection.prepareStatement(query);
                    stat.setNString(1,mealSearchField.getText());
                    ResultSet rS = stat.executeQuery();
                    
                    tableMeal.setModel(DbUtils.resultSetToTableModel(rS));
                    stat.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			
			}
			
		});
		mealSearchField.setColumns(10);
		
		JButton btnLoad = new JButton("Load Details");
		btnLoad.setBounds(1106, 150, 162, 40);
		panel_1.add(btnLoad);
		btnLoad.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(523, 224, 745, 452);
		panel_1.add(scrollPane);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		tableMeal = new JTable();
		tableMeal.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Meal ID", "Meal Name", "Price", "Description"
			}
		) {
			Class[] columnTypes = new Class[] {
				Float.class, String.class, Float.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow1 = tableMeal.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)tableMeal.getModel();
				
				//MealIDField.setText(model.getValueAt(selectedRow1, 0).toString());
				mNameField.setText(model.getValueAt(selectedRow1, 1).toString());
				MPriceField.setText(model.getValueAt(selectedRow1, 2).toString());
				mDesArea.setText(model.getValueAt(selectedRow1, 3).toString());
				
			}
		});
		scrollPane.setViewportView(tableMeal);
		tableMeal.setSelectionForeground(new Color(0, 0, 0));
		tableMeal.setBackground(SystemColor.menu);
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 83, 417, 606);
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Meal Plan Name");
		lblNewLabel_2_1.setBounds(32, 138, 120, 20);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Price");
		lblNewLabel_2_1_1.setBounds(32, 220, 120, 20);
		panel.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Calibri", Font.BOLD, 17));
		
		mNameField = new JTextField();
		mNameField.setBounds(164, 130, 210, 35);
		panel.add(mNameField);
		mNameField.setColumns(10);
		
		MPriceField = new JTextField();
		MPriceField.setBounds(164, 212, 210, 35);
		panel.add(MPriceField);
		MPriceField.setColumns(10);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Description");
		lblNewLabel_2_1_2.setBounds(32, 295, 120, 20);
		panel.add(lblNewLabel_2_1_2);
		lblNewLabel_2_1_2.setFont(new Font("Calibri", Font.BOLD, 17));
		
		mDesArea = new JTextField();
		mDesArea.setBounds(164, 295, 210, 91);
		panel.add(mDesArea);
		mDesArea.setColumns(10);
		btnNewAdd = new JButton("ADD");
		btnNewAdd.setForeground(SystemColor.desktop);
		btnNewAdd.setBounds(32, 474, 71, 37);
		panel.add(btnNewAdd);
		btnNewAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String mealName = mNameField.getText();
				double mealprice = Double.parseDouble(MPriceField.getText());
				String mfDes = mDesArea.getText();
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");

                    String query = "INSERT INTO mealplan values(000,'" + mealName + "','" + mealprice + "','" + mfDes + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    
                    connection.close();
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from mealplan";
                    Statement sta = connection.createStatement();
                    ResultSet rs = sta.executeQuery(query);
                    
                    tableMeal.setModel(DbUtils.resultSetToTableModel(rs));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				mNameField.setText("");
				MPriceField.setText("");
				mDesArea.setText("");
			}
			
		});
		btnNewAdd.setBackground(SystemColor.inactiveCaption);
		btnNewAdd.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(157, 474, 92, 37);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow=tableMeal.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) tableMeal.getModel();
				String id=(model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
					
                    String sqlq = "update mealplan set mealname = '"+mNameField.getText()+"',price = '"+MPriceField.getText()+"',description1 = '"+mDesArea.getText()+"'where mealid = "+id;

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(sqlq);
                    
                    connection.close();
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from mealplan";
                    Statement sta = connection.createStatement();
                    ResultSet rs = sta.executeQuery(query);
                    
                    tableMeal.setModel(DbUtils.resultSetToTableModel(rs));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 18));
		btnUpdate.setBackground(SystemColor.inactiveCaption);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(298, 474, 86, 37);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = tableMeal.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableMeal.getModel();
				String id = (model.getValueAt(selectedRow, 0).toString());
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "DELETE FROM mealplan WHERE mealid = "+id;
                    PreparedStatement stat = connection.prepareStatement(query);
                    int rss = stat.executeUpdate(query);
					
					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
				}
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from mealplan";
                    Statement sta = connection.createStatement();
                    ResultSet rs = sta.executeQuery(query);
                    
                    tableMeal.setModel(DbUtils.resultSetToTableModel(rs));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
				
				
				mNameField.setText("");
				MPriceField.setText("");
				mDesArea.setText("");
				
				
				
				
			}
		});
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 18));
		btnDelete.setBackground(SystemColor.inactiveCaption);
		lblAddMealPlan_1 = new JLabel("Add, Update Meal Plan");
		lblAddMealPlan_1.setBounds(101, 24, 210, 44);
		panel.add(lblAddMealPlan_1);
		lblAddMealPlan_1.setFont(new Font("Calibri", Font.BOLD, 21));
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement?useSSL=false", "root", "root");
                    String query = "select * from mealplan";
                    Statement sta = connection.createStatement();
                    ResultSet rs = sta.executeQuery(query);
                    
                    tableMeal.setModel(DbUtils.resultSetToTableModel(rs));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
				 
			
		});
		
		
		
		
	}
}
