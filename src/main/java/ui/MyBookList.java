package ui;

import java.awt.EventQueue;
import bitirme.*;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Kullanıcının kitap listesini barındıran sayfayı oluşturan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class MyBookList extends JFrame {
	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Kullanıcının kitap listesi
	 */
	private JList<String> bookList;
	/**
	 * Kullanıcının bilgilerinin tutulacağı nesne
	 */
	private Users user;
	/**
	 * Ana sayfaya geri dönecek buton
	 */
	private JButton goBackToHomePageButton;
	/**
	 * Kitap listesinin tutulacağı aşağı yukarı kaydırılabilir alan
	 */
	private JScrollPane listScrollPane;
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
		this.similarityThreshold = similarityThreshold;
		DefaultListModel<String> dlm = new DefaultListModel<>();
		for (int i = 0; i < user.getUserReadingList().size(); i++) {
			dlm.addElement(user.getUserReadingList().get(i).getTitle());
		}

		bookList = new JList<String>(dlm);
		bookList.setBounds(25, 105, 775, 500);
		bookList.setBackground(new Color(150, 126, 118));
		listScrollPane = new JScrollPane();
		listScrollPane.setBounds(25, 150, 776, 400);
		contentPane.add(listScrollPane);
		listScrollPane.setViewportView(bookList);
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
					MyBookList frame = new MyBookList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Kullanıcının kitap listesini oluşturur, ana sayfaya geri dönecek butonu
	 * barındırır
	 */
	public MyBookList() {
		setBackground(new Color(150, 126, 118));
		setTitle("My Book List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		goBackToHomePageButton = new JButton("Go Back To Home Page");
		goBackToHomePageButton.setForeground(new Color(150, 126, 118));
		goBackToHomePageButton.setBackground(new Color(238, 227, 203));
		goBackToHomePageButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		goBackToHomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setUser(user, similarityThreshold);
				hp.setVisible(true);
			}
		});
		goBackToHomePageButton.setBounds(627, 618, 173, 35);
		contentPane.add(goBackToHomePageButton);
		
		JButton btnViewTheRating = new JButton("View The Rating Score of Selected Book");
		btnViewTheRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("View The Rating Score of Selected Book")) {
					String item = bookList.getSelectedValue();
					
					for (Books book : user.getUserReadingList()) {
						if (item.equals(book.getTitle())) {
							UsersRatingOfSelectedBook ur = new UsersRatingOfSelectedBook();
							ur.setBook(book);
							ur.setVisible(true);
						}
					}
				}
			}
		});
		btnViewTheRating.setForeground(new Color(150, 126, 118));
		btnViewTheRating.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnViewTheRating.setBackground(new Color(238, 227, 203));
		btnViewTheRating.setBounds(10, 618, 327, 35);
		contentPane.add(btnViewTheRating);
	}
}
