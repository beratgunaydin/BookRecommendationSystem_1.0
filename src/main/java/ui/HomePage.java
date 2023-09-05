package ui;

import java.awt.EventQueue;
import bitirme.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Diğer sayfalara yönlendirme yapılmasını sağlayan Ana Sayfayı oluşturan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class HomePage extends JFrame {
	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Hoşgeldiniz mesajı yazdırmak için kullanıcının adını tutacak etiket
	 */
	private JLabel userNameLabel;

	/**
	 * Kullanıcının bilgilerinin tutulacağı nesne
	 */
	private Users user;
	/**
	 * Kullanıcının kitap listesini barındıran sayfaya giden button
	 */
	private JButton myBookListButton;
	/**
	 * Kitap veri setini barındıran sayfaya giden buton
	 */
	private JButton bookDatasetButton;
	/**
	 * Kullanıcının kitap öneri listesini barındıran sayfaya giden button
	 */
	private JButton recommendBookButton;
	/**
	 * Giriş ekranına geri dönecek buton
	 */
	private JButton loginScreenButton;
	/**
	 * Benzerlik alt limiti
	 */
	private double similarityThreshold;

	/**
	 * Gelen kullanıcının bilgilerini bu sınıf için kullanılabilir hale getiren ve
	 * Hoşgeldiniz yazısı yazdıran metot
	 * 
	 * @param user                Giriş yapan kullanıcı bilgileri
	 * @param similarityThreshold Giriş yapan kullanıcının belirlediği minimum
	 *                            benzerlik değeri
	 */
	public void setUser(Users user, double similarityThreshold) {
		this.user = user;
		userNameLabel.setText("Welcome " + user.getUserName() + ".");
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
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Ana sayfayı oluşturur. Diğer sayfalara giden butonları barındırır.
	 */
	public HomePage() {
		setBackground(new Color(150, 126, 118));
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Tıklandığında kullanıcı bilgileri sayfasına gidecek buton
		JButton profileInformationButton = new JButton("Profile Information");
		profileInformationButton.setForeground(new Color(150, 126, 118));
		profileInformationButton.setBackground(new Color(238, 227, 203));
		profileInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProfileInformation pi = new ProfileInformation();
				pi.setUser(user, similarityThreshold);
				pi.setVisible(true);
			}
		});
		profileInformationButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		profileInformationButton.setBounds(27, 121, 205, 42);
		contentPane.add(profileInformationButton);

		userNameLabel = new JLabel();
		userNameLabel.setForeground(new Color(183, 196, 207));
		userNameLabel.setBackground(new Color(150, 126, 118));
		userNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		userNameLabel.setBounds(52, 20, 296, 24);
		contentPane.add(userNameLabel);

		// Tıklandığında kullanıcının kitap listesi sayfasına gidecek buton
		myBookListButton = new JButton("My Book List");
		myBookListButton.setForeground(new Color(150, 126, 118));
		myBookListButton.setBackground(new Color(238, 227, 203));
		myBookListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyBookList mbl = new MyBookList();
				mbl.setUser(user, similarityThreshold);
				mbl.setVisible(true);
			}
		});
		myBookListButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		myBookListButton.setBounds(27, 188, 205, 42);
		contentPane.add(myBookListButton);

		// Tıklandığında tüm kitapların listesi sayfasına gidecek buton
		bookDatasetButton = new JButton("Book Dataset");
		bookDatasetButton.setForeground(new Color(150, 126, 118));
		bookDatasetButton.setBackground(new Color(238, 227, 203));
		bookDatasetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BookDataSet bds = new BookDataSet();
				bds.setUser(user, similarityThreshold);
				bds.setVisible(true);
			}
		});
		bookDatasetButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		bookDatasetButton.setBounds(27, 253, 205, 42);
		contentPane.add(bookDatasetButton);

		// Tıklandığında kullanıcıya kitap öneri listesi sayfasına gidecek buton
		recommendBookButton = new JButton("Recommend a Book");
		recommendBookButton.setForeground(new Color(150, 126, 118));
		recommendBookButton.setBackground(new Color(238, 227, 203));
		recommendBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RecommendBook rb = new RecommendBook();
				rb.setUser(user, similarityThreshold);
				rb.setVisible(true);
			}
		});
		recommendBookButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		recommendBookButton.setBounds(345, 121, 205, 42);
		contentPane.add(recommendBookButton);

		// Tıklandığında giriş sayfasına gidecek buton
		loginScreenButton = new JButton("Exit to Login");
		loginScreenButton.setForeground(new Color(150, 126, 118));
		loginScreenButton.setBackground(new Color(238, 227, 203));
		loginScreenButton.addActionListener(new ActionListener() {
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
		loginScreenButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		loginScreenButton.setBounds(345, 253, 205, 42);
		contentPane.add(loginScreenButton);

		JButton settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Settings s = new Settings();
				s.setUser(user, similarityThreshold);
				s.setVisible(true);
			}
		});
		settingsButton.setForeground(new Color(150, 126, 118));
		settingsButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		settingsButton.setBackground(new Color(238, 227, 203));
		settingsButton.setBounds(345, 188, 205, 42);
		contentPane.add(settingsButton);
	}
}
