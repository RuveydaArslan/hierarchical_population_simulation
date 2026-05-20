

import java.util.List;
import java.util.Scanner;

public class SeciliSehir {

	// son turdaki şehir nüfuslarından kullanıcıdan alınan satır ve sütun numaraları
	// ile o şehre ait
	// kişileri, id ve yaş bilgileri gösteriliyor

	public void seciliSehir(List<Sehir> sehirler) {
		Scanner scanner = new Scanner(System.in);
		boolean devam = true;
		while (devam) {
			System.out.print("Satır numarası (0'dan başlayarak girin): ");
			int satir = scanner.nextInt();
			System.out.print("Sütun numarası (0'dan başlayarak girin): ");
			int sutun = scanner.nextInt();

			// eğer olmayan bir indeks girilirse hata mesajı veriyoruz

			int indeks = satir * 5 + sutun;
			if (indeks >= sehirler.size()) {
				System.out.println("!!! Geçersiz indeks !!!");
				return;
			}
			System.out.println();
			System.out.println();

			// nüfusları gösteriyoruz

			Sehir seciliSehir = sehirler.get(indeks);

			int sehir_nufusu = 0;

			for (Ilce ilce : seciliSehir.ilceler) {
				for (Mahalle mahalle : ilce.mahalleler) {
					sehir_nufusu += mahalle.kisiler.size();
				}
			}

			System.out.println("Şehir:  " + seciliSehir.adi + " -  Nüfus: " + sehir_nufusu);

			for (Ilce ilce : seciliSehir.ilceler) {
				int ilceNufusu = 0;
				for (Mahalle mahalle : ilce.mahalleler) {
					ilceNufusu += mahalle.kisiler.size();
				}
				System.out.println("İlçe:  " + ilce.adi + " - Nüfus: " + ilceNufusu);

				for (Mahalle mahalle : ilce.mahalleler) {
					System.out.println("Mahalle: " + mahalle.adi + " - Nüfus: " + mahalle.kisiler.size());
					System.out.println("Kişiler: ");
					for (Kisi kisi : mahalle.kisiler) {
						System.out.println(" 	" + kisi.id + " - " + kisi.adSoyad + " - " + kisi.yas);
					}
				}
			}

			// kullanıcıdan oyuna devam edip etmeyeceği bilgisini alıyoruz

			System.out.println();
			System.out.print("Başka şehir bilgisi görmek ister misiniz? (e/h): ");
			String cevap = scanner.next();
			if (cevap.equalsIgnoreCase("h")) {
				devam = false;
			}
		}

		// eğer oyunu bitirmek isterse bir tuşa basmasını istiyoruz ve oyun bitip çıkış
		// yapmasını sağlıyoruz

		System.out.print("Oyunu bitirmek için adınızın baş harfinizi girin: ");
		try {
			System.in.read();
		} catch (Exception e) {
		}
		System.out.println("Oyun bitti...");
		System.exit(0);
	}
}