package bitirme;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Eklenen kullanıcıların usersInformation.json dosyasına yazılmasını sağlayan
 * sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class JSONWriter {

	/**
	 * Eklenen kullanıcıların json dosyasına ekleyen metot. Bir user adında nesnenin
	 * içine Name, Password ve Country alanlarına karşılık gelen değerleri ekler
	 * 
	 * @param userObj usersInformation.json dosyasına eklenecek olan kullanıcı
	 * @throws ParseException Veriyi ayrıştırma sırasında bir hata meydana
	 *                        geldiğinde verilecek hata mesajı
	 */
	@SuppressWarnings("unchecked")
	public static void JsonWriter(Users userObj) throws ParseException {
		// JSONParser sınıfından bir nesne oluşturuldu
		JSONParser jsonParser = new JSONParser();

		// json dosyasının bulunamama ihtimalinde verilecek hata mesajı için bir try
		// catch bloğu oluşturuldu
		try {
			// Bir obje oluşturuldu ve JSONParser sınıfının parse metodu ile
			// usersInformation.json dosyasındaki veri ayrıştırıldı
			Object obj = jsonParser.parse(new FileReader("data/usersInformation.json"));
			// userList adında bir JSONArray dizisi oluşturuldu ve oluşturulan obje
			// JSONArray tipine dönüştürülerek bu diziye atandı
			JSONArray userList = (JSONArray) obj;

			// userDetails adında bir JSONObject nesnesi oluşturuldu
			JSONObject userDetails = new JSONObject();
			// userDetails nesnesinin Name adlı alanına parametre olarak gelen Users
			// tipindeki nesnenin getUserName metodu ile kullanıcı adı atandı
			userDetails.put("Name", userObj.getUserName());
			// userDetails nesnesinin Password adlı alanına parametre olarak gelen Users
			// tipindeki nesnenin getUserPassword metodu ile şifresi atandı
			userDetails.put("Password", userObj.getUserPassword());
			// userDetails nesnesinin Country adlı alanına parametre olarak gelen Users
			// tipindeki nesnenin getCountry metodu ile ülke ismi atandı
			userDetails.put("Country", userObj.getCountry());

			// userObject adında bir JSONObjec nesnesi oluşturuldu
			JSONObject userObject = new JSONObject();
			// userObject nesnesinin içine put metodu ile user isimli alana userDetails
			// nesnesi yerleştirildi
			userObject.put("user", userDetails);

			// Ayrıştırılan userList adlı JSON dizisine userObject nesnesi eklendi
			userList.add(userObject);

			// Bir try catch bloğu ile usersInformation.json dosyasının bulunamama
			// ihtimaline karşın verilecek hata mesajı ayarlandı
			try (FileWriter file = new FileWriter("data/usersInformation.json")) {
				file.write(userList.toJSONString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
