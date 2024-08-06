# MVVM Örnek Proje

Bu proje, kişilerin adını, soyadını ve telefon numarasını ana ekranda bir CardView yapısında gösteren bir Android uygulamasıdır. 
Proje, MVVM (Model-View-ViewModel) mimarisine uygun olarak geliştirilmiştir ve aşağıdaki teknolojileri kullanmaktadır:

- **Kotlin**
- **MVVM**
- **Root**
- **ViewModel**
- **DataBinding**
- **ViewBinding**
- **LiveData**
- **Hilt**

## Özellikler

- Kişi bilgilerini (ad, soyad, telefon numarası) CardView ile ana ekranda gösterme
- MVVM mimarisi kullanarak daha temiz ve yönetilebilir kod
- Dependency Injection için Hilt kullanımı
- Veri bağlama için DataBinding ve ViewBinding kullanımı
- Gerçek zamanlı veri güncellemeleri için LiveData kullanımı

## Kurulum

1. Bu projeyi bilgisayarınıza klonlayın:

    git clone https://github.com/abkopan/MVVM-Ornek-Proje.git

2. Android Studio'da projeyi açın.

3. Gerekli bağımlılıkları yüklemek için `build.gradle` dosyasını senkronize edin.

## Kullanılan Teknolojiler ve Kütüphaneler

- **Kotlin**: Proje dili olarak kullanıldı.
- **MVVM**: Proje mimarisi olarak kullanıldı.
- **Hilt**: Dependency Injection (Bağımlılık Enjeksiyonu) için kullanıldı.
- **LiveData**: Canlı veri akışı ve güncellemeleri yönetmek için kullanıldı.
- **DataBinding**: XML layout dosyalarını ViewModel'e bağlamak için kullanıldı.
- **ViewBinding**: XML layout dosyalarıyla güvenli ve kolay etkileşim için kullanıldı.

## Proje Yapısı

- **data**: Veritabanı tabloları ve veri modelleri burada bulunur.
- **view**: Kullanıcı arayüzü ve ekranlar burada bulunur.
- **viewmodel**: UI ile veri arasında bağlantı kuran ViewModel sınıfları burada bulunur.
- **repo**: Veri kaynaklarına erişimi yöneten repository sınıfları burada bulunur.
- **di**: Hilt ile ilgili bağımlılık enjeksiyonu yapılandırmaları burada bulunur.
- **fragment**: Kullanıcılara sunulan ekranların alt yapılandırmaları burada bulunur.
- **room**: SQLite veritabanı işlemleri için kullanılan kalıcı depolama çözümü burada bulunur.


---

Bu örnek proje hakkında herhangi bir sorunuz varsa, lütfen bana ulaşmaktan çekinmeyin. İyi kodlamalar!

