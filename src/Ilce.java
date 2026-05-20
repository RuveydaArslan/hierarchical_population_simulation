
import java.util.List;
import java.util.ArrayList;

// ilçe sınıfına ait kullanılacak nesneler tanımlandı
// ilçe sınıfı mahalle sınıfına erişiyor

public class Ilce {
	public String adi;
	public int sehirId;
	public int id;
	public static int ilceCounter = 1;
	
	public Ilce(int id,int sehirId,String adi) {
		this.id = id;
		this.sehirId = sehirId;
		this.adi = adi;
	}
	public List<Mahalle> mahalleler = new ArrayList<>();
	int toplamNufus;
}
