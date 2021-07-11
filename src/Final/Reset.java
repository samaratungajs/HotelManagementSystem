package Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Reset extends JFrame {

	private JPanel contentPane;
	private JTextField secq1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField secq2;
	private JLabel error;
	private JTextField uname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset frame = new Reset();
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
	public Reset() {
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1409, 923);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 30, 46));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
                 Login ah = new Login();
                 ah.setTitle("Welcome");
                 ah.setVisible(true);
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(713, 597, 133, 29);
		panel.add(btnLogin);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Reset.class.getResource("/Final/resthouse125-removebg-preview.png")));
		label_2.setBounds(637, 68, 113, 91);
		panel.add(label_2);
		
		error = new JLabel("");
		error.setFont(new Font("Tahoma", Font.BOLD, 11));
		error.setForeground(new Color(255, 51, 51));
		error.setBounds(728, 462, 153, 14);
		panel.add(error);
		
		secq2 = new JTextField();
		secq2.setColumns(10);
		secq2.setBounds(703, 438, 119, 20);
		panel.add(secq2);
		
		JLabel lblWhoIsYour = new JLabel("Who is your favorite super hero?");
		lblWhoIsYour.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblWhoIsYour.setBounds(485, 430, 208, 35);
		panel.add(lblWhoIsYour);
		
		JLabel lblAnswerTheSecurity = new JLabel("Answer the security questions ");
		lblAnswerTheSecurity.setFont(new Font("Georgia", Font.BOLD, 13));
		lblAnswerTheSecurity.setBounds(571, 362, 251, 35);
		panel.add(lblAnswerTheSecurity);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(703, 532, 119, 20);
		panel.add(passwordField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(703, 491, 119, 20);
		panel.add(passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(571, 520, 119, 42);
		panel.add(lblConfirmPassword);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNewPassword.setBounds(571, 479, 113, 42);
		panel.add(lblNewPassword);
		
		JButton btnNewButton = new JButton("Reset password");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String userName = uname.getText();
				String secque1 = secq1.getText();
				String secque2 = secq2.getText();
	
				 try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root", "1998Jayamini");

	                    PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("Select username, password,secq1,secq2 from user where username=? ");

	                    st.setString(1, userName);
	                  
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                    String q1 =  rs.getString("secq1");
	                    String q2 =  rs.getString("secq2");
	                  //  String psw =  rs.getString("password");

	                   

	                        	 if(uname.getText().isEmpty()) {
	                        		 error.setText("username is required");

	  		                   } else if(secq1.getText().isEmpty()) {
	                        		 error.setText("question1 is required");

	  		                   } else if(secq2.getText().isEmpty()) {
	                        		 error.setText("question2 is required");

	  		                   }
	                        	 else if(passwordField.getText().isEmpty()) {
	                        		 error.setText("password is required");

	  		                   }else if(passwordField_1.getText().isEmpty()) {
	  		                	 error.setText("confirm your password");

	  		                   }
	  		                   else if(!passwordField.getText().equals(passwordField_1.getText())) {
	  		                	 error.setText("Password fields mismatch");
	  		                   
	  		                   }
	  						   else{	
	  							 if(q1.equalsIgnoreCase(secque1) && q2.equalsIgnoreCase(secque2) ) {
	  								 PreparedStatement stu = (PreparedStatement) connection.prepareStatement("UPDATE user SET password=? where username=?");
	  			                   	 stu.setString(1, passwordField.getText());
	  			                   	 stu.setString(2, uname.getText());
		                        	
	                        	 stu.executeUpdate();	                        	 	                        	 
	                        	  dispose();
	                        Login ah = new Login();
	                        ah.setTitle("Welcome");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "Password successfully changed");
	  							 }
	  							 else {
	 		                        JOptionPane.showMessageDialog(btnNewButton, "Incorrect answers");
	 		                    }

	  						   }
	                        
	                         }
	                       		                } catch (SQLException sqlException) {
		                    sqlException.printStackTrace();
		                }
				
				
				
			}
		});
		btnNewButton.setBounds(549, 597, 133, 29);
		panel.add(btnNewButton);
		
		secq1 = new JTextField();
		secq1.setBounds(703, 400, 119, 20);
		panel.add(secq1);
		secq1.setColumns(10);
		
		uname = new JTextField();
		uname.setBounds(703, 331, 119, 20);
		panel.add(uname);
		uname.setColumns(10);
		
		JLabel lblWhatIsYour = new JLabel("What is your first school name?");
		lblWhatIsYour.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblWhatIsYour.setBounds(485, 392, 208, 35);
		panel.add(lblWhatIsYour);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 13));
		lblNewLabel.setBounds(581, 320, 98, 42);
		panel.add(lblNewLabel);
		
		JLabel lblResetPassword = new JLabel("Reset Password");
		lblResetPassword.setOpaque(true);
		lblResetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblResetPassword.setFont(new Font("Century Schoolbook", Font.BOLD, 30));
		lblResetPassword.setBounds(360, 185, 660, 126);
		panel.add(lblResetPassword);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		label_1.setBackground(new Color(230, 230, 250));
		label_1.setBounds(360, 185, 660, 461);
		panel.add(label_1);
	}
}
