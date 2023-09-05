package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bitirme.Books;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Seçili kitabın bilgilerinin getirildiği sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class UsersRatingOfSelectedBook extends JFrame {

	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Seçilen kitabın adı
	 */
	private JLabel selectedBooksTitle;
	/**
	 * Seçilen kitabın yazarı
	 */
	private JLabel selectedBooksAuthor;
	/**
	 * Seçilen kitabın dil kodu
	 */
	private JLabel selectedBooksLanguageCode;
	/**
	 * Seçilen kitabın sayfa sayısı
	 */
	private JLabel selectedBooksNumberOfPages;
	/**
	 * Seçilen kitabın kullanıcı reytingi
	 */
	private JLabel selectedBooksUsersRating;

	/**
	 * Seçilen kitabın bilgilerini arayüzde göstermek için oluşturulmuş elemanlara
	 * atar
	 * 
	 * @param selectedBook Arayüzde seçilen kitap
	 */
	public void setBook(Books selectedBook) {
		// Kitabın adı arayüze eklendi.
		selectedBooksTitle.setText(selectedBook.getTitle());
		// Kitabın yazarı arayüze eklendi.
		selectedBooksAuthor.setText(selectedBook.getAuthors());
		// Kitabın dil kodu arayüze eklendi.
		selectedBooksLanguageCode.setText(selectedBook.getLanguage_code());
		// Kitabın sayfa sayısı arayüze eklendi.
		selectedBooksNumberOfPages.setText(String.valueOf(selectedBook.getNum_pages()));
		// Kitaba verilen puanı arayüze eklendi.
		selectedBooksUsersRating.setText(String.valueOf(selectedBook.getUsers_rating()));
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
					UsersRatingOfSelectedBook frame = new UsersRatingOfSelectedBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Seçilen kitabın bilgilerinin gösterileceği arayüzü ayarlar. İçerisinde kitap
	 * ismi, kitabın yazarı, kitabın dil kodu, kitabın sayfa sayısı, mevcut
	 * kullanıcının seçilen kitap için değerlendirme puanının tutulduğu alanı
	 * barındırır. Bu sayfa sadece bilgilendirme amaçlı olduğu için sayfa
	 * kapatıldığında uygulama kapatılmaz.
	 */
	public UsersRatingOfSelectedBook() {
		setBackground(new Color(150, 126, 118));
		setTitle("Users Ratings of Selected Book");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBooksName = new JLabel("Title : ");
		lblBooksName.setForeground(new Color(183, 196, 207));
		lblBooksName.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblBooksName.setBackground(new Color(150, 126, 118));
		lblBooksName.setBounds(10, 25, 204, 35);
		contentPane.add(lblBooksName);

		JLabel lblBooks = new JLabel("Author : ");
		lblBooks.setForeground(new Color(183, 196, 207));
		lblBooks.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblBooks.setBackground(new Color(150, 126, 118));
		lblBooks.setBounds(10, 82, 195, 35);
		contentPane.add(lblBooks);

		JLabel lblLanguageCode = new JLabel("Language Code : ");
		lblLanguageCode.setForeground(new Color(183, 196, 207));
		lblLanguageCode.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblLanguageCode.setBackground(new Color(150, 126, 118));
		lblLanguageCode.setBounds(10, 138, 195, 35);
		contentPane.add(lblLanguageCode);

		JLabel lblNumberOfPages = new JLabel("Number of Pages : ");
		lblNumberOfPages.setForeground(new Color(183, 196, 207));
		lblNumberOfPages.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblNumberOfPages.setBackground(new Color(150, 126, 118));
		lblNumberOfPages.setBounds(10, 197, 204, 35);
		contentPane.add(lblNumberOfPages);

		JLabel lblYourRating = new JLabel("Your Rating : ");
		lblYourRating.setForeground(new Color(183, 196, 207));
		lblYourRating.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblYourRating.setBackground(new Color(150, 126, 118));
		lblYourRating.setBounds(10, 254, 204, 35);
		contentPane.add(lblYourRating);

		selectedBooksTitle = new JLabel("");
		selectedBooksTitle.setForeground(new Color(183, 196, 207));
		selectedBooksTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		selectedBooksTitle.setBackground(new Color(150, 126, 118));
		selectedBooksTitle.setBounds(243, 25, 583, 35);
		contentPane.add(selectedBooksTitle);

		selectedBooksAuthor = new JLabel("");
		selectedBooksAuthor.setForeground(new Color(183, 196, 207));
		selectedBooksAuthor.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		selectedBooksAuthor.setBackground(new Color(150, 126, 118));
		selectedBooksAuthor.setBounds(243, 82, 583, 35);
		contentPane.add(selectedBooksAuthor);

		selectedBooksLanguageCode = new JLabel("");
		selectedBooksLanguageCode.setForeground(new Color(183, 196, 207));
		selectedBooksLanguageCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		selectedBooksLanguageCode.setBackground(new Color(150, 126, 118));
		selectedBooksLanguageCode.setBounds(243, 138, 583, 35);
		contentPane.add(selectedBooksLanguageCode);

		selectedBooksNumberOfPages = new JLabel("");
		selectedBooksNumberOfPages.setForeground(new Color(183, 196, 207));
		selectedBooksNumberOfPages.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		selectedBooksNumberOfPages.setBackground(new Color(150, 126, 118));
		selectedBooksNumberOfPages.setBounds(243, 197, 583, 35);
		contentPane.add(selectedBooksNumberOfPages);

		selectedBooksUsersRating = new JLabel("");
		selectedBooksUsersRating.setForeground(new Color(183, 196, 207));
		selectedBooksUsersRating.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		selectedBooksUsersRating.setBackground(new Color(150, 126, 118));
		selectedBooksUsersRating.setBounds(243, 254, 583, 35);
		contentPane.add(selectedBooksUsersRating);
	}
}
