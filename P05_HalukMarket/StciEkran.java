package JavaProjects.P05_HalukMarket;

import java.util.Scanner;

import static JavaProjects.P05_HalukMarket.KullaniciGiris.Kullanici;

public class StciEkran extends Depo {

        public static Scanner scan = new Scanner(System.in);
        static int devamMi;
        static int sil;
        static int fGuncelle;
        //static int gfGuncelle;
        static int sGuncelle;
        static int secimG;
        static int secimR;



        public StciEkran(String urunKodum, String urunAdim, Double urunStok, Double urunFiyatim) {
                super(urunKodum, urunAdim, urunStok, urunFiyatim);
        }

        Depo obj1 = new StciEkran();

        public StciEkran() {

        }


        public static void StciEkran() {
                System.out.println("************************************************");
                System.out.println("*        Basarili Market Satici Ekrani :-)     *");
                System.out.println("=====================İSLEMLER===================\n");
                System.out.println("*  1. Ürün Ekleme");
                System.out.println("*  2. Ürün Silme");
                System.out.println("*  3. Fiyat Güncelleme");
                System.out.println("*  4. Stok Güncelleme");
                System.out.println("*  5. Raporlama");
                System.out.println("*  0. Cikis");
                System.out.println("================================================\n");
                for (int i = 0; i <urunStoklari.size() ; i++) {
                        if (urunStoklari.get(i)<50) {
                                stokEk.add(urunKodu.get(i));
                        }
                }
                if (!stokEk.isEmpty()) {
                        System.out.println("!!!ACİL!!! " + stokEk + " KODLU URUNLERINIZ STOK ALARMINDA");
                }
                stokEk.clear();
                System.out.print("Lutfen islemi seciniz...= ");
                int menu = scan.nextInt();



                switch (menu) {
                        case 1:
                                UrunEkleme(urunKodum, urunAdim, urunStok, urunFiyatim);
                                break;
                        case 2:
                                UrunSilme(urunKodum, urunAdim, urunStok, urunFiyatim);
                                break;
                        case 3:
                                FiyatGuncelleme(urunKodum, urunAdim, urunStok, urunFiyatim);
                                break;
                        case 4:
                                StokGuncelleme(urunKodum, urunAdim, urunStok, urunFiyatim);
                                break;
                        case 5:
                                RaporlamaMethod();
                                break;
                        case 0:
                                Cıkıs();
                                break;
                }
        }

        private static  void RaporlamaMethod(){
                System.out.println("*        Basarili Market Satici Ekrani :)     *");
                System.out.println("==================RAPORLAR EKRANI===============\n");
                System.out.println("*  1. Depo Raporu");
                System.out.println("*  2. Finansal Rapor");
                System.out.print("Lutfen islemi seciniz...= ");
                secimR = scan.nextInt();
                if (secimR == 1){
                        Sepet();
                } else if (secimR ==2){
                        MstriEkran.Raporlama();}
                StciEkran();
        }

        private static void Cıkıs() {
                System.out.println("Girise Yonlendiriliyorsunuz");
                Kullanici();
        }


        private static void StokGuncelleme(String urunKodum, String urunAdim, Double urunStok, Double urunFiyatim) {
                do {
                        Sepet();
                        System.out.print("Lutfen Stogunu güncellemek istediginiz Urun Kodunu Giriniz ");
                        urunKodum = scan.next();
                        sGuncelle = urunKodu.indexOf(urunKodum);
                        System.out.print("Lutfen Urunun Yeni Stogunu Giriniz ");
                        urunStok = scan.nextDouble();

                        urunStoklari.set(sGuncelle, urunStok);
                        System.out.println("Stok Guncellemeye Devam etmek İstiyor musunuz. 1/Evet   -  2/Hayir");
                        devamMi = scan.nextInt();
                } while (devamMi == 1);
                StciEkran();
        }

