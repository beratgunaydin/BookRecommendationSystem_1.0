package ui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bitirme.Books;
import bitirme.Users;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Ayarlar ekranını oluşturan sınıf
 * 
 * @author Berat
 * @version 1.0.0
 */
public class Settings extends JFrame {

	/**
	 * Sayfanın düzeni için container
	 */
	private JPanel contentPane;
	/**
	 * Benzerlik alt limiti
	 */
	private JLabel thresholdValue;
	/**
	 * Kullanıcının bilgilerinin tutulacağı nesne
	 */
	private Users user;
	/**
	 * Daha önceden belirlenmiş benzerlik alt limiti
	 */
	private double similarityThreshold;

	/**
	 * Kullanıcı bilgilerini ve daha önceden belirlenmiş veya default olarak
	 * verilmiş benzerlik alt limitini getirir
	 * 
	 * @param user                Giriş yapan kullanıcı bilgileri
	 * @param similarityThreshold Giriş yapan kullanıcının daha önceden belirlediği
	 *                            minimum benzerlik değeri
	 */
	public void setUser(Users user, double similarityThreshold) {
		this.user = user;
		// Daha önce belirlenmiş olan benzerlik alt limiti sınıftaki bu değeri tutacak
		// değişkene atandı
		this.similarityThreshold = similarityThreshold;
		// Ekranda gösterilen benzerlik alt limiti değeri atanan değişken ile
		// güncellendi
		thresholdValue.setText(String.valueOf(similarityThreshold));
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
					Settings frame = new Settings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Ayarlar sayfasının görünümünü ayarlar, içerisinde kullanıcının benzerlik alt
	 * limitini ayarlayabildiği alanı ve ana sayfaya geri dönülecek butonu
	 * barındırır.
	 */
	public Settings() {
		setBackground(new Color(150, 126, 118));
		setTitle("Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 126, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSimilarityThreshold = new JLabel("Similarity Threshold");
		lblSimilarityThreshold.setForeground(new Color(183, 196, 207));
		lblSimilarityThreshold.setFont(new Font("Consolas", Font.BOLD, 21));
		lblSimilarityThreshold.setBounds(21, 46, 405, 38);
		contentPane.add(lblSimilarityThreshold);

		thresholdValue = new JLabel("");
		thresholdValue.setForeground(new Color(183, 196, 207));
		thresholdValue.setFont(new Font("Consolas", Font.BOLD, 21));
		thresholdValue.setBounds(125, 130, 173, 38);
		contentPane.add(thresholdValue);

		// Kullanıcının ekranda sürükleyerek benzerlik alt limitini belirleyebileceği
		// alan oluşturuldu
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 70);
		slider.addChangeListener(new ChangeListener() {
			// Slider'ın konumu değiştirildiğinde
			public void stateChanged(ChangeEvent e) {
				// Bir değişkene slider'ın sahip olduğu değer atandı.
				int value = slider.getValue();
				// Slider'ın tuttuğu değer Integer veri tipinde olduğu ve benzerlik alt limiti
				// Double türünde olduğu için Slider'a 0 ile 100 değer aralğı verildi.
				// Sonrasında bu değer 100'e bölünerek benzerlik limiti ayarlandı.
				double tValue = (double) value / 100;
				// Ekranda ayarlanan benzerlik değeri güncellendi
				thresholdValue.setText(String.valueOf(tValue));
				// Sınıfta tutulan alana ayarlanan değer atandı
				similarityThreshold = tValue;
			}
		});
		slider.setBackground(new Color(238, 227, 203));
		slider.setBounds(105, 94, 200, 22);
		contentPane.add(slider);

		JButton ApplyandGoBackToHomePageButton = new JButton("Apply and Go Back To Home Page");
		ApplyandGoBackToHomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setUser(user, similarityThreshold);
				hp.setVisible(true);
			}
		});
		ApplyandGoBackToHomePageButton.setForeground(new Color(150, 126, 118));
		ApplyandGoBackToHomePageButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		ApplyandGoBackToHomePageButton.setBackground(new Color(238, 227, 203));
		ApplyandGoBackToHomePageButton.setBounds(125, 209, 301, 30);
		contentPane.add(ApplyandGoBackToHomePageButton);
	}
}
