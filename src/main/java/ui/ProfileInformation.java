package ui;

import java.awt.EventQueue;
import bitirme.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Kullanıcının bilgilerini gösterecek sayfayı oluşturan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class ProfileInformation extends JFrame {
	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Ekranda gösterilecek kullanıcı adı
	 */
	private JLabel username;
	/**
	 * Ekranda gösterilecek kullanıcının ülkesi
	 */
	private JLabel country;
	/**
	 * Ekranda gösterilecek kullanıcının ID'si
	 */
	private JLabel userID;

	/**
	 * Kullanıcının bilgilerinin tutulacağı nesne
	 */
	private Users user;
	/**
	 * Kullanıcının belirlediği minimum benzerlik oranı değeri
	 */
	private double similarityThreshold;

	/**
	 * Gelen kullanıcının bilgilerini bu sınıf için kullanılabilir hale getiren
	 * metot
	 * 
	 * @param users            Giriş yapan kullanıcı bilgileri
	 * @param similarityThreshold Giriş yapan kullanıcının belirlediği minimum benzerlik değeri
	 */
	public void setUser(Users users, double similarityThreshold) {
		this.user = users;
		username.setText(user.getUserName());
		country.setText(user.getCountry());
		userID.setText(String.valueOf(user.getUserID()));
		this.similarityThreshold = similarityThreshold;
	}

	/**
	 * Proje başlatıldığında ilk çalışacak ana metot
	 * 
	 * @param args Komut satırı argümanları
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileInformation frame = new ProfileInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Kullanıcının bilgilerini içeren sayfayı oluşturur, ana sayfaya geri dönecek
	 * butonu barındırır
	 */
	public ProfileInformation() {
		setBackground(new Color(150, 126, 118));
		setTitle("Profile Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel usernameLabel = new JLabel("Username :");
		usernameLabel.setForeground(new Color(183, 196, 207));
		usernameLabel.setBackground(new Color(150, 126, 118));
		usernameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		usernameLabel.setBounds(28, 98, 157, 35);
		contentPane.add(usernameLabel);

		username = new JLabel("");
		username.setForeground(new Color(183, 196, 207));
		username.setBackground(new Color(150, 126, 118));
		username.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		username.setBounds(227, 98, 217, 35);
		contentPane.add(username);

		JLabel countryLabel = new JLabel("Country : ");
		countryLabel.setForeground(new Color(183, 196, 207));
		countryLabel.setBackground(new Color(150, 126, 118));
		countryLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		countryLabel.setBounds(28, 162, 157, 35);
		contentPane.add(countryLabel);

		country = new JLabel("");
		country.setForeground(new Color(183, 196, 207));
		country.setBackground(new Color(150, 126, 118));
		country.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		country.setBounds(227, 162, 217, 35);
		contentPane.add(country);

		JLabel userIDLabel = new JLabel("User ID : ");
		userIDLabel.setForeground(new Color(183, 196, 207));
		userIDLabel.setBackground(new Color(150, 126, 118));
		userIDLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		userIDLabel.setBounds(28, 42, 157, 35);
		contentPane.add(userIDLabel);

		userID = new JLabel("");
		userID.setForeground(new Color(183, 196, 207));
		userID.setBackground(new Color(150, 126, 118));
		userID.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		userID.setBounds(227, 35, 217, 35);
		contentPane.add(userID);

		JButton homePageButton = new JButton("Go Back To Home Page");
		homePageButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		homePageButton.setForeground(new Color(150, 126, 118));
		homePageButton.setBackground(new Color(238, 227, 203));
		homePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setUser(user, similarityThreshold);
				hp.setVisible(true);
			}
		});
		homePageButton.setBounds(287, 302, 200, 35);
		contentPane.add(homePageButton);
	}
}
