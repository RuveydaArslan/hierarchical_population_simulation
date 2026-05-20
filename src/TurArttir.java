
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

// new ile yeni nesneler üretiliyor
public class TurArttir {
	private Faker faker = new Faker();
	private Yazdir yazdir = new Yazdir();
	// private KisiMahalleArttir arttir = new KisiMahalleArttir();

	public void turArtir(List<Sehir> sehirler) {
		System.out.print("\033[H\033[2J");
		System.out.flush();

		// kurala göre son nüfus verisine göre artış oranı hesaplanıyor

		for (Sehir sehir : sehirler) {
			int onlar = (sehir.toplamNufus / 10) % 10;
			int birler = sehir.toplamNufus % 10;


			int artisOran = onlar + birler;
			if (artisOran == 0) {
				artisOran = 1;
			}
			
			// yeni kişiler oluşturup yaşları arttırılıyor

			for (Ilce ilce : sehir.ilceler) {

				for (Mahalle mahalle : ilce.mahalleler) {
					// System.out.println(ilce.mahalleler.get(0).kisiler.size());
					int mevcut = mahalle.kisiler.size();
					int eklenecek = (artisOran - 1) * mevcut;

					for (int m = 0; m < eklenecek; m++) {
						int kisiId = Kisi.kisiCounter++;
						int mahalleId = mahalle.id;
						String adSoyad = faker.name().fullName();
						int yas = faker.number().numberBetween(0, 51);
						Kisi kisi = new Kisi(kisiId, mahalleId, adSoyad, yas);
						mahalle.kisiler.add(kisi);
					}

					for (Kisi k : mahalle.kisiler) {
						k.yas++;
					}

				}

			}

			sehir.toplamNufus = hesaplaNufus(sehir);

		}

		System.out.println("-----Artış sonrasındaki nüfuslar------");
		yazdir.yazdir(sehirler);

		// eğer nüfus 1000'i aşarsa kurala göre bölünüp yeni mahalle ve şehirler
		// oluşturuluyor

		List<Sehir> yeniOlusanSehirler = new ArrayList<>();
		for (Sehir eskiSehir : sehirler) {

			if (eskiSehir.toplamNufus >= 1000) {
				int toplamIlce = eskiSehir.ilceler.size();

				if (toplamIlce >= 2) {
					int tasinacakIlceSayisi;

					if (toplamIlce % 2 == 0) {
						tasinacakIlceSayisi = toplamIlce / 2;
					} else {
						tasinacakIlceSayisi = (toplamIlce - 1) / 2;
					}

					Sehir yeniSehir = new Sehir(Sehir.sehirCounter++, faker.address().cityName());
					yeniSehir.ilceler = new ArrayList<>();

					for (int i = 0; i < tasinacakIlceSayisi; i++) {
						Ilce tasinanIlce = eskiSehir.ilceler.remove(eskiSehir.ilceler.size() - 1);
						tasinanIlce.sehirId = yeniSehir.id;
						yeniSehir.ilceler.add(tasinanIlce);
					}

					eskiSehir.toplamNufus = hesaplaNufus(eskiSehir);

					yeniSehir.toplamNufus = hesaplaNufus(yeniSehir);

					yeniOlusanSehirler.add(yeniSehir);
				}

				else if (toplamIlce == 1) {
					Ilce tekIlce = eskiSehir.ilceler.get(0);

					if (tekIlce.mahalleler.size() >= 2) {

						int tasinacakMahalle = tekIlce.mahalleler.size() / 2;

						Ilce yeniIlce = new Ilce(Ilce.ilceCounter++, eskiSehir.id, faker.address().streetName());
						yeniIlce.mahalleler = new ArrayList<>();

						for (int i = 0; i < tasinacakMahalle; i++) {
							Mahalle mahalle = tekIlce.mahalleler.remove(tekIlce.mahalleler.size() - 1);
							mahalle.ilceId = yeniIlce.id;
							yeniIlce.mahalleler.add(mahalle);
						}
						Sehir yeniSehir = new Sehir(Sehir.sehirCounter++, faker.address().cityName());
						yeniSehir.ilceler = new ArrayList<>();
						yeniSehir.ilceler.add(yeniIlce);

						eskiSehir.toplamNufus = hesaplaNufus(eskiSehir);
						yeniSehir.toplamNufus = hesaplaNufus(yeniSehir);

						yeniOlusanSehirler.add(yeniSehir);
					} else if (tekIlce.mahalleler.size() == 1) {

						Mahalle eskiMahalle = tekIlce.mahalleler.get(0);

						List<Kisi> kisiler = eskiMahalle.kisiler;

						int yarisi = kisiler.size() / 2;

						Mahalle yeniMahalle = new Mahalle(Mahalle.mahalleCounter++, tekIlce.id,
								faker.address().streetName());
						yeniMahalle.adi = faker.address().streetName();
						yeniMahalle.kisiler = new ArrayList<>();

						for (int i = 0; i < yarisi; i++) {
							Kisi k = kisiler.remove(kisiler.size() -1);
							k.mahalleId = yeniMahalle.id;
							yeniMahalle.kisiler.add(k);
						}
						Ilce yeniIlce = new Ilce(Ilce.ilceCounter++, eskiSehir.id, faker.address().streetName());
						yeniIlce.adi = faker.address().streetName();
						yeniIlce.mahalleler = new ArrayList<>();
						yeniIlce.mahalleler.add(yeniMahalle);

						Sehir yeniSehir = new Sehir(Sehir.sehirCounter++, faker.address().cityName());
						yeniSehir.adi = faker.address().cityName();
						yeniSehir.ilceler = new ArrayList<>();
						yeniSehir.ilceler.add(yeniIlce);

						eskiSehir.toplamNufus = hesaplaNufus(eskiSehir);
						yeniSehir.toplamNufus = hesaplaNufus(yeniSehir);

						yeniOlusanSehirler.add(yeniSehir);

					}
				}

			}

		}
		sehirler.addAll(yeniOlusanSehirler);

		System.out.println("-----Bölünme sonrasındaki nüfuslar-----");
		yazdir.yazdir(sehirler);

	}

	public int hesaplaNufus(Sehir sehir) {
		int toplam = 0;

		for (Ilce ilce : sehir.ilceler) {
			if (ilce.mahalleler == null)
				continue;

			for (Mahalle mahalle : ilce.mahalleler) {
				if (mahalle.kisiler == null)
					continue;
				toplam += mahalle.kisiler.size();
			}
		}

		return toplam;

	}

}
