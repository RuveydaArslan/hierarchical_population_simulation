
// sehir sayısı istenilen bir şekile her satırda 5 şehir nüfusunun gözükmesi sağlanıyor

import java.util.List;

public class Yazdir {
	public void yazdir(List<Sehir> sehirler) {
		for (int i = 0; i < sehirler.size(); i++) {
			System.out.print("[" + sehirler.get(i).toplamNufus + "]");
			if ((i + 1) % 5 != 0 && (i + 1) != sehirler.size())
				System.out.print("-");
			if ((i + 1) % 5 == 0)
				System.out.println();
		}
		if (sehirler.size() % 5 != 0)
			System.out.println();
		System.out.println();
	}
}