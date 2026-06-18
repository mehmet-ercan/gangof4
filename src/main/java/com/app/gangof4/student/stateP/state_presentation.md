---
theme: gaia
_class: lead
paginate: true
backgroundColor: #fff
backgroundImage: url('https://marp.app/assets/hero-background.svg')
---

![bg left:40% 100%](https://refactoring.guru/images/patterns/content/state/state-en-1.5x.png)

# **State Design Pattern**

<br>

#### Also known as: Objects for States

<br>
<br>
<br>

###### mehmet ercan akcan
##### 19.06.2026

---

# Amaç :bookmark_tabs:

- Behavioral design pattern
- Bir nesnenin iç durumu değiştiğinde davranışının da değişmesini sağlar
- `if-else` / `switch` zincirlerini durum sınıflarına dağıtarak karmaşıklığı azaltır
- Aynı nesne, runtime sırasında farklı davranışlar sergileyebilir

---

# Problem :confused:

Bir nesne zaman içinde farklı aşamalardan geçebilir.

Örnekler:
- Sipariş: `Yeni` → `Hazırlanıyor` → `Kargoda` → `Teslim Edildi`
- Asansör: `Beklemede` → `Hareket halinde` → `Kapı açık` → `Bakım`
- Oyun karakteri: `Normal` → `Saldırı` → `Savunma` → `Sersemlemiş`

---

# Problem :confused:

Böyle durumlarda kod genelde şu mantığa dönüşür:

- if durum > `NEW` ise hazırlık adımına geç
- if durum > `PREPARING` ise kargoya ver
- if durum > `IN_TRANSIT` ise teslim et

Bu yaklaşım büyüdükçe:
- tek sınıf şişer
- bakım zorlaşır
- yeni durum eklemek riskli olur

---

# Solution :sunglasses:

- Her durum ayrı bir sınıfa taşınır
- Context, mevcut state nesnesini tutar
- Davranış state içinde tanımlanır
- Durum değiştiğinde context, yeni state nesnesine geçer

Bu sayede:
- davranışlar ayrışır
- geçiş kuralları netleşir
- kod daha okunabilir olur

---

<!--
# Structure (roles) :bricks:

- **State**: Duruma özel davranışı tanımlayan arayüz

- **ConcreteState**: Her bir somut durum sınıfı

- **Context**: Mevcut durumu tutar ve geçişi yönetir

-->

---

# Davranışı örneği :gear:

Akış:
- İlk durum: `Yeni Sipariş`
- Sonra: `Hazırlanıyor`
- Sonra: `Kargoda`
- Sonra: `Teslim Edildi`
- Son durumda geçiş yok

---

# Sequence :gear:

1. Context başlangıç state'ini oluşturur
2. İstemci `nextState()` çağırır
3. Mevcut state kendi `next()` davranışını çalıştırır
4. State, context üzerinden yeni state'i set eder
5. Context bir sonraki çağrıda yeni davranışı kullanır

---

# Günlük hayattan örnekler :earth_americas:

- **Sipariş takibi**: Her aşamada farklı işlem yapılır
- **Asansör sistemi**: Duruma göre farklı tuşlar / kurallar geçerli olur
- **Trafik ışığı**: Kırmızı, sarı, yeşil için farklı davranışlar vardır
- **Oyun karakteri**: Saldırı veya savunma durumuna göre hareket değişir

---

# Ne zaman kullanılmalı? :point_right:

- Davranış nesnenin iç durumuna bağlıysa
- Birden fazla state ve net geçiş kuralları varsa
- Büyük `if-else` / `switch` bloklarından kaçınmak istiyorsan
- Her durumun ayrı sorumluluğu olması isteniyorsa

---

# Ne zaman kullanılmamalı? :no_entry:

- Durum sayısı çok az ve basitse
- Davranış aslında strateji değişimiyse
- Tek seferlik, sabit akış yeterliyse
- Enum + switch çözümü yeterliyken gereksiz soyutlama yapılıyorsa

<!--

### Anti-pattern uyarıları

- Gereksiz sınıf patlaması oluşturma
- Geçişleri dağınık bırakma
- State ile Strategy’yi karıştırma
- Basit problemde overengineering yapma

-->

---

# Sağladığı faydalar :wrench:

- `if-else` karmaşasını azaltır
- Davranışı küçük sınıflara böler
- Yeni state eklemeyi kolaylaştırır
- Test edilebilirliği artırır
- Kodun okunabilirliğini yükseltir

---

# Dezavantajlar :balance_scale:

- Sınıf sayısı artar
- Basit problemler için gereksiz olabilir
- Geçiş mantığı yanlış kurgulanırsa takip zorlaşır
- Çok küçük state’ler kodu parçalayabilir

---

# ilişkili Patternlar :link:

- **Strategy**: ... Henüz anlatılmadı <!-- Davranışı değiştirmek için kullanılır, ama amaç farklıdır -->
- **Template Method**: ... Henüz anlatılmadı <!-- Adımlar sabit, değişen parçalar sınıflarda ise alternatif olabilir -->

---

# Projelerde nerede kullanılabilir? :construction:

- Sipariş yaşam döngüsü
- Üyelik / abonelik statüleri
- Onay akışları
- Rezervasyon süreçleri
- Ders kayıt süreçleri

---

# Kapanış :microphone:

State pattern, nesnenin davranışını **iç durumuna göre** değiştirmek için çok kullanışlıdır.

Özet:
- Durum = sınıf
- Geçiş = context yönetimi
- Davranış = state içinde

---

# Sorular :question:

<!--
- State pattern ile Strategy pattern arasındaki temel fark nedir?
- Hangi durumda enum + switch yeterli olur?
- Bu örnekte yeni bir `CancelledState` eklesek yapı nasıl genişler?

-->