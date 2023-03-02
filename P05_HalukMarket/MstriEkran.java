package JavaProjects.P05_HalukMarket;

import java.time.LocalDate;
import java.util.Scanner;

public class MstriEkran extends Depo{
    //urun fiyatlarinin atanacagi bos list


    static int secim;
    static int sayac;
    public static Scanner scan = new Scanner(System.in);

    public MstriEkran(String urunKodum, String urunAdim, Double urunStok, Double urunFiyatim) {
        super(urunKodum, urunAdim, urunStok, urunFiyatim);
    }

    public static void Ekran() {

        System.out.println("************************************************");
        System.out.println("*   Basarili Market alış-veriş programı :)    *\n");
        System.out.println(" No \t   Ürün \t\t  Fiyat");
        System.out.println("====\t =======\t \t=========");
        for (int i = 0; i < urunKodu.size(); i++) {
            System.out.println(" " + urunKodu.get(i) + "\t   \t" + urunListesi.get(i) + "\t \t \t "+urunFiyatlari.get(i));
        }


        musteriSecim();
    }

    private static void musteriSecim() {

        System.out.print("Sepete eklemek istediginiz urunu seciniz :");
        secim = scan.nextInt();
        secKodu.add(urunKodu.get(secim-1));
        secUrun.add(urunListesi.get(secim-1));
        secFiyat.add(urunFiyatlari.get(secim-1));
        System.out.print("Sectiginiz urunden kac kilo alacaksiniz : ");
        double kilo = scan.nextDouble();
        while(urunStoklari.get(secim-1)<kilo){
            System.out.println("Stoklarimizda "+urunStoklari.get(secim-1)+" Stok bulunmaktadir.");
            System.out.print("Lutfen Yeniden Kilo giriniz..:");
            kilo = scan.nextDouble();
        }
        secKilo.add(kilo);
        urunStoklari.set(urunKodu.indexOf(urunKodu.get(secim-1)),(urunStoklari.get(secim-1)-kilo));

        double urunTutari = urunFiyatlari.get(secim - 1);
        double urunToplamTutar = kilo * urunTutari;
        secKlmTutar.add(urunToplamTutar);
        toplamOdenecekTutar += urunToplamTutar;//alınan her urun odemesi ana odemeye eklendi
        toplamGelisFiyat+=gelisFiyatlari.get((secim - 1))*kilo;
        sayac++;
        sepet();
        System.out.println("");
        System.out.println("Alışveriş sonlandirmak icin  : 0,");
        System.out.println("Devam edecekseniz            : 1,");
        System.out.println("Sepet için                   : 2 seciniz...:");

        int karar = scan.nextInt();
        if (karar == 0) {
            Cikis();
        } else if (karar == 1){
            musteriSecim();
        } else{
            sepet();
        }
    }

    private static  void sepet() {
        System.out.println("************************************************");
        System.out.println("*   Basarili Market alış-veriş Sepetiniz :-)    *\n");
        System.out.println(" No \t   Ürün \t  Fiyat \t  Kilo \t \t Tutar");
        System.out.println("====\t =======\t ========\t =======\t=======");
        for (int i = 0; i <secKodu.size() ; i++) {
            System.out.println(" "+secKodu.get(i)+"\t    "+secUrun.get(i)+"\t      "+secFiyat.get(i)+"\t       "+secKilo.get(i)+
                    "\t \t"+secKlmTutar.get(i));


        }
        System.out.println("=============================================");
        System.out.println(" Sepet toplam tutari : " + toplamOdenecekTutar);

        System.out.println("");
        System.out.println("Alışveriş sonlandirmak icin  : 0,");
        System.out.println("Devam edecekseniz            : 1,");
        System.out.println("Sepet için                   : 2 seciniz...");

        int karar = scan.nextInt();
        if (karar == 0) {
            Cikis();
        } else if (karar == 1){
            musteriSecim();
        } else{
            sepet();
        }
    }

    protected static  void Raporlama() {
        System.out.println("************************************************");

        System.out.println("*Basarili Market "+ LocalDate.now()+" Günlük Satış Raporu :)    *\n");

        toplamSatisFiyat=toplamOdenecekTutar;
        gunlukKar=toplamSatisFiyat-toplamGelisFiyat;
        System.out.println("=============================================");
        System.out.println(" Satilan Ürünlerin Gelis Fiyatı : " + toplamGelisFiyat);
        System.out.println(" Satilan Ürünlerin Satış Fiyatı : " + toplamSatisFiyat);
        System.out.println(" Gunluk Kariniz................ : " + gunlukKar);
    }
    private static void Cikis() {
        System.out.println("************************************************");
        System.out.println("*   Basarili Market Alış-Veriş Fisiniz  :)    *\n");
        System.out.println(" No \t   Ürün \t  Fiyat \t  Kilo \t \t Tutar");
        System.out.println("====\t =======\t ========\t =======\t =======");
        for (int i = 0; i <secKodu.size() ; i++) {
            System.out.println(" "+secKodu.get(i)+"\t    "+secUrun.get(i)+"\t      "+secFiyat.get(i)+"\t       "+secKilo.get(i)+
                    "\t \t"+secKlmTutar.get(i));
        }
        System.out.println("=============================================");
        System.out.println(" Sepet toplam tutari : " + toplamOdenecekTutar+"\n");
        System.out.print("Lutfen Odemeicin Para Miktarı veriniz : ");
        double para=scan.nextDouble();
        System.out.println("Para Ustunuz "+ (para-toplamOdenecekTutar) + " TL'dir");
        System.out.println("Isleminiz basariyla gerceklestirilmistir.");
        System.out.println("Basarili Marketi Tercih Ettiginiz icin Tesekkur Ederiz.");
        System.out.println();
        KullaniciGiris.Kullanici();
    }
}
