package bitirme;

import java.io.*;

/**
 * Veri setindeki kitapları kitap listesine atayan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class CSVReader {

	/**
	 * // Books.csv dosyasındaki kitap veri setini alıp, işleyip, kitap listesine
	 * eklenmesi için gönderen metot
	 */
	public static void CsvReader() {
		// Okunacak dosyanın yolu
		String path = "data/books.csv";
		String line;

		// Dosya yolunun doğru olup olmamasının kontrolü için try catch bloğu
		// oluşturuldu
		try {
			// BufferedReader sınıfının bir örnek nesnesi oluşturuldu ve içerisine okunacak
			// dosya gönderildi
			BufferedReader br = new BufferedReader(new FileReader(path));

			// Eğer okunulacak satır boş değilse
			while ((line = br.readLine()) != null) {
				// Split metodu ile mevcut satır virgüller arası ayrıldı ve String türünde bir
				// diziye atandı
				String[] booksProperties = line.split(",");
				// Books sınıfından bir kitap nesnesi oluşturuldu
				Books book = new Books();
				// Kitap özellikleri set metotları kullanılarak oluşturulan book nesnesinin
				// özelliklerine atandı
				book.setBookID(Integer.parseInt(booksProperties[0]));
				book.setTitle(booksProperties[1]);
				book.setAuthors(booksProperties[2]);
				book.setAverage_rating(Double.parseDouble(booksProperties[3]));
				book.setIsbn(booksProperties[4]);
				book.setIsbn13(booksProperties[5]);
				book.setLanguage_code(booksProperties[6]);
				book.setNum_pages(Integer.parseInt(booksProperties[7]));
				book.setRatings_count(Integer.parseInt(booksProperties[8]));
				book.setText_reviews_count(Integer.parseInt(booksProperties[9]));
				book.setPublication_date(booksProperties[10]);
				book.setPublisher(booksProperties[11]);

				// Özellikleri atanan book nesnesi kitap listesine eklendi
				Books.AddBookToBookList(book);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
