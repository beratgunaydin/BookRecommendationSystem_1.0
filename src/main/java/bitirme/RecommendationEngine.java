package bitirme;

import java.util.List;

import org.apache.commons.text.similarity.SimilarityScore;

import java.util.ArrayList;

/**
 * Öneri sisteminin oluşturulduğu sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class RecommendationEngine {
	/**
	 * Kullanıcı ID'si
	 */
	private int userID;
	/**
	 * Kitap ID'si
	 */
	private int bookID;
	/**
	 * Kitabın kullanıcı tarafından verilen değerlendirme puanı
	 */
	private double rating;
	/**
	 * Kullanıcının değerlendirme puanlarının tutulduğu liste
	 */
	private List<RecommendationEngine> usersRatingsList = new ArrayList<RecommendationEngine>();

	/**
	 * Kullanıcının ID'sine ulaşmak için get metodu
	 * 
	 * @return Kullanıcın ID'si
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * Parametre olarak gelen kullanıcının ID'sini mevcut kullanıcıya atamak için
	 * set metodu
	 * 
	 * @param userID Kullanıcının ID'si
	 */
	private void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * Kullanıcının listesindeki kitabın ID'sine ulaşmak için get metodu
	 * 
	 * @return Kullanıcının listesindeki kitabın ID'si
	 */
	public int getBookID() {
		return bookID;
	}

	/**
	 * Parametre olarak gelen kullanıcının listesindeki kitabın ID'sini mevcut
	 * kullanıcının listesindeki kitabın ID'sine atamak için set metodu
	 * 
	 * @param bookID Kullanıcının listesindeki kitabın ID'si
	 */
	private void setBookID(int bookID) {
		this.bookID = bookID;
	}

	/**
	 * Kullanıcının kitaba verdiği puana ulaşmak için get metodu
	 * 
	 * @return Kullanıcının kitaba verdiği puan
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Parametre olarak gelen kullanıcının kitaba verdiği puanı mevcut kullanıcının
	 * kitaba verdiği puana atamak için set metodu
	 * 
	 * @param rating Kullanıcının kitaba verdiği puan
	 */
	private void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Parametre olarak gelen kullanıcının bilgileri RecommendationEngine türündeki
	 * usersRating nesnesine atanır. usersRating nesnesi, bir döngü ile
	 * usersRatingsList listesine eklenir. RecommendationEngine türünde
	 * bookRecommendations nesnesi oluşturulur ve içine atama yapılması için
	 * recommendBooks metoduna gönderilir. Books nesnesi alan recommendedBooks
	 * isimli bir liste oluşturulur. bookRecommendations nesnesinin içerisinde bir
	 * döngü ile gezilir. Bu döngünün içerisinde tüm kitap listesi içerisinde bir
	 * döngü ile gezilir. Eğer bookRecommendations listesinin elemanının kitap ID'si
	 * ile kitap listesinin elemanının kitap ID'si eşitse recommendedBooks listesine
	 * bu kitap eklenir.
	 * 
	 * @param user                Kitap öneri listesi hazırlanacak kullanıcı
	 * @param similarityThreshold Kullanıcı tarafından belirlenen benzerlik eşik
	 *                            değeri
	 * @return Önerilen kitap listesi
	 */
	public List<Books> addUsersRating(Users user, double similarityThreshold) {
		// RecommendationEngine türünde bir usersRating nesnesi oluşturuldu
		RecommendationEngine usersRating;

		// Kullanıcının okuma listesi içerisinde bir for döngüsü ile dönülür
		for (int i = 0; i < user.getUserReadingList().size(); i++) {
			// usersRating nesnesinin örneği oluşturuldu
			usersRating = new RecommendationEngine();
			// usersRating nesnesinin userID alanına user nesnesinin userID alanı atandı
			usersRating.userID = user.getUserID();
			// usersRating nesnesinin bookID alanına user nesnesinin okuma listesinin
			// elemanının bookID alanı atandı
			usersRating.bookID = user.getUserReadingList().get(i).getBookID();
			// usersRating nesnesinin rating alanına user nesnesinin okuma listesinin
			// elemanının book users_rating alanı atandı
			usersRating.rating = user.getUserReadingList().get(i).getUsers_rating();
			// usersRatingsList listesine usersRating nesnesi eklendi
			usersRatingsList.add(usersRating);
		}
		// bookRecommendations isminde içerisine RecommendationEngine türünde nesne alan
		// bir liste oluşturuldu ve içerisine değer atamak için recommendBook metoduna
		// gönderildi. Parametre olarak usersRatingsList listesi gönderildi
		List<RecommendationEngine> bookRecommendations = recommendBook(usersRatingsList, similarityThreshold);

		// Books sınıfından book adında bir nesne üretildi
		Books book = new Books();
		// recommendedBooks isminde içerisine Books tüüründe nesne alan bir liste
		// oluşturuldu
		List<Books> recommendedBooks = new ArrayList<Books>();

		// Bir for döngüsü ile bookRecommendations listesi içerisinde gezildi
		for (int i = 0; i < bookRecommendations.size(); i++) {
			// Bir for döngüsü ile kitap listesi içerisinde gezilddi
			for (int j = 0; j < book.getBooksList().size(); j++) {
				// Bir if bloğu ile bookRecommendations listesinin elemanının kitap ID'si ile
				// kitap listesinin elemanının kitap ID'sinin eşit olması kontrol edildi
				if (bookRecommendations.get(i).bookID == book.getBooksList().get(j).getBookID()) {
					// Eşit ise recommendedBooks listesine kitap listesinin elemanı atandı.
					recommendedBooks.add(book.getBooksList().get(j));
				}
			}
		}
		// recommendedBooks listesi geri döndürüldü
		return recommendedBooks;
	}

	/**
	 * Bir benzer kullanıcılar listesi oluşturulur. Bu listeye
	 * createSimiliarUsersList metodu ile benzer kullanıcılar atanır. Benzer
	 * kullanıcıların listesinde aynı kitaplar tutulabilir. Kitaplar aynı ise bir
	 * kitap eklemek için bir liste daha oluşturulur. Kullanıcının kitapları ile
	 * benzer kullanıcıların kitapları eşleşmiyorsa ilk oluşturulan listeye eklenir.
	 * 
	 * @param userRatingsList     Öneri listesi oluşturulacak kullanıcının kitap
	 *                            değerlendirme listesi
	 * @param similarityThreshold Kullanıcı tarafından belirlenen benzerlik eşik
	 *                            değeri
	 * @return Önerilecek kitaplar
	 */
	public List<RecommendationEngine> recommendBook(List<RecommendationEngine> userRatingsList,
			double similarityThreshold) {
		// İçerisine RecommendationEngine türünde nesne alan benzer kullanıcıların
		// kitaplarını tutacak bir liste oluşturuldu ve içerisine ekleme yapmak için
		// createSimiliarUsersList metoduna userRatingsList listesi parametre olarak
		// gönderildi. Listeye aynı kitapların eklenmesini önlemek için bir liste daha
		// oluşturulur. Bu listeye listedeki her kitaptan birer adet eklenir.
		List<RecommendationEngine> similiarUsersBooks = createSimiliarUsersList(userRatingsList, similarityThreshold);
		// İçerisine RecommendationsEngine türünde nesne alan benzer kitapları tutacak
		// bir liste oluşturuldu
		List<RecommendationEngine> similiarBooks = new ArrayList<RecommendationEngine>();

		// Bir for döngüsü ile benzer kullanıcıların kitapları içerisinde gezildi
		for (int i = 0; i < similiarUsersBooks.size(); i++) {
			// Bir for döngüsü ile kullanıcının puanlama listesi içerisinde gezildi
			for (int j = 0; j < userRatingsList.size(); j++) {
				// Kullanıcının kitap puanlama listesindeki kitabın ID'si ile benzer
				// kullanıcıların kitabının ID'si eşleşmiyorsa
				if (userRatingsList.get(j).bookID != similiarUsersBooks.get(i).bookID) {
					// benzer kitaplar listesine kitap eklendi
					similiarBooks.add(similiarUsersBooks.get(i));
				}
			}
		}

		// filteredBooks adında içerisine RecommendationEngine türünde nesne alan bir
		// nesne oluşturuldu
		List<RecommendationEngine> filteredBooks = new ArrayList<RecommendationEngine>();

		// similiarBooks listesinin içerisinde gezildi
		for (RecommendationEngine book : similiarBooks) {
			// Kitabın listede olup olmadığının kontrolü için boolean bir değişken
			// oluşturuldu ve başlangıç olarak true değeri atandı
			boolean controle = true;
			// filteredBooks listesinin içerisinde gezildi
			for (RecommendationEngine book2 : filteredBooks) {
				// similiarBooks listesindeki kitap ile filteredBooks listesindeki kitap
				// eşleşiyorsa
				if (book.bookID == book2.bookID) {
					// Boolean değişken false olarak değiştirildi
					controle = false;
				}
			}
			// controle değişkeni doğru ise
			if (controle) {
				// filteredBooks listesine kitap eklendi
				filteredBooks.add(book);
			}
		}
		// similiarBooks listesine filteredBooks listesi atandı
		similiarBooks = filteredBooks;

		// similiarBooks listesi geri döndürüldü
		return similiarBooks;
	}

	/**
	 * Benzer kullanıcılar listesi oluşturur. Bu listeyi oluşturmak için tüm
	 * kullanıcılar listesindeki her bir kullanıcıya gerekli alanları atar.
	 * Benzerlik değeri hesaplanması için iki kullanıcı
	 * computePearsonCorrelationSimilarity metoduna gönderilir. Benzerlik değeri
	 * yüksek olan kullanıcılar benzer kullanıcılar listesine eklenir. Benzerlik
	 * değerinin alt limitini kullanıcıdan alınan değer belirler. Kullanıcı değer
	 * ayarlaması yapmaz ise 0.7 olarak girilir.
	 * 
	 * @param userRatingsList     Benzer kullanıcılar listesi oluşturulacak
	 *                            kullanıcının bilgileri
	 * @param similarityThreshold Kullanıcı tarafından belirlenen benzerlik eşik
	 *                            değeri
	 * @return Benzer kullanıcılar listesi
	 */
	public List<RecommendationEngine> createSimiliarUsersList(List<RecommendationEngine> userRatingsList,
			double similarityThreshold) {
		// Users sınıfından u adlı nesne üretildi
		Users u = new Users();
		// Benzer kullanıcıların kitaplarını tutmak için liste oluşturuldu
		List<RecommendationEngine> similiarUsersBooks = new ArrayList<RecommendationEngine>();

		// Tüm kullanıcılar listesi içerisinde gezildi
		for (int i = 0; i < u.getUsersList().size(); i++) {
			// Eğer listedeki kullanıcının ID'si mevcut kullanıcının ID değerine eşitse
			if (u.getUsersList().get(i).getUserID() == userRatingsList.get(0).userID) {
				// Bu kullanıcı atlandı
				continue;
			}
			// Benzerlik değeri hesaplanacak ikinci kullanıcı için liste oluşturuldu
			List<RecommendationEngine> user2RatingsList = new ArrayList<RecommendationEngine>();
			// Bu kullanıcının kitap listesi içerisinde gezildi
			for (int j = 0; j < u.getUsersList().get(i).getUserReadingList().size(); j++) {
				// RecommendationEngine türünde ikinci kullanıcı için nesne oluşturuldu
				RecommendationEngine user2Ratings = new RecommendationEngine();
				// Nesnenin alanlarına atmalar yapıldı
				user2Ratings.userID = u.getUsersList().get(i).getUserID();
				user2Ratings.bookID = u.getUsersList().get(i).getUserReadingList().get(j).getBookID();
				user2Ratings.rating = u.getUsersList().get(i).getUserReadingList().get(j).getUsers_rating();
				// Kullanıcının kitap ve puan bilgileri listeye eklendi
				user2RatingsList.add(user2Ratings);
			}
			// İki kullanıcı arasındaki benzerliğin hesaplanması için
			// computePearsonCorrelationSimilarity metoduna iki kullanıcının kitap ve puan
			// bilgileri gönderildi
			double similarity = computePearsonCorrelationSimilarity(userRatingsList, user2RatingsList);

			System.out.println(similarityThreshold);
			// Benzerlik benzerlik alt limitinden yüksek ise
			if (similarity > similarityThreshold) {
				// İkinci kullanıcının kitap puanlamaları içinde gezildi
				for (int k = 0; k < user2RatingsList.size(); k++) {
					// Benzer kullanıcılar listesine eklendi
					similiarUsersBooks.add(user2RatingsList.get(k));
				}
			}
		}

		// Benzer kullanıcıların kitapları döndürüldü
		return similiarUsersBooks;
	}

	/**
	 * İki kullanıcı arasındaki benzerlik değerini hesaplamak için Pearson
	 * Korelasyon Katsayısı hesaplanır. Parametre olarak gelen kullanıcıların
	 * listelerindeki ortak kitaplar bir listeye eklenir. Bu liste boş olursa iki
	 * kullanıcı arasında benzerlik yok demektir. İki kullanıcı için de ortak
	 * kitapların değerlendirme puanlarının toplamı hesaplanır. Bu toplamlar ortak
	 * kitap sayısına bölünerek iki kullanıcı için de ortalama puan hesaplanır. İki
	 * kullanıcı için de ortak kitapların varyans değeri hesaplanır. Varyans değeri
	 * her iki kullanıcı için de ortak kitabın ortalamadan çıkarılıp karesinin
	 * alınması ve bu değerlerin toplanması, toplanan değerlerin ortak kitap
	 * sayısına bölünmesi ile hesaplanır. Bu varyans değerleri 0 olabilir. Eğer 0
	 * ise iki kullanıcı arasında anlamlı bir ilişki yok demektir. Benzerlik
	 * değerinin NaN (Not a Number) olarak çıkmaması için iki varyans değerinden en
	 * az birinin 0 olup olmadığı kontrol edilir. Varyans değerleri karekök içine
	 * alınarak iki kullanıcının da standart sapması hesaplanır. Kullanıcıların
	 * ortak kitaplara verdikleri puanlardan ortalama paunları çıkarılır ve bu
	 * değerler çarpılır. Her bir ortak kitap için çarpılan bu değerler toplanır.
	 * Toplanan değerler ortak kitap sayısına bölünerek kovaryans değeri hesaplanır.
	 * Kovaryans değerinin kullanıcıların standart sapma değerlerinin çarpımına
	 * bölümü ile korelasyon katsayısı hesaplanır. Bu katsayı iki kullanıcı
	 * arasındaki benzerlik değeridir.
	 * 
	 * @param userRatingsList  Benzerlik değeri hesaplanacak ilk kullanıcı
	 * @param user2RatingsList Benzerlik değeri hesaplanacak ikinci kullanıcı
	 * @return Benzerlik değeri
	 */
	public double computePearsonCorrelationSimilarity(List<RecommendationEngine> userRatingsList,
			List<RecommendationEngine> user2RatingsList) {
		// Ortak kitapların id değerlerinin tutulacağı liste
		List<Integer> sharedBooksIDs = new ArrayList<>();

		// İlk kullanıcının kitap puanları içerisinde gezildi
		for (int i = 0; i < userRatingsList.size(); i++) {
			// İkinci kullanıcının kitap puanları içerisinde gezildi
			for (int j = 0; j < user2RatingsList.size(); j++) {
				// Ortak kitap varsa
				if (userRatingsList.get(i).bookID == user2RatingsList.get(j).bookID) {
					// Bu ortak kitabın id'si ortak kitap id'leri listesine eklendi
					sharedBooksIDs.add(userRatingsList.get(i).bookID);
				}
			}
		}

		// Ortak kitap yoksa
		if (sharedBooksIDs.isEmpty()) {
			// Bu iki kullanıcı arasında benzerlik yok demektir bu nedenle 0 değeri
			// döndürüldü
			return 0.0;
		}

		// Kullanıcıların ortak kitaplara verdikleri puanların toplamları
		double sumUser1 = 0.0;
		double sumUser2 = 0.0;

		// Ortak kitap listesi içerisinde gezildi
		for (int i = 0; i < sharedBooksIDs.size(); i++) {
			// İlk kullanıcının kitaplara verdikleri puanlar içerisinde gezildi
			for (int j = 0; j < userRatingsList.size(); j++) {
				// Kitaplar ortak ise
				if (userRatingsList.get(j).bookID == sharedBooksIDs.get(i)) {
					// Kullanıcının ortak kitaplara verdiği puanlar toplama eklendi
					sumUser1 += userRatingsList.get(j).rating;
				}
			}

			// İkinci kullanıcının kitaplara verdikleri puanlar içerisinde gezildi
			for (int j = 0; j < user2RatingsList.size(); j++) {
				// Kitaplar ortak ise
				if (user2RatingsList.get(j).bookID == sharedBooksIDs.get(i)) {
					// Kullanıcının ortak kitaplara verdiği puanlar toplama eklendi
					sumUser2 += user2RatingsList.get(j).rating;
				}
			}
		}

		// Kullanıcıların ortak kitaplara verdikleri puanların ortalaması
		double averageUser1 = sumUser1 / sharedBooksIDs.size();
		double averageUser2 = sumUser2 / sharedBooksIDs.size();

		// Kullanıcıların varyans değerleri
		double varianceUser1 = 0.0;
		double varianceUser2 = 0.0;

		// Ortak kitap listesi içerisinde gezildi
		for (int i = 0; i < sharedBooksIDs.size(); i++) {
			// İlk kullanıcının kitaplara verdikleri puanlar içerisinde gezildi
			for (int j = 0; j < userRatingsList.size(); j++) {
				// Kitaplar ortak ise
				if (userRatingsList.get(j).bookID == sharedBooksIDs.get(i)) {
					// Kullanıcının varyans değeri hesaplandı
					varianceUser1 += Math.pow(userRatingsList.get(j).rating - averageUser1, 2);
				}
			}

			// İkinci kullanıcının kitaplara verdikleri puanlar içerisinde gezildi
			for (int j = 0; j < user2RatingsList.size(); j++) {
				// Kitaplar ortak ise
				if (user2RatingsList.get(j).bookID == sharedBooksIDs.get(i)) {
					// Kullanıcının varyans değeri hesaplandı
					varianceUser2 += Math.pow(user2RatingsList.get(j).rating - averageUser2, 2);
				}
			}
		}

		// Kullanıcıların varyans değerleri ortak kitap sayısına bölünerek hesaplandı
		varianceUser1 /= sharedBooksIDs.size();
		varianceUser2 /= sharedBooksIDs.size();

		// Varyans değerleri 0 olabilir değerin NaN olarak çıkmaması için kontrol edildi
		if (varianceUser1 == 0 || varianceUser2 == 0) {
			return 0.0;
		}

		// Kullanıcıların standart sapmaları varyansları karekök içerisine alınarak
		// hesaplandı
		double standardDeviationUser1 = Math.sqrt(varianceUser1);
		double standardDeviationUser2 = Math.sqrt(varianceUser2);

		// Kovaryans değeri
		double covariance = 0.0;

		// İlk kullanıcının kitaplara verdikleri puanlar içerisinde gezildi
		for (int i = 0; i < userRatingsList.size(); i++) {
			// İkinci kullanıcının kitaplara verdikleri puanlar içerisinde gezildi
			for (int j = 0; j < user2RatingsList.size(); j++) {
				// Kitaplar ortak ise
				if (userRatingsList.get(i).bookID == user2RatingsList.get(j).bookID) {
					// Kovaryans değeri hesaplanması için değerler toplandı
					covariance += (userRatingsList.get(i).rating - averageUser1)
							* (user2RatingsList.get(j).rating - averageUser2);
				}
			}
		}
		// Toplanan değerler ortak kitap sayısına bölünerek kovaryans değeri hesaplandı
		covariance /= sharedBooksIDs.size();

		// Kovaryans değeri kullanıcıların standart sapmalarının çarpımına bölünerek
		// korelasyon katsayısı hesaplandı
		double correlation = covariance / (standardDeviationUser1 * standardDeviationUser2);
		return correlation;
	}
}
