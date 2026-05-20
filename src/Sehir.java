

// sehir sınıfına ait nesneler tanımlandı
// list ile sehir sınıfının ilçe sınıfına erişimi sağlandı

import java.util.List;
import java.util.ArrayList;

public class Sehir {
	public String adi;
	public int id;
	public static int sehirCounter = 1;
	public List<Ilce> ilceler = new ArrayList<>();
	public int mahalleSayisi, kisiMahalle, toplamNufus,sabitMahalleSayisi,sabitIlceSayisi;

	public Sehir(int id,String adi) {
		this.id = id;
		this.adi = adi;
	}
	
}
