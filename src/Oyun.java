
// new ile yeni nesneler oluşturuluyor
// oluşturulan nesneler sınıflar çağırılarak kullanılmaya başlanıyor
// list ile oyun sınıfı sehir sınıfına erişebiliyor

import java.util.ArrayList;
import java.util.List;

public class Oyun {
	List<Sehir> sehirler = new ArrayList<>();
	SehirOlustur sehirOlustur = new SehirOlustur();
	TurArttir turArttir = new TurArttir();
	Yazdir yazdir = new Yazdir();
	SeciliSehir seciliSehir = new SeciliSehir();

	public int hedefKisiSayisi = 10000;
	public int olusanKisiSayisi = 0;
	
	public boolean limitDolduMu() {
		return olusanKisiSayisi >= hedefKisiSayisi;
	}
	public void baslat(String il,int tur) {
		sehirler = sehirOlustur.sehirOlustur(il);
		System.out.println("Başlangıç nüfusları: ");
		yazdir.yazdir(sehirler);
		
		for (int t = 1; t <= tur; t++) {

			System.out.print("\033[H\033[2J");
			turArttir.turArtir(sehirler);
			System.out.println(t + ". tur sonrası nüfuslar:");
			yazdir.yazdir(sehirler);
		}
		seciliSehir.seciliSehir(sehirler);
	
	}
}
