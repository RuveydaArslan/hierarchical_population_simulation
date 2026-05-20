# 🏙️ Hiyerarşik Nüfus Simülasyon Sistemi

Bu proje, **Java dili** kullanılarak geliştirilmiş hiyerarşik bir nüfus simülasyon sistemidir.

Sistem; şehir, ilçe, mahalle ve kişi yapıları arasında ilişki kurarak dinamik bir yerleşim simülasyonu gerçekleştirmektedir. Projede nesne yönelimli programlama (OOP), modüler programlama ve koleksiyon yapılarının kullanımı hedeflenmiştir.

Projede kullanılan şehir, ilçe, mahalle ve kişi verileri **Java Faker** kütüphanesi kullanılarak gerçekçi şekilde üretilmektedir.

---

## ✨ Özellikler

- 🏙️ **Şehir → İlçe → Mahalle → Kişi** hiyerarşik veri yapısı
- 👥 Dinamik nüfus oluşturma sistemi
- 📈 Tur bazlı nüfus artış simülasyonu
- 🧩 Modüler proje mimarisi
- 🧠 Nesne yönelimli programlama (OOP)
- 🎲 Java Faker ile gerçekçi veri üretimi
- 🖥️ Konsol tabanlı kullanıcı arayüzü
- 📋 `ArrayList` tabanlı veri yönetimi
- 💾 Üretilen verilerin dosyaya yazdırılması

---

## 🏗️ Proje Yapısı

```text
JavaOdev1/
│
├── src/
│     ├── Main.java
│     ├── Oyun.java
│     ├── Sehir.java
│     ├── Ilce.java
│     ├── Mahalle.java
│     ├── Kisi.java
│     ├── SehirOlustur.java
│     ├── TurArttir.java
│     ├── Yazdir.java
│     ├── SeciliSehir.java
│     
│         
├── dist/           # Derlenmiş çıktılar
└── README.md
```

---

## 🔧 Kullanılan Teknolojiler

| Teknoloji | Açıklama |
|-----------|----------|
| ☕ Java | Ana simülasyon sistemi |
| 🎲 Java Faker | Rastgele gerçekçi veri üretimi |
| 🧠 OOP | Nesne yönelimli programlama |
| 📋 ArrayList | Dinamik veri yönetimi |
| 📂 FileWriter | Dosya yazma işlemleri |

---

## 🌳 Hiyerarşik Yapı

```text
Sehir
 └── Ilce
       └── Mahalle
             └── Kisi
```

Projede şehir yapıları arasında hiyerarşik ilişki kurulmuştur.

---

## 📊 Simülasyon Mantığı

1. Kullanıcıdan başlangıç nüfus değerleri alınır.
2. Girilen değerlere göre şehir yapıları oluşturulur.
3. Java Faker ile:
   - şehir isimleri
   - ilçe isimleri
   - mahalle isimleri
   - kişi bilgileri
   otomatik olarak üretilir.
4. Her tur sonunda:
   - 📈 Nüfus artışı gerçekleşir
   - 👶➡️🧓 Yaş bilgileri güncellenir
   - 🏘️ Yeni yerleşimler oluşabilir
5. Üretilen veriler `.txt` dosyalarına yazdırılır.

---

## 🚀 Çalıştırma

### ▶️ Eclipse ile Çalıştırma

1. Projeyi Eclipse'e import edin.
2. `Main.java` dosyasını çalıştırın.
3. Konsol üzerinden nüfus bilgilerini girin.
4. Simülasyon sonuçlarını takip edin.

---

## 🧠 Kullanılan Programlama Konuları

- Nesne yönelimli programlama (OOP)
- ArrayList kullanımı
- Dosya yazma işlemleri
- Modüler programlama
- Simülasyon sistemleri
- Veri modelleme
- Hiyerarşik yapı tasarımı

---


## 👩‍💻 Geliştirici

Bu proje, **Programlama Dillerinin Prensipleri** dersi kapsamında geliştirilmiştir.
