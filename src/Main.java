
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// kullanıcıdan tur sayısını ve başlangıç nüfus değerleri alınıyor

		Scanner scanner = new Scanner(System.in);
		System.out.print("Oynanacak tur sayısı: ");
		int tur = Integer.parseInt(scanner.nextLine());

		System.out.print("Nüfus sayıları (boşluk olacak şekilde giriniz): ");
		String il = scanner.nextLine();

		// girilen değerlerin iki basamaklı olup olmadığına bakılıyor
		// eğer değerler iki basamaklı değilse hata vermesi sağlanıyor

		String[] parcala = il.split(" ");
		int[] dizi = new int[parcala.length];

		for (int i = 0; i < parcala.length; i++) {
			int sayi = Integer.parseInt(parcala[i]);

			if (sayi >= 10 && sayi <= 99) {
				dizi[i] = sayi;
			} else {
				System.out.println("Hata: " + "sadece iki basamaklı sayı giriniz ");
				return;
			}
		}

		// oyun başlatılıyor ve gerekli sınıflar çağırılıyor

		Oyun oyun = new Oyun();

		oyun.baslat(il, tur);

	}
}
