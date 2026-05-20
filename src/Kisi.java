
// kişi sınıfın nesneleri tanımlandı
// sayac yardımı ile kişi id'lerini benzersiz şekilde tanımlıyor

public class Kisi {
	public String adSoyad;
	public int yas;
	public int id;
	public int mahalleId;
	public static int kisiCounter = 1;

	public Kisi(int id, int mahalleId, String adSoyad, int yas) {
		this.id = id;
		this.mahalleId = mahalleId;
		this.adSoyad = adSoyad;
		this.yas = yas;
	}
}
