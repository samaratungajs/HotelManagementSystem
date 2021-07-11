package Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login extends JFrame {

	private JPanel contentPane;
  
	//private static final long serialVersionUID = 1 L;
	private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		JLabel background;
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1409, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	     
	     JLabel lblNewLabel_5 = new JLabel("Forgot Password?");
	     lblNewLabel_5.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent arg0) {
	     		
	     		  dispose();
                  Reset r = new Reset();
                  r.setTitle("Welcome");
                  r.setVisible(true);
	     		
	     	}
	     });
	     lblNewLabel_5.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
	     lblNewLabel_5.setBounds(607, 593, 122, 22);
	     contentPane.add(lblNewLabel_5);
	     
	     JLabel lblNewLabel_4 = new JLabel("New label");
	     lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/Final/resthouse125-removebg-preview.png")));
	     lblNewLabel_4.setBounds(607, 36, 129, 121);
	     contentPane.add(lblNewLabel_4);
		
	     JLabel lblNewLabel = new JLabel("Login");
	        lblNewLabel.setForeground(Color.BLACK);
	        lblNewLabel.setFont(new Font("Colonna MT", Font.BOLD, 42));
	        lblNewLabel.setBounds(607, 201, 273, 93);
	        contentPane.add(lblNewLabel);

	        textField = new JTextField();
	        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        textField.setBounds(648, 327, 232, 52);
	        contentPane.add(textField);
	        textField.setColumns(10);

	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField.setBounds(648, 421, 232, 52);
	        contentPane.add(passwordField);

	        JLabel lblUsername = new JLabel("Username");
	        lblUsername.setBackground(Color.BLACK);
	        lblUsername.setForeground(Color.BLACK);
	        lblUsername.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
	        lblUsername.setBounds(445, 330, 193, 52);
	        contentPane.add(lblUsername);

	        JLabel lblPassword = new JLabel("Password");
	        lblPassword.setForeground(Color.BLACK);
	        lblPassword.setBackground(Color.CYAN);
	        lblPassword.setFont(new Font("Mongolian Baiti", Font.BOLD, 27));
	        lblPassword.setBounds(445, 425, 193, 52);
	        contentPane.add(lblPassword);

	        btnNewButton = new JButton("Login");
	        btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 23));
	        btnNewButton.setBounds(607, 507, 108, 52);
	        btnNewButton.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                String userName = textField.getText();
	                String password = passwordField.getText();
	                String type="Admin";
	                try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");
	                    PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("Select username, password,usertype from user where username=? and password=?");

	                    st.setString(1, userName);
	                    st.setString(2, password);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                    String t =  rs.getString("usertype");
	                    
	                        if(t.equalsIgnoreCase("Admin") ) {
	                        	  dispose();
	                        Rooms ah = new Rooms();
	                        ah.setTitle("Rooms");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                       else if(t.equalsIgnoreCase("Receptionist") ) {
	                        	  dispose();
	                        hotel1 ah = new hotel1();
	                        ah.setTitle("Room Reservation");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                       else if(t.equalsIgnoreCase("Inventory manger") ) {
	                        	  dispose();
	                        	  Permanent ah = new Permanent();
	                        ah.setTitle("Inventory");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                       else if(t.equalsIgnoreCase("Kitchen manger") ) {
	                        	  dispose();
	                        	  MealJFrame  ah = new MealJFrame();
	                        ah.setTitle("Meal");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                       else if(t.equalsIgnoreCase("Restaurentcashier") ) {
	                        	  dispose();
	                        	  FoodItem  ah = new FoodItem();
	                        ah.setTitle("Restuarant");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                       else if(t.equalsIgnoreCase("Hall manager") ) {
	                        	  dispose();
	                        	  MainWindow  ah = new MainWindow();
	                        ah.setTitle("Restuarant");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                       else if(t.equalsIgnoreCase("Bartender") ) {
	                        	  dispose();
	                        	  Bar  ah = new Bar();
	                        ah.setTitle("Bar");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                       else if(t.equalsIgnoreCase("HR manger") ) {
	                        	  dispose();
	                        	  Employee  ah = new Employee();
	                        ah.setTitle("HR Manager");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        }
	                        
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            }
	        });
	        contentPane.add(btnNewButton);
	        
	        lblNewLabel_3 = new JLabel("Royal Resort");
	        lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
	        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_3.setOpaque(true);
	        lblNewLabel_3.setFont(new Font("Colonna MT", Font.BOLD, 45));
	        lblNewLabel_3.setBounds(336, 182, 660, 112);
	        contentPane.add(lblNewLabel_3);
	        
	        lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setBackground(new Color(230, 230, 250));
	        lblNewLabel_2.setOpaque(true);
	        lblNewLabel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	        lblNewLabel_2.setBounds(336, 188, 660, 452);
	        contentPane.add(lblNewLabel_2);
	        
	        
	        
	        JLabel lblNewLabel_1 = new JLabel("");
	        lblNewLabel_1.setOpaque(true);
	        lblNewLabel_1.setBackground(new Color(0, 30, 46));
	        lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_1.setBounds(0, 0, 1547, 781);
	        lblNewLabel_1.setBorder(null);
	        contentPane.add(lblNewLabel_1);
		
		
		setVisible(true);
	}
}