        private static void Sepet() {

                System.out.println("**********************************************************");
                System.out.println("*             Basarili Market Depo Raporu :)            *\n");
                System.out.println(" No \t  Ürün \t  \t  Stok \t\t G.Fiyati  \t  S.Fiyati");
                System.out.println("====\t =======\t =======\t  ======= \t  =======");
                for (int i = 0; i < urunKodu.size(); i++) {
             System.out.println(" " + urunKodu.get(i) + "\t    " + urunListesi.get(i) + "\t      " + urunStoklari.get(i) + "\t  " +
                                "\t"+ gelisFiyatlari.get(i)+"\t        "+urunFiyatlari.get(i));
                }

        }

        private static void FiyatGuncelleme(String urunKodum, String urunAdim, Double urunStok, Double urunFiyatim) {
                do {
                        Sepet();
                        System.out.print("Lutfen Fiyatini güncellemek istediginiz Urun Kodunu Giriniz  ");
                        scan.nextLine();
                        urunKodum = scan.nextLine();
                        System.out.println("1-Geliş fiyatı ///  2-Satış Fiyati");
                        secimG=scan.nextInt();
                        fGuncelle = urunKodu.indexOf(urunKodum);
                        if (secimG==1){
                                fGuncelle = urunKodu.indexOf(urunKodum);
                                System.out.print("Lutfen Urunun Yeni Fiyatini Giriniz  ");
                                urunFiyatim = scan.nextDouble();
                                gelisFiyatlari.set(fGuncelle, urunFiyatim);
                        } else if(secimG==2){

                                System.out.print("Lutfen Urunun Yeni Fiyatini Giriniz  ");
                                urunFiyatim = scan.nextDouble();
                                urunFiyatlari.set(fGuncelle, urunFiyatim);
                        }
                        if (gelisFiyatlari.get(fGuncelle)>urunFiyatlari.get(fGuncelle)){
                                System.out.println("!!Gelis fiyati satis fiyatindan buyuk olamaz!!");
                                System.out.print("Lutfen satis fiyatini guncelleyiniz..: ");
                                urunFiyatim = scan.nextDouble();
                                urunFiyatlari.set(fGuncelle, urunFiyatim);}


                        System.out.println("Fiyat Guncellemeye Devam etmek İstiyor musunuz.  1/Evet   -  2/Hayir");
                        devamMi = scan.nextInt();
                } while (devamMi == 1);
                StciEkran();
        }

        private static void UrunSilme(String urunKodum, String urunAdim, Double urunStok, Double urunFiyatim) {
                do {
                        Sepet();
                        System.out.print("Lutfen Silmek istediginiz Urun Kodunu Giriniz  ");
                        scan.nextLine();
                        urunKodum = scan.nextLine();
                        sil = urunKodu.indexOf(urunKodum);

                        urunKodu.remove(sil);
                        urunListesi.remove(sil);
                        urunStoklari.remove(sil);
                        urunFiyatlari.remove(sil);
                        System.out.println("Urun Silmeye Devam etmek İstiyor musunuz.  1/Evet   -  2/Hayir");
                        devamMi = scan.nextInt();
                } while (devamMi == 1);
                StciEkran();
        }

        private static void UrunEkleme(String urunKodum, String urunAdim, Double urunStok, Double urunFiyatim) {
                do {
                        Sepet();
                        System.out.print("Lutfen Eklemek istediginiz Urun Kodu Giriniz  ");
                        urunKodum = scan.next();
                        System.out.print("Lutfen Eklemek istediginiz Urun Adi Giriniz  ");
                        urunAdim = scan.next();
                        System.out.print("Lutfen Eklemek istediginiz Urun Stogu(Kg) Giriniz  ");
                        urunStok = scan.nextDouble();
                        System.out.print("Lutfen Eklemek istediginiz Urun Fiyatini Giriniz  ");
                        urunFiyatim = scan.nextDouble();

                        urunKodu.add(urunKodum);
                        urunListesi.add(urunAdim);
                        urunStoklari.add(urunStok);
                        urunFiyatlari.add(urunFiyatim);
                        System.out.println("Urun Eklemeye Devam etmek İstiyor musunuz.  1/Evet   -  2/Hayir");
                        devamMi = scan.nextInt();
                } while (devamMi == 1);
                StciEkran();
        }



}


