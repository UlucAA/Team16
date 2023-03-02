package JavaProjects.P05_HalukMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Depo {

        static List<String> urunKodu = new ArrayList<>(Arrays.asList("01","02","03","04","05","06","07","08","09","10","11" ));
        static List<String> urunListesi = new ArrayList<>(Arrays.asList("Domates","Patates","Biber","Sogan ",
                "Havuc", "Elma", "Muz","Cilek","Kavun","Uzum","Limon" ));
        static List<Double> urunFiyatlari = new ArrayList<>(Arrays.asList(2.10,3.20,1.50,2.30,3.10,1.20,1.90,6.10,4.30,2.70,0.50));
        static List<Double> gelisFiyatlari = new ArrayList<>(Arrays.asList(1.10,2.20,1.00,1.80,2.10,0.80,1.20,5.10,3.30,2.00,0.40));
        static List<Double> urunStoklari = new ArrayList<> (Arrays.asList(49.0,100.0,100.0,100.0,100.0,100.0,100.0,100.0,100.0,100.0,100.0));
        static List<String> stokEk = new ArrayList<>();
        static String urunKodum;
        static String urunAdim;
        static Double urunFiyatim;

        //static Double gelisFiyatim;
        static Double urunStok;
        static List<String> secKodu=new ArrayList<>();
        static List<String> secUrun=new ArrayList<>();
        static List<Double> secFiyat=new ArrayList<>();
        static List<Double> secKilo=new ArrayList<>();
        static List<Double> secKlmTutar=new ArrayList<>();
        static double toplamOdenecekTutar;
        static double toplamGelisFiyat = 0;
        static double toplamSatisFiyat=0;
        static double gunlukKar=0;
        public Depo(String urunKodum, String urunAdim, Double urunStok, Double urunFiyatim) {
        this.urunKodum = urunKodum;
        this.urunAdim = urunAdim;
        this.urunFiyatim = urunFiyatim;
        this.urunStok = urunStok;
    }
        public Depo() {

    }

        public static List<String> getUrunKodu() {
        return urunKodu;
    }

        public void setUrunKodu(List<String> urunKodu) {
        this.urunKodu = urunKodu;
    }

        public static List<String> getUrunListesi()
        {return urunListesi;
    }

        public void setUrunListesi(List<String> urunListesi) {
        this.urunListesi = urunListesi;
    }

        public static List<Double> getUrunFiyatlari() {
        return urunFiyatlari;
    }

        public void setUrunFiyatlari(List<Double> urunFiyatlari) {
        this.urunFiyatlari = urunFiyatlari;
    }

        public static String getUrunKodum()
        {return urunKodum;}

        public void setUrunKodum(String urunKodum)
        {this.urunKodum = urunKodum;
        }

        public static String getUrunAdim() {
        return urunAdim;
    }

        public void setUrunAdim(String urunAdim) {
        this.urunAdim = urunAdim;
    }

        public static Double getUrunFiyatim() {
        return urunFiyatim;
    }

        public void setUrunFiyatim(Double urunFiyatim) {
        this.urunFiyatim = urunFiyatim;
    }

        public static Double getUrunStok() {
        return urunStok;
    }

        public void setUrunStok(Double urunStok) {
        this.urunStok = urunStok;
    }

    }

