package ui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bitirme.Books;
import bitirme.RecommendationEngine;
import bitirme.Users;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * Kullanıcıya yapılan kitap öneri listesinin bulunduğu sayfayı oluşturan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class RecommendBook extends JFrame {
	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Kullanıcının bilgilerinin tutulacağı nesne
	 */
	private Users user;
	/**
	 * Kullanıcının kitap öneri listesi
	 */
	private List<Books> recommendedBooks;
	/**
	 * Kitap listesinin tutulacağı aşağı yukarı kaydırılabilir alan
	 */
	private JScrollPane jscrollPane;
	/**
	 * Önerilecek kitapların isimlerinin listesi
	 */
	private JList<String> recommendedBooksJList;
	/**
	 * Kullanıcının belirlediği minimum benzerlik değeri
	 */
	private double similarityThreshold;

	/**
	 * Gelen kullanıcının bilgilerini bu sınıf için kullanılabilir hale getiren
	 * metot
	 * 
	 * @param user             Giriş yapan kullanıcı bilgileri
	 * @param similarityThreshold Giriş yapan kullanıcının belirlediği minimum benzerlik değeri
	 */
	public void setUser(Users user, double similarityThreshold) {
		this.user = user;
		Books book = new Books();
		RecommendationEngine re = new RecommendationEngine();
		this.similarityThreshold = similarityThreshold;

		// Öneri listesini oluşturacak metoda gidildi
		recommendedBooks = re.addUsersRating(user, similarityThreshold);

		DefaultListModel<String> dlm = new DefaultListModel<>();
		for (int i = 0; i < recommendedBooks.size(); i++) {
			System.out.println(recommendedBooks.get(i).getTitle());
			dlm.addElement(recommendedBooks.get(i).getTitle());
		}

		recommendedBooksJList = new JList<String>(dlm);
		recommendedBooksJList.setBounds(25, 105, 775, 500);
		recommendedBooksJList.setBackground(new Color(150, 126, 118));
		jscrollPane = new JScrollPane();
		jscrollPane.setBounds(25, 150, 776, 400);
		contentPane.add(jscrollPane);
		jscrollPane.setViewportView(recommendedBooksJList);
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
					RecommendBook frame = new RecommendBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Kullanıcya önerilecek kitapların listesini içerir, ana sayfaya geri dönecek
	 * butonu barındırır
	 */
	public RecommendBook() {
		setBackground(new Color(150, 126, 118));
		setTitle("Recommend a Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton goBackToHomePageButton = new JButton("Go Back To Home Page");
		goBackToHomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setUser(user, similarityThreshold);
				hp.setVisible(true);
			}
		});
		goBackToHomePageButton.setForeground(new Color(150, 126, 118));
		goBackToHomePageButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		goBackToHomePageButton.setBackground(new Color(238, 227, 203));
		goBackToHomePageButton.setBounds(591, 562, 210, 30);
		contentPane.add(goBackToHomePageButton);
	}
}
