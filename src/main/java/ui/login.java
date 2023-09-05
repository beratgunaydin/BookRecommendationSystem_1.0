package ui;

import java.awt.EventQueue;
import bitirme.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.parser.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JList;

/**
 * Kullanıcı giriş ekranının oluşturulduğu sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class login extends JFrame {
	/**
	 * Kullanıcının belirlediği minimum benzerlik değeri, proje başlatıldığında kullanıcı belirlemezse default olarak 0.7 atanır
	 */
	private double similarityThreshold = 0.7;
	
	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Kullanıcı adı girilmesi için yazı alanı
	 */
	private JTextField userNameTextField;
	/**
	 * Kullanıcı şifresi girişi için şifre alanı
	 */
	private JPasswordField passwordField;
	/**
	 * 
	 */
	/**
	 * Sayfanın çerçevesi
	 */
	protected Window frame;

	/**
	 * Proje başlatıldığında ilk çalışacak ana metot
	 * 
	 * @param args Komut satırı argümanları
	 */
	public static void main(String[] args) {
		/**
		 * Görevin tüm görevler bitirildikten sonra çalıştırılması sağlandı
		 */
		EventQueue.invokeLater(new Runnable() {
			/**
			 * Kodu çalıştıran metot
			 */
			public void run() {
				/**
				 * Bir try catch bloğu ile sayfanın yüklenip yüklenmediği kontrol edildi
				 */
				try {
					// login sınıfının frame adında bir nesne oluşturuldu
					login frame = new login();
					/**
					 * Çerçevenin görünür olması ayarlandı
					 */
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * login sayfasının dizaynını ayarlar ve butonlarla signIn ve HomePage
	 * pencerelerine ulaşımını sağlar.
	 * 
	 * @throws IOException Belirtilen dosyanın bulunamaması durumunda verilecek hata
	 *                     mesajı
	 */
	public login() throws IOException {
		// Sayfanın arka plan rengi
		setBackground(new Color(150, 126, 118));
		// Users sınıfından bir user nesnesi oluşturuldu
		Users user = new Users();
		// CSVReader sınıfının CsvReader metodu çağırıldı.
		CSVReader.CsvReader();
		// json dosyasının ayrıştırılmasında sorun yaşanırsa hata mesajı vermesi için
		// try catch bloğu oluşturuldu
		try {
			JSONReader.JsonReader();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // JSONReader sınıfının JsonReader metodu çağırıldı.

		// Sayfanın başlığı
		setTitle("Book Recommendation System");
		// Pencere kapandığında uygulamayı durduran kod
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Pencerenin boyutları ve ekranın hangi bölümünde ortaya çıkacağı
		setBounds(100, 100, 450, 300);
		// contentPane nesnesi örneklendi ve özellikleri ayarlandı
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Kullanıcı adı girilecek alanı belirtmek için bir etiket oluşturuldu,
		// özellikleri ayarlandı ve container a eklendi
		JLabel userNameLabel = new JLabel("Username : ");
		userNameLabel.setForeground(new Color(183, 196, 207));
		userNameLabel.setFont(new Font("Consolas", Font.BOLD, 21));
		userNameLabel.setBounds(32, 38, 130, 38);
		contentPane.add(userNameLabel);

		// Kullanıcı adı girilecek alan oluşturuldu, özellikleri ayarlandı ve container
		// a eklendi
		userNameTextField = new JTextField();
		userNameTextField.setBackground(new Color(215, 192, 174));
		userNameTextField.setForeground(new Color(150, 126, 118));
		userNameTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		userNameTextField.setBounds(180, 38, 230, 38);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);

		// Kullanıcı şifresi girilecek alanı belirtmek için bir etiket oluşturuldu,
		// özellikleri ayarlandı ve container a eklendi
		JLabel passwordLabel = new JLabel("Password : ");
		passwordLabel.setForeground(new Color(183, 196, 207));
		passwordLabel.setFont(new Font("Consolas", Font.BOLD, 21));
		passwordLabel.setBounds(32, 117, 130, 38);
		contentPane.add(passwordLabel);

		// Kullanıcı şifresi girilecek alan oluşturuldu, özellikleri ayarlandı ve
		// container a eklendi
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(215, 192, 174));
		passwordField.setForeground(new Color(150, 126, 118));
		passwordField.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		passwordField.setBounds(180, 117, 230, 38);
		contentPane.add(passwordField);

		// Girilen bilgiler ile giriş yapmaya çalışılacak buton oluşturuldu, özellikleri
		// ayarlandı ve container a eklendi
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(238, 227, 203));
		loginButton.setForeground(new Color(150, 126, 118));
		loginButton.setFont(new Font("Consolas", Font.PLAIN, 21));
		loginButton.setBounds(147, 195, 130, 38);
		contentPane.add(loginButton);

		// Kullanıcı kaydı yapılacak sayfaya yönlendiren buton oluşturuldu, özellikleri
		// ayarlandı ve container a eklendi
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(new Color(150, 126, 118));
		btnSignIn.setFont(new Font("Consolas", Font.PLAIN, 18));
		// Sign In butonuna basıldığında signIn.java sayfasının açılmasını sağlayan kod
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Farklı bir sayfaya geçilirken mevcut sayfanın kapanmasını sağlayan metot
				dispose();
				signIn si = new signIn();
				si.setVisible(true);
			}
		});
		btnSignIn.setBackground(new Color(238, 227, 203));
		btnSignIn.setBounds(316, 229, 110, 24);
		contentPane.add(btnSignIn);

		// Login butonuna basıldığında bilgilerin doğruluğunu kontrol edip, doğru ise
		// HomePage.java sayfasına kullanıcının bilgileri ile birlikte yönlendirir
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameTextField.getText();
				char[] password = passwordField.getPassword();
				String passwordInput = "";
				System.out.println(userName);

				// Şifre alanı bir char dizisi olarak tutulduğu için pu dizi bir String
				// değişkene for döngüsü ile atandı
				for (int i = 0; i < password.length; i++) {
					passwordInput += password[i];
				}

				System.out.println(passwordInput);

				// Kullanıcının bilgilerinin doğruluğunu kontrol etmek için Users sınıfının
				// kullanıcı listesine bakıldı
				if (Users.SearchUserName(userName, passwordInput, user)) {
					// Doğru ise

					// Kullanıcının listedeki indeksi belirlendi
					int userIndex = Users.GetUserIndex(userName);
					dispose();
					HomePage hp = new HomePage();

					// Kullanıcının bilgileri ve benzerlik eşik değeri HomePage sayfasına gönderildi
					hp.setUser(user.getUsersList().get(userIndex), similarityThreshold);
					hp.setVisible(true);
				}

				else {

				}
			}
		});
	}
}
