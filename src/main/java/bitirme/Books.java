package bitirme;

import java.util.ArrayList;
import java.util.List;

/**
 * Books sınıfı bir kitap hakkında bilgiler içerir, içerisinde bulunan list
 * yapısına her bir kitabın gelen bilgilerini ekler.
 * 
 * @author Berat
 * @version 1.0.0
 */
public class Books {
	/**
	 * Kitabın ID'si
	 */
	private int bookID;
	/**
	 * Kitabın ismi
	 */
	private String title;
	/**
	 * Kitabın yazarı
	 */
	private String authors;
	/**
	 * Kitabın ortalama puanı
	 */
	private double average_rating;
	/**
	 * Kitabın isbn numarası
	 */
	private String isbn;
	/**
	 * Kitabın isbn13 numarası
	 */
	private String isbn13;
	/**
	 * Kitabın dil kodu
	 */
	private String language_code;
	/**
	 * Kitabın sayfa sayısı
	 */
	private int num_pages;
	/**
	 * Kitabın değerlendirme sayısı
	 */
	private int ratings_count;
	/**
	 * Kitabın yorum sayısı
	 */
	private int text_reviews_count;
	/**
	 * Kitabın yayın tarihi
	 */
	private String publication_date;
	/**
	 * Kitabın yayıncısı
	 */
	private String publisher;
	/**
	 * Mevcut kullanıcının kitaba verdiği puan
	 */
	private double users_rating;

	/**
	 * Mevcut kullanıcının kitaba verdiği puana ulaşmak için get metodu
	 * 
	 * @return Mevcut kullanıcının kitaba verdiği puan
	 */
	public double getUsers_rating() {
		return users_rating;
	}

	/**
	 * Parametre olarak gelen Mevcut kullanıcının kitaba verdiği puanı mevcut kitaba
	 * atamak için set metodu
	 * 
	 * @param users_rating Mevcut kullanıcının kitaba verdiği puan
	 */
	public void setUsers_rating(double users_rating) {
		this.users_rating = users_rating;
	}

	/**
	 * Kitap bilgilerinin tutulduğu list yapısı Bu alan static oluşturulmuştur,
	 * bunun sebebi kitap listesi bir adet olmalıdır ve güncellendiği zaman her
	 * yerde aynı olmalıdır.
	 */
	private static List<Books> BooksList = new ArrayList<Books>();

	/**
	 * Mevcut kitabın ID'sine ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın ID'si
	 */
	public int getBookID() {
		return bookID;
	}

	/**
	 * Parametre olarak gelen kitap ID'sini mevcut kitaba atamak için set metodu
	 * 
	 * @param bookID Kitabın ID'si
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	/**
	 * Mevcut kitabın adına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın adı
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Parametre olarak gelen kitap adını mevcut kitaba atamak için set metodu
	 * 
	 * @param title Kitabın adı
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Mevcut kitabın yazarına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın yazarı
	 */
	public String getAuthors() {
		return authors;
	}

	/**
	 * Parametre olarak gelen kitabın yazarını mevcut kitaba atamak için set metodu
	 * 
	 * @param authors Kitabın yazarı
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}

	/**
	 * Mevcut kitabın ortalama puanına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın ortalama puanı
	 */
	public double getAverage_rating() {
		return average_rating;
	}

	/**
	 * Parametre olarak gelen kitabın ortalama puanını mevcut kitaba atamak için set
	 * metodu
	 * 
	 * @param average_rating Kitabın ortalama puanı
	 */
	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}

	/**
	 * Mevcut kitabın isbn numarasına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın isbn numarası
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Parametre olarak gelen kitabın isbn numarasını mevcut kitaba atamak için set
	 * metodu
	 * 
	 * @param isbn Kitabın isbn numarası
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Mevcut kitabın isbn13 numarasına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın isbn13 numarası
	 */
	public String getIsbn13() {
		return isbn13;
	}

	/**
	 * Parametre olarak gelen kitabın isbn13 numarasını mevcut kitaba atamak için
	 * set metodu
	 * 
	 * @param isbn13 Kitabın isbn13 numarası
	 */
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	/**
	 * Mevcut kitabın dil koduna ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın dil kodu
	 */
	public String getLanguage_code() {
		return language_code;
	}

	/**
	 * Parametre olarak gelen kitabın dil kodunu mevcut kitaba atamak için set
	 * metodu
	 * 
	 * @param language_code Kitabın dil kodu
	 */
	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}

	/**
	 * Mevcut kitabın sayfa sayısına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın sayfa sayısı
	 */
	public int getNum_pages() {
		return num_pages;
	}

	/**
	 * Parametre olarak gelen kitabın sayfa sayısını mevcut kitaba atamak için set
	 * metodu
	 * 
	 * @param num_pages Kitabın sayfa sayısı
	 */
	public void setNum_pages(int num_pages) {
		this.num_pages = num_pages;
	}

	/**
	 * Mevcut kitabın değerlendirme sayısına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın değerlendirme sayısı
	 */
	public int getRatings_count() {
		return ratings_count;
	}

	/**
	 * Parametre olarak gelen kitabın değerlendirme sayısını mevcut kitaba atamak
	 * için set metodu
	 * 
	 * @param ratings_count Kitabın değerlendirme sayısı
	 */
	public void setRatings_count(int ratings_count) {
		this.ratings_count = ratings_count;
	}

	/**
	 * Mevcut kitabın yorum sayısına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın yorum sayısı
	 */
	public int getText_reviews_count() {
		return text_reviews_count;
	}

	/**
	 * Parametre olarak gelen kitabın yorum sayısını mevcut kitaba atamak için set
	 * metodu
	 * 
	 * @param text_reviews_count Kitabın yorum sayısı
	 */
	public void setText_reviews_count(int text_reviews_count) {
		this.text_reviews_count = text_reviews_count;
	}

	/**
	 * Mevcut kitabın yayın tarihine ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın yayın tarihi
	 */
	public String getPublication_date() {
		return publication_date;
	}

	/**
	 * Parametre olarak gelen kitabın yayın tarihini mevcut kitaba atamak için set
	 * metodu
	 * 
	 * @param publication_date Kitabın yayın tarihi
	 */
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	/**
	 * Mevcut kitabın yayıncısına ulaşmak için get metodu
	 * 
	 * @return Mevcut kitabın yayıncısı
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Parametre olarak gelen kitabın yayıncısını mevcut kitaba atamak için set
	 * metodu
	 * 
	 * @param publisher Kitabın yayıncısı
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Parametre olarak gelen kitap nesnesini, kitap listesine ekleyen metot
	 * 
	 * @param book Listeye eklenmek için gelen kitap nesnesi
	 */
	public static void AddBookToBookList(Books book) {
		BooksList.add(book);
	}

	/**
	 * Mevcut kitap listesine ulaşmak için get metodu
	 * 
	 * @return Mevcut kitap listesi
	 */
	public List<Books> getBooksList() {
		return BooksList;
	}

	/**
	 * Console ekranı üzerinden kitap adları listesini görüntülemek için kullanılan
	 * metot
	 */
	public void PrintBooksName() {
		/*
		 * Bir for döngüsü ile kitap listesinin boyutu kadar kitap listesinin içerisinde
		 * gezilir
		 */
		for (int i = 0; i < BooksList.size(); i++) {
			// Her bir kitabın adı listenin o elemanına ulaşılarak console ekranına
			// yazdırılır
			System.out.println(BooksList.get(i).title);
		}
	}
}
