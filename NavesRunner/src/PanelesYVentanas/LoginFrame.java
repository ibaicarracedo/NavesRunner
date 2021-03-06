package PanelesYVentanas;
import GmailYBd.BaseDeDatos;
import GmailYBd.MailYConfirmaciones;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.Environment;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que controla todo lo relacionado con la ventana de login
 * @author iCarr
 *
 */
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private static LoginFrame frame;
	private static String nick = "";
	/**
	 * Constructor de la ventana Login(Window builder)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginFrame();
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
		setResizable(false);
		setTitle("Space Runner Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setText("User");
		txtUser.setBounds(15, 58, 224, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("Password");
		txtPassword.setBounds(15, 100, 224, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BaseDeDatos.loginUsuario(txtUser.getText(), String.valueOf(txtPassword.getPassword())) == true) {
					nick = txtUser.getText();
					(new Thread() {
						@Override
						public void run() {
							dispose();
							GameFrame.main();
							super.run();
						}
					}).start();

				} else {
					JOptionPane.showMessageDialog(frame, "Error en user/password.");
				}
			}
		});
		btnLogin.setBounds(73, 142, 115, 29);
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
				nombre.setSize(70, 25);
				nombre.setLocation(20, 10);
				registro.add(nombre);
				
				JLabel apellido = new JLabel("Apellido: ");
				apellido.setSize(70, 25);
				apellido.setLocation(20, 40);
				registro.add(apellido);
				
				JLabel email = new JLabel("Email: ");
				email.setSize(70, 25);
				email.setLocation(20, 70);
				registro.add(email); 
				
				JLabel pass = new JLabel("Password : ");
				pass.setSize(70, 25);
				pass.setLocation(20, 100);
				registro.add(pass); 
				
				JTextField name1= new JTextField("Nombre");
				name1.setSize(175, 25);
				name1.setLocation(100, 10);
				registro.add(name1);
				
				JTextField ape1= new JTextField("Apellido");
				ape1.setSize(175, 25);
				ape1.setLocation(100, 40);
				registro.add(ape1);
				
				JTextField email1= new JTextField("example@example.com");
				email1.setSize(175, 25);
				email1.setLocation(100, 70);
				registro.add(email1);
				
				JPasswordField pass1= new JPasswordField("    ");
				pass1.setSize(175, 25);
				pass1.setLocation(100, 100);
				registro.add(pass1);
				
				register.addActionListener(new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
						
						MailYConfirmaciones.enviarMail(email1.getText());
						if (BaseDeDatos.anadirUsuario(name1.getText(), email1.getText(), String.valueOf(pass1.getPassword())) == false) {
							JOptionPane.showMessageDialog(registerForm, "Error al reegistrarse. Usuario existente.");
						} else {
							JOptionPane.showMessageDialog(registerForm, "Registro realizado correctamente. Chequea el correo para la confirmacion.");
						}
						
						
					}
				});
				
				exit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						registerForm.dispose();
						frame.setVisible(true);
					}
				});
				
				
				
				
				botonera.add(register);
				botonera.add(exit);
				
				
				registerForm.getContentPane().add(botonera, BorderLayout.SOUTH);
				registerForm.getContentPane().add(registro, BorderLayout.CENTER);
				
				
				registerForm.setSize(300, 225);
				registerForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;
				registerForm.setLocationRelativeTo(null);
				registerForm.setVisible(true);
				frame.dispose();
			}
		});
		btnRegister.setBounds(73, 177, 115, 29);
		contentPane.add(btnRegister);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(108, 16, 45, 26);
		contentPane.add(lblLogin);
		
		try {
			BaseDeDatos.crearBD(Constantes.nomBD);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static String getNick() {
		return nick;
	}
}

	