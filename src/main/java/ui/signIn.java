package ui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import bitirme.Users;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * Yeni kullanıcı kaydı sayfasını olşturan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class signIn extends JFrame {
	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Kayıt işlemi yapılacak kullanıcı adı
	 */
	private JTextField userNameField;
	/**
	 * Kayıt işlemi yapılacak kullanıcı şifresi
	 */
	private JPasswordField passwordField;
	/**
	 * Kullanıcının bilgilerinin tutulacağı nesne
	 */
	private Users user;
	/**
	 * Kayıt işlemi yapılacak kullanıcının ülkesi
	 */
	private JTextField countryField;

	/**
	 * Proje başlatıldığında ilk çalışacak ana metot
	 * 
	 * @param args Komut satırı argümanları
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signIn frame = new signIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Girilen kullanıcının bilgileri sistemde bulunmuyorsa sisteme kaydedilir.
	 * Kayıt ol ve giriş ekranına dönmee butonlarını barındırır.
	 */
	public signIn() {
		setBackground(new Color(150, 126, 118));
		setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel userNameLabel = new JLabel("Username : ");
		userNameLabel.setForeground(new Color(183, 196, 207));
		userNameLabel.setFont(new Font("Consolas", Font.BOLD, 21));
		userNameLabel.setBounds(10, 49, 130, 38);
		contentPane.add(userNameLabel);

		userNameField = new JTextField();
		userNameField.setForeground(new Color(150, 126, 118));
		userNameField.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		userNameField.setColumns(10);
		userNameField.setBackground(new Color(215, 192, 174));
		userNameField.setBounds(161, 45, 230, 38);
		contentPane.add(userNameField);

		JLabel passwordLabel = new JLabel("Password : ");
		passwordLabel.setForeground(new Color(183, 196, 207));
		passwordLabel.setFont(new Font("Consolas", Font.BOLD, 21));
		passwordLabel.setBounds(10, 128, 130, 38);
		contentPane.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(150, 126, 118));
		passwordField.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		passwordField.setBackground(new Color(215, 192, 174));
		passwordField.setBounds(161, 128, 230, 38);
		contentPane.add(passwordField);

		// Bilgiler girilip kayıt ol butonuna basıldığında
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Girilen bilgiler değişkenlere atanır
				String userName = userNameField.getText();
				char[] password = passwordField.getPassword();
				String country = countryField.getText();
				String passwordInput = "";

				// Şifre char dizisi olarak tutulduğu için bir for döngüsü ile string bir
				// değişkene atanır
				for (int i = 0; i < password.length; i++) {
					passwordInput += password[i];
				}

				// Eğer alanlar boş bırakılmamışsa
				if (!country.equals(null) && !password.equals(null) && !userName.equals(null)) {
					// Users türünde bir kullanıcı nesnesi oluşturulur
					Users userObj = new Users();
					// kullanıcı nesnesinin özelliklerine girilen değerler atanır
					userObj.setUserID();
					userObj.setUserName(userName);
					userObj.setUserPassword(passwordInput);
					userObj.setCountry(country);
					try {
						// Kaydedilmek istenen kullanıcı kullanıcı verisetine eklendi
						userObj.AddUserToJSONFile(userObj);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSignIn.setForeground(new Color(150, 126, 118));
		btnSignIn.setFont(new Font("Consolas", Font.PLAIN, 21));
		btnSignIn.setBackground(new Color(238, 227, 203));
		btnSignIn.setBounds(204, 303, 130, 38);
		contentPane.add(btnSignIn);

		JLabel lblCountry = new JLabel("Country : ");
		lblCountry.setForeground(new Color(183, 196, 207));
		lblCountry.setFont(new Font("Consolas", Font.BOLD, 21));
		lblCountry.setBounds(10, 210, 130, 38);
		contentPane.add(lblCountry);

		JButton btnGoBackTo = new JButton("Go Back To Login Screen");
		btnGoBackTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login lgn = null;
				try {
					lgn = new login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lgn.setVisible(true);
			}
		});
		btnGoBackTo.setForeground(new Color(150, 126, 118));
		btnGoBackTo.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnGoBackTo.setBackground(new Color(238, 227, 203));
		btnGoBackTo.setBounds(285, 365, 230, 38);
		contentPane.add(btnGoBackTo);

		countryField = new JTextField();
		countryField.setForeground(new Color(150, 126, 118));
		countryField.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		countryField.setColumns(10);
		countryField.setBackground(new Color(215, 192, 174));
		countryField.setBounds(161, 210, 230, 38);
		contentPane.add(countryField);
	}
}
