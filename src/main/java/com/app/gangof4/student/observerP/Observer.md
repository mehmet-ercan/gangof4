# Observer Design Pattern

## Nedir?
- Observer (Gözlemci) deseni, bir nesnenin durumunda değişiklik olduğunda, bu nesneye bağımlı olan diğer nesnelerin (gözlemcilerin) otomatik olarak uyarılmasını ve güncellenmesini sağlayan davranışsal (behavioral) bir tasarım desenidir.

## Hangi Problemleri Çözer?
- Bir nesnenin durumu değiştiğinde diğer nesnelerin (ve kaç tane olduklarının bilinmesine gerek kalmadan) bu durumdan haberdar olması gerekiyorsa.
- Sıkı bağlılığı (tight coupling) önlemek ve bileşenlerin birbirinden bağımsız çalışmasını (loose coupling) sağlamak isteniyorsa.
- Durum değişikliklerini dinleyen nesnelerin çalışma zamanında (runtime) dinamik olarak eklenip çıkarılması gereken sistemlerde.

## Günlük Hayattan Örnekler
- **Whatsapp Grup Bildirimleri:** Bir WhatsApp grubuna yeni bir mesaj geldiğinde, gruba üye olan herkes (Observer) bu mesajdan haberdar olur. Gruba katılan yeni üyeler de bundan sonra gelen mesajları görmeye başlar.
- **YouTube Kanalı Aboneliği:** Bir YouTube kanalına abone olduğunuzda (Observer), kanal yeni bir video yüklediğinde (Subject durum değiştirdiğinde) size bildirim gelir. Abonelikten çıktığınızda bildirim almayı bırakırsınız.
- **Gazete/Dergi Aboneliği:** Yayıncı yeni sayı çıkardığında tüm aktif abonelere otomatik ulaştırır.

## Projelerde Nerelerde Kullanırız?
- **Bildirim (Notification) Sistemleri:** Veritabanına yeni bir kayıt eklendiğinde veya bir işlem bittiğinde ilgili e-posta gönderme servislerinin tetiklenmesi.
- **Event Handling (Olay Yönetimi):** UI uygulamalarında buton tıklamaları vb. olayların dinlenmesi.
- **Pub/Sub Mimarileri:** Daha büyük çaplı dağıtık sistemlerde RabbitMQ, Kafka, Redis Pub/Sub gibi teknolojiler aslında bu desenin bir üst seviye uygulamalarıdır.
- **MVC Mimarisi:** Model değiştiğinde View'ın otomatik olarak kendini güncellemesi.

## İsimlendirmenin Anlaşılması İçin

### Publisher (Yayıncı / Kaynak)
- **Publisher (Yayıncı):** Megafonu elinde tutan, olayların merkezindeki kaynaktır. Olayların koptuğu, asıl veriyi veya durumu elinde tutan yerdir.
- **Subject (Özne/Konu/Kaynak):** Tasarım desenleri literatüründe "gözlemlenen, takip edilen asıl merkez" anlamına gelir. İngilizce'deki "Subject of interest" (İlgi odağı) kalıbından türemiştir.
- **Observable (Gözlemlenebilir Obje):** Java'nın eski sürümlerinde bizzat (`java.util.Observable`) olarak da kullanılan, kendisini dinlemeye açan nesne.

**Publisher Sınıfının 3 Temel Görevi Vardır:**
1. **Aboneleri Kayıt Altına Almak (attach / subscribe (bizde join)):** Kendini dinlemek isteyenleri bir listede tutar.
2. **Abonelikten Çıkarmak (detach / unsubscribe (bizde leave)):** Artık dinlemek istemeyenleri listeden siler.
3. **Abonelere Haber Vermek (notify / fireEvent):** Kendi içinde bir değişiklik olduğunda (yeni haber gelmesi, fiyatın değişmesi vb.) listedeki herkesi tek tek dolaşıp güncellemeyi yollar.

*Özetle; Publisher, kendisinde olan biteni başkalarına anons eden megafondur.*

### Listener (Dinleyici / Abone)
- **Listener (Dinleyici):** O megafondan çıkacak sesi duymak için bekleyen kalabalıktır. (Örn: Arayüzdeki butonu dinleyen metotlar, `OnClickListener` gibi)
- **Observer (Gözlemci):** Kelime anlamı "Gözlemci" olsa da, aslında sürekli aktif olarak kaynağı gözlemez (sürekli "yeni bir şey var mı?" diye sormaz). Pasif olarak bekler; kaynak ona veriyi "gönderdiğinde/ittirdiğinde" (push mantığıyla) haberdar olur.
- **Subscriber (Abone):** Whatsapp aboneleri, e-posta bülten aboneleri gibi.
- **Consumer (Tüketici):** Mesaj kuyruklarından (RabbitMQ, Kafka vb.) gelen mesajları alan ve işleyen servisler.

**Listener (Dinleyici) Sınıfının Tek Bir Temel Görevi Vardır:**
1. **Dinlemek / Tepki Vermek / Güncellenmek (update / onNext / onEvent):** Listener, kendi içinde sistemin ne yapması gerektiğini tanımlayan bir metot bulundurur. Publisher tarafında bir olay koptuğunda, Publisher gelir ve Listener'ın bu reaksiyon kodunu (yani update metodunu) tetikler.
