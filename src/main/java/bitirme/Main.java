package bitirme;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import org.json.simple.parser.ParseException;

import ui.login;

/**
 * Ana metot
 * 
 * @author Berat
 * @version 1.0.0
 */
public class Main {

	/**
	 * Ana metot
	 * 
	 * @param args komut satırı argümanları
	 */
	public static void main(String[] args) {
		try {
			login lgn = new login();
			lgn.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
