
import java.util.List;
import java.util.ArrayList;

import com.github.javafaker.Faker;

public class SehirOlustur {

	private Faker faker = new Faker();

	// kurala göre girilen nüfuslara göre ilçe ve mahalle sayısı alınıyor

	public List<Sehir> sehirOlustur(String il) {
		List<Sehir> sehirler = new ArrayList<>();
		String[] parcala = il.split(" ");
		for (String string : parcala) {
			int sayi = Integer.parseInt(string);
			int birler = sayi % 10;
			int onlar = sayi / 10;
			int ilceSayisi = sayi / 10;
			int mahalleSayisi = sayi % 10;
			int toplamNufus = sayi;

			
			int sabitMahalleSayisi = birler;
			int sabitIlceSayisi = onlar;
			
	
			if (sabitMahalleSayisi == 0) {
				sabitMahalleSayisi = sabitIlceSayisi;
			}
			else if (sabitMahalleSayisi%sabitIlceSayisi != 0) {

				int artiralacakMahalleSayisi = sabitIlceSayisi - (sabitMahalleSayisi%sabitIlceSayisi);

				if(((toplamNufus+artiralacakMahalleSayisi)/10)!=sabitIlceSayisi) {
					sabitMahalleSayisi -= (sabitMahalleSayisi%sabitIlceSayisi);
				}
				else {
					sabitMahalleSayisi += artiralacakMahalleSayisi;
				}
			}
			toplamNufus = sabitIlceSayisi * 10 + sabitMahalleSayisi;
			
			int yedekNufus = toplamNufus;//25->26 olunca 25 sayısını tutmak için yeni değişken oluşturdum
			int yedekMahalleSayisi=yedekNufus%10;
			int yedekIlceSayisi = yedekNufus/10;
			
			if (toplamNufus % sabitMahalleSayisi != 0) {

				int artiralacakNufus = sabitMahalleSayisi - (toplamNufus % sabitMahalleSayisi);
				toplamNufus += artiralacakNufus;
			}
	

			int kisiMahalle = toplamNufus / sabitMahalleSayisi;

			int mahallePerIlce = sabitMahalleSayisi / sabitIlceSayisi;
			int id = Sehir.sehirCounter++;
			String adi =faker.address().cityName();
			
			Sehir sehir = new Sehir(id,adi);
			
			sehir.kisiMahalle = kisiMahalle;
			sehir.toplamNufus = toplamNufus;
			sehir.sabitMahalleSayisi = sabitMahalleSayisi;
			sehir.sabitIlceSayisi = sabitIlceSayisi;

			
			for (int i = 0; i < sabitIlceSayisi; i++) {
				int ilceId = Ilce.ilceCounter++;
				int sehirId = sehir.id;
				String ilceAdi = faker.address().streetName();
				Ilce ilce = new Ilce(ilceId,sehirId,ilceAdi);

				for (int j = 0; j < mahallePerIlce; j++) {
					int mahalleId = Mahalle.mahalleCounter++;
					int ilce_id= ilce.id;
					String mahalleAdi = faker.address().streetAddress();
					Mahalle mahalle = new Mahalle(mahalleId,ilce_id,mahalleAdi);

					for (int k = 0; k < kisiMahalle; k++) {
						int kisiId =Kisi.kisiCounter++;
						int mahalle_id = mahalle.id;
						String adSoyad = faker.name().fullName();
						int yas = faker.number().numberBetween(0, 51);
						Kisi kisi = new Kisi(kisiId,mahalle_id,adSoyad,yas);
						mahalle.kisiler.add(kisi);
					}
					ilce.mahalleler.add(mahalle);
				}
				sehir.ilceler.add(ilce);
			}
			sehirler.add(sehir);
		}
		return sehirler;
	}
}
