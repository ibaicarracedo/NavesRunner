package PanelesYVentanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Space Runner Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setText("User");
		txtUser.setBounds(460, 80, 156, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(460, 122, 156, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame game = new GameFrame();
				dispose();
			}
		});
		btnLogin.setBounds(480, 164, 115, 29);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() { // ABrimos ventana registro y hacemos lo que tengamos que hacer
			public void actionPerformed(ActionEvent arg0) {
				JFrame registerForm = new JFrame("Register form");// Abro nueva forma de registro
				JPanel botonera = new JPanel();
				botonera.setBackground(Color.DARK_GRAY);
				JPanel registro = new JPanel();
				registro.setLayout(null);
				JButton register = new JButton("Register");
				JButton exit = new JButton("Exit");
				
				JLabel nombre = new JLabel("Nombre: ");
				nombre.setSize(70, 15);
				nombre.setLocation(20, 10);
				registro.add(nombre);
				
				JLabel apellido = new JLabel("Apellido: ");
				apellido.setSize(70, 15);
				apellido.setLocation(20, 30);
				registro.add(apellido);
				
				JLabel email = new JLabel("Email: ");
				email.setSize(70, 15);
				email.setLocation(20, 50);
				registro.add(email); 
				
				JLabel pass = new JLabel("Password : ");
				pass.setSize(70, 15);
				pass.setLocation(20, 70);
				registro.add(pass); 
				
				
				registerForm.setSize(300, 175);
				registerForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
				
				botonera.add(register);
				botonera.add(exit);
				
				
				registerForm.add(botonera, BorderLayout.SOUTH);
				registerForm.add(registro, BorderLayout.CENTER);
				
				
				registerForm.setVisible(true);
			}
		});
		btnRegister.setBounds(480, 198, 115, 29);
		contentPane.add(btnRegister);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(523, 38, 45, 26);
		contentPane.add(lblLogin);
	}
}
