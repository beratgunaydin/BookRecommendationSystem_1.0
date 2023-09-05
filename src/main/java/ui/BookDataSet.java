package ui;

import java.awt.EventQueue;
import java.util.List;
import java.util.Random;

import bitirme.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;

/**
 * Tüm kitapların listesininin ekranda gösterildiği sayfayı oluşturan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class BookDataSet extends JFrame {
	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;

	/**
	 * Kullanıcının bilgilerinin tutulacağı nesne
	 */
	private Users user;
	/**
	 * Ana Sayfaya geri gidecek buton
	 */
	private JButton goBackToHomePageButton;
	/**
	 * Kitap listesinin tutulacağı aşağı yukarı kaydırılabilir alan
	 */
	private JScrollPane listScrollPane;
	/**
	 * Kitap listesindeki kitabı kullanıcının listesine ekleyecek buton
	 */
	private JButton addBookButton;
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
					BookDataSet frame = new BookDataSet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Kitap listesini ekranda gösterir, ana sayfaya geri dönecek butonu ve
	 * kullanıcının listesine kitap ekleyeceği butonu barındırır.
	 */
	public BookDataSet() {
		setBackground(new Color(150, 126, 118));
		Books book = new Books();
		List<Books> bookList = book.getBooksList();

		// JList e atama yapmak için öncelikle bir DefaultListModel oluşturulur ve bu
		// modelin içerisine kitap adları atanır
		DefaultListModel<String> booksTitles = new DefaultListModel<>();
		for (int i = 0; i < bookList.size(); i++) {
			booksTitles.addElement(bookList.get(i).getTitle());
		}

		setTitle("Book Dataset");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JListe oluşturulan DefaultListModel atanır ve JList scrollPane 'e eklenir
		JList<String> booksJList = new JList<String>(booksTitles);
		booksJList.setBounds(25, 150, 775, 400);
		booksJList.setBackground(new Color(150, 126, 118));
		listScrollPane = new JScrollPane();
		listScrollPane.setBounds(25, 150, 776, 400);
		contentPane.add(listScrollPane);
		listScrollPane.setViewportView(booksJList);

		// Ana sayfaya geri dönecek buton
		goBackToHomePageButton = new JButton("Go Back To Home Page");
		goBackToHomePageButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		goBackToHomePageButton.setForeground(new Color(150, 126, 118));
		goBackToHomePageButton.setBackground(new Color(238, 227, 203));
		goBackToHomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setUser(user, similarityThreshold);
				hp.setVisible(true);
			}
		});
		goBackToHomePageButton.setBounds(573, 566, 210, 30);
		contentPane.add(goBackToHomePageButton);

		// Seçilen kitap kullanıcının listesinde yoksa ekleyecek buton
		addBookButton = new JButton("Add Book");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Butona basılmış ise
				if (e.getActionCommand().equals("Add Book")) {
					// String bir değişkene seçilen kitabın değeri atandı
					String item = (String) booksJList.getSelectedValue();
					// Seçilen kitap değerine öncelikle boş bir değer atandı
					Books selectedBook = null;
					// Kitabın kullanıcı listesinde olup olmadığını kontrol edecek boolean bir
					// değişken oluşturuldu ve başlangıç olarak false değeri atandı
					boolean isBookInMyBookList = false;

					// Kullanıcının kitap listesi içerisinde gezildi, seçilen kitap listede mevcut
					// ise değişkene true değeri atandı ve döngüden çıkıldı
					for (int i = 0; i < user.getUserReadingList().size(); i++) {
						if (item.equals(user.getUserReadingList().get(i).getTitle())) {
							isBookInMyBookList = true;
							break;
						}
					}

					// Kitap listesi içerisinde gezildi ve kitabın adı listede bulunduğunda
					// selectedBook nesnesine bu kitabın bilgileri atandı
					for (int i = 0; i < bookList.size(); i++) {
						if (item.equals(bookList.get(i).getTitle())) {
							selectedBook = bookList.get(i);
							break;
						}
					}

					// Kitap kullanıcının listesinde yoksa listeye eklendi
					if (!isBookInMyBookList) {
						Random rnd = new Random();
						double rating_value = rnd.nextDouble(0, 5);
						selectedBook.setUsers_rating(rating_value);
						user.getUserReadingList().add(selectedBook);
					}
					System.out.println(item);
				}
			}
		});
		addBookButton.setForeground(new Color(150, 126, 118));
		addBookButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		addBookButton.setBackground(new Color(238, 227, 203));
		addBookButton.setBounds(25, 560, 205, 42);
		contentPane.add(addBookButton);
	}
}
