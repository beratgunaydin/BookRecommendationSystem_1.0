package bitirme;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 * Json simple kütüphanesini kullanarak veri setindeki kullanıcıları kullanıcı
 * listesine atayan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class JSONReader {

	/**
	 * usersInformation.json dosyasından verileri alıp ayrıştıran metot
	 * 
	 * @throws org.json.simple.parser.ParseException Verisetindeki veriler
	 *                                               ayrıştırılırken bir sorun
	 *                                               çıkarsa verilecek hata
	 */
	@SuppressWarnings("unchecked")
	public static void JsonReader() throws org.json.simple.parser.ParseException {
		// JSONParser sınıfından veriyi ayrıştırmak için bir nesne oluşturuldu
		JSONParser jsonParser = new JSONParser();

		// Dosyaya ulaşılamaması durumunda hata mesajı vermek için bir try catch bloğu
		// oluşturuldu
		try {
			// Bir obje oluşturuldu ve json dosyasının parse metodu ile ayrıştırılmış hali
			// bu objeye atandı
			Object obj = jsonParser.parse(new FileReader("data/usersInformation.json"));
			// JSONArray türünde bir userList JSON dizisi oluşturuldu ve oluşturulan obje
			// JSONArray türüne çevrilerek userList'e atandı
			JSONArray userList = (JSONArray) obj;

			// JSONArray sınıfının forEach metodu ile userList içerisinde gezilmek için
			// parseUserObj metoduna user isminde JSON objesi gönderildi
			userList.forEach(user -> parseUserObj((JSONObject) user));

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Kullanıcı verilerini ayrıştıran ve bunu kullanıcı listesine ekleyen metot
	 * 
	 * @param user Kullanıcı listesine eklenecek kullanıcı
	 */
	private static void parseUserObj(JSONObject user) {
		// Users sınıfından bir users nesnesi oluşturuldu
		Users users = new Users();
		// Kullanıcının ID değerini belirlemek için Users sınıfının setUserID metoduna
		// gidildi
		users.setUserID();
		// Bir JSON objesi oluşturuldu ve user objesinin user adı verilen alanı bu
		// objeye atandı
		JSONObject userObj = (JSONObject) user.get("user");
		// users nesnesine user objesinin Name adı verilen alanı bu objeye atandı
		users.setUserName((String) userObj.get("Name"));
		// users nesnesine user objesinin Password adı verilen alanı bu objeye atandı
		users.setUserPassword((String) userObj.get("Password"));
		// users nesnesine user objesinin Country adı verilen alanı bu objeye atandı
		users.setCountry((String) userObj.get("Country"));
		// Kullanıcının okuma listesi oluşturmak için setUserReadingList metodu
		// çağırıldı ve içine parametre olarak CreateUsersReadingList metodunun
		// parmetresi users nesnesi olacak şekilde gönderildi
		users.setUserReadingList(users.CreateUsersReadingList(users));
		// Kullanıcıyı kullanıcı listesine eklemek için Users sınıfının
		// AddUserToUsersList metodu çağrıldı ve parametre olarak users nesnesi
		// gönderildi
		Users.AddUserToUsersList(users);
	}

}
