# Observer Presentation — Konuşma Notları

Bu dosya, her slayt için kısa ve teknik konuşma notları içerir. Dil sade tutulmuştur, fakat terimler tasarım deseni terminolojisine uygun şekilde kullanılmıştır. Notlar, `observer_presentation.md` içindeki slayt sırasını takip eder.

---

## 1) Başlık — Observer Design Pattern
Bu sunumda Observer tasarım desenini açıklayacağım. Önce desenin amacını, çözdüğü problemi ve pratikte nasıl kullanıldığını göreceğiz. Ardından rollerini, bildirim akışını ve temel artı / eksi yönlerini inceleyeceğiz.

---

## 2) Also known as: Event-Subscriber, Listener
Observer deseni, bazı bağlamlarda Event-Subscriber veya Listener olarak da anılır. Bu isimler aynı temel fikri anlatır: bir nesne bir olay üretir, diğer nesneler de buna tepki verir. Kullanılan isim, framework'e veya alanın terminolojisine göre değişebilir.

---

## 3) Amaç
Observer, nesneler arasında bire-çok bağımlılık tanımlayan davranışsal (behavioral) bir tasarım desenidir. Bir nesnenin durumu değiştiğinde, kayıtlı olan tüm bağımlılar otomatik olarak bilgilendirilir. Kısacası, abonelik tabanlı bir güncelleme mekanizması sağlar.

---

## 4) Problem
Buradaki temel problem, birden fazla bağımlı nesneyi senkron tutarken sıkı bağlılık (tight coupling) oluşturmamaktır. Eğer bir nesne, durumunu kullanan tüm alıcıları doğrudan tanımak zorunda kalırsa, kodun bakımı ve genişletilmesi zorlaşır. Observer bu sorunu, değişikliğin kaynağı ile bu değişikliğe tepki veren nesneleri birbirinden ayırarak çözer.

---

## 5) Solution
Subject, gözlemcilerin (observer) listesini tutar ve `attach`, `detach` ve `notify` gibi işlemler sunar. İç durumu değiştiğinde, bu değişikliği kayıtlı tüm gözlemcilere yayar. Her gözlemci de ortak bir arayüz üzerinden, genellikle `update()` metodu ile kendi güncellemesini yapar.

---

## 6) Ne zaman kullanılır?
Tek bir durum değişikliğinin birden fazla bağımsız nesneye aktarılması gerekiyorsa bu desen kullanılır. Olayın kaynağı ile alıcılar arasında gevşek bağlılık (loose coupling) isteniyorsa da oldukça uygundur. Gözlemcilerin çalışma zamanında eklenip çıkarılması gerekiyorsa yine iyi bir seçenektir.

---

## 7) Hangi problemleri çözer?
Observer, birden fazla bağımlının bulunduğu sistemlerde durum yayılımı (state propagation) problemini çözer. Subject ile her tüketici arasındaki doğrudan referansları kaldırdığı için bağlılığı azaltır ve genişletilebilirliği artırır. Ayrıca, Subject'in çekirdek mantığını değiştirmeden yeni tepkiler eklemeyi kolaylaştırır.

---

## 8) Günlük hayattan örnekler
Günlük hayatta en sık gördüğümüz örneklerden biri GUI olay dinleyicileridir; bir buton tıklaması birden fazla callback'i tetikleyebilir. Bir diğer örnek, abonelik sistemiyle çalışan haber akışıdır; aboneler bir yayıncıdan güncellemeleri alır. MVC mimarisinde de View katmanı, Model değiştiğinde buna tepki verir.

---

## 9) Yapı (roller)
Bu desen genellikle dört rolden oluşur: Subject, Observer, ConcreteSubject ve ConcreteObserver. Subject, gözlemci listesini yönetir; Observer ise güncelleme sözleşmesini tanımlar. ConcreteSubject durumu saklar, ConcreteObserver ise gelen bildirimlere tepki verir.

---

## 10) Çalışma sırası
Çalışma akışı oldukça nettir. Önce gözlemciler Subject'e abone olur. Ardından Subject'in durumu değişir ve `notify()` çağrılır. Son aşamada her gözlemci bir güncelleme alır; ya en güncel veriyi kendisi çeker (pull) ya da veri doğrudan gönderilir (push).

---

## 11) Avantajlar ve dezavantajlar
Başlıca avantajlar; gevşek bağlılık, çalışma zamanı esnekliği ve daha iyi sorumluluk ayrımıdır. Ancak güncelleme akışı dolaylı olduğu için kontrol akışını takip etmek zorlaşabilir. Özellikle uzun ömürlü sistemlerde gözlemciler doğru şekilde ayrılmazsa yaşam döngüsü sorunları da oluşabilir.

---

## 12) İlişkili desenler
Observer, Publisher–Subscriber desenine yakındır; ancak Pub/Sub yaklaşımında genellikle arada bir mesaj aracısı (message broker) bulunur. Mediator ile karşılaştırmak da faydalıdır; çünkü Mediator, olay yayınlamak yerine etkileşim mantığını merkezileştirir. Command ise, işlemlerin kapsüllenip daha sonra çalıştırıldığı sistemlerde benzer yapılarda görülebilir.

---

## 13) Kaynaklar
Bu sunum için ana kaynak Refactoring.Guru'nun Observer pattern sayfasıdır. Slaytlardaki terminolojiyi, yapıyı ve davranış akışını bu kaynağa göre hizaladım. Link: https://refactoring.guru/design-patterns/observer

---

## 14) Projelerimizde nerede kullanıyoruz? (placeholder)
Bu slayt proje-özel örnekler için ayrıldı. Burada kod tabanımızda olaylara tepki veren, değişiklikleri dinleyen veya bildirim yayınlayan alanları gösterebiliriz. Tipik örnekler arasında UI listener'lar, mesaj abonelikleri veya domain event handler'lar yer alabilir.

Konuşma notu: Bu slaytı kendi kod örneklerimizle dolduracağım; böylece desenin gerçek projedeki karşılığını net şekilde gösterebileceğiz.

---

## 15) El ile yazılmış örnek (AI yok) (placeholder)
Bu slayt, elle yazılmış bir örnek için ayrıldı. Amaç, desenin yapısını bir framework soyutlamasının arkasına gizlemeden, sade kod üzerinden göstermek. Bu bölümü açık bırakıyorum; daha sonra insan eliyle yazılmış bir örnek eklenebilir.

Konuşma notu: Bu örnek manuel olarak eklenecek, böylece proje içinde kullanılan stil ve kuralları birebir yansıtabilecek.

---

## 16) Sorular?
Sunumun sonuna geldik. Sorular varsa akışı tekrar açıklayabilirim veya kod seviyesindeki yapıya geri dönebiliriz. İstenirse Observer'ı başka bir tasarım deseniyle de karşılaştırabiliriz.

---

