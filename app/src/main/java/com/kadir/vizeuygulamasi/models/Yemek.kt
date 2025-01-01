package com.kadir.vizeuygulamasi.models

import com.kadir.vizeuygulamasi.R

data class Yemek(
    val isim: String,
    val malzemeler: String,
    val tarif: String,
    val resim: Int
) {
    companion object {
        val ornekYemekler = listOf(
            Yemek(
                isim = "Tandırda Kaz Çekmesi",
                malzemeler = "Kaz, Baharatlar, Soğan, Yağ ,Bulgur, Su",
                tarif = "Kaz kesildikten sonra 4-5 saat güneşe doğru asılarak kurutulur. Bu sırada bulgur tuzlu suda haşlanır. Kaynamaya başlayınca hafif ateşe alınır." +
                        " Suyunu çekip göz göz olmaya başlayınca tavada kızdırılmış tereyağı üzerine dökülür," +
                        "tandırın dibine oturtturulur. Tam üstüne gelecek şekilde kaz ayaklarından aşağıya doğru asılır. " +
                        "Tandırın sıcaklığı ile kızaran kazın yağı pilavın üzerine damlar. Pilavda tandırın " +
                        "sıcaklığında demlenir. Kaz piştikten sonra çıkarılır. Etleri pilavın " +
                        "üstüne konularak sıcak sıcak yenilir. Tandır olmayan evlerde bulgur pilavı " +
                        "ayrı yapılır. Kaz fırında ayrı kızartılır. Her ikisi de sıcakken kazın " +
                        "fırın tepsisinde biriken yağı pilavın üzerine dökülerek birlikte sıcak " +
                        "sıcak yenilir. ",
                resim = R.drawable.kaz
            ),
            Yemek(
                isim = "Hıngel",
                malzemeler = "1 adet yumurta\n" +
                        "1 su bardağı ılık su\n" +
                        "Aldığı kadar un\n" +
                        "3-4 orta boy patates\n" +
                        "Tuz, karabiber, kırmızı toz biber\n" +
                        "Tereyağı\n" +
                        "Su",
                tarif = "Patatesler haşlanır. İyice ezilir.\n" +
                        "Tuz, karabiber, kırmızı toz biber ile karıştırılır. Soğumaya bırakılır.\n" +
                        "1 yumurta, 1 su bardağı ılık su ile çırpılır. Tuzu eklenir.\n" +
                        "Üzerine yavaş yavaş un eklenir. Kulak memesinden biraz daha katı kıvamda bir hamur yapılır. Dinlenmeye bırakılır.\n" +
                        "Dinlenen hamurdan 3 beze yapılır. Bezeler mantı hamuru gibi açılır. Çay bardağı ile yuvarlaklar kesilir.\n" +
                        "Yuvarlakların ortasına patates püremizden çay kaşığı ile konur ve yarım ay şeklinde sıkıca kapatılır.\n" +
                        "Bol tuzlu sıcak suda haşlanır.\n" +
                        "Piştikten sonra, soğuk sudan geçirilir ve süzülür.\n" +
                        "Üzerine tereyağı kızdırılır, toz biber eklenir ve sıcak sıcak dökülür.",
                resim = R.drawable.hingel
            ),
            Yemek(
                isim = "Hasil",
                malzemeler = "2 su bardağı haşıllık yarma\n" +
                        "2 yemek kaşığı un\n" +
                        "Yarım tatlı kaşığı tuz\n" +
                        "Yoğurt\n" +
                        "Sarımsak\n" +
                        "3 yemek kaşığı tereyağ",
                tarif = "Öncellikle haşıllık yarmamızı tencereye alalım.\n" +
                        "Üstünü geçecek kadar sıcak su ve tuzunu ilave edip kısık ateşte biraz suyunu çekene kadar pişirelim(tamamen çekmemiş olsun).\n" +
                        "Yarmamıza unu ilave edip kıvam alıp pişene kadar devamlı karıştıralım ki dibi tutmasın.\n" +
                        "Ocağımızın altını kapatalım. Tenceremizin de kapağını kapatıp 5 dk demlenmeye bırakalım.\n" +
                        "Haşılımız demlenirken bizde sarımsaklı yoğurdumuzu hazırlayalım.\n" +
                        "3 yemek kaşığı tereyağımızı eritelim.\n" +
                        "Haşılımızı yemek tabağına alıp pasta gibi güzelce yağlayalım.\n" +
                        "Ortasına çukur açıp tereyağını dökelim. Üzerine de sarımsaklı yoğurdu gezdirip servis yapalım.",
                resim = R.drawable.hasil
            )
        )
    }
}

