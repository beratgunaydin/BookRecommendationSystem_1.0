package bitirme;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.opencsv.CSVWriter;

/**
 * Kullanıcı nesnesinin oluşturulduğu ve kullanıcı işlemlerinin yapıldığı sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class Users {
	/**
	 * Kullanıcı ID'si
	 */
	private int user_id;
	/**
	 * Kullanıcı adı
	 */
	private String user_name;
	/**
	 * Kullanıcının şifresi
	 */
	private String user_password;
	/**
	 * Kullanıcının ülkesi
	 */
	private String country;
	/**
	 * Kullanıcının okuduğu kitaplar listesi
	 */
	private List<Books> user_reading_list = new ArrayList<Books>();

	/**
	 * Kullanıcı listesi, static olma sebebi tek olmalı ve bir yerde
	 * değiştirildiğinde her yerde değişmeli
	 */
	private static List<Users> usersList = new ArrayList<Users>();

	/**
	 * Mevcut kullanıcı ID'sine ulaşmak için get metodu
	 * 
	 * @return Mevcut kullanıcının ID'si
	 */
	public int getUserID() {
		return user_id;
	}

	/**
	 * Kullanıcın ID'sinin atandığı set metodu, atanan kullanıcılara otomatik olarak
	 * id atar. Listeye her kullanıcı eklendiğinde indeks değeri bir artar ve
	 * kullanıcı ID'sini 1 değerinden başlatmak için lstenin boyutunun 1 fazlası
	 * kullanıcı ID'sine atanır.
	 */
	public void setUserID() {
		user_id = usersList.size() + 1;
	}

	/**
	 * Mevcut kullanıcı adına ulaşmak için get metodu
	 * 
	 * @return Mevcut kullanıcının adı
	 */
	public String getUserName() {
		return user_name;
	}

	/**
	 * Parametre olarak gelen kullanıcı adını mevcut kullanıcı adına atamak için set
	 * metodu
	 * 
	 * @param user_name Kullanıcı adı
	 */
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * Mevcut kullanıcı şifresine ulaşmak için get metodu
	 * 
	 * @return Mevcut kullanıcının şifresi
	 */
	public String getUserPassword() {
		return user_password;
	}

	/**
	 * Parametre olarak gelen kullanıcının şifresini mevcut kullanıcının şifresine
	 * atamak için set metodu
	 * 
	 * @param user_password Kullanıcının şifresi
	 */
	public void setUserPassword(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * Mevcut kullanıcının ülkesine ulaşmak için get metodu
	 * 
	 * @return Mevcut kullanıcının ülkesi
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Parametre olarak gelen kullanıcının ülkesini mevcut kullanıcının ülkesine
	 * atamak için set metodu
	 * 
	 * @param country Kullanıcının ülkesi
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Mevcut kullanıcının kitap listesine ulaşmak için get metodu
	 * 
	 * @return Mevcut kullanıcının kitap listesi
	 */
	public List<Books> getUserReadingList() {
		return user_reading_list;
	}

	/**
	 * Parametre olarak gelen kullanıcının kitap listesini mevcut kullanıcının kitap
	 * listesine atamak için set metodu
	 * 
	 * @param user_reading_list Kullanıcının kitap listesi
	 */
	public void setUserReadingList(List<Books> user_reading_list) {
		this.user_reading_list = user_reading_list;
	}

	/**
	 * Mevcut kullanıcı listesine ulaşmak için get metodu
	 * 
	 * @return Mevcut kullanıcı listesi
	 */
	public List<Users> getUsersList() {
		return usersList;
	}

	/**
	 * Parametre olarak gelen kullanıcının kitap listesini oluşturur. Kitap nesnesi
	 * içeren iki liste oluşturulur. usersReadingList ve bookList. bookList'e tüm
	 * kitapların listesi atanır. Random bir sayı oluşturulur ve bu sayı kadar
	 * dönecek bir döngü oluşturulur. Bu döngü içerisinde 1 ile kitap listesinin
	 * boyutu arasında bir kitap listeye random olarak atanır. Bir döngü ile
	 * usersReadingList listesi içerisinde gezilir ve kullanıcının kitaplara
	 * puanları random olarak atanır.
	 * 
	 * @param user Kitap okuma listesi oluşturulacak kullanıcı
	 * @return Oluşturulan kitap okuma listesi
	 */
	public List<Books> CreateUsersReadingList(Users user) {
		List<Books> usersReadingList = null;

		// Öneri sistemi için benzer kullanıcılar oluşturmak için 2. kullanıcıdan 49.
		// kullanıcıya kadar random bir şekilde kitap listesi oluşturulur
		if (user.getUserID() != 1 && user.getUserID() < 50) {
			// Books sınıfından book isimli bir nesne oluşturuldu
			Books book = new Books();
			// Books nesnesi içerecek usersReadingList adında bir liste oluşturuldu
			usersReadingList = new ArrayList<Books>();
			// Books nesnesi içerecek bookList adında bir liste oluşturuldu
			List<Books> bookList = book.getBooksList();

			// Random sınıfından rnd isimli bir nesne oluşturuldu
			Random rnd = new Random();
			// randomNumber adında bir integer tipinde değişken oluşturuldu ve bu değişkene
			// 20 ile 30 arasında değer atandı
			int randomNumber = rnd.nextInt(50, 60);

			// Oluşturulan randomNumber sayısı kadar dönecek bir for döngüsü oluşturuldu
			for (int i = 1; i <= randomNumber; i++) {
				// usersReadingList adlı listeye tüm kitapların listesinden random olarak kitap
				// eklendi
				usersReadingList.add(bookList.get(rnd.nextInt(1, bookList.size())));
			}

			// usersReadingList içerisinde gezinmek için bir for döngüsü oluşturuldu
			for (int i = 0; i < usersReadingList.size(); i++) {
				// 0 ile 5 arasında random olarak bir double sayı oluşturuldu ve rating_value
				// değişkeninine atandı
				double rating_value = rnd.nextDouble(0, 5);
				// Kullanıcının kitap okuma listesindeki kitaplara random olarak puanlama
				// sistemi oluşturuldu
				usersReadingList.get(i).setUsers_rating(rating_value);
			}
			// Kullanıcı kitap okuma listesi döndürüldü
		}

		else {
			// Books sınıfından book isimli bir nesne oluşturuldu
			Books book = new Books();
			// Books nesnesi içerecek usersReadingList adında bir liste oluşturuldu
			usersReadingList = new ArrayList<Books>();
			// Books nesnesi içerecek bookList adında bir liste oluşturuldu
			List<Books> bookList = book.getBooksList();

			// Random sınıfından rnd isimli bir nesne oluşturuldu
			Random rnd = new Random();

			// usersReadingList adlı listeye tüm kitapların listesinden random olarak kitap
			// eklendi
			usersReadingList.add(bookList.get(rnd.nextInt(1, bookList.size())));
			double rating_value = rnd.nextDouble(0, 5);
			usersReadingList.get(0).setUsers_rating(rating_value);
		}
		return usersReadingList;
	}

	/**
	 * Kullanıcıyı kullanıcı listesine ekler
	 * 
	 * @param user Listeye eklenecek kullanıcı
	 */
	public static void AddUserToUsersList(Users user) {
		// Parametre ile gelen kullanıcı kullanıcı listesine eklendi
		usersList.add(user);
	}

	/**
	 * Console ekranında görüntüleyebilmek için parametre ile gelen kullanıcının
	 * bilgileri ekrana yazdırılır.
	 * 
	 * @param user Bilgileri görüntülenmek istenen kullanıcı
	 */
	public void GetUsersInformation(Users user) {
		// Kullanıcının ID'si console ekranına yazdırıldı
		System.out.println(user.getUserID());
		// Kullanıcının adı console ekranına yazdırıldı
		System.out.println(user.getUserName());
		// Kullanıcının ülkesi console ekranına yazdırıldı
		System.out.println(user.getCountry());
		System.out.println(" ");
		System.out.print("Reading List : ");

		// Kullanıcının kitap okuma listesi içerisinde for döngüsü ile gezildi
		for (int i = 0; i < user.getUserReadingList().size(); i++) {
			// Kullanıcının kitap okuma listesindeki kitap isimleri teker teker aralarında
			// virgül ile console ekranında yazdırıldı
			System.out.print(user.getUserReadingList().get(i).getTitle() + ", ");
		}
	}

	/**
	 * Tüm kullanıcıların bilgileri console ekranına yazdırılır.
	 */
	public void PrintUsersInformation() {
		// Kullanıcı listesi içerisinde for döngüsü ile gezildi
		for (int i = 0; i < usersList.size(); i++) {
			// Kullanıcının ID'si console ekranına yazdırıldı
			System.out.println("User ID : " + usersList.get(i).getUserID());
			// Kullanıcının adı console ekranına yazdırıldı
			System.out.println("User Name : " + usersList.get(i).getUserName());
			// Kullanıcının ülkesi console ekranına yazdırıldı
			System.out.println("Country : " + usersList.get(i).getCountry());
			System.out.print("Users Reading List : ");

			// Kullanıcının kitap okuma listesi içerisinde for döngüsü ile gezildi
			for (int j = 0; j < usersList.get(i).getUserReadingList().size(); j++) {
				// Kullanıcının kitap okuma listesindeki kitap isimleri teker teker aralarında
				// virgül ile console ekranında yazdırıldı
				System.out.print(usersList.get(i).getUserReadingList().get(j).getTitle() + ", ");
			}
			System.out.println(" ");
			System.out.println(" ");
		}
	}

	/**
	 * Giriş yapmak isteyen kullanıcının bilgileri ile sistemdeki bir kullanıcının
	 * bilgilerinin eşleşip eşleşmediğine bakılır. Sistemde böyle bir kullanıcı
	 * mevcutsa true değeri döndürür.
	 * 
	 * @param userName      Giriş yapmak isteyen kullanıcının adı
	 * @param passwordInput Giriş yapmak isteyen kullanıcının şifresi
	 * @param user          Kullanıcı nesnesi
	 * @return Kullanıcı sitemde mevcutsa true, değilse false
	 */
	public static boolean SearchUserName(String userName, String passwordInput, Users user) {
		// Kullanıcının adının doğru olup olmadığını kontrol etmek için tempUserName
		// adlı boolean bir değişken oluşturuldu ve bu değişkene başlangıç olarak false
		// değeri atandı
		boolean tempUserName = false;
		// Kullanıcının şifresinin doğru olup olmadığını kontrol etmek için tempPassword
		// adlı boolean bir değişken oluşturuldu ve bu değişkene başlangıç olarak false
		// değeri atandı
		boolean tempPassword = false;

		// Kullanıcı listesi içerisinde for döngüsü ile gezildi
		for (int i = 0; i < usersList.size(); i++) {
			// Girilen kullanıcı adının sistemde kayıtlı olup olmadığı kontrol edildi
			if (usersList.get(i).user_name.contentEquals(userName)) {
				// Kullanıcı sistemde kayıtlı ise

				// Kullanıcı şifresinin doğru olup olmadığının kontrolü için ConfirmPassword
				// metoduna bilgiler gönderildi
				tempPassword = ConfirmPassword(i, user, passwordInput, tempUserName);
				// Kullanıcı adının doğru olduğunu belirten true değeri atandı
				tempUserName = true;
				break;
			}
		}
		// Kullanıcı adı ve şifre doğru ise true değeri döndürüldü
		if (tempUserName == true && tempPassword == true) {
			return true;
		}

		// İkisinden biri veya her ikisi de yanlış ise false değeri döndürüldü
		else
			return false;
	}

	/**
	 * Girilen kullanıcı adına sahip hesabın şifresinin doğru girilip girilmediği
	 * kontrol edilir.
	 * 
	 * @param i             Giriş yapmak isteyen kullanıcının kullanıcı listesindeki
	 *                      indeks değeri
	 * @param user          Kullanıcı nesnesi
	 * @param passwordInput Giriş yapmak isteyen kullanıcının girdiği şifre
	 * @param tempUserName  Kullanıcı adının doğru olup olmadığı bilgisi
	 * @return Şifre hesap ile örtüşüyorsa true, örtüşmüyorsa false
	 */
	private static boolean ConfirmPassword(int i, Users user, String passwordInput, boolean tempUserName) {
		// Kullanıcının şifresinin doğru olup olmadığını kontrol etmek için tempPassword
		// adlı boolean bir değişken oluşturuldu ve bu değişkene başlangıç olarak false
		// değeri atandı
		boolean tempPassword = false;

		// Giriş yapmak isteyen kullanıcının hesabının şifresinin doğru girilip
		// girilmediği kontrol edildi
		if (usersList.get(i).user_password.contentEquals(passwordInput)) {
			tempPassword = true;
		}
		// tempPassword değişkeni döndürüldü
		return tempPassword;
	}

	/**
	 * Girilen kullanıcı adının kullanıcı listesindeki indeks değeri bulunur.
	 * 
	 * @param userName Girilen kullanıcı adı
	 * @return Kullanıcı adının kullanıcı listesindeki indeks değeri
	 */
	public static int GetUserIndex(String userName) {
		// İndeks değerini döndürebilmek için for döngüsü dışında tanımlandı
		int i = 0;

		// Kullanıcı listesi içerisinde for döngüsü ile gezildi
		for (i = 0; i < usersList.size(); i++) {
			// Kullanıcı listesinde kullanıcı adı arandı
			if (usersList.get(i).user_name.contentEquals(userName)) {
				// Kullanıcı adı bulunursa indeks değerinin değişmemesi için döngü bitirildi
				break;
			}
		}
		// İndeks değeri döndürüldü
		return i;
	}

	/**
	 * Kullanıcı verisetine eklenir. Kullanıcının sistemde var olup olmadığı kontrol
	 * edilir. Eğer sistemde mevcut değilse verisetine eklenir
	 * 
	 * @param userObj Verisetine eklenecek kullanıcı
	 * @throws ParseException veriseti ayrıştırılırken hata meydana gelirse
	 *                        verilecek hata mesajı
	 */
	public void AddUserToJSONFile(Users userObj) throws ParseException {
		// Kullanıcının sistemde var olup olmadığının kontrol edilmesi için hasUser
		// adında boolean bir değişken oluşturuldu ve başlangıç olarak false değeri
		// atandı
		boolean hasUser = false;

		// Kullanıcı listesi içerisinde for döngüsü ile gezildi
		for (int i = 0; i < usersList.size(); i++) {
			// Kullanıcının sistemde var olup olmadığı kontrol edildi
			if (userObj.getUserName().equals(usersList.get(i).getUserName())) {
				// Kullanıcı sistemde mevcutsa hasUser değişkenine true değeri atandı
				hasUser = true;
			}
		}

		// Kullanıcı sistemde mevcut değilse
		if (!hasUser) {
			// JSONWriter sınıfının JsonWriter metoduna kullanıcı bilgileri sisteme eklenmek
			// için gönderildi
			JSONWriter.JsonWriter(userObj);
		}
	}
}
