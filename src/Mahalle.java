
// mahalle sınıfının nesne tanımlandı
// list kullanımı ile mahalle sınıfı kişi sınıfına erişiyor

import java.util.List;
import java.util.ArrayList;

public class Mahalle {
	public int id;
	public int ilceId;
	public String adi;
	public static int mahalleCounter = 1;
	public List<Kisi> kisiler = new ArrayList<>();


	public Mahalle(int id,int ilceId,String adi) {
		this.id=id;
		this.ilceId = ilceId;
		this.adi=adi;
	}
	public int getKisiSayisi() {
		return kisiler.size();
	}
}
